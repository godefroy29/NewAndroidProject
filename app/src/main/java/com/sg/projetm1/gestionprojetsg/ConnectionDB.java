package com.sg.projetm1.gestionprojetsg;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Godefroy on 02/03/2016.
 */

public class ConnectionDB extends AsyncTask<Void, Integer, Void>
{
    public String adr;
    public String dbName;
    public String dbUser;
    public String dbPwd;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values){
        super.onProgressUpdate(values);
    }

    @Override
    protected Void doInBackground(Void... arg0) {
        Connection connection;
        Statement statement;
        ResultSet result;
        System.out.println("Chargement driver");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver Valide");
        } catch (Exception e) {
            System.out.println("JDBC driver fail");
            return null;
        }

        try {
            System.out.println("Test connection");
            //connection = DriverManager.getConnection("jdbc:mysql://192.168.1.25:3306/myBase?user=plop&password=plop");

            connection = DriverManager.getConnection("jdbc:mysql://"+adr+":3306/"+dbName+"?user="+dbUser+"&password="+dbPwd);
            System.out.println("Connection open");
            statement = connection.createStatement();
            System.out.println("Statement créé");
            result = statement.executeQuery("SELECT * from plop");
            System.out.println("SQL request done");
            result.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {


    }
}
