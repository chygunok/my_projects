package Homework;
import java.util.*;
import java.io.*;
public class PhoneBook {
    private String Name;
    private String Surname;
    private String patronymic;
    private String PhoneNumberS;
    private String PhoneNumberH;
    private String area;
    private String status;

    PhoneBook(String Name, String Surname, String patronymic, String PhoneNumberS, String PhoneNumberH, String area, String status) {
        this.Name = Name;
        this.Surname = Surname;
        this.patronymic = patronymic;
        this.PhoneNumberS = PhoneNumberS;
        this.PhoneNumberH = PhoneNumberH;
        this.area = area;
        this.status = status;
    }

    PhoneBook(String s, String s1, String s2, String i, String j, String s3, String s4, String s5, String s6) {
    }
    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhoneNumberS() {
        return PhoneNumberS;
    }

    public String getPhoneNumberH() { return PhoneNumberH; }

    public String getArea() {
        return area;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setArea(String area) { this.area = area; }

    public void setPhoneNumberS(String PhoneNumberS) { this.PhoneNumberS = PhoneNumberS; }

    public void setPhoneNumberH(String PhoneNumberH) {
        this.PhoneNumberH = PhoneNumberH;
    }

    public void setStatus(String status) { this.status = status; }
    void Printdata(){
        System.out.println("Имя - " + Name + ", Фамилия - " + Surname +", Отчество - " + patronymic + ", Адрес - " + area
                +  ",  Сотовый телефон - " + PhoneNumberS + ", Домашний телефон - " + PhoneNumberH +", Статус - " + status );
    }
}
