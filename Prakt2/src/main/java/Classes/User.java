package Classes;
public class User {
    private int _Role;
    private String _Login;
    private int _Password;
    public User(int Role, String Login, int Password){
        this._Login = Login;
        this._Role = Role;
        this._Password = Password;
    }
    public User(String Login, int Password){
        this._Login = Login;
        this._Password = Password;
    }
    public int getRole() {
        return _Role;
    }
    public void setRole(int Role) {
        this._Role = Role;
    }
    public String getLogin() {
        return _Login;
    }
    public void setLogin(String Login) {
        this._Login = Login;
    }
    public int getPassword() {
        return _Password;
    }
    public void setPassword(int Password) {
        this._Password = Password;
    }

    public void showInfo(){
        System.out.printf("Ваша роль: %d \nВаш логин: %s \nВаш пароль: %d", _Role, _Login, _Password);
    }
    public void showChances(){
        System.out.println("Ваши шансы изменить свою жизнь: " + Math.random() * 1999);
    }
    public void showUser(User[] mass){
        System.out.println("Всего пользователей: " + mass.length);
    }

}
