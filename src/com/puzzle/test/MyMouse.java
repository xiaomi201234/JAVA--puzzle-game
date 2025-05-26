package com.puzzle.test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouse  extends JFrame implements MouseListener {
    JButton jtb=new JButton("clcik me!");
    public  MyMouse(){
        this.setSize(603, 680);
        this.setTitle("Beck Puzzle Game");
        this.setAlwaysOnTop(true);
        //center
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(3);

        //cancel the default central settings
        this.setLayout(null);


        jtb.setBounds(0,0,100,100);
        jtb.addMouseListener(this);
        this.getContentPane().add(jtb);
        this.setVisible(true);

    }





    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("clicked");

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("pressed");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("release");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("enter");

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("exit");

    }


}
