/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2project;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Ali Abdulhady
 */
public class Admin extends SystemUser implements Serializable{
    
    private final String adminFileName="admin.bin" ;
    ArrayList<Admin> admins=new ArrayList<>();

    @Override
    public String toString(){
        
     return "ADMIN's First name: " + FName +  " ,Last name: " +Lname + " ,ID : " 
             + ID + " ,UserName: " + UserName + " ,Password: " + PassWord ;

    }
    
//    *************************************************************************

        
    public Admin(){
        
    }
    public Admin(int id,String email,String username,String password,
            String fname,String lname){
        super(id,email,username,password,fname,lname);
 
    }

        
    
        public void alterPassword(String np){
            this.PassWord=np;
            
        }
        public void alterUsername(String nu){
            this.UserName=nu;
        }


//    **********************************************
    public void add_studnet(int id,String email,String username,String password,
            String fname,String lname){
       Student x=new Student(id,email,username,password,fname,lname);
       if(x.addStudent())
           System.out.println("A new Student has been added successfully,with"+
                   x.toString());
       else
           System.out.println("failed to add");
    }
    
    
    public void add_leturer(int id,String email,String username,String password,
            String fname,String lname){
        Lecturer x=new Lecturer(id,email,username,password,fname,lname);
        if(x.addlecturer())
           System.out.println("A new Lecturer has been added successfully,with"+
                    x.toString());
        else
            System.out.println("Failed to add");
    }
//    ************************************************************************
    public void update_lecturer(int oldL_id,Lecturer newLecturerdata){
        Lecturer x=new Lecturer();
        if(x.update_lecturerdata(oldL_id,newLecturerdata))
            System.out.println("The lecturer with this ID has been updated"
                    + " successfully");
        else
            System.out.println("Failed to updated");
    }
    
    public void update_student(int oldS_id,Student newStudentdata){
        Student x=new Student();
        if(x.updateStudent(oldS_id, newStudentdata))
           System.out.println("The student with this ID has been changed"
                   + " successfully");
        else 
            System.out.println("Failed to updated");
    }
//    ********************************************************
    public void list_lecturers(){
         Lecturer x=new Lecturer();
         String a=x.list_lecturerdata();
         System.out.println(a);
    }

    public void list_students(){
         Student x=new Student();
         String a=x.listStudents();
         System.out.println(a);
}    
  //********************************************************
  public void search_lecturer(int ID){
      Lecturer x=new Lecturer();
      if(x.searchlecturer(ID))    
         System.out.println("found"+x.toString());
         else System.out.println("not found");
  }

  public void search_srudent(int id){
      Student x=new Student();
      if(x.searchStudent(id))
          System.out.println("found"+x.toString());
      else System.out.println("not found");
  }
//  *******************************************
  public void delete_lecturer(int id){
      Lecturer x=new Lecturer();
      if(x.delete_lecturerdata(id))
          System.out.println("Deleted successfully");
  }
  
  public void delete_student(int id){
      Student x=new Student();
      if(x.deleteStudent(id))
          System.out.println("Deleted successfully");
  }
  //*********************************************************
  
  public void addSubject(String accesscode,String name){
      Subject s=new Subject(name,accesscode);
      if(s.addSubject())
      System.out.println("Subject added successfully");
      else
          System.out.println("Failed to add");
  }
  public void listSubject(){
      Subject s=new Subject();
      String s1=s.listSubjects();
      System.out.println(s1);
  }
  public void updateSubject(String oldacc,Subject newsubjectdata){
      Subject s=new Subject();
      if(s.updateSubject(oldacc, newsubjectdata))
          System.out.println("Updated successfully");
      else System.out.println("Failed to update");
      
  }
  public void searchSubject(String acc){
      Subject s=new Subject();
      Object o=s.searchSubject(acc);
      o.toString();
  }
  
  public void deleteSubject(String acc){
      Subject s=new Subject();
      if(s.deleteSubject(acc))
          System.out.println("deleted successfully");
  }
 
  //*********************************************************
  
  public void assignLecturerSubjects(Lecturer l,Subject s){
        if(l.SetTeachedSubjects(s))
        System.out.println("Added successfully");
  }
        
  public void assignStudentSubjects(Student s,Subject su){
      if(s.setRegisteredsubjects(su)){
          System.out.println("Added successfully");
      }
  }
  
//  **************************************************************
      @Override
        public Admin login(String username,String password){
          for(Admin x:admins){
            if(username.equals(this.UserName)&&password.equals(this.PassWord))
                return this;
             }
           return null;
  
  
        }
}