package net.javaguides.registration.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.javaguides.registration.model.User;
 
public class UserDao {
	Connection con;
	public UserDao(Connection con)
	{
		this.con=con;
	}
	public boolean registerEmployee(User user) throws ClassNotFoundException {
		boolean setStatus=false;
		try
		{
        String INSERT_USERS_SQL = "INSERT INTO users.user" +
            "  (first_name, last_name, username, password, address, contact) VALUES " +
            " (?, ?, ?, ?, ?,?);";

        //int result=0;
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = this.con.prepareStatement(INSERT_USERS_SQL);
            //preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getContact());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
            setStatus=true;

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return setStatus;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    public User login(String email, String pass){
        User usr=null;
        try{
            String query ="select * from user where username=? and password=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, pass);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                usr = new User();
                usr.setFirstName(rs.getString("firstName"));
                usr.setLastName(rs.getString("lastName"));
                usr.setPassword(rs.getString("password"));
                usr.setUsername(rs.getString("username"));
                usr.setAddress(rs.getString("address"));
                usr.setContact(rs.getString("contact"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return usr;
    }
	}
