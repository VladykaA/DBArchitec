package com.architec.dao;

import com.architec.dao.mysql.MySQLDAOFactory;

public abstract class DAOFactory {
    public static final int MySQL = 1;

    public abstract UserDAO getUserDAO();

    public static DAOFactory getDAOFactory() {

        return new MySQLDAOFactory();
    }

}
