package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.UserDao;
import model.entities.User;

public class UserDaoJDBC implements UserDao {

	Connection conn = null;

	public UserDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public User findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
			st.setInt(1, id);

			rs = st.executeQuery();
			if (rs.next()) {
				User user = instantiateUser(rs);
				return user;
			}
			return null;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		
		try {
			st = conn.prepareStatement("SELECT * FROM users");
			rs = st.executeQuery();
			
			while (rs.next()) {
				User user = instantiateUser(rs);
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void insert(User obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User obj) {
		// TODO Auto-generated method stub

	}
	
	private User instantiateUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPassWord(rs.getString("password"));
		return user;
	}

}
