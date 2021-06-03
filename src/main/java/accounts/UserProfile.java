package accounts;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class UserProfile {
    //  у юзера есть логин, пароль, сервер
    private final String login;
    private final String pass;

    // два конструктора
    //1. по всем ээлементам
    public UserProfile(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }
    //2. параметр логин присваивается всем элементам
    public UserProfile(String login) {
        this.login = login;
        this.pass = login;
    }
    // геттеры для всех элементов
    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

}
