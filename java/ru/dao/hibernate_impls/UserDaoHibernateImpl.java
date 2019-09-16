package ru.dao.hibernate_impls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.dao.UserDao;
import ru.models.User;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;
import java.util.List;
import java.util.Optional;

public class UserDaoHibernateImpl implements UserDao {
    private SessionFactory sessionFactory;

    public UserDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Optional<User> findUserByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Query query = session.createQuery("FROM User where name =?1");
        query.setParameter(1,name);
        User user = (User) query.getSingleResult();
        transaction.commit();
        session.close();
        if (user!=null){
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public void deleteByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Query query = session.createQuery("delete from User where name =?1");
        query.setParameter(1,name);
        query.executeUpdate();
        session.flush();
        transaction.commit();
        session.close();
    }

    @Override
    public Optional<User> find(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        User user = session.find(User.class, id);
        transaction.commit();
        session.close();
        if (user != null) {
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        List<User> userList = session.createQuery("FROM User", User.class).list();
        transaction.commit();
        session.close();

        return userList;
    }

    @Override
    public void save(User model) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        session.save(model);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(User model) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        session.update(model);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        User user = session.load(User.class, id);
        session.delete(user);
        transaction.commit();
        session.close();
    }
}
