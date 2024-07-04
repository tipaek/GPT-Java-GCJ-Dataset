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
              System.out.println("Case #" + i + ":");
              for (int j = 1; j <=n; j++) 
                  System.out.println(j + " 1");
            }
           if(n == 501){   
               System.out.println("Case #" + i + ":");
               System.out.println("1 1");
               System.out.println("1 2");
               System.out.println("2 2");
               System.out.println("3 2");
               for (int j = 3; j <=n; j++) 
                   System.out.println(j + " 1");
           }
          
        }
      }
}