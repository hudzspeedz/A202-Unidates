package com.coventery.jack.unidatesapp.app;

/**
 * Created by user on 14/04/2016.
 */
public class Matches {
    // private variables
    int _id;
    String _Username;
    String _Password;
    String _Firstname;
    String _Surname;
    String _Age;
    String _University;
    String _Url1;
    String _Url2;
    String _Url3;

    public Matches(){

    }


    public Matches(int id,
                 String firstname, String surname, String age, String university, String url1, String url2,String url3){
        this._id = id;
        this._Firstname = firstname;
        this._Surname = surname;
        this._Age = age;
        this._University = university;
        this._Url1 = url1;
        this._Url2 = url2;
        this._Url3 = url3;
    }


    public Matches(
                 String firstname, String surname, String age, String university, String url1, String url2,String url3){
        this._Firstname = firstname;
        this._Surname = surname;
        this._Age = age;
        this._University = university;
        this._Url1 = url1;
        this._Url2 = url2;
        this._Url3 = url3;
    }


    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_Username() {
        return this._Username;
    }

    public void set_Username(String _Username) {
        this._Username = _Username;
    }

    public String get_Password() {
        return this. _Password;
    }

    public void set_Password(String _Password) {
        this._Password = _Password;
    }

    public String get_Firstname() {
        return this._Firstname;
    }

    public void set_Firstname(String _Firstname) {
        this._Firstname = _Firstname;
    }

    public String get_Surname() {
        return this._Surname;
    }

    public void set_Surname(String _Surname) { this._Surname = _Surname; }

    public String get_Age() {
        return this._Age;
    }

    public void set_Age(String _Age) {
        this._Age = _Age;
    }

    public String get_University() {
        return this._University;
    }

    public void set_University(String _University) {
        this._University = _University;
    }

    public String get_Url1() {
        return this._Url1;
    }

    public void set_Url1(String _Url1) {
        this._Url1 = _Url1;
    }

    public String get_Url2() {
        return this._Url2;
    }

    public void set_Url2(String _Url2) {
        this._Url2 = _Url2;
    }

    public String get_Url3() {
        return this._Url3;
    }

    public void set_Url3(String _Url3) {
        this._Url3 = _Url3;
    }
}
