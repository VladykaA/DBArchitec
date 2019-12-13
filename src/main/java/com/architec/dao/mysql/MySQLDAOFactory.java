package com.architec.dao.mysql;

import com.architec.dao.DAOFactory;
import com.architec.dao.UserDAO;

public class MySQLDAOFactory extends DAOFactory {
    @Override
    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }
}
