import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[]args)throws IOException{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        while(t-->0){
            StringBuffer sb = new StringBuffer();
            if(b==10){
                for(int i = 1;i<=b;i++){
                    System.out.println(i);
                    System.out.flush();
                    String s = sc.next();
                    sb.append(s);
                }
                System.out.println(sb);
                System.out.flush();
                char ch = sc.next().charAt(0);
                if(ch=='N') System.exit(0);
            }else if(b==20){
                for(int i = 0;i<20;i++) sb.append(0);
                for(int i = 1;i<=5;i++){
                    System.out.println(i);
                    System.out.flush();
                    char s = sc.next().charAt(0);
                    sb.setCharAt(i-1,s);
                }
                for(int i = 16;i<=20;i++){
                    System.out.println(i);
                    System.out.flush();
                    char s = sc.next().charAt(0);
                    sb.setCharAt(i-1,s);
                }
                for(int i = 6;i<=15;i++){
                    System.out.println(i);
                    System.out.flush();
                    char s = sc.next().charAt(0);
                    sb.setCharAt(i-1,s);
                }
                String c = "";
                for(int i = 6;i<=10;i++){
                    System.out.println(i);
                    System.out.flush();
                    String s = sc.next();
                    c+=s;
                }
                
                String oldC = sb.substring(5,10);
                String oldD = sb.substring(10,15);
                if(c.equalsIgnoreCase(oldC)){
                    //no change
                }else if(c.equalsIgnoreCase(reverse(oldD))){
                    sb.replace(5,10,c);
                    sb.replace(10,15,reverse(oldC));
                }else if(c.equalsIgnoreCase(complement(reverse(oldD)))){
                    sb.replace(5,10,c);
                    sb.replace(10,15,complement(reverse(oldC)));
                }else if(c.equalsIgnoreCase(complement(oldC))){
                    sb.replace(5,10,c);
                    sb.replace(10,15,complement(oldD));
                }
                
                String a = "";
                for(int i = 1;i<=5;i++){
                    System.out.println(i);
                    System.out.flush();
                    String s = sc.next();
                    a+=s;
                }
                String oldA = sb.substring(0,5);
                String oldB = sb.substring(15,20);
                if(a.equalsIgnoreCase(oldA)){
                    //no change
                }else if(a.equalsIgnoreCase(reverse(oldB))){
                    sb.replace(0,5,a);
                    sb.replace(15,20,reverse(oldA));
                }else if(a.equalsIgnoreCase(complement(reverse(oldB)))){
                    sb.replace(0,5,a);
                    sb.replace(15,20,complement(reverse(oldA)));
                }else if(a.equalsIgnoreCase(complement(oldA))){
                    sb.replace(0,5,a);
                    sb.replace(15,20,complement(oldB));
                }
                System.out.println(sb);
                System.out.flush();
                char ch = sc.next().charAt(0);
                if(ch=='N') System.exit(0);
            }
            
        }
    }
    
    public static String reverse(String s){
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }
    
    public static String complement(String s){
        StringBuffer sb = new StringBuffer();
        for(int i= 0;i<s.length();i++){
            if(s.charAt(i)=='1') sb.append("0");
            else sb.append("1");
        }
        return sb.toString();
    }
}