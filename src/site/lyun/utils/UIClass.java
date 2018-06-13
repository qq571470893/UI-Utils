package site.lyun.utils;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.io.File;

//本类提供最基本的界面方便使用
public class UIClass extends JFrame implements ActionListener{
    JButton jb = new JButton("打开文件");
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        new UIClass();
    }
    public UIClass(){
        jb.setActionCommand("open");
        jb.setBackground(Color.WHITE);//设置按钮颜色
        this.getContentPane().add(jb, BorderLayout.CENTER);//建立容器使用边界布局
        //
        jb.addActionListener(this);
        this.setTitle("去空格&换行程序");
        this.setSize(300, 200);
        this.setLocation(600,400);
        //显示窗口true
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("open")){
            JFileChooser jf = new JFileChooser();
            jf.showOpenDialog(this);//显示打开的文件对话框
            File f =  jf.getSelectedFile();//使用文件类获取选择器选择的文件
            String s = f.getAbsolutePath();//返回路径名
            //JOptionPane弹出对话框类，显示绝对路径名
            try {
                UIUtils.control(s);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "成功生成去空格文件", "标题",JOptionPane.WARNING_MESSAGE);
        }
    }
}
