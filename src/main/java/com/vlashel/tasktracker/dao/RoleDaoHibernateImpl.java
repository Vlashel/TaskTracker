package com.vlashel.tasktracker.dao;

import com.vlashel.tasktracker.model.Role;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 30.06.2014.
 */
@Repository
@Transactional
public class RoleDaoHibernateImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (Role) session.get(Role.class, id);
    }

    @Override
    public Role getByName(String role) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Role.class);
        criteria.add(Restrictions.eq("role", role));
        return (Role) criteria.uniqueResult();
    }
}
