package dq_jdbc_final;

import java.sql.SQLException;
import java.util.List;

import dq_jdbc_final.DAO;
import dq_jdbc_final.phonebook;
public class DAOaction {
	public void add(phonebook pb) throws SQLException {
		DAO dao=new DAO();
		dao.addone(pb);
	}
	public void update(phonebook pb) throws SQLException {
		DAO dao=new DAO();
		dao.updateone(pb);
	}
	public void delete(String name) throws SQLException {
		DAO dao = new DAO();
		dao.deleteone(name);
	}
	public List<phonebook> query() throws SQLException {
		DAO dao = new DAO();
		List<phonebook> result = dao.queryone();
		return result;
	}
	public phonebook get(String name) throws SQLException {
		DAO dao = new DAO();
		phonebook pb = dao.getone(name);
		return pb;
	}
}
