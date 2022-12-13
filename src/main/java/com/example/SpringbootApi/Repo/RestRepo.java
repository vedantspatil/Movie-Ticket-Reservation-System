package com.example.SpringbootApi.Repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RestRepo {
	public static List Query(String query) {
		System.out.print(true);
		List list = null ;
		try {
			String myDriver = "com.mysql.cj.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			list = resultSetToArrayList(rs);
			st.close();
			return list;
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		return list;
	}
	public static List resultSetToArrayList(ResultSet rs) throws SQLException{
		  ResultSetMetaData md = rs.getMetaData();
		  int columns = md.getColumnCount();
		  ArrayList list = new ArrayList();
		  while (rs.next()){
		     HashMap row = new HashMap(columns);
		     for(int i=1; i<=columns; ++i){           
		      row.put(md.getColumnName(i),rs.getObject(i));
		     }
		      list.add(row);
		  }

		 return list;
		}

}
