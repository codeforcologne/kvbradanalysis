package de.illilli.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.io.IOUtils;

public abstract class Select<T> {

	private String queryString;

	private List<T> dbObjectList = new ArrayList<T>();

	protected void runSelect(BeanListHandler<T> beanListHandler,
			Object... params) throws SQLException, NamingException, IOException {

		Connection conn = ConnectionFactory.getConnection();
		InputStream inputStream = this.getClass().getResourceAsStream(
				queryString);
		String sql = IOUtils.toString(inputStream);

		DbUtilsBeanListHandler<T> rsh = new DbUtilsBeanListHandler<T>(conn,
				beanListHandler, sql, params);
		dbObjectList = rsh.getList();

		conn.close();
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public List<T> getDbObjectList() {
		return dbObjectList;
	}

}
