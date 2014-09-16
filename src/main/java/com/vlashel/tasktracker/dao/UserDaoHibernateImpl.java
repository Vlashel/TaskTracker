package com.vlashel.tasktracker.dao;

import com.vlashel.tasktracker.model.User;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 06.06.2014.
 */
@Repository
@Transactional
public class UserDaoHibernateImpl implements UserDao {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public User getUserById(Long id) {

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("id", id));

        return (User) criteria.uniqueResult();
        
       
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void createUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "DELETE FROM User where id = :id";

        Query query = session.createQuery(hql);

        query.setLong("id", id);

        query.executeUpdate();
    }

    @Override
    public User getUserByName(String name) {

        if (sessionFactory == null) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!SESSION FACTORY IS NULL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("name", name));

        return (User) criteria.uniqueResult();
    }

    @Override
    public List<User> getAllUsers() {

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);

        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        return (List<User>) criteria.list();
    }
}
