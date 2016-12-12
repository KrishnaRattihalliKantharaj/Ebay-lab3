import java.sql.*;
import javax.jws.WebService;
@WebService
public class eBay {
	Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    public boolean register(String regEmail,String firstName,String lastName,String Dob, String contactNo,String location, String password,String date) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    	System.out.println("reached registration part of server");
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager
                .getConnection("jdbc:mysql://localhost/ebayuser?"
                                + "user=root&password=1234");
        st = con.createStatement();
        StringBuffer xmlArray = new StringBuffer("<results>");
        boolean response=false;
        try{
        	 response = st.execute("insert into users (emailId,password,firstName,lastName,Dob,location,lastLogin) values ('"+regEmail+"','"+password+"','"+firstName+"','"+lastName+"','"+Dob+"','"+location+"','"+date+"')");
        
       
        while (rs.next()) {
        	System.out.println("reached registration part of server");
            int total_rows = rs.getMetaData().getColumnCount();
            xmlArray.append("<result ");
            for (int i = 0; i < total_rows; i++) {
                xmlArray.append(" " + rs.getMetaData().getColumnLabel(i + 1)
                    .toLowerCase() + "='" + rs.getObject(i + 1) + "'");
            }
            xmlArray.append(" />");
        }
        xmlArray.append("</results>");
        }
        catch(Exception e){
        	System.out.println(e.getMessage());
        }
        
        return response;
    }
    public String login(String emailId, String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager
                .getConnection("jdbc:mysql://localhost/ebayuser?"
                                + "user=root&password=1234");
        st = con.createStatement();
        rs = st.executeQuery("select emailId,seller_handle from ebayuser.users where emailId='"+emailId+"' and password='" +password+"'");
        StringBuffer xmlArray = new StringBuffer("<results>");
        while (rs.next()) {
            int total_rows = rs.getMetaData().getColumnCount();
            xmlArray.append("<result ");
            for (int i = 0; i < total_rows; i++) {
                xmlArray.append(" " + rs.getMetaData().getColumnLabel(i + 1)
                    .toLowerCase() + "='" + rs.getObject(i + 1) + "'");
            }
            xmlArray.append(" />");
        }
        xmlArray.append("</results>");
        return xmlArray.toString();
    }
    
    public String ebayMainPage(String emailId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager
                .getConnection("jdbc:mysql://localhost/ebayuser?"
                                + "user=root&password=1234");
        st = con.createStatement();
        rs = st.executeQuery("select firstName from ebayuser.users where emailId='"+emailId+"';'");
        StringBuffer xmlArray = new StringBuffer("<results>");
        while (rs.next()) {
            int total_rows = rs.getMetaData().getColumnCount();
            xmlArray.append("<result ");
            for (int i = 0; i < total_rows; i++) {
                xmlArray.append(" " + rs.getMetaData().getColumnLabel(i + 1)
                    .toLowerCase() + "='" + rs.getObject(i + 1) + "'");
            }
            xmlArray.append(" />");
        }
        xmlArray.append("</results>");
        return xmlArray.toString();
    }
    
    public String ebayCart(String emailId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager
                .getConnection("jdbc:mysql://localhost/ebayuser?"
                                + "user=root&password=1234");
        st = con.createStatement();
        rs = st.executeQuery("select firstName from ebayuser.users where emailId='"+emailId+"';'");
        StringBuffer xmlArray = new StringBuffer("<results>");
        while (rs.next()) {
            int total_rows = rs.getMetaData().getColumnCount();
            xmlArray.append("<result ");
            for (int i = 0; i < total_rows; i++) {
                xmlArray.append(" " + rs.getMetaData().getColumnLabel(i + 1)
                    .toLowerCase() + "='" + rs.getObject(i + 1) + "'");
            }
            xmlArray.append(" />");
        }
        xmlArray.append("</results>");
        return xmlArray.toString();
    }
    public String profile(String emailId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager
                .getConnection("jdbc:mysql://localhost/ebayuser?"
                                + "user=root&password=1234");
        st = con.createStatement();
        rs = st.executeQuery("select firstName,emailId,lastName,Dob,location,seller_handle from ebayuser.users where emailId='"+emailId+"';'");
        StringBuffer xmlArray = new StringBuffer("<results>");
        while (rs.next()) {
            int total_rows = rs.getMetaData().getColumnCount();
            xmlArray.append("<result ");
            for (int i = 0; i < total_rows; i++) {
                xmlArray.append(" " + rs.getMetaData().getColumnLabel(i + 1)
                    .toLowerCase() + "='" + rs.getObject(i + 1) + "'");
            }
            xmlArray.append(" />");
        }
        xmlArray.append("</results>");
        return xmlArray.toString();
    }
    
    public String postAdvertisement(String seller_handle,String s_username,String prd_name,String prd_desc,String prd_quantity,String prd_price,String prd_image,String type) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager
                .getConnection("jdbc:mysql://localhost/ebayuser?"
                                + "user=root&password=1234");
        st = con.createStatement();
        
        rs = st.executeQuery("insert into ebayuser.product (seller_handle,s_username,prd_name,prd_desc,prd_quantity,prd_price,prd_image,type) values "+"('"+seller_handle+"','"+s_username+"','"+prd_name+"','"+prd_desc+"','"+prd_quantity+"','"+prd_price+"','"+prd_image+"','"+type+"';'");
        StringBuffer xmlArray = new StringBuffer("<results>");
        while (rs.next()) {
            int total_rows = rs.getMetaData().getColumnCount();
            xmlArray.append("<result ");
            for (int i = 0; i < total_rows; i++) {
                xmlArray.append(" " + rs.getMetaData().getColumnLabel(i + 1)
                    .toLowerCase() + "='" + rs.getObject(i + 1) + "'");
            }
            xmlArray.append(" />");
        }
        xmlArray.append("</results>");
        return xmlArray.toString();
    }
    public String fetchAdvertisement(String s_username) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager
                .getConnection("jdbc:mysql://localhost/ebayuser?"
                                + "user=root&password=1234");
        st = con.createStatement();
        rs = st.executeQuery("select * from ebayuser.product where s_username='"+s_username+"''");
        StringBuffer xmlArray = new StringBuffer("<results>");
        while (rs.next()) {
            int total_rows = rs.getMetaData().getColumnCount();
            xmlArray.append("<result ");
            for (int i = 0; i < total_rows; i++) {
                xmlArray.append(" " + rs.getMetaData().getColumnLabel(i + 1)
                    .toLowerCase() + "='" + rs.getObject(i + 1) + "'");
            }
            xmlArray.append(" />");
        }
        xmlArray.append("</results>");
        return xmlArray.toString();
    }
    
public String myPurchases(String buyer_uname) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager
                .getConnection("jdbc:mysql://localhost/ebayuser?"
                                + "user=root&password=1234");
        st = con.createStatement();
        rs = st.executeQuery("select * from ebayuser.bill where buyer_uname ='"+buyer_uname+"';'");
        StringBuffer xmlArray = new StringBuffer("<results>");
        while (rs.next()) {
            int total_rows = rs.getMetaData().getColumnCount();
            xmlArray.append("<result ");
            for (int i = 0; i < total_rows; i++) {
                xmlArray.append(" " + rs.getMetaData().getColumnLabel(i + 1)
                    .toLowerCase() + "='" + rs.getObject(i + 1) + "'");
            }
            xmlArray.append(" />");
        }
        xmlArray.append("</results>");
        return xmlArray.toString();
    }

public String mySoldItems(String s_username) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager
            .getConnection("jdbc:mysql://localhost/ebayuser?"
                            + "user=root&password=1234");
    st = con.createStatement();
    rs = st.executeQuery("select * from ebayuser.bill where s_username ='"+s_username+"';'");
    StringBuffer xmlArray = new StringBuffer("<results>");
    while (rs.next()) {
        int total_rows = rs.getMetaData().getColumnCount();
        xmlArray.append("<result ");
        for (int i = 0; i < total_rows; i++) {
            xmlArray.append(" " + rs.getMetaData().getColumnLabel(i + 1)
                .toLowerCase() + "='" + rs.getObject(i + 1) + "'");
        }
        xmlArray.append(" />");
    }
    xmlArray.append("</results>");
    return xmlArray.toString();
}

public String eBayShowBidders(String type,String productId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager
            .getConnection("jdbc:mysql://localhost/ebayuser?"
                            + "user=root&password=1234");
    st = con.createStatement();
    rs = st.executeQuery("select * from ebayuser.bill where type='"+type+"'and productId='"+productId+"';'");
    StringBuffer xmlArray = new StringBuffer("<results>");
    while (rs.next()) {
        int total_rows = rs.getMetaData().getColumnCount();
        xmlArray.append("<result ");
        for (int i = 0; i < total_rows; i++) {
            xmlArray.append(" " + rs.getMetaData().getColumnLabel(i + 1)
                .toLowerCase() + "='" + rs.getObject(i + 1) + "'");
        }
        xmlArray.append(" />");
    }
    xmlArray.append("</results>");
    return xmlArray.toString();
}

public String postAdvertisementBid(String seller_handle,String s_username,String prd_name,String prd_desc,String prd_quantity,String prd_price,String prd_image,String type,String bid_days,String date_of_sale,String available_till) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager
            .getConnection("jdbc:mysql://localhost/ebayuser?"
                            + "user=root&password=1234");
    st = con.createStatement();
    rs = st.executeQuery("insert into ebayuser.product (seller_handle,s_username,prd_name,prd_desc,prd_quantity,prd_price,prd_image,type,bid_days,date_of_sale,available_till) values "+"('"+seller_handle+"','"+s_username+"','"+prd_name+"','"+prd_desc+"','"+prd_quantity+"','"+prd_price+"','"+prd_image+"','"+type+"','"+bid_days+"',now(),DATE_ADD(date_of_sale, INTERVAL '"+available_till+"' DAY);'");
    StringBuffer xmlArray = new StringBuffer("<results>");
    while (rs.next()) {
        int total_rows = rs.getMetaData().getColumnCount();
        xmlArray.append("<result ");
        for (int i = 0; i < total_rows; i++) {
            xmlArray.append(" " + rs.getMetaData().getColumnLabel(i + 1)
                .toLowerCase() + "='" + rs.getObject(i + 1) + "'");
        }
        xmlArray.append(" />");
    }
    xmlArray.append("</results>");
    return xmlArray.toString();
}



}
