/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2project;

import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class TFQ extends Questions{
    String QTA = new String();
    ArrayList<String> QAS = new ArrayList<String>();
    String qType = "TFQ";
   
    void setTFQ(Exam x,String a,String b,String c,String d,double de){
    this.Q = a;
    this.QTA = b;
    this.QAS.add(c);
    this.QAS.add(d);
    this.q_degree = de;
    this.qt = 1;
    x.added_q++;
}
 public String TA(){
   return this.QTA;
   }
   public String AS (int a){
   return this.QAS.get(a);
   }
  
}
