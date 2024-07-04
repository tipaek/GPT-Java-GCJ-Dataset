import java.io.*;
import java.util.*;

public class Solution
{
   public static void main(String[] args) throws IOException
   {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for(int i = 1; i <= t; i++){
         int n = sc.nextInt();
         n = n-1;
         System.out.println("Case #" + i + ": ");
         System.out.println("1 1");
         Double x = (Math.sqrt(2*n + 0.25)-0.5);
         int a = x.intValue();
         int j = 1;
         while(j <= a){
            System.out.println(j+1 + " " + 2);
            j++;
         }
         n = (n-(a*(a+1)/2));
         while(n>0){
            System.out.println(j+1 + " " + 1);
            j++;
            n--;
         } 
      }
   }
}