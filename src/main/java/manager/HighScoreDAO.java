package manager;

import com.sun.xml.bind.v2.TODO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HighScoreDAO implements DaoHighScoreInterface<HighScoreDTO>{
    private Session session;
    private Transaction currentTransaction;

    public Session openSession(){
        session = getSessionFactory().openSession();
        return session;
    }

    public Session openSessionWithTransaction(){
        session = getSessionFactory().openSession();
        currentTransaction = session.beginTransaction();
        return session;
    }

    public void openTransaction(){
        currentTransaction = session.beginTransaction();
    }

    private static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }
    public Session getCurrentSession(){
        return session;
    }

    public void closeSession(){
        session.close();
    }

    public void closeSessionWithTransaction(){
        currentTransaction.commit();
        session.close();
    }

    public void commitTransaction(){
        currentTransaction.commit();
    }


    public HighScoreDTO findMin(){
        Session session = getCurrentSession();
        return session.createQuery("SELECT * FROM score_board ORDER BY score LIMIT 1", HighScoreDTO.class).getSingleResult();
    }

    @Override
    public void persist(HighScoreDTO entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(HighScoreDTO entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public HighScoreDTO findById(Long id) {
        return getCurrentSession().get(HighScoreDTO.class, id);
    }

    @Override
    public void delete(HighScoreDTO entity) {
        getCurrentSession().delete(entity);
    }

    public List<HighScoreDTO> findAll(){
        List<HighScoreDTO> list = (List<HighScoreDTO>) getCurrentSession().createQuery("from HighScoreDTO").list();
        return list;
    }

    @Override
    public void deleteAll() {
        List<HighScoreDTO> entityList = findAll();
        for (HighScoreDTO entity : entityList){
            delete(entity);
        }
    }
}
