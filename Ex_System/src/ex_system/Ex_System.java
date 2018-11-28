/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_system;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Ali
 */
public class Ex_System extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Text title = new Text("Examenation System");
        title.setFont(Font.font("Tahoma",FontWeight.BOLD,FontPosture.ITALIC, 20));
        ImageView amg3 = new ImageView("Admin.jpg");
        ImageView amg1 = new ImageView("profs.jpg");
        ImageView amg2 = new ImageView("student.jpg");
        Button btn2 = new Button("", amg3);
        Button btn1 = new Button("", amg2);
        Button btn = new Button("",amg1);
        btn2.setOnAction((ActionEvent event) -> {
            System.out.println("I'm a Admin");
        });
        btn.setOnAction((ActionEvent event) -> {
            System.out.println("I'm a Professor");
        });
        btn1.setOnAction((ActionEvent event) -> {
            System.out.println("I'm a Student");
        });
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(25);
        root.add(title, 1, 0);
        root.add(btn, 0, 1);
        root.add(btn1,1,1);
        root.add(btn2,2,1);
        root.setPadding(new Insets(25, 25, 25, 25));
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Examenation System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

    /**
     * @param args the command line arguments
     */