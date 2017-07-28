package logics;

import javax.naming.NamingException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ResourceManager {
    public static DAO getDAO(){
        return new DAOmysql();
        }
}
