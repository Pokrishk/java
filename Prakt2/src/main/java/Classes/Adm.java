package Classes;
public class Adm extends User {
    public Adm(int _Role, String _Login, int _Password){
        super(_Role, _Login, _Password);
    }
    public Adm(String _Login, int _Password){
        super(_Login, _Password);
    }
    @Override
    public void showUser(User[] mass) {
        for (int i=0; i< mass.length; i++){
            System.out.println(mass[i]);
        }
    }
    public void showInfo(){
        System.out.printf("Ваша роль: %d \nВаш логин: %s \nВаш пароль: %d", getRole(), getLogin(), getPassword());
    }
    @Override
    public void showChances(){
        System.out.println("Ваши шансы изменить свою жизнь: " + 0);
    }

}
