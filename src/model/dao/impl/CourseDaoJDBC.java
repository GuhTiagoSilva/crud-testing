package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.CourseDao;
import model.entities.Course;

public class CourseDaoJDBC implements CourseDao {

	private Connection conn;

	public CourseDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Course course) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("INSERT INTO " + "tb_course " + "(nm_course, ds_class, ds_period, ds_year) "
					+ "VALUES (? , ? , ? , ?) ", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, course.getCourseName());
			st.setString(2, course.getClassDescription());
			st.setString(3, course.getPeriod());
			st.setInt(4, course.getYear());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();

				if (rs.next()) {
					int id = rs.getInt(rowsAffected);
					course.setId(id);
				} else {
					throw new DbException("Error! 0 Rows Affected");
				}
				DB.closeResultSet(rs);
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Course course) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(
					"UPDATE tb_course SET nm_course = ?, ds_class= ?, ds_period = ?, ds_year = ? WHERE id_course = ? )");

			st.setString(1, course.getCourseName());
			st.setString(2, course.getClassDescription());
			st.setString(3, course.getPeriod());
			st.setInt(4, course.getYear());

			int rowsAffected = st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void delete(Integer id) {

	}

	@Override
	public List<Course> listAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM tb_course");

			rs = st.executeQuery();

			Map<Integer, Course> map = new HashMap<>();

			List<Course> items = new ArrayList<>();

			while (rs.next()) {
				Course course = map.get(rs.getInt("id_course"));
				if (course == null) {
					course = instantiateCourse(rs);
					items.add(course);

				}

			}

			return items;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {

		}

	}

	private Course instantiateCourse(ResultSet rs) throws SQLException {
		Course course = new Course();
		course.setId(rs.getInt("id_course"));
		course.setCourseName(rs.getString("nm_course"));
		course.setClassDescription(rs.getString("ds_class"));
		course.setPeriod(rs.getString("ds_period"));
		course.setYear(rs.getInt("ds_year"));

		return course;

	}

}
