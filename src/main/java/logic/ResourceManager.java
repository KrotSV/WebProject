package logic;

public class ResourceManager {
    public static DAO getDAO(){
        return new DAOmysql();
        }
}
