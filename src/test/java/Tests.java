import manager.*;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Tests {
    static PlayerService playerService;
    static HighScoreService highScoreService;

    @BeforeAll
    public static void initialize(){
       playerService = new PlayerService();
       highScoreService = new HighScoreService();
    }

    @Test
    public void test(){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setName("Стёпочка");
        HighScoreDTO highScoreDTO = new HighScoreDTO();
        highScoreDTO.setHighScore(999L);
        highScoreDTO.setPlayer(playerDTO);
        playerService.persist(playerDTO);
        highScoreService.persist(highScoreDTO);

        assert playerDTO.getId() !=null;
    }

    @Test
    public void testDelete(){
        highScoreService.delete(4L);
        assert highScoreService.findById(4L) == null;
    }

    @Test
    public void testDeleteALl(){
        highScoreService.deleteAll();
        assert highScoreService.findAll().size() == 0;
    }

    @Test
    public void findAll(){
        List<HighScoreDTO> list = highScoreService.findAll();
        assert list.size() == 2;
    }

}
