package com.vlashel.tasktracker.dao;

import com.vlashel.tasktracker.model.Task;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TaskDaoHibernateImpl implements TaskDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Task getTask(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Task) session.get(Task.class, id);
	}

	@Override
	public void updateTask(Task task) {
		Session session = sessionFactory.getCurrentSession();
        session.update(task);
	}

	@Override
	public void createTask(Task task) {
		sessionFactory.getCurrentSession().save(task);
	}

	@Override
	public void deleteTask(Long id) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "DELETE FROM Task WHERE id = :id";

        Query query = session.createQuery(hql);

        query.setLong("id", id);

        query.executeUpdate();
	}

    @Override
    public List<Task> getAllTasks(Long id) {

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Task.class);
        criteria.addOrder(Order.desc("createdDate"));
        Criteria userCriteria = criteria.createCriteria("user");
        userCriteria.add(Restrictions.eq("id", id));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        return (List<Task>) criteria.list();
    }
}
