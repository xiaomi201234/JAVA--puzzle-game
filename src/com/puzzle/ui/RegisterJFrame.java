package com.puzzle.ui;

import com.puzzle.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//user register frame
public class RegisterJFrame extends JFrame implements MouseListener {
    JTextField usertext=new JTextField();
    JPasswordField passtext=new JPasswordField();
    JPasswordField passagain=new JPasswordField();
    JButton reset=new JButton();
    JButton register=new JButton();
    public RegisterJFrame(){
        initFrame();
        initblank();

        this.setVisible(true);

    }
    private void initFrame(){
        this.setSize(490,430);
        this.setTitle("Beck Puzzle Game--Register");
        this.setAlwaysOnTop(true);
        //center
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);


    }
    private void initblank(){

        this.getContentPane().removeAll();

        //1. username
        JLabel username=new JLabel(new ImageIcon("image/register/注册用户名.png"));
        username.setBounds(80,140,79,17);
        usertext.setBounds(180,139,200,30);
        this.getContentPane().add(username);
        this.getContentPane().add(usertext);

        //2. password
        JLabel password=new JLabel(new ImageIcon("image/register/注册密码.png"));
        password.setBounds(80,180,64,16);
        passtext.setBounds(180,179,200,30);
        this.getContentPane().add(password);
        this.getContentPane().add(passtext);

        //3. Register button
        register.setBounds(100,260,128,47);
        register.setIcon(new ImageIcon("image/register/注册按钮.png"));
        register.setBorderPainted(false);
        register.setContentAreaFilled(false);
        register.addMouseListener(this);
        this.getContentPane().add(register);

        //4. reset button
        reset.setBounds(260,260,128,47);
        reset.setIcon(new ImageIcon("image/register/重置按钮.png"));
        reset.setBorderPainted(false);
        reset.setContentAreaFilled(false);
        reset.addMouseListener(this);
        this.getContentPane().add(reset);

        //5. password-again
        JLabel rightpassword=new JLabel(new ImageIcon("image/register/再次输入密码.png"));
        rightpassword.setBounds(80,220,96,17);
        passagain.setBounds(180,219,200,30);
        this.getContentPane().add(rightpassword);
        this.getContentPane().add(passagain);


        //
        JLabel background=new JLabel(new ImageIcon("image/login/background.png"));
        background.setBounds(1,1,470,390);
        this.getContentPane().add(background);

    }
    public void generatedialog(String show){
        JDialog dialog=new JDialog();
        dialog.setSize(280,100);
        dialog.setAlwaysOnTop(true);
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);


        JLabel jl = new JLabel(show, SwingConstants.CENTER); // 水平居中
        jl.setVerticalAlignment(SwingConstants.CENTER);      // 垂直居中
        dialog.add(jl, BorderLayout.CENTER);
        dialog.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==register){
            String userinput=usertext.getText();
            String passinput=passtext.getText();
            String passinput_2=passagain.getText();
            User user=new User();

            if(userinput.length()==0){
                generatedialog("The username can not be blank!");
            } else if (passinput.length()==0 || passinput_2.length()==0) {
                generatedialog("The password can not be  blank!");

            } else if (!passinput.equals(passinput_2)) {
                generatedialog("The passwords are not the same!");

            } else  {
                user.setUsername(userinput);
                user.setPassword(passinput);
                if(LoginJFrame.finduser(user)){
                    generatedialog("The user has already existed!");
                }else {
                    User use=new User();
                    use.setPassword(passinput_2);
                    use.setUsername(userinput);
                    LoginJFrame.userlist.add(use);
                    generatedialog("Register successfully!");
                    this.setVisible(false);
                    new LoginJFrame();
                }

            }

        } else if (e.getSource()==reset) {
        new RegisterJFrame();

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==register){
            register.setIcon(new ImageIcon("image/register/注册按下.png"));
        } else if (e.getSource()==reset) {
            reset.setIcon(new ImageIcon("image/register/重置按下.png"));

        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==register){
            register.setIcon(new ImageIcon("image/register/注册按钮.png"));
        } else if (e.getSource()==reset) {
            reset.setIcon(new ImageIcon("image/register/重置按钮.png"));

        }

    }
}
