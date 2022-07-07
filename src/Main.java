import java.io.PrintStream;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your id:");
        String id = sc.nextLine();
//

        System.out.println("Hello world!");
        String host = "127.0.0.1";
        String port = "5432";
        String base = "postgres";
        String user = "postgres";
        String pass = "root";
        String url = "jdbc:postgresql://" + host + ":" + port + "/" + base;



        String sql = "UPDATE info SET name = 'dima' WHERE id = " + id;

        try (Connection connection = DriverManager.getConnection(url, user, pass);) {




            assert connection != null : "connection is null";
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);

//            PreparedStatement ps = connection.prepareStatement("SELECT * FROM info WHERE id = ?");
//            ps.setInt(1, Integer.parseInt(id));
//            ResultSet resultSet = ps.executeQuery();

//            while (resultSet.next()){
//
//
//                String idFromDb = resultSet.getString("id");
//                String name = resultSet.getString(2);
//                String phone = resultSet.getString(3);
//                String email = resultSet.getString(4);
//                String address = resultSet.getString(5);
//
//                System.out.printf("%s %s %s %s %s \n\r", idFromDb, name, phone, email, address);
//
//
//            }
//
//
            Statement statement = connection.createStatement();

//            boolean execute = statement.execute("DELETE FROM info WHERE id =" + id);
//            boolean execute = statement.execute(sql);
//

            //statement.execute("INSERT INTO info(name,phone,email,address) VALUES ('dima1', '8503', '@email', 'minsk')");
            String s = "SELECT bill_id FROM users WHERE id = your_id";
            String s1 = "Select check from bills where bill_id = you_bill_id";
            String s2 = "update bills set cash = cash-check*1% where bill_id = your_bill_id";
            String s3 = "update bills set cash = cash-check where bill_id = your_bill_id";
            String s4 = "update bills set cash = cash+check where bill_id = your_friend_bill_id";
            boolean execute1 = statement.execute(s);
            boolean execute2 = statement.execute(s1);
            boolean execute3 = statement.execute(s2);
            boolean execute4 = statement.execute(s3);
            boolean execute5 = statement.execute(s4);

            String sql1 = "INSERT INTO info VALUES (43,'dima2', 'email1', '770', 'misk');" +
                    "INSERT INTO info VALUES (43,'dima2', 'email1', '770', 'misk');";
            boolean execute = statement.execute(sql1);


            if (execute5 && execute1 && execute2 && execute3 && execute4){

                connection.commit();
            } else {

                connection.rollback();
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}