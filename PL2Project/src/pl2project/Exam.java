/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2project;
import java.util.*;


/**
 *
 * @author lenovo
 */
// data types
public class Exam {
String e_type;
String e_date;
int totalDegree;
int question_nom = 0;
int time = 0;
int added_q = 0;
double e_grade;
ArrayList<Questions> questions = new ArrayList<Questions>();
ArrayList<String> SAS = new ArrayList<String>();
String acess_code;

    

//funcs
/*xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
*/
void setType (String a){
this.e_type = a;
}
void setDate(String a){
this.e_date = a;
}
void setNom (int a){
this.question_nom = a;
}
void setTime (int a){
this.time = a;
}
void setTD(int a){
this.totalDegree = a;
}
String getType(){
return this.e_type;
}
String getDate(){
return this.e_date;
}
int getNom(){
return this.question_nom;
}
int getTime (int a){
return this.time;
}
int getTD(){
return this.totalDegree;
}
public void added(){
this.added_q++;
}
public String getAcess_code() {
        return acess_code;
    }

    public void setAcess_code(String acess_code) {
        this.acess_code = acess_code;
    }
public void update_questions(int a,Questions q,Exam x){
    if (q.qt == 1){    x.questions.set(a,(TFQ)q);
}
     else   if (q.qt == 1){    x.questions.set(a,(MCQ)q);
}
     else  if (q.qt == 1){    x.questions.set(a,(MatchQ)q);
}
     else x.questions.set(a,(Essay)q);

}
double get_grade(){
return this.e_grade;}
/*xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
*/
/////////////////////*
/*

double cal_grade(String[] a,String[]b ,double c,int q){
    double grade=0;
    int k ;
    for (k=0 ;k<q ;k++){
    if (a[k]== b[k]) {
    		grade+=c;
    	}
    }
    return grade;
}
*/
 /*xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
*/
void add_ans (String a){
    this.SAS.add(a);
}
String get_ans(int a){
    return this.SAS.get(a);
}


 
double calc(Exam x){
    TFQ q1 ;
    MCQ q2;
    MatchQ q3;
    double grade = 0;
    for (int i=0 ; i < x.added_q ; i++){
    
    if (x.questions.get(i).qt == 1){
        q1 = (TFQ) x.questions.get(i);
    if (q1.TA() == x.SAS.get(i)){
    grade+= x.questions.get(i).q_degree;
            }
    }
    else if (x.questions.get(i).qt == 2){
        q2 = (MCQ) x.questions.get(i);
    if (q2.TA() == x.SAS.get(i)){
    grade+= x.questions.get(i).q_degree;
            }
    }
    else {
    q3 = (MatchQ) x.questions.get(i);
    if (q3.TA() == x.SAS.get(i)){
    grade+= x.questions.get(i).q_degree;
            }
    }
    
    
    
    
    
    
    
}
    






    this.e_grade = grade;
    return grade;
}

/*xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
for (int i=0 ; i<x.added_q;i++){
    q2 = (MCQ) x.questions.get(i);
    if (q2.TA() == x.SAS.get(i)){
    grade+= x.questions.get(i).q_degree;
            }
}
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
void add_q(String a,String b,String c,double de){
    Questions temp = new MatchQ(a,b,c,de);
    this.questions.add(temp);
    this.added_q +=1;
   
}
void add_q(String a,double de){
    Questions temp = new Essay(a,de);
    this.questions.add(temp);
    this.added_q +=1;
   
}
void add_q(String a,String b,String c,String d,double de){
    Questions temp = new TFQ(a,b,c,d,de);
    this.questions.add(temp);
    this.added_q +=1;
}
void add_q(String a,String b,String c,String d, String e,String f,double de){
    Questions temp = new MCQ(a,b,c,d,e,f,de);
    this.questions.add(temp);
    this.added_q +=1;
}
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
*/
}
