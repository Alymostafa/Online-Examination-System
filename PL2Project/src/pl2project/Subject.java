/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2project;

import java.util.*;

/**
 *
 * @author Ali Abdulhady
 */
public class Subject {
    
    private String subjectName;
    private String accessCode;
    public static ArrayList<Subject> subjects=new ArrayList<>();
    private final String subjectFileName ="subject.bin";
    BinaryManager fmanager=new BinaryManager();
    
    @Override
    public String toString(){
        return subjectName+"Access code:"+accessCode;
    }

    public Subject() {
    }

    public Subject(String subjectName, String accessCode) {
        this.subjectName = subjectName;
        this.accessCode = accessCode;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    
//    ****************************************************
    private void loadfromfile(){
        subjects =(ArrayList<Subject>) fmanager.read(subjectFileName);
    }
        private boolean updatefile(){
            return fmanager.write(subjectFileName, subjects);
            
        }
        public int getSubjectIndex(String ac){
            for(int i=0;i<subjects.size();i++){
                if(subjects.get(i).getAccessCode().equals(ac))
                    return i;
            }
            return 0;
            
        }
        public boolean addSubject(){
            loadfromfile();
            subjects.add(this);
            return updatefile();
        }
        
        public Subject searchSubject(String acc){
            loadfromfile();
            int si=getSubjectIndex(acc);
            if(si>0){
                return subjects.get(si);
                
            }
            return null;
        }
        public boolean deleteSubject(String acc){
            loadfromfile();
            int si=getSubjectIndex(acc);
            if(si>0){
                subjects.remove(si);
                
                return updatefile();
                
            }
            return false;
        }
        public String listSubjects(){
            loadfromfile();
            String x="\n";
            for(Subject y:subjects ){
                x=x+y.toString();
            }
            return x;
        }
        public boolean updateSubject (String oldacc,Subject newSubject){
            loadfromfile();
            int si=getSubjectIndex(oldacc);
            if(si>0){
                for(Subject x:subjects){
                subjects.set(si, newSubject);
                return updatefile();
                }
            }
            return false;
        }
        
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

