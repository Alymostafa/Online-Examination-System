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
public class Essay extends Questions{
    void setEssay(Exam x,String a,double de){
    this.Q = a;
    this.q_degree = de;
    this.qt = 4;
    x.added_q++;

}
    
}
