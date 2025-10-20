package metier;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import dao.IDao;
import entities.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CategorieDaoImpl implements IDao<Categorie> {


    @Autowired
    private SessionFactory sessionFactory;



    @Transactional
    @Override
    public boolean create(Categorie o) {
        Session session=sessionFactory.getCurrentSession();
        session.save(o);
        return true;
    }

    @Transactional
    @Override
    public boolean delete(Categorie o) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(o);
        return true;
    }

    @Transactional
    @Override
    public boolean update(Categorie o) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(o);
        return true;
    }

    @Transactional
    @Override
    public Categorie findById(int id) {
        return sessionFactory.getCurrentSession().get(Categorie.class, id);
    }

    @Transactional
    @Override
    public List<Categorie> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Categorie", Categorie.class)
                .list();
    }
}
