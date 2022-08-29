package manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HighScoreDAO {

    Session session;
    public HighScoreDAO(){
        Configuration config = new Configuration();
        config.configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        session = sessionFactory.getCurrentSession();
    }

    public HighScoreDTO findMin(){
        HighScoreDTO highScoreDTO = new HighScoreDTO();
        return session.createQuery("SELECT * FROM score_board ORDER BY score LIMIT 1", HighScoreDTO.class).getSingleResult();
    }

    public List<HighScoreDTO> findAll(){
        return session.createQuery("SELECT * FROM score_board").getResultList();
    }

    public void saveScore(HighScoreDTO highScoreDTO){
        session.beginTransaction();
        session.save(highScoreDTO);
        session.getTransaction().commit();
    }



}
