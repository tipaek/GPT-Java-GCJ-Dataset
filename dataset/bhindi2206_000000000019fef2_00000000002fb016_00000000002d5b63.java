
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import java.lang.*;
import java.io.*;


public class Solution {
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int tt=0;
        while(tt++<t){
            Random rand = new Random();
            for(int i=0;i<300;i++){
                StringWriter writer = new StringWriter(); 
                String tmp= (-5+rand.nextInt(10))+"  "+(-5+rand.nextInt(10));
                writer.write(tmp);
                System.out.println(writer.toString());
                writer.flush();
                String str= sc.nextLine();
                if("CENTER".equals(str)||"WRONG".equals(str)){       
                    tt =t;
                    break;
                }
            }
        }
    }
}