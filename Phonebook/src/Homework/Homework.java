package Homework;
import java.util.*;
import java.io.*;
import java.io.IOException;
import java.io.FileWriter;
public class Homework {
    static List<PhoneBook> phone1 = new ArrayList<>();


    public static void main(String[] args) {
        main();
    }

    public static void main() {

        try (Scanner scanner = new Scanner(new File("123.txt"));) {
            Scanner s = new Scanner(System.in);
            Homework main = new Homework();
            main.FirstData(scanner);
            main.menu(s);
            s.close();
        } catch (IOException ex) {
            System.out.println("Файл отсутствует!");
        }
    }

    void menu(Scanner s) {
        System.out.println("Загружено знакомых " + phone1.size());
        System.out.println();
        System.out.println("\033[1mМеню:\033[0m");
        System.out.println();
        System.out.println("1. Добавить знакомого.");
        System.out.println("2. Удалить знакомого.");
        System.out.println("3. Изменение адреса или телефона.");
        System.out.println("4. Приглашение на собитие по статусу.");
        System.out.println("5. Вывод на экран всех знакомых по фамилии или статусу.");
        System.out.println("6. Выход из программы.");
        String snum = s.nextLine();
        if (!snum.matches("[-+]?\\d+") || Integer.parseInt(snum) > 7 || Integer.parseInt(snum) < 1) {
            menu(s);
            return;
        }
        int num = Integer.parseInt(snum);

        if (num == 1) AddPhone(s);
        if (num == 2) delPhone(s);
        if (num == 3) ChangeAdress(s);
        if (num == 4) Invite(s);
        if (num == 5) Sort(s);
        if (num != 6) {
            menu(s);
        } else {
            System.out.println("Программа завершила работу.");
            System.exit(0);
        }
    }

    public void FirstData(Scanner s) {
        System.out.println("Вводите данные в файл без знаков препинания английскими буквами, в порядке, установленном условиями задачи");
        String text = s.useDelimiter("\\A").next();
        s.close();
        String[] info;
        text = text.replace("\n", " ").replace("\r", " ");
        text = text.replaceAll("[\\s]{2,}", " ");
        info = text.split(" ");
        if (info.length % 9 != 0) {
            System.out.println("В файле находятся некорректные данные");
            return;
        }
        for (int i = 0; i < info.length; i+=9){
        if ((!info[i].matches("[a-zA-Z]+")) || (!info[i + 1].matches("[a-zA-Z]+")) || (!info[i + 2].matches("[a-zA-Z]+"))
                || (!info[i + 3].matches("[-+]?\\d+")) || (!info[i + 4].matches("[-+]?\\d+"))
                || (!info[i + 5].matches("[a-zA-Z]+")) || (!info[i + 6].matches("[a-zA-Z]+"))
                || (!info[i + 7].matches("[-+]?\\d+")) || (!info[i + 8].matches("[a-zA-Z]+"))) {
            System.out.println("В файле находятся некорректные данные");
            return;
        }

        phone1.add(new PhoneBook(info[i], info[i + 1], info[i + 2], info[i + 3], info[i + 4], info[i + 5]+ " " + info[i + 6]+ " " + info[i + 7], info[i + 8]));}
    }

    private void AddPhone(Scanner s) {
        System.out.println("Введите Имя");
        String s1 = s.nextLine();
        if (!s1.matches("[a-zA-Z]+")) {
            System.out.println("Введено некорректное Имя");
            AddPhone(s);
        } else {
            System.out.println("Введите Фамилию");
            String s2 = s.nextLine();
            if (!s2.matches("[a-zA-Z]+")) {
                System.out.println("Введена некорректная Фамилия");
                AddPhone(s);
            } else {
                System.out.println("Введите Отчество");
                String s3 = s.nextLine();
                if ((!s3.matches("[a-zA-Z]+"))) {
                    System.out.println("Введено некорректное Отчество");
                    AddPhone(s);
                } else {
                    System.out.println("Введите Сотовый номер");
                    String s4 = s.nextLine();
                    if (!s4.matches("[-+]?\\d+")) {
                        System.out.println("Введено не число");
                        AddPhone(s);
                    } else {
                        System.out.println("Введите Домашний номер");
                        String s5 = s.nextLine();
                        if ((!s5.matches("[-+]?\\d+"))) {
                            System.out.println("Введено не число");
                            AddPhone(s);
                        } else {
                            System.out.println("Введите адрес");
                            String s6 = s.nextLine();
                            String[] s7 = s6.split(" ");
                            if ((!s7[0].matches("[a-zA-Z]+")) || (!s7[1].matches("[a-zA-Z]+") || (!s7[2].matches("[-+]?\\d+")))) {
                                System.out.println("Введены некорректные данные");
                                AddPhone(s);
                            } else {
                                System.out.println("Введите статус");
                                String s8 = s.nextLine();
                                if (!s8.matches("[a-zA-Z]+")) {
                                    System.out.println("Выввели не число");
                                    AddPhone(s);
                                }
                                phone1.add(new PhoneBook(s1, s2, s3, s4, s5, s7[0]+" "+ s7[1]+" "+ s7[2], s8));
                                int j=phone1.size();
                                j=j-1;
                                try {
                                    Writer output;
                                    output = new BufferedWriter(new FileWriter("123.txt", true));
                                    output.append("\n"+phone1.get(j).getName() + " "+ phone1.get(j).getSurname()+" "+ phone1.get(j).getPatronymic()+" "+phone1.get(j).getPhoneNumberS()+" "+phone1.get(j).getPhoneNumberH()+" "+phone1.get(j).getArea()+" "+phone1.get(j).getStatus());
                                    output.close();
                                }
                                catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    private void delPhone(Scanner s) {
        System.out.println("Введите имя");
        String s1 = s.nextLine();
        if (s1.matches("[-+]?\\d+")) {
            System.out.println("Некорректное имя");
            delPhone(s);
        } else {
            System.out.println("Введите Фамилию");
            String s2 = s.nextLine();
            if (s2.matches("[-+]?\\d+")) {
                System.out.println("Некорректная фамилия");
                delPhone(s);
            } else {
                System.out.println("Введите Отчество");
                String s3 = s.nextLine();
                if (s3.matches("[-+]?\\d+")) {
                    System.out.println("Некорректное Отчество");
                    delPhone(s);
                } else {
                    System.out.println("Введите Сотовый номер");
                    String s4 = s.nextLine();
                    if (!s4.matches("[-+]?\\d+")) {
                        System.out.println("Вы ввели не число");
                        delPhone(s);
                    } else {
                        System.out.println("Введите Домашний номер");
                        String s7 = s.nextLine();
                        if (!s7.matches("[-+]?\\d+")) {
                            System.out.println("Вы ввели не число");
                            delPhone(s);
                        } else {
                            System.out.println("Введите статус");
                            String s6 = s.nextLine();
                            if ((!s6.matches("[a-zA-Z]+"))) {
                                System.out.println("Вы ввели некорректный статус");
                                delPhone(s);
                            } else {
                                System.out.println("Введите адрес");
                                String s8 = s.nextLine();
                                String[] s9 = s8.split(" ");
                                if ((!s9[0].matches("[a-zA-Z]+") || (!s9[1].matches("[a-zA-Z]+")) || (!s9[2].matches("[-+]?\\d+")))) {
                                    System.out.println("Вы ввели некорректный адрес");
                                    delPhone(s);
                                }
                                PhoneBook work = new PhoneBook(s1, s2, s3, s4, s7, s9[0] + " " + s9[1] + " " + s9[2], s6);
                                for (int i = 0; i < phone1.size(); i++) {
                                    if (work.getClass() == phone1.get(i).getClass())
                                        phone1.remove(i);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void ChangeAdress(Scanner s) {
        ArrayList<Integer> check = new ArrayList<>();
        for (int i = 0; i < phone1.size(); i++) {
            check.add(i);
        }
        System.out.println("Выберите человека в списке, нажмите правильную цифру");
        String s1 = s.nextLine();
        if ((Integer.parseInt(s1) > check.size()) || (!s1.matches("[-+]?\\d+"))) {
            System.out.println("Вы ввели некорректные данные");
            ChangeAdress(s);
        }
        int p = Integer.parseInt(s1);
        System.out.println("Введите 1, если хотите изменить адрес и 2, если хотите изменить телефон");
        String s3= s.nextLine();
        int ent = Integer.parseInt(s3);
        if ((ent > 2) || (ent < 1) || (!s3.matches("[-+]?\\d+")))
        {
            System.out.println("Введены некорректные данные");
            ChangeAdress(s);
        }
        if (ent == 1) {
            System.out.println("Введите новый адрес");
            String s2 = s.nextLine();
            phone1.get(p).setArea(s2);
        }
        else
        {
            System.out.println("Введите 1, если хотите изменить мобильный телефон, 2, если хотите изменить домашний");
            String s4 = s.nextLine();
            int ph = Integer.parseInt(s4);
            if ((ph > 2) || (ph < 1) || (!s4.matches("[-+]?\\d+")))
            {
                System.out.println("Введены некорректные данные");
                ChangeAdress(s);
            }
            else
                {
                    if (ph==1)
                    {
                        System.out.println("Введите новый сотовый телефон");
                        String s5 = s.nextLine();
                        phone1.get(p).setPhoneNumberS(s5);
                    }
                    else
                        {
                            System.out.println("Введите новый домашний телефон");
                            String s6 = s.nextLine();
                            phone1.get(p).setPhoneNumberH(s6);
                        }
                }
        }
    }

    private void Invite(Scanner s){
        System.out.println("Введите статус человека");
        String s1 = s.nextLine();
        if (!s1.matches("[a-zA-Z]+"))
        {
            System.out.println("Неправильно введен статус");
            Invite(s);
        }
        int i;
        System.out.println("Введите приглашение на праздник или поздравление");
        String s4 =s.nextLine();
        System.out.println("Введите 1, если хотите ввести адрес");
        String s5 =s.nextLine();
        int j = Integer.parseInt(s5);
        for (i=0;i<phone1.size();i++)
        {
            String s2 = phone1.get(i).getStatus();

            if (s2.equals(s1))
            {
                String s3= Integer.toString(i+1);
                String filename = "%s invite.txt".format(s3);
                File file = new File(filename);
                try
                {
                    file.createNewFile();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                try (FileWriter writer = new FileWriter(filename)) {
                    if (j==1)
                    {
                        writer.write(phone1.get(i).getArea() +"\n");
                        writer.write(s4);
                    }
                    else{
                    writer.write(s4);
                    }
                } catch

        (IOException e) {
            e.printStackTrace();
        }
            }
        }
    }
    private void Sort(Scanner s)
    {
        System.out.println("Введите 1, если хотите отсортировать по фамилии, 2, если хотите отсортировать по статусу");
        String s1 = s.nextLine();
        int p = Integer.parseInt(s1);
        if ((p > 2) || (p < 1) || (!s1.matches("[-+]?\\d+")))
        {
            System.out.println("Введены некорректные данные");
            Sort(s);
        }
        if (p==1)
        {
            Collections.sort(phone1,(p1,p2) -> {
            return p1.getSurname().compareTo(p2.getSurname());
            }
            )
            ;
            for (int i = 0; i < phone1.size(); i++){
                phone1.get(i).Printdata();
            }
        }
        else
        {
            Collections.sort(phone1,(p1,p2) -> {
                return p1.getStatus().compareTo(p2.getStatus());
            }
            )
            ;
            for (int i = 0; i < phone1.size(); i++){
                phone1.get(i).Printdata();
            }
        }
    }
}


