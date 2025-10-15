package manager;

import java.util.List;

public class HighScoreService {

    private static HighScoreDAO highScoreDAO;

    public HighScoreService(){
        highScoreDAO = new HighScoreDAO();
    }

    public void persist (HighScoreDTO entity){
        highScoreDAO.openSessionWithTransaction();
        highScoreDAO.persist(entity);
        highScoreDAO.closeSessionWithTransaction();
    }

    public void update(HighScoreDTO entity){
        highScoreDAO.openSessionWithTransaction();
        highScoreDAO.update(entity);
        highScoreDAO.closeSessionWithTransaction();
    }

    public HighScoreDTO findById(Long id){
        highScoreDAO.openSession();
        HighScoreDTO highScoreDTO = highScoreDAO.findById(id);
        highScoreDAO.closeSession();
        return highScoreDTO;
    }

    public void delete (Long id){
        highScoreDAO.openSessionWithTransaction();
        HighScoreDTO highScoreDTO =  highScoreDAO.findById(id);
        highScoreDAO.delete(highScoreDTO);
        highScoreDAO.closeSessionWithTransaction();
    }
    public List<HighScoreDTO> findAll(){
        highScoreDAO.openSession();
        List<HighScoreDTO> entityList = highScoreDAO.findAll();
        highScoreDAO.closeSession();
        return entityList;
    }
    public void deleteAll(){
        highScoreDAO.openSessionWithTransaction();
        highScoreDAO.deleteAll();
        highScoreDAO.closeSessionWithTransaction();
    }

    public HighScoreDAO highScoreDAO(){
        return highScoreDAO;
    }
}
