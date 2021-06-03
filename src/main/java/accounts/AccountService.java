package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;
import org.h2.message.DbException;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountService {
    DBService dbService;

    public AccountService() {
        this.dbService = new DBService();
        dbService.printConnectInfo();
    }
    //добавление в логин нового юзера
    public void addNewUser(UserProfile userProfile) {
        String login = userProfile.getLogin();
        String password = userProfile.getPass();
        try {
            dbService.addUser(login, password);
        } catch (DBException e){
            e.printStackTrace();
        }
    }
    // получить юзера
    public UserProfile getUserByLogin(String login) {
        String loginDB = null;
        String passwordDB = null;
        try {
            UsersDataSet usersDataSet = dbService.getUser(login);
            loginDB = usersDataSet.getLogin();
            passwordDB = usersDataSet.getPassword();
            return new UserProfile(loginDB, passwordDB);
        } catch (DBException e) {
            e.printStackTrace();
        }
        return new UserProfile(loginDB, passwordDB);

    }







//    // две мапы: 1 отвечает за логин профиля, 2 за сессию профиля
//    private final Map<String, UserProfile> loginToProfile;
//    private final Map<String, UserProfile> sessionIdToProfile;
//    // при создании мапы инициализируются
//    public AccountService() {
//        loginToProfile = new HashMap<>();
//        sessionIdToProfile = new HashMap<>();
//    }
//    //добавление в логин нового юзера
//    public void addNewUser(UserProfile userProfile) {
//        loginToProfile.put(userProfile.getLogin(), userProfile);
//    }
//    // получить логин юзера
//    public UserProfile getUserByLogin(String login) {
//        return loginToProfile.get(login);
//    }
//    //получить сессию юзера
//    public UserProfile getUserBySessionId(String sessionId) {
//        return sessionIdToProfile.get(sessionId);
//    }
//    //добавить сессию юзера
//    public void addSession(String sessionId, UserProfile userProfile) {
//        sessionIdToProfile.put(sessionId, userProfile);
//    }
//    // удалить сессию из sessionIdToProfile
//    public void deleteSession(String sessionId) {
//        sessionIdToProfile.remove(sessionId);
//    }
}
