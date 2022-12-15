import java.sql.*;

public class JDBC_Query02 {

    public static void main(String[] args) throws SQLException {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("DriverNotFound");
        }

        //bağlantı için username ve password girilir

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Faruk12068036");



        //3- sql query için statement objesi olusturup,javada kendimize sql sorguları için bir alan açacağız

        Statement st=con.createStatement();


        //sadece ankarada yasayanların isim ve maaslarını mass ters sıralı olarak listele

        ResultSet data=st.executeQuery("SELECT isim , maas FROM calisanlar WHERE sehir='Ankara' order by maas DESC");

        while (data.next()) {
            System.out.println(data.getString("isim")+ " " +data.getInt("maas"));
        }






        /*=======================================================================
		  ORNEK3: Maasi en yuksek 3 kisinin adini, yasadigi sehri ve maasini
		   maas sirali listeyiniz.
		========================================================================*/
        System.out.println("======================= ORNEK 3 ===========================");

        String sorgu = "SELECT isim, sehir, maas FROM calisanlar ORDER BY maas DESC LIMIT 3";

        ResultSet veri2 = st.executeQuery(sorgu);

        while (veri2.next()){
            System.out.println( veri2.getString(1)+ " - " + veri2.getString(2)+ " - " + veri2.getInt(3));
        }

        // NOT1 : Sorgulama icin get ile istenirse sütun (field) ismini yazabilecegimiz gibi sutun index
        // (field olusturulma sirasina gore) yazilabilir.

        // NOT2 : Sorgumuzda SELECT'ten sonra sadece belli fieldlari dondurmesini istiyorsak
        // get ile cagirdigimiz field indexleri sorguda belirttigimiz sirayla ifade etmemiz gerekiyor


        con.close();
        st.close();
        data.close();
    }
}
