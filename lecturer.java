/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class lecturer extends sy  {
    
    public static ArrayList<lecturer>lecturers =new ArrayList<>();
    static ArrayList<String>teached_subjects = new ArrayList<>();
    public static ArrayList<student>reports = new ArrayList<>();
    HashMap<Integer,Integer>map = new HashMap<>();
    HashMap<Integer,Integer>student_degrees = new HashMap<>();

    Scanner sc = new Scanner(System.in); 
    public static ArrayList<String> getTeached_subjects() {
        return teached_subjects;
    }

    public static void setTeached_subjects(ArrayList<String> teached_subjects) {
        lecturer.teached_subjects = teached_subjects;
    }
    private final String lecturerFileName = "lecturer.txt";
    private final String reportsfilename = "reports.txt";
    
   
    
   public lecturer (String username, String pass, int id, String fname, String lname , String email)
   {
       super( username , pass , id , fname , lname , email);

   }
   
   
   
  public boolean addlecturer(){
       return FManger.write(getDataAUX(), lecturerFileName,true);
        }
    
    
    
    @Override
     public String toString() {
        return "lecturer " + fname + lname + "\n" + "ID : " + id   + "\nUserName: " + username + "\t Password: " + pass + "\n";
    }
    
     //AUX FUNCTIONS SECTION//
     //WE USE IT IN OTHER FUNCTIONS AND DONT MAKE BODY OF FUNCTION SO BIG//
     private void loadAUX() {
            lecturers = (ArrayList<lecturer>) (Object) FManger.read(lecturerFileName);
     }
     
      private int getterAUX(int id){
        for (int i = 0; i < lecturers.size(); i++)
            if(lecturers.get(i).getID() == id) {                
             return i;

            }
        return 0;   
    }
      private void updateAUX(){
      for (int i = 1; i < lecturers.size(); i++) {
            FManger.write(lecturers.get(i).getDataAUX(), lecturerFileName, true);
        }
      }
      
      private String getDataAUX() {
        return this.id + "~~" + this.fname + "~~" + this.lname + "~~"+ this.username + "~~" + this.pass + "~~"+lecturer.teached_subjects+"~~";

    }
      
      private student write_reports_Aux(student x)
    {
        map.put(x.id, x.degree);
        
       for (int i = 0; i < x.reports.length; i++) {
	System.out.print("Enter The Report Please : " + (i+1) + " : ");
        x.reports[i] = sc.nextLine();
       }  
       return x;
       
    }
      
    
        
     
   
    
        
    
       
      
      
     //END OF AUX FUNCTIONS SECTION//
     
       public String list_lecturerdata() {
        loadAUX();
        String x = "\n" ;
        for (lecturer z : lecturers) {
            x = x + z.toString();
        }
        return x;
    }
     
    
       public void update_lecturerdata(int oid, lecturer l){
        loadAUX();
        int ind = getterAUX(oid);
        lecturers.set(ind, l);
        updateAUX();
    } 
    
       
     public void delete_lecturerdata(int id , lecturer l)
     {
       loadAUX();
       int ind = getterAUX(id);
       lecturers.remove(ind);
       updateAUX();
       
     }
     
     
    public void addexam(subject x)
    {
        x.addexam();
    }
    
   
    
    
     
    /*void student_reports()
    {

        
    }*/
    
    public void delete_exam(int id , exam l)
     {
         l.delete_exam();
     }
    
    public void update_exam(exam l)
    {
        l.update_exam();
    }
    
    public void list_exams(exam l)
    {
        l.list_exams();   
    }
    
    
    /* public void Assign_studnet_degree(student x , subject y )
    {
        
     
    }
    */
    

 
       
     
     
    
    

    

    
    
}
