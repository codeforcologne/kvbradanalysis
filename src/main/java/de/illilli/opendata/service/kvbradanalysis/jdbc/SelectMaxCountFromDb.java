package de.illilli.opendata.service.kvbradanalysis.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.handlers.BeanHandler;

import de.illilli.jdbc.Select;

public class SelectMaxCountFromDb extends Select<NumberDao> {

	String queryString = "/selectMaxCount.sql";

	public SelectMaxCountFromDb() throws SQLException, NamingException, IOException {
		setQueryString(queryString);
		Object[] params = new Object[] {};
		runSelect(new BeanHandler<NumberDao>(NumberDao.class), params);
	}

}
