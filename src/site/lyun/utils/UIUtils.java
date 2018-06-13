package site.lyun.utils;

import java.io.*;
import java.util.*;
/*
    龙岩学院 彬哥出品
 */
public class UIUtils {
    //数字控制方法
    final static int HTML_METHOD = 10;
    final static int CSS_METHOD = 20;
    //System.out.print();
    /*
        main方法
     */
//    public static void main(String[] args) throws Exception{
//        control("E://login.css",CSS_METHOD);
//    }
    /*
        控制方法调用
     */
    public static void control(String filepath) throws Exception {
        String outPath = null;
        int method = HTML_METHOD;
        //判断路径
        if(filepath.contains("\\")) {
            outPath = filepath.substring(0, filepath.lastIndexOf("\\")+1);
        } else {
            outPath = filepath.substring(0, filepath.lastIndexOf("/")+1);
        }
        //文件路径获得方法
        File file = new File(filepath);
        String fileName = file.getName();
        //创建输出文件&名字
        String filePartName = fileName.substring(0,fileName.lastIndexOf("."));
        String filePartType = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        String fileNewName = filePartName+"-small."+filePartType;
        File file2 = new File(outPath+fileNewName);

        //如果类型为css则用css方法，否则都为html方式
        if(filePartType.contains("css")){
            method = CSS_METHOD;
        }

        if(method == HTML_METHOD ){
            htmlChange(file,file2);
        } else if ( method == CSS_METHOD){
            cssChange(file,file2);
        }
    }
    /*
        得到html文件。然后调用方法
     */
    public static void htmlChange(File file1,File file2) throws Exception{
        FileInputStream fis = new FileInputStream(file1);
        InputStreamReader cisr = new InputStreamReader(fis,"UTF-8");
        BufferedReader reader = new BufferedReader(cisr);
        FileOutputStream fos = new FileOutputStream(file2);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter writer = new BufferedWriter(osw);
        String part;
        while((part=reader.readLine())!=null){
            part = part.replace("\t", "");
            part = htmlDeleteBlank(part);
            writer.write(part);
        }
        writer.close();
        osw.close();
        fos.close();
        reader.close();
        cisr.close();
        fis.close();
    }
    /*
        得到外部css文件，然后调用方法
     */
    public static void cssChange(File file1,File file2) throws Exception{
        FileInputStream fis = new FileInputStream(file1);
        InputStreamReader cisr = new InputStreamReader(fis,"UTF-8");
        BufferedReader reader = new BufferedReader(cisr);
        FileOutputStream fos = new FileOutputStream(file2);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter writer = new BufferedWriter(osw);
        String part;
        while((part=reader.readLine())!=null){
            part = part.replace("\t", "");
            part = cssDeleteBlank(part);
            writer.write(part);
        }
        writer.close();
        osw.close();
        fos.close();
        reader.close();
        cisr.close();
        fis.close();
    }
    /*
        删除html中标签*外*的空格比如<a href="xxxx">这边的空格不删除
        ！！有不支持 html中有内部样式的情况！！！！！！
        因为程序是依靠<>来判断，如果使用了 子代选择器，则程序出现异常。
     */
    public static String htmlDeleteBlank(String part){
        Queue<Character> queue = new LinkedList<>();
        for(int i=0;i<part.length();i++){
            queue.offer(part.charAt(i));
        }
        int k=0;
        String newStr = "";
        while (!queue.isEmpty()){
            Character c = queue.poll();
            if(c=='<'){
                k=1;
            }
            if(c=='>'){
                k=0;
            }
            if(k==0 && c!=' '){
                newStr += c;
            }
            if(k==1){
                newStr += c;
            }
        }
        return newStr;
    }
    /*
       删除CSS中{}中的空格
     */
    public static String cssDeleteBlank(String part){
        Queue<Character> queue = new LinkedList<>();
        for(int i=0;i<part.length();i++){
            queue.offer(part.charAt(i));
        }
        int k=0;
        String newStr = "";
        while (!queue.isEmpty()){
            Character c = queue.poll();
            if(c=='{'){
                k=1;
            }
            if(c=='}'){
                k=0;
            }
            if(k==1 && c!=' '){
                newStr += c;
            }
            if(k==0){
                newStr += c;
            }
        }
        return newStr;
    }
}
