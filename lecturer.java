/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.user;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class lecturer extends sy implements Serializable  {
    
    public static ArrayList<lecturer>lecturers =new ArrayList<>();
    static ArrayList<String>teached_subjects = new ArrayList<>();
    public static ArrayList<student>reports = new ArrayList<>();
    HashMap<Integer,Integer>map = new HashMap<>();
    HashMap<String,Integer>student_degrees = new HashMap<>();

    FileMangerBinary fm = new FileMangerBinary();
    
    Scanner sc = new Scanner(System.in); 
    public static ArrayList<String> getTeached_subjects() {
        return teached_subjects;
    }

    public static void setTeached_subjects(ArrayList<String> teached_subjects) {
        lecturer.teached_subjects = teached_subjects;
    }
    private final String lecturerFileName = "lecturer.bin";
    private final String reportsfilename = "reports.bin";
    private final String student_degree = "degrees.bin";
   
    
   public lecturer (String username, String pass, int id, String fname, String lname , String email)
   {
       super( username , pass , id , fname , lname , email);

   }
   public lecturer()
   {
   
   }

    
   
   
  public boolean addlecturer(){
      loadAUX();
      lecturers.add(this);
      return updateAUX();
        }
    
    
    
    @Override
     public String toString() {
        return "lecturer " + fname + lname + "\n" + "ID : " + id   + "\nUserName: " + username + "\t Password: " + pass + "\n";
    }
    
     //AUX FUNCTIONS SECTION//
     //WE USE IT IN OTHER FUNCTIONS AND DONT MAKE BODY OF FUNCTION SO BIG//
     private void loadAUX() {
            lecturers = (ArrayList<lecturer>) (Object) fm.read(lecturerFileName);

     }
     
      private int getterAUX(int id){
        for (int i = 0; i < lecturers.size(); i++)
            if(lecturers.get(i).getID() == id) {                
             return i;

            }
        return 0;   
    }
      private boolean updateAUX(){
          
        return fm.write(lecturerFileName, lecturers );
        
        }
      
      
      private String getDataAUX() {
        return this.id + "~~" + this.fname + "~~" + this.lname + "~~"+ this.username + "~~" + this.pass + "~~"+lecturer.teached_subjects+"~~";

    }
      
      /*private student write_reports_Aux(student x)
    {
        map.put(x.id, x.degree);
        
       for (int i = 0; i < x.reports.length; i++) {
	System.out.print("Enter The Report Please : " + (i+1) + " : ");
        x.reports[i] = sc.nextLine();
       }  
       return x;
       
    }*/
      
      
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
        if (ind != -1) {
        lecturers.set(ind, l);
        updateAUX();
    } 
       }
    
       
     public void delete_lecturerdata(int id , lecturer l)
     {
       loadAUX();
       int ind = getterAUX(id);
       if(ind != -1){
       lecturers.remove(ind);
       updateAUX();
       }
     }
     
    
    public void addexam(subject x)
    {
        x.addexam();
    }
    
   
    
    
     
    public student student_reports(student x)
    {
        map.put(x.id, x.degree);
        
       for (int i = 0; i < x.reports.length; i++) {
	System.out.print("Enter The Report Please : " + (i+1) + " : ");
        x.reports[i] = sc.nextLine();
       }  
        try
           {
         try (FileOutputStream fos = new FileOutputStream("reports.bin"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
             oos.writeObject(map);
         }
                  System.out.printf("Serialized HashMap data is saved in reports.bin");
           }catch(IOException ioe)
            {
            }
        return x;
        
        
    }
    
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
    
    
     public void Assign_student_degree(student x , exam e)
     {
     for (int i = 1; i <x.students_subjects.size(); i++)
     {
         student_degrees.put(x.subject, e.degree);
         
     } 
     try
           {
         try (FileOutputStream fos = new FileOutputStream("degrees.bin"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
             oos.writeObject(student_degrees);
         }
                  System.out.printf("Serialized HashMap data is saved in degrees.bin");
           }catch(IOException ioe)
            {
            }
      }
     
     
   
     
     
     
    
     
    
    

 

     
     
    
    

    

    
    
}
