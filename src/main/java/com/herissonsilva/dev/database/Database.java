package com.herissonsilva.dev.database;

import java.sql.*;

public class Database
{
    private String driver;
    private String url;
    private Connection conn;
    private Statement statement;
    private String user = null;
    private String password;

    public Statement getStatement()
    {
        return statement;
    }

    public ResultSet getResultSet()
    {
        return resultSet;
    }

    private ResultSet resultSet;

    public Database(final String driver, final String url)
    {
        this.driver = driver;
        this.url = url;
    }

    public Database(final String driver, final String url, final String user, final String password)
    {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public boolean connect()
    {
        try
        {
            Class.forName(driver);

            if(user != null)
                conn = DriverManager.getConnection(url, user, password);
            else
                conn = DriverManager.getConnection(url);

            statement = conn.createStatement();
            return true;
        }catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
            return false;
        }catch(SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    public void close(boolean connection, boolean statment, boolean resultset)
    {
        try
        {
            if(connection)
                conn.close();
            else if(statment)
                statement.close();
            else if(resultset)
                resultSet.close();
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void close()
    {
        try
        {
            conn.close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void setResultSet(String query)
    {
        try
        {
            resultSet = statement.executeQuery(query);
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public int executeQuery(String query)
    {
        int quant = 0;
        try
        {
            quant = statement.executeUpdate(query);
        } catch (SQLException erro)
        {
            erro.printStackTrace();
        }
        return quant;
    }
}