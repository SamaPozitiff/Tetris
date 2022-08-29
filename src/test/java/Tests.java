import manager.HighScoreDAO;
import manager.HighScoreDTO;
import manager.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void test(){
        HighScoreDAO highScoreDAO = new HighScoreDAO();
        Player player = new Player();
        player.setName("Стёпочка");
        Configuration config = new Configuration();
        config.configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(player);
        session.getTransaction().commit();
        HighScoreDTO highScoreDTO= new HighScoreDTO();
        highScoreDTO.setHighScore(9999L);
        highScoreDTO.setPlayer(player);
        highScoreDAO.saveScore(highScoreDTO);
        assert highScoreDAO.findAll().size() == 1;
    }

}
