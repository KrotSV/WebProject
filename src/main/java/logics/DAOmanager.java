package logics;

public class DAOmanager {
    public DAO getDAO(){
        return new DAOJava();
    }
}
