import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
       int test=input.nextInt();
       for(int t=1;t<=test;t++) {
           System.out.println("Case #"+t+": ");
           int n=input.nextInt();
           int lst_i=-1,lst_j=-1;
           for(int i=1;;i++) {
               int pow=(int)Math.pow(2, i-1);
               if(n<pow) {
                   break;
               }
               n-=pow;
               if(i%2==1) {
                   for(int j=1;j<=i;j++) {
                       System.out.println(i+" "+j);
                       lst_i=i;
                       lst_j=j;
                   }
               }
               else {
                   for(int j=i;j>=1;j--) {
                       System.out.println(i+" "+j);
                       lst_i=i;
                       lst_j=j;
                   }
               }
           }
           while(n!=0) {
               if(lst_j==1) {
                   lst_i++;
                   System.out.println(lst_i+" "+lst_j);
               }
               else {
                   lst_i++;
                   lst_j++;
                   System.out.println(lst_i+" "+lst_j);
               }
               n--;
           }
       }
    }
}
