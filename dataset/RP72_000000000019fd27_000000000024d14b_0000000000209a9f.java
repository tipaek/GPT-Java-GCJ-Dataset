/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Parikhs
 */
public class nestingDepths {
    public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     int t = input.nextInt();
     int i;
     String answer[] = new String [t];
     for(i=0;i<t;i++){
         String s = input.next();
         int len= s.length(),j;
         int a[] = new int [len];
         for(j=0;j<len;j++){
             a[j] = Integer.parseInt(String.valueOf(s.charAt(j)));
         }
         String ans = "";
         int in = 0,k;
         for(j=0;j<len;j++){
             if(in<=a[j]){
             for(k=0;k<a[j] && in!=a[j];k++){
                 ans+="(";
                 in++;
             }
             }
             else while(in!=a[j]){
                 ans+=")";
                 in--;
             }
             ans+=a[j];
         }
         while(in!=0){
             ans+=")";
             in--;
         }
         answer[i] = ans;
        }
     for(i=0;i<t;i++){
         System.out.printf("Case #%d: %s\n",i+1,answer[i]);
     }
    }
}
