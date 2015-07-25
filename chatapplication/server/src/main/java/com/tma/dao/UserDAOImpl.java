package com.tma.dao;

import com.tma.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dhnhan on 7/2/15.
 */
@Repository(value = "userDAO")
public class UserDAOImpl implements UserDao
{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    @Transactional
    public boolean checkLogin(String username, String password) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username",username));
        criteria.add((Restrictions.eq("password", password)));
        int count = criteria.list().size();
        session.getTransaction().commit();
        if (count > 0)
            return true;
        else
            return false;
    }

    @Override
    @Transactional
    public User getUserByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username",name));
        User user = (User) criteria.list().get(0);
        session.getTransaction().commit();
        return user;
    }

    @Override
    @Transactional
    public boolean checkUserExist(String username) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username",username));
        long count = criteria.list().size();
        session.getTransaction().commit();
        if (count > 0)
            return true;
        return false;
    }

    @Override
    @Transactional
    public List<User> getAllUser() {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        List<User> users = criteria.list();
        session.getTransaction().commit();
        return users;
    }

    @Override
    @Transactional
    public <T> void save(T t) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
    }

    @Override
    @Transactional
    public <T> void update(T t) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
    }

    @Override
    @Transactional
    public <T> void delete(T t) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
    }

    @Override
    @Transactional
    public <T> T getObjectById(long id) {
        return null;
    }


}
