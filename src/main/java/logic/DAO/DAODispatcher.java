package logic.DAO;

public class DAODispatcher {
    public static DAO getDAO(){
        return new DAOmysql();
        }
}
