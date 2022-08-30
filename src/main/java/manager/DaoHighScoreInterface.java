package manager;

public interface DaoHighScoreInterface<T> extends DaoInterface<T, Long>{
    public T findMin();
}
