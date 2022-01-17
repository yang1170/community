package com.newcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository("alpha")
public class AlphaDaoHibernateImpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}
