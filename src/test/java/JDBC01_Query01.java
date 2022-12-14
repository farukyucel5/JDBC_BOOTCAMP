import java.sql.*;

public class JDBC01_Query01 {
    public static void main(String[] args) throws SQLException {
        //1-ilgili driver'ı yükle
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("DriverNotFound");
        }

        //bağlantı için username ve password girilir

          Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Faruk12068036");



        //3- sql query için statement objesi olusturup,javada kendimize sql sorguları için bir alan açacağız

        Statement st=con.createStatement();

        //4 sql sorgularını yazıp çalıştırabiliriz

        ResultSet data=st.executeQuery("select * from calisanlar");

        //5-sonucları  görmek için iterasyon yapıyoruz

        /*
        CREATE TABLE calisanlar
	(
		id INT PRIMARY KEY,
		isim VARCHAR(50),
		sehir VARCHAR(50),
		maas INT,
		sirket VARCHAR(20)
	);
         */


    while (data.next()){
        System.out.println(data.getInt("id")+" "+data.getString("isim")+
                " "+data.getString("sehir")+" "+data.getInt("maas")+" "+data.getString("sirket"));
    }

    //6 oluşturulan nesneleri close() ile kapatıyoruz ki bellekten yemesin

        con.close();
        st.close();
        data.close();



    }
}
