/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2project;


/**
 *
 * @author lenovo
 */
public class MatchQ extends Questions{
    String QTA = new String();
    String QAS = new String();
    
    
    public void setMatchQ (Exam x ,String a,String b,String c,double de){
        this.Q = a;
        this.q_degree = de;
        this.QTA = b;
        this.QAS = c;
        this.qt = 3;
        x.added_q++;
    }
    public String TA(){
   return this.QTA;
   }
   public String AS (){
   return this.QAS;
   }
        
    
    
}
