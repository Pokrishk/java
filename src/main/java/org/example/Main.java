package org.example;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
public class Main {
    public static void main(String[] args) {
        System.out.println("Приветствую! Что вы хотите запустить? \n1.Есть ли 18? \n2.P, S, R: ");
        Scanner scanner = new Scanner(System.in);
        int prog = scanner.nextInt();
        switch (prog) {
            case 1:
                System.out.println("Введите ФИО: ");
                Scanner sc = new Scanner(System.in);
                String FIO = sc.nextLine();
                System.out.println("Введите дату рождения (в формате дд.мм.гггг): ");
                String birthDate = sc.nextLine();
                sc.close();
                LocalDate date = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                User user = new User(FIO, date);
                User[] users = new User[]{user};
                if (user.isEighteen()) {
                    System.out.println("Пользователю уже исполнилось 18 лет");
                } else {
                    System.out.println("Пользователю еще не исполнилось 18 лет");
                }
                break;
            case 2:
                System.out.println("Что вы хотите найти? \n1.P \n2.S \n3.R ");
                Scanner scaner = new Scanner(System.in);
                int answ = scaner.nextInt();
                switch (answ) {
                    case 1:
                        System.out.println("P Какой фигуры хотите найти? \n1.Квадрат \n2.Пряиоугольник");
                        int ch = scanner.nextInt();
                        switch (ch){
                            case 1:
                                System.out.println("Введите сторону: ");
                                double a = scaner.nextDouble();
                                scaner.close();
                                System.out.println("Результат: " + perimetr(a));
                                break;
                            case 2:
                                System.out.println("Введите первую сторону: ");
                                double b = scaner.nextDouble();
                                System.out.println("Введите вторую сторону: ");
                                double c = scaner.nextDouble();
                                System.out.println("Результат: " + perimetr(b, c));
                                scaner.close();
                                break;
                            default:
                                System.out.println("Что-то пошло не так. Перезапустите программу");
                        }
                        break;
                    case 2:
                        System.out.println("S Какой фигуры хотите найти? \n1.Квадрат \n2.Пряиоугольник");
                        int cho = scaner.nextInt();
                        switch (cho) {
                            case 1:
                                System.out.println("Введите сторону: ");
                                double a = scaner.nextDouble();
                                System.out.println("Результат: " + ploshad(a));
                                scaner.close();
                                break;
                            case 2:
                                System.out.println("Введите первую сторону: ");
                                double b = scaner.nextDouble();
                                System.out.println("Введите вторую сторону: ");
                                double c = scaner.nextDouble();
                                System.out.println("Результат: " + ploshad(b, c));
                                scaner.close();
                                break;
                            default:
                                System.out.println("Что-то пошло не так. Перезапустите программу");
                        }
                        break;
                    case 3:
                        System.out.println("Введите периметр: ");
                        double p = scaner.nextDouble();
                        System.out.println("Результат: " + radius(p));
                        scaner.close();
                        break;
                }
                break;
            default:
                System.out.println("Что-то пошло не так. Перезапустите программу");

        }
        scanner.close();
    }
    public static double perimetr(double a)
    {
        return a * 4;
    }
    public static double perimetr(double a, double b)
    {
        return (a+b)*2;
    }
    public static double ploshad(double a)
    {
        return a * a;
    }
    public static double ploshad(double a, double b)
    {
        return a*b;
    }
    public static double radius(double p)
    {
        return p/(2* Math.PI);
    }
}


class User {
    private String FIO;
    private LocalDate birthDate;

    public User(String FIO, LocalDate birthDate) {
        this.FIO = FIO;
        this.birthDate = birthDate;
    }

    public boolean isEighteen() {
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);
        if(age.getYears() > 18)
            return true;
        else if (age.getYears() == 18)
        {
            if (currentDate.isAfter(birthDate)) {
                return true;
            } else if (currentDate.isBefore(birthDate)) {
                return false;
            } else {
                return true;
            }
        }
        return false;

    }
}
