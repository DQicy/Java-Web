package dq_jdbc_final;


import dq_jdbc_final.phonebook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dq_jdbc_final.DBUtil;
public class DAO {
	//������ϵ����Ϣ
	public void addone(phonebook pb) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql=""+
		"insert into phonebook"+
		"(name,sex,number)"+
		"values(?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, pb.getName());
		ptmt.setString(2, pb.getSex());
		ptmt.setString(3, pb.getNumber());
		ptmt.execute();
		System.out.println("add success!");
	}
	//�޸���ϵ����Ϣ
	public void updateone(phonebook pb) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql=" "+
				   "update phonebook "+
				   "set sex= ? , number= ? "+
				   "where name=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, pb.getSex());
		ptmt.setString(2, pb.getNumber());
		ptmt.setString(3, pb.getName());
		ptmt.execute();				
				
	}
	//ɾ����ϵ����Ϣ
	public void deleteone(String name) throws SQLException {
		
		Connection conn = DBUtil.getConnection();
		String sql=""+
		"delete from phonebook where name=?"
		+" "
		+"";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, name);
		ptmt.execute();
	}
	//��ѯ��ϵ����Ϣ
	public List<phonebook> queryone() throws SQLException{
			ArrayList<phonebook> result = new ArrayList<phonebook>();
			Connection conn = DBUtil.getConnection();
			String sql="select * from phonebook";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery(sql);
			phonebook pb=null;
			while(rs.next()) {
				pb = new phonebook();
				String string = rs.getString("name");
				pb.setName(string);
				string = rs.getString("sex");
				pb.setSex(string);
				string = rs.getString("number");
				pb.setNumber(string);
				result.add(pb);
			}
			return result;
		
		}
	//��ѯ�ض���������ϵ����Ϣ
		public phonebook getone(String name) throws SQLException {
			Connection conn = DBUtil.getConnection();
//			String sql=""+
//					"select * from phonebook where name=?"
//					+" "
//					+"";
//			String sql=" "+
//			" select * from phonebook "+
//			" "+
//			"where name= ? "+
//			" ";
			String sql="" +
					" select * from phonebook where name = ? ";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, name);
			ResultSet rs = ptmt.executeQuery();
			phonebook pb=null;
			while(rs.next()) {
				pb = new phonebook();
				pb.setName(rs.getString("name"));
				pb.setSex(rs.getString("sex"));
				pb.setNumber(rs.getString("number"));
			}
			return pb;
	}
}
