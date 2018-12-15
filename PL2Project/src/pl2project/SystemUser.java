/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2project;

/**
 *
 * @author ali
 */
public abstract class  SystemUser {
       
    protected int ID;
    protected String UserName;
    protected String PassWord;
    protected String FName;
    protected String Lname;
    protected String email;
    protected String UserType;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }

    public int getID() {
        return ID;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public String getFName() {
        return FName;
    }

    public String getLname() {
        return Lname;
    }

    public String getEmail() {
        return email;
    }

    public String getUserType() {
        return UserType;
    }
//    ************************************************************
    public SystemUser(){
        
    }
    
    public SystemUser(int id,String email,String username,String password,String fname,String lname){
        
        
        this.ID=id;
        this.email=email;
        this.UserName=username;
        this.PassWord=password;
        this.FName=fname;
        this.Lname=lname;
        
    }

   
    public abstract SystemUser login(String username,String password);
 
}