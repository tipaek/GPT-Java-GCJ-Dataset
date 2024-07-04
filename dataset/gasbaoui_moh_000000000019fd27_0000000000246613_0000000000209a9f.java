/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package javaapplication60;



import java.util.Scanner;

/**
 *
 * @author amine gasa
 */
public class Solution {

    public static void main(String[] args) {
      Scanner x=new Scanner(System.in);
      int t=x.nextInt();
      
        for (int i = 1; i <= t; i++) {
            String s=x.next();
            int o=0;int count_op=0,count_cl=0;String res="";
            for (int j = 0; j < s.length(); j++) {
                if(j==0){
                    o=Integer.parseInt(s.charAt(j)+"");
                  //  System.out.println("o="+o);
                    String s1="";
                    for (int k = 0; k < o; k++) {
                        s1=s1+"(";count_op++;
                    }
                    res=res+s1+o;
                }else{
                    if(o>Integer.parseInt(s.charAt(j)+"")){
                        int c=o-Integer.parseInt(s.charAt(j)+"");String s2="";
                        for (int k = 0; k < c; k++) {
                            s2=s2+")";count_cl++;
                            
                        }o=Integer.parseInt(s.charAt(j)+"");
                        res=res+s2+o;
                    }
                    else{
                        int tmp=Integer.parseInt(s.charAt(j)+"")-o;String s3="";
                        for (int k = 0; k < tmp; k++) {
                            s3=s3+"(";count_op++;
                        }o=Integer.parseInt(s.charAt(j)+"");
                        res=res+s3+o;
                    }
                    
                }
            }String s4="";
            for (int j = 0; j < count_op-count_cl; j++) {
                s4=s4+")";
            }
          res=res+s4;
            
            
            System.out.println("Case #"+i+": "+res);
        }
    
    }

    
    
}
