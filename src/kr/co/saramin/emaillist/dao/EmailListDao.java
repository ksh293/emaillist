package kr.co.saramin.emaillist.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.saramin.emaillist.vo.EmailListVo;

public class EmailListDao {
		public void insert(EmailListVo vo){
			Connection conn = null;
			PreparedStatement pstmt = null;
			try{
				//1.드라이버 로딩
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost/webdb";
				//2.DB 연결
				conn = DriverManager.getConnection(url,"webdb","webdb");
				//3.create statement
				String sql = "insert into emaillist values (null, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				//4.binding
				pstmt.setString(1, vo.getFirstName());
				pstmt.setString(2, vo.getLastName());
				pstmt.setString(3, vo.getEmail());
				//5.result
				pstmt.executeUpdate(sql);
				
			}catch(ClassNotFoundException ex){
				ex.printStackTrace();
				System.out.println("Driver Loading Fail");
			}catch(SQLException ex){
				ex.printStackTrace();
				System.out.println("error=" + ex);
			}finally{
				try{
					if(pstmt != null){
						pstmt.close();	
					}
					if(conn != null){
						conn.close();
					}
			}catch(SQLException ex){
				ex.printStackTrace();
				}
			}

			
		}
		public List<EmailListVo> getList(){
			List<EmailListVo> list = new ArrayList<EmailListVo>();
			Connection conn = null;
			Statement stmt = null;
			String sql = null;
			ResultSet rs = null;
			try{
				//1.드라이버 로딩
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost/webdb";
				//2.DB 연결
				conn = DriverManager.getConnection(url,"webdb","webdb");
				//3.create statement
				stmt = conn.createStatement();
				//4.Query
				sql = "select * from emaillist";
				rs = stmt.executeQuery(sql);
				//5.result
				while(rs.next()){
					Long no = rs.getLong(1);
					String firstName = rs.getString(2);
					String lastName = rs.getString(3);
					String email = rs.getString(4);
					
					EmailListVo vo = new EmailListVo();
					vo.setNo(no);
					vo.setFirstName(firstName);
					vo.setLastName(lastName);
					vo.setEmail(email);
					
					list.add(vo);
				}
				
			}catch(ClassNotFoundException ex){
				ex.printStackTrace();
				System.out.println("Driver Loading Fail");
			}catch(SQLException ex){
				ex.printStackTrace();
				System.out.println("error=" + ex);
			}finally{
				try{
					if(rs != null){
						rs.close();	
					}
					if(stmt != null){
						stmt.close();	
					}
					if(conn != null){
						conn.close();
					}
			}catch(SQLException ex){
				ex.printStackTrace();
				}
			}
			
			return list;
		}
}
