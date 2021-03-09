package com.company.data;

import java.sql.Connection;
import java.sql.SQLException;

public interface sqlConnection {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
