import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
class Start {
    public static void main(String[] data) {
        System.out.println("Hello Database");
        Company c = new Company();
        c.show();
    }
}

class Company {
    void show() {
        String connectionString = "jdbc:mysql://127.0.0.1/company?user=alice&password=1985-Alice";
        String driver = "com.mysql.cj.jdbc.Driver";
        String sql = "select * from staff";
        try{
            //1. start driver
//            new com.mysql.cj.jdbc.Driver(); // this method is correct but if you need to change its not quite usual
            Class.forName(driver);
            //2. Get connection
            Connection cn = DriverManager.getConnection(connectionString);
            System.out.println(cn); // check connection
            //3. Prepare Statement
            // PrepareStatement ps = cn.prepareStatement(sql);
            var ps = cn.prepareStatement(sql);
            //4. Query Data
            ResultSet rs =  ps.executeQuery(); //if use var dont have to import
            //5. Read each row
            while (rs.next()) {
                String s = rs.getString("name");
                double v = rs.getDouble("salary");
                Date d = rs.getDate("dob");
                System.out.println(s + " " + v + " " + d);
            }
            
            rs.close(); ps.close();cn.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}