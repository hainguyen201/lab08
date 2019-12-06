package bll;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductBLL {
    public List<Product> getNewProducts(int number) throws NamingException {
        
        try {   
            Context initContext= new InitialContext();
            DataSource ds=(DataSource) initContext.lookup("java:comp/env/jdbc/eMarket");
            Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from product");
            ArrayList<Product> prods = new ArrayList<>();
            while (resultSet.next()) {
                Product p = new Product();
                p.setProductID(resultSet.getInt("product_id"));
                p.setName(resultSet.getString("name"));
                p.setCategoryID(resultSet.getInt("category_id"));
                p.setPrice(resultSet.getFloat("price"));
                p.setDescription(resultSet.getString("description"));
                p.setImage(resultSet.getString("image"));
                
                p.setThumbImage(resultSet.getString("thumb_image"));
                p.setLastUpdate(resultSet.getDate("last_update"));
                p.setDescriptionDetail(resultSet.getString("description_detail"));
                prods.add(p);
            }
            return prods;
        } catch (SQLException e) {
            return null;
        }
        /*
         * finally { try { if (connection != null) { connection.close(); } if (statement
         * != null) { statement.close(); } if (resultSet != null) { resultSet.close(); }
         * } catch (SQLException e2) { // TODO: handle exception return null; } }
         */
    }

}
