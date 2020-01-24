package com.architec.dao;

import com.architec.dao.DAOFactory;
import com.architec.dao.interfaces.CRUDUserDAO;
import com.architec.dao.mysql.MySQLCRUDUserDAO;

public class MySQLDAOFactory extends DAOFactory {
   /* @Override
    public CRUDUserDAO getUserDAO() {
        return new MySQLCRUDUserDAO();
    }*/
}
