/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2project;

/**
 *
 * @author Ali Abdulhady
 */

    
    
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;


/**
 *
 * @author elnafad
 */
public class Student extends SystemUser implements Serializable{
    protected static int times_exams ;
    private double degree;

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public double getDegree() {
        return degree;
    }
    
    final private String StudentFileName = "Student.bin" ; 

   // private final String studentFileName = "Students.txt";
    
    public static ArrayList<Student> Students = new ArrayList<>();
    //public static ArrayList<subjects> allSubject = new ArrayList<subjects>();
    public static ArrayList<Subject> registeredsubjects = new ArrayList<Subject>();
    public static ArrayList<Integer> IDEnter = new ArrayList<Integer>();
    public static ArrayList<Double> degres = new ArrayList<Double>();
 //   public static HashMap<Integer,String> stuInfo = new HashMap<>();
    public static HashMap<String,Float> degInfo = new HashMap<>();
  //  public static HashMap<Object , Object> H_degrees = new HashMap<>();
    BinaryManager fmanager=new BinaryManager();
    private final String studentSubjectsFile="studentSubjects.bin";

    public  boolean setRegisteredsubjects(Subject s) {
        loadSubjects();
        registeredsubjects.add(s);
        return updateSubjects();
    }
   
    
    /*
    private String[] subjects;
    private String[] degrees_for_each_question;
    */
    Exams exam = new Exams() ;
    Subject sub = new Subject() ;
  //  private static int ACi=0;
    
    private void loadSubjects(){
        registeredsubjects=(ArrayList<Subject>) fmanager.read(studentSubjectsFile);
    }
    private boolean updateSubjects(){
        return fmanager.write(studentSubjectsFile,registeredsubjects);
    }
    public Student() {
        /// Students.add(this);

    }

    public Student(int id,String email,String username,String password,
            String fname,String lname) {
         super(id,email,username,password,fname,lname);

        

  
    }

    
    
    
    public boolean registere (String subID)
    {
        
         
        
        for(int i =0 ; i<=registeredsubject.size();i++){
        
            if( registeredsubject.get(i) == subID) {
                System.out.println("you are reguist it before ");
                break ;
                
            }
        }
        
        if (registeredsubject.add(subID)){
            
            
            return true;}
        
        else
        {
            System.out.println("Sorry ");
            return false ;
        }
    }
    
    
    
    
    public String showExam(String subID)
    {
        int flag = 0 ;
        if(registeredsubject.isEmpty())
                flag = 0;
        else{
            for(int i = 0 ; i<=registeredsubject.size() ; i++)
            {
                /*if(registeredsubject.isEmpty()){
                    flag = 0;
                    break;
                }*/
                 if(subID.equals(registeredsubject.get(i)))
                {
                    flag = 1 ; 
                    break ;
                } 
                else {
                    flag = 0 ; 
                    break ;
                }

            }
        }
        if (flag == 1)
            return exam.get_data() ; 
        else    
            return "sorry you are not registree this subject " ;
        
       
}
    
    
    public boolean enterExam(int id)
    {
        
        
        int flag =0;
        //System.out.println(IDEnter.size());
       // System.out.println(IDEnter.get(0));
        //IDEnter.add(1);
        //IDEnter.add(2);
        //IDEnter.add(3);
       // IDEnter.add(4);
       
        for(int i=0 ; i <=IDEnter.size();i++)
        {
            if(IDEnter.isEmpty())
            {
                
                flag = 1;
                break ;
            }
            else if(id == IDEnter.get(i)  )
            {
               // System.out.println("4444444444");
                flag = 0 ;
                break ;
                
            }
            else 
            {
                flag = 1 ;
            }
        }
                System.out.println(IDEnter.size());

        if(flag == 1)
        {
            IDEnter.add(id);
//             for(int p=0 ; p <IDEnter.size();p++)
//        {
//            System.out.println(IDEnter.get(p));
//        }
          //  System.out.println(IDEnter.size());  
            return true;
            
        }
        else
            return false ;
        
        
    } 
    public float myDegree()
    {
        float degrees = 0;
        for(int i =0 ; i<=Exams.degree.size();i++)
        {
            degrees = degrees + Exams.degree.get(i);
            
        }
        return degrees;
    }

    @Override
    public String toString() {
        return "\nI'm Eng : " + FName + " " + Lname + "\n" + "ID : " + ID  + "\n"
                + "Level : " + level + " GPA : " + GPA ;
    }
    public  void report()
    {
        for(int i=0 ;i<=registeredsubject.size();i++ )
        {
            System.out.println(degInfo.get(i));
            
        }
        
        
        
    }
    private void loadData() {
            Students = (ArrayList<Student>) fmanager.read(StudentFileName);
     }
    
    private boolean updateData(){
    
            return fmanager.write(StudentFileName, Students);
        
      }
    private String getData() {
        return ID + "@" + FName + "@" + Lname + "@"+ level + "@" + GPA + "@" + PassWord + "@"+Student.registeredsubject+"@";

    }
    private int getDataStudent(int id){
        for (int i = 0; i < Students.size(); i++)
            if(Students.get(i).getID() == id) {                
             return i;

            }
        return 0;   
    }
   
    public boolean addStudent(){
        loadData();
        Students.add(this);
        return updateData();
    }
       public boolean updateStudent(int Sid, Student s){
           
        loadData();
        int ind = getDataStudent(Sid);
        Students.set(ind, s);
        return updateData();
    } 
    
       public boolean searchStudent(int id){
           loadData();
           int sid=getDataStudent(id);
        return (sid>0);
       }
       
       public String listStudents(){
           loadData();
           String x="\n";
           for(Student s:Students){
               x=x+s.toString();
           }
           return x;
       }
     public boolean deleteStudent(int id )
     {
       loadData();
       int ind = getDataStudent(id);
       Students.remove(ind);
       return updateData();
       
     }
    @Override
    public Student login(String username,String password){
        loadData();
        for(Student s:Students){
            if(username.equals(s.UserName)&&password.equals(s.PassWord))
                return s;
        }
        return null;
    }
    
    
        
    
    
    
    
    
}

   
   
   
   
   
   
   
   
   


