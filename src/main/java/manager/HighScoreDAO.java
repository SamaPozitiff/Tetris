package manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HighScoreDAO {
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

    public List<HighScoreDTO> findAll(){
        return session.createNativeQuery("SELECT * FROM score_board").getResultList();
    }

    public void saveScore(HighScoreDTO highScoreDTO){
        session.save(highScoreDTO);
    }



}
