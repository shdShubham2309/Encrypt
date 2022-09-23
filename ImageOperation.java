import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Font.*;
import java.io.*;
import java.awt.FlowLayout.*;

public class ImageOperation{

    public static void operate(int key){
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();
        //file inputStrem
        try {

            FileInputStream fis=new FileInputStream(file);
            byte[]data=new byte[fis.available()];
            fis.read(data);
             int i=0;
            for(byte b:data){
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }

            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"FileIncrypted");
            
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    public static void main(String[] args){
        JFrame f1=new JFrame();
        f1.setTitle("Image Encryption And Decreption");
        f1.setSize(400,400);
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font=new Font("Roboto",Font.BOLD,25);
        //creating button
        JButton b1=new JButton();
        b1.setText("Select Image");
        b1.setFont(font);
        //creating text field
        JTextField textfield=new JTextField(10);
        textfield.setFont(font);

        b1.addActionListener(e->{
            System.out.println("Selecting Image");
            String num=textfield.getText();
            int temp=Integer.parseInt(num);
            operate(temp);
        });
        f1.setLayout(new FlowLayout()); 
        f1.add(b1);
        f1.add(textfield);
        f1.setVisible(true);
    }
}