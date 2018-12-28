package com.thzhima.eye025.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetExtractor<T> {

	T extract(ResultSet rst)throws SQLException;
}
