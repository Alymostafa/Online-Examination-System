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
public class MCQ extends Questions{
   String QTA = new String();
   ArrayList<String> QAS = new ArrayList<String>();
   void setMCQ(Exam x,String a,String b,String c,String d,String e,String f,double de){
    this.Q = a;
    this.QTA = b;
    this.QAS.add(c);
    this.QAS.add(d);
    this.QAS.add(e);
    this.QAS.add(f);
    this.q_degree = de;
    x.added_q++;
    this.qt = 2;
}
   public String TA(){
   return this.QTA;
   }
   public String AS (int a){
   return this.QAS.get(a);
   }
}
