package com.puzzle.ui;
import cn.hutool.core.io.FileUtil;
import com.puzzle.domain.User;
import  com.puzzle.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
//user login frame

public class LoginJFrame extends JFrame implements MouseListener {

    ArrayList<User> userlist=new ArrayList<>();


    JTextField usertext=new JTextField();
    JPasswordField passtext=new JPasswordField();
    JTextField vcode=new JTextField();
    JLabel rightcode=new JLabel();

    JButton login=new JButton();
    JButton register=new JButton();


    public LoginJFrame(){
        //read user info in the local file
        readuserinfo();

        //when build the login frame,show the frame
        initFrame();
        initblank();

        this.setVisible(true);
    }

    private void readuserinfo() {
        List<String> userinfolist= FileUtil.readUtf8Lines("D:\\多伦多\\Java\\Puzzle game\\userinfo.txt");
        for (String str : userinfolist) {
            String[] userarr = str.split("&");
            String[] arr1 = userarr[0].split("=");
            String[] arr2 = userarr[1].split("=");

            User u =new User(arr1[1],arr2[1]);
            userlist.add(u);

        }
    }

    private void initFrame(){
        this.setSize(490,430);
        this.setTitle("Beck Puzzle Game-- Login");
        this.setAlwaysOnTop(true);
        //center
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);

    }
    private void initblank(){
        this.getContentPane().removeAll();

        //1. username
        JLabel username=new JLabel(new ImageIcon("image/login/用户名.png"));
        username.setBounds(80,120,47,17);
        usertext.setBounds(140,119,200,30);
        this.getContentPane().add(username);
        this.getContentPane().add(usertext);

        //2. password
        JLabel password=new JLabel(new ImageIcon("image/login/密码.png"));
        password.setBounds(80,170,32,16);
        passtext.setBounds(140,169,200,30);
        this.getContentPane().add(password);
        this.getContentPane().add(passtext);


        //3. verify code
        JLabel verify=new JLabel(new ImageIcon("image/login/验证码.png"));
        verify.setBounds(80,220,50,30);
        vcode.setBounds(140,219,100,30);
        this.getContentPane().add(verify);
        this.getContentPane().add(vcode);


        //4.Get Verify Code:
        String verifycode=getCode.verifycode();
        rightcode.setText(verifycode);
        rightcode.addMouseListener(this);


        rightcode.setBounds(260,219,120,30);
        this.getContentPane().add(rightcode);


        //5. Login Bottom
        login.setBounds(100,260,128,47);
        login.setIcon(new ImageIcon("image/login/登录按钮.png"));
        login.setBorderPainted(false);
        login.setContentAreaFilled(false);
        login.addMouseListener(this);
        this.getContentPane().add(login);

        //6. register Bottom
        register.setBounds(240,260,128,47);
        register.setIcon(new ImageIcon("image/login/注册按钮.png"));
        register.setBorderPainted(false);
        register.setContentAreaFilled(false);
        register.addMouseListener(this);
        this.getContentPane().add(register);

        // 7. background
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
        if (e.getSource()==login){
            String usernameinput=usertext.getText();
            String passwordinput=passtext.getText();
            String codeinput=vcode.getText();

            User user=new User(usernameinput,passwordinput);

            if(codeinput.length()==0){
                generatedialog("The verify code can not be blank!");

            } else if (usernameinput.length()==0 || passwordinput.length()==0) {
                generatedialog("Username or Password can not be blank!");

            } else if (!codeinput.equalsIgnoreCase(rightcode.getText())) {
                generatedialog("Wrong verify code!");

            } else if (finduser(user)) {
                this.setVisible(false);
                new GameJFrame();

            }else {
                generatedialog("Username or Password is not correct!");
            }

        } else if (e.getSource()==register) {
            this.setVisible(false);
            new RegisterJFrame(userlist);

        } else if (e.getSource()==rightcode) {
            String code=getCode.verifycode();
            rightcode.setText(code);

            System.out.println(code);


        }
    }

    public  boolean finduser(User input){
        for (int i = 0; i < userlist.size(); i++) {
            User right=userlist.get(i);
            if(input.getUsername().equals(right.getUsername()) && input.getPassword().equals(right.getPassword())){
                return true;
            }
        }
        return false;


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==login){
            login.setIcon(new ImageIcon("image/login/登录按下.png"));
        } else if (e.getSource()==register) {
            register.setIcon(new ImageIcon("image/login/注册按下.png"));

        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==login){
            login.setIcon(new ImageIcon("image/login/登录按钮.png"));
        } else if (e.getSource()==register) {
            register.setIcon(new ImageIcon("image/login/注册按钮.png"));

        }

    }
}
