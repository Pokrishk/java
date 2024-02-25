package org.example;
import Classes.Adm;
import Classes.User;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Заполните массив данными");
        Scanner scanner = new Scanner(System.in);
        User[] mass = new User[10];
        for (int i = 0; i < mass.length; i++) {
            System.out.println("Введите роль (1 - Пользователь, 2 - Администратор):");
            int UserRole = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введите логин:");
            String UserLogin = scanner.next();
            System.out.println("Введите пароль:");
            int UserPassword = scanner.nextInt();
            switch (UserRole){
                case 2:
                    Adm newUser = new Adm(UserRole, UserLogin, UserPassword);
                    mass[i] = newUser;
                    break;
                default:
                    User nnewUser = new User(UserRole, UserLogin, UserPassword);
                    mass[i] = nnewUser;
                    break;
            }
        }
        System.out.println("Выберите действие: 1 - Регистрация, 2 - Вход");
        int choice = scanner.nextInt();
        int role =0;
        int index =0;
        switch (choice) {
            case 1:
                System.out.println("Введите данные для регистрации:");
                System.out.println("Введите роль (1 - Пользователь, 2 - Администратор):");
                role = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Введите логин:");
                String login = scanner.nextLine();
                System.out.println("Введите пароль:");
                int password = scanner.nextInt();
                if (role == 1) {
                    mass[0] = new User(role, login, password);
                } else if (role == 2) {
                    mass[0] = new Adm(role, login, password);
                }
                break;
            case 2:
                System.out.println("Введите логин: ");
                String llogin = scanner.next();
                System.out.println("Введите пароль: ");
                int ppassword = scanner.nextInt();
                boolean loggedIn = false;
                for (int i =0; i< mass.length; i++) {
                    if (mass[i].getLogin().equals(llogin) && mass[i].getPassword() == ppassword) {
                        loggedIn = true;
                        System.out.println("Вход выполнен успешно!");
                        role = mass[i].getRole();
                        index = i;
                    }
                }
                if (!loggedIn) {
                    System.out.println("Неверный логин или пароль!");
                }
                break;
            default:
                System.out.println("Что-то пошло не так.");
                break;
        }
            if (role == 2) {
                System.out.println("Доступ к действиям администратора:");
                Adm adm = (Adm) mass[index];
                System.out.println("Выберите действие: \n1 - Просмотреть список пользователей \n2 - Просмотреть информацию об администраторе \n3 - Посмотреть свои шансы на изменения чего-то в жизни");
                int action = scanner.nextInt();
                switch (action){
                    case 1:
                        adm.showUser(mass);
                        break;
                    case 2:
                        adm.showInfo();
                        break;
                    case 3:
                        adm.showChances();
                        break;
                    default:
                        System.out.println("Что-то пошло не так");
                        break;
                }
            } else {
                System.out.println("Доступ к действиям пользователя: \nВыберите действие: \n1 - Просмотреть информацию о пользователе \n2 - Посмотреть количество пользователей \n3 - Посмотреть свои шансы на изменения чего-то в жизни");
                int action = scanner.nextInt();
                switch (action){
                    case 1:
                        mass[index].showInfo();
                        break;
                    case 2:
                        mass[index].showUser(mass);
                        break;
                    case 3:
                        mass[index].showChances();
                        break;
                    default:
                        System.out.println("Что-то пошло не так");
                        break;
                }
            }
    }
}