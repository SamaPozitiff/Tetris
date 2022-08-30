package manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PlayerDAO implements DaoInterface<PlayerDTO, Long>{
    private Session session;
    private Transaction currentTransaction;

    public Session openSession(){
        return getSessionFactory().openSession();
    }

    public Session openSessionWithTransaction(){
        session = getSessionFactory().openSession();
        currentTransaction = session.beginTransaction();
        return session;
    }

    private static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration().configure();
        return configuration.buildSessionFactory();
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

    @Override
    public void persist(PlayerDTO entity) {

        getCurrentSession().save(entity);
    }

    @Override
    public void update(PlayerDTO entity) {

        getCurrentSession().update(entity);
    }

    @Override
    public PlayerDTO findById(Long id) {
        return getCurrentSession().get(PlayerDTO.class, id);
    }

    @Override
    public void delete(PlayerDTO entity) {

        getCurrentSession().delete(entity);
    }

    @Override
    public List findAll() {
        return session.createNativeQuery("SELECT * FROM player").list();
    }

    @Override
    public void deleteAll() {
        List<PlayerDTO> entityList = findAll();
        for (PlayerDTO entity : entityList){
            delete(entity);
        }
    }
}
