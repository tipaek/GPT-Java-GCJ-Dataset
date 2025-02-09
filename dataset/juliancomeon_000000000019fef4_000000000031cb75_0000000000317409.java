/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;
import java.util.*;
import java.lang.*;

public class JavaApplication4 {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int count=input.nextInt();
        for (int i=0;i<count;i++){
            int right=input.nextInt(),top=input.nextInt();
            String str=input.next();
            System.out.println("Case #"+String.valueOf(i+1)+": "+bfs(right,top,str));
        }
    }
    
    public static String bfs(int right,int top,String str){
        if (right==0 && top==0){
            return "0";
        }
        
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)=='E' || str.charAt(i)=='W'){
                right=str.charAt(i)=='E'?right+1:right-1;
            }
            else{
                top=str.charAt(i)=='N'?top+1:top-1;
            }
            int dis=Math.abs(right)+Math.abs(top);
            if (dis<=i+1){
                return String.valueOf(i+1);
            }
        }
        return "IMPOSSIBLE";
    }
}
