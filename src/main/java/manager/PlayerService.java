package manager;

import java.util.List;

public class PlayerService {

    private PlayerDAO playerDAO;

    public  PlayerService(){
        playerDAO = new PlayerDAO();
    }

    public void persist(PlayerDTO entity){
        playerDAO.openSessionWithTransaction();
        playerDAO.persist(entity);
        playerDAO.closeSessionWithTransaction();
    }

    public void update(PlayerDTO entity){
        playerDAO.closeSessionWithTransaction();
        playerDAO.update(entity);
        playerDAO.closeSessionWithTransaction();
    }

    public PlayerDTO findById(Long id){
        playerDAO.openSession();
        PlayerDTO playerDTO = playerDAO.findById(id);
        playerDAO.closeSession();
        return playerDTO;
    }

    public void delete (Long id){
        playerDAO.openSessionWithTransaction();
        playerDAO.delete(playerDAO.findById(id));
        playerDAO.closeSessionWithTransaction();
    }

    public List<PlayerDTO> findAll(){
        playerDAO.openSession();
        List<PlayerDTO> entityList = playerDAO.findAll();
        playerDAO.closeSession();
        return entityList;
    }

    public void deleteAll(){
        playerDAO.openSessionWithTransaction();
        playerDAO.deleteAll();
        playerDAO.closeSessionWithTransaction();
    }

    public PlayerDAO playerDAO(){
        return playerDAO;
    }
}
