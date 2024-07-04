import java.util.*;
    import java.io.*;
    public class Solution {
        
      public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); 
        int b = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String Result="";
            if(b==10){
              int count=1;
              while(count<=10){
                System.out.println(count);
                Result=Result+in.next();
                count++;
                }
            System.out.println(Result);
            String check = (in.next()).trim();
            if(check.equals("N"))break;
            
            }
            else break;
      }
    }
    }