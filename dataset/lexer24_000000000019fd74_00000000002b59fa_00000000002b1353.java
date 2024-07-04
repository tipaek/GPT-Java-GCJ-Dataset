import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          if(n<=500) {
              for (int j = 1; j <=500; j++) 
                  System.out.println("Case #" + i + ": " + j + " 1");
            }
           if(n == 501){   
               
               System.out.println("Case #" + i + ": 1 1");
               System.out.println("Case #" + i + ": 1 2");
               System.out.println("Case #" + i + ": 2 2");
               System.out.println("Case #" + i + ": 2 1");
               for (int j = 3; j <=500; j++) 
                   System.out.println("Case #" + i + ": " + j + " 1");
           }
          
        }
      }
}