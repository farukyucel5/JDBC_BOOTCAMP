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



        con.close();
        st.close();
        data.close();


    }
}
