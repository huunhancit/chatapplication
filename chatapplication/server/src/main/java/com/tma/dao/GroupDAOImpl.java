package com.tma.dao;

import com.tma.model.Group;
import com.tma.model.Message;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.Set;


/**
 * Created by dhnhan on 7/2/15.
 */
@Repository(value = "groupDAO")
public class GroupDAOImpl implements GroupDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public <T> void save(T t) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
    }

    @Override
    public <T> void update(T t) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
    }
    @Override
    public <T> void delete(T t) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
    }

    @Override
    public <T> T getObjectById(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        T t = (T) session.get(Group.class,id);
        session.getTransaction().commit();
        return t;
    }

    @Override
    public Group findGroupByNameGroup(String namegroup) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Group.class);
        criteria.add(Restrictions.eq("namegroup", namegroup));
        long count = criteria.list().size();
        Group group = null;
        if (count > 0)
            group = (Group) criteria.list().get(0);
        session.getTransaction().commit();
        return group;
    }

    @Override
    public void addMessageIntoGroup(Group group, Message message) {
        group.addMessage(message);
        this.update(group);
    }

    @Override
    public Set<Message> getAllMessageByNameGroup(String namegroup) {
        Session session= this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Group.class);
        criteria.add(Restrictions.eq("namegroup",namegroup));
        long count = criteria.list().size();
        Group group = (Group) criteria.list().get(0);
        session.getTransaction().commit();
        if (count > 0)
           return  group.getMessages();
        return null;
    }

    @Override
    public boolean checkGroupExit(String namegroup) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Group.class);
        criteria.add(Restrictions.eq("namegroup",namegroup));
        long count = criteria.list().size();
        session.getTransaction().commit();
        if (count >0)
            return true;
        return false;
    }

    @Override
    public void deleteMessageByNameGroup(String namegroud) {
        Group group = findGroupByNameGroup(namegroud);
        if (group != null){
            Iterator iterator = group.getMessages().iterator();
            while (iterator.hasNext()){
                Message message = (Message) iterator.next();
                delete(message);
            }
        }
    }
}
