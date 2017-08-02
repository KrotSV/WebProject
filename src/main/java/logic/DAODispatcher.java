package logic;

public class DAODispatcher {
    public static DAO getDAO(){
        return new DAOmysql();
        }
}
