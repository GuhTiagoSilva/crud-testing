package model.dao;

import db.DB;
import model.dao.impl.CourseDaoJDBC;

public class DaoFactory {
	
	public static CourseDaoJDBC createCourseDao() {
		return new CourseDaoJDBC(DB.getConnection()); 
	}
	
	
	
}
