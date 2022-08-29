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
        Session session = highScoreDAO.openSessionWithTransaction();
        session.save(player);
        System.out.println("Сохранили игрока" + player.getId());
        highScoreDAO.commitTransaction();
        player.setName("Степан");
        highScoreDAO.openTransaction();
        HighScoreDTO highScoreDTO= new HighScoreDTO();
        highScoreDTO.setHighScore(9999L);
        highScoreDTO.setPlayer(player);
        highScoreDAO.saveScore(highScoreDTO);
        highScoreDAO.commitTransaction();
        highScoreDAO.openTransaction();
        assert highScoreDAO.findAll().size() > 0;
        highScoreDAO.closeSessionWithTransaction();
    }

}
