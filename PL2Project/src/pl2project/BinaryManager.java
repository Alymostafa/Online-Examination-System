/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2project;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ali Abdulhady
 */
public class BinaryManager implements Serializable{
        public boolean write(String path,Object data){
        try{
        ObjectOutputStream write=new ObjectOutputStream(new FileOutputStream(path));
        write.writeObject(data);
        System.out.println("Compeleted");
        write.close();
        return true;
        }
        catch(IOException e){
                System.out.println(e);
                }
        
    return false;
    }
    
    public Object read(String path){
    Object output=null;
    try{
    ObjectInputStream reader=new ObjectInputStream(new FileInputStream(path));
    output=reader.readObject();
    }
    catch(IOException e){
    System.out.println(e);
    }   catch (ClassNotFoundException ex) {   
            Logger.getLogger(BinaryManager.class.getName()).log(Level.SEVERE, null, ex);
        }   
    return output;
    }
    
}
