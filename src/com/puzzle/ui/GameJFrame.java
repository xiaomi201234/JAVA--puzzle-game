package com.puzzle.ui;

import com.puzzle.domain.GameInfo;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Objects;
import java.util.Properties;
import java.util.Random;
// The game menu

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    int[][]  data=new int[4][4];

    //blank block's position
    int x;
    int y;

    int count=0;

    int[][] win={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};


    //menu and bar
    JMenuBar jMenuBar=new JMenuBar();
    JMenu options=new JMenu("Options");
    JMenu about=new JMenu("About Us");
    //
    JMenu change=new JMenu("change pictures");
    JMenuItem replay=new JMenuItem("Restart the game");
    JMenuItem relogin=new JMenuItem("Re-Login");
    JMenuItem close=new JMenuItem("Close");
    JMenuItem account=new JMenuItem("Beck");
    JMenuItem sports=new JMenuItem("sports");
    JMenuItem animals=new JMenuItem("animals");

    JMenu save=new JMenu("save");
    JMenu load=new JMenu("load");

    JMenuItem save0=new JMenuItem("save_0");
    JMenuItem save1=new JMenuItem("save_1");
    JMenuItem save2=new JMenuItem("save_2");
    JMenuItem save3=new JMenuItem("save_3");
    JMenuItem save4=new JMenuItem("save_4");

    JMenuItem load0=new JMenuItem("load_0");
    JMenuItem load1=new JMenuItem("load_1");
    JMenuItem load2=new JMenuItem("load_2");
    JMenuItem load3=new JMenuItem("load_3");
    JMenuItem load4=new JMenuItem("load_4");



    String pathname="image\\animal\\animal3";

    public GameJFrame() {

        // initialize the frame
        initJFrame();


        // initialize the menu bar
        initJMenuBar();

        // initialize images
        initData();// Get random order

        initimage();


        this.setVisible(true);
    }

    private void initData() {
        int[] tmp={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r=new Random();
        for (int i = 0; i < tmp.length; i++) {
            // Get random index
            int index=r.nextInt(tmp.length);
            int k=tmp[i];
            tmp[i]=tmp[index];
            tmp[index]=k;

        }


        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i]==0){
                x=i/4;
                y=i%4;


            }
            data[i/4][i%4]=tmp[i];}


    }


    private void initimage() {
        this.getContentPane().removeAll();

        if(victory()){
            JLabel win=new JLabel(new ImageIcon("D:\\多伦多\\Java\\Puzzle game\\image\\win.png"));
            win.setBounds(203,283,197,73);
            this.getContentPane().add(win);
        }

        JLabel step=new JLabel("Steps:"+count);
        step.setBounds(50,30,100,20);
        Font menuFont = new Font("Arial", Font.PLAIN, 20);
        step.setFont(menuFont);
        this.getContentPane().add(step);

        for (int i = 0; i < 4; i++) {
            for(int j = 0; j <4; j++){
                int number=data[i][j];
                JLabel jlabel1=new JLabel(new ImageIcon(pathname+"\\"+number+".jpg"));
                //this.add(jlabel);
                jlabel1.setBounds(j *105+83,105*i+120,105,105);


                //add edges to each image
                jlabel1.setBorder(new BevelBorder(1));



                this.getContentPane().add(jlabel1);


            }

        }

        //add background
        ImageIcon bg=new ImageIcon("image\\background.png");
        JLabel background=new JLabel(bg);
        background.setBounds(40,30,508,560);
        this.getContentPane().add(background);


        this.getContentPane().repaint();


    }


    private void initJMenuBar() {




        //

        Font menuFont = new Font("Arial", Font.PLAIN, 24); // 设置字号为18
        change.setFont(menuFont);
        replay.setFont(menuFont);
        relogin.setFont(menuFont);
        close.setFont(menuFont);
        account.setFont(menuFont);
        options.setFont(menuFont);
        about.setFont(menuFont);
        save.setFont(menuFont);
        load.setFont(menuFont);


        Font secondmenu=new Font("Arial", Font.PLAIN, 18);
        animals.setFont(secondmenu);
        sports.setFont(secondmenu);
        save0.setFont(secondmenu);
        save1.setFont(secondmenu);
        save2.setFont(secondmenu);
        save3.setFont(secondmenu);
        save4.setFont(secondmenu);
        load0.setFont(secondmenu);
        load1.setFont(secondmenu);
        load2.setFont(secondmenu);
        load3.setFont(secondmenu);
        load4.setFont(secondmenu);


        //Combine

        save.add(save0);
        save.add(save1);
        save.add(save2);
        save.add(save3);
        save.add(save4);
        load.add(load0);
        load.add(load1);
        load.add(load2);
        load.add(load3);
        load.add(load4);
        change.add(animals);
        change.add(sports);
        options.add(change);
        options.add(replay);
        options.add(relogin);
        options.add(save);
        options.add(load);
        options.add(close);

        about.add(account);


        jMenuBar.add(options);
        jMenuBar.add(about);


        replay.addActionListener(this);
        relogin.addActionListener(this);
        close.addActionListener(this);
        account.addActionListener(this);
        animals.addActionListener(this);
        sports.addActionListener(this);
        save0.addActionListener(this);
        save1.addActionListener(this);
        save2.addActionListener(this);
        save3.addActionListener(this);
        save4.addActionListener(this);

        load0.addActionListener(this);
        load1.addActionListener(this);
        load2.addActionListener(this);
        load3.addActionListener(this);
        load4.addActionListener(this);


        getgameinfo();
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        this.setSize(603, 680);
        this.setTitle("Beck Puzzle Game");
        this.setAlwaysOnTop(true);
        //center
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(3);

        //cancel the default central settings
        this.setLayout(null);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==65){
            this.getContentPane().removeAll();
            JLabel all=new JLabel(new ImageIcon(pathname+"\\"+"all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);


            ImageIcon bg=new ImageIcon("image\\background.png");
            JLabel background=new JLabel(bg);
            background.setBounds(40,30,508,560);
            this.getContentPane().add(background);

            this.getContentPane().repaint();


        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
            if(victory()){
                return;
            }
            int code=e.getKeyCode();
            if (code==37){
                if (y>=1){
                    data[x][y]=data[x][y-1];
                    data[x][y-1]=0;
                    y--;
                    count++;
                    initimage();

                }

            } else if (code==38) {
                if(x>=1){
                    data[x][y]=data[x-1][y];
                    data[x-1][y]=0;
                    x--;
                    count++;
                    initimage();
                }

            } else if (code == 39) {

                if(y<=2){
                    data[x][y]=data[x][y+1];
                    data[x][y+1]=0;
                    y++;
                    count++;
                    initimage();
                }

            } else if (code == 40) {

                if(x<=2){
                    data[x][y]=data[x+1][y];
                    data[x+1][y]=0;
                    x++;
                    count++;
                    initimage();
                }else{
                    return;
                }

            } else if (code==65) {
                initimage();

            } else if (code==87) {
                data=new int[][]{
                        {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}
                };
                initimage();

            }

    }

    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j]!=win[i][j]){
                    return false;
                }

            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //get the clicked  item
        Object obj=e.getSource();
        if(obj==replay){
            initData();

            count=0;
            initimage();

        } else if (obj==relogin) {
            this.setVisible(false);
            new LoginJFrame();
        } else if (obj==close) {
            System.exit(0);
        } else if (obj==account) {
            Properties prop=new Properties();
            try {

                FileInputStream fis=new FileInputStream("D:\\多伦多\\Java\\Puzzle game\\game.properties");
                prop.load(fis);
                fis.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            String path  = (String) prop.get("about");
            showJDialog(path);

/*
            //create a dialog object
            JDialog jd=new JDialog();
            JLabel people=new JLabel(new ImageIcon("D:\\多伦多\\Java\\Puzzle game\\image\\beck.png"));
            people.setBounds(0,0,256,256);
            jd.getContentPane().add(people);
            jd.setSize(300,300);
            jd.setAlwaysOnTop(true);
            jd.setLocationRelativeTo(null);

            //need to close it to continue
            jd.setModal(true);
            jd.setVisible(true);
*/
        } else if (obj==animals) {
            Random r=new Random();
            int num=r.nextInt(8)+1;
            count=0;
            pathname="image/animal/animal"+num;

            initData();
            initimage();

        }else if(obj==sports){
            Random r= new Random();
            int num=r.nextInt(10)+1;
            count=0;
            pathname="image/sport/sport"+num;

            initData();
            initimage();

        } else if (obj==save0 ||obj==save1 ||obj==save2 ||obj==save3 ||obj==save4 ) {

            // save the documents

            JMenuItem item = (JMenuItem) obj;
            String text = item.getText();
            int index= text.charAt(5)-'0';
            //System.out.println(index);


            try {
                ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("D:\\多伦多\\Java\\Puzzle game\\SAVE\\save"+index+".data"));
                GameInfo gi= new GameInfo(data,x,y,pathname,count);
                oos.writeObject(gi);
                oos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            // edit the information
            item.setText("save_"+index+"("+count+"steps)");
            load.getItem(index).setText("save_"+index+"("+count+"steps)");

        } else if (obj==load0 ||obj==load1 ||obj==load2 ||obj==load3 ||obj==load4 ) {
            JMenuItem item = (JMenuItem) obj;
            String text = item.getText();
            int index= text.charAt(5)-'0';
            GameInfo o =null;
            try {
                ObjectInputStream ois= new ObjectInputStream(new FileInputStream("D:\\多伦多\\Java\\Puzzle game\\SAVE\\save"+index+".data"));
                o = (GameInfo)ois.readObject();
                ois.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }

            // get the information of the save
            data = o.getData();
            pathname=o.getPath();
            count=o.getStep();
            x=o.getX();
            y=o.getY();

            initimage();
        }

    }

    public void getgameinfo(){
        File  file=new File("D:\\多伦多\\Java\\Puzzle game\\SAVE");
        File[] files = file.listFiles();
        // get the steps and edit the menu
        for (File file1 : files) {
            GameInfo o = null;
            try {
                ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file1));
                o = (GameInfo) ois.readObject();
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            int step=o.getStep();
            String name = file1.getName();
            int index= name.charAt(4)-'0';
            save.getItem(index).setText("save_"+index+"("+step+"steps)");
            load.getItem(index).setText("save_"+index+"("+step+"steps)");

        }
    }
    public void showJDialog(String path) {

        File file = new File(path);
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "图片不存在: " + path);
            return;
        }


        ImageIcon originalIcon = new ImageIcon(path);
        Image img = originalIcon.getImage();


        Image scaledImg = img.getScaledInstance(260, 260, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);


        JLabel label = new JLabel(scaledIcon);
        JDialog dialog = new JDialog();
        dialog.setTitle("关于");
        dialog.getContentPane().add(label);
        dialog.setSize(280, 300);
        dialog.setLocationRelativeTo(null);
        dialog.setAlwaysOnTop(true);
        dialog.setModal(true);
        dialog.setVisible(true);
    }

}

