import java.util.Scanner;
import java.lang.*;
class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n,d,sum,k;
        for(int m = 1; m <= t; m++) {
            n = sc.nextInt();
            d = sc.nextInt();
            k = n+1; 
            sum = 0;
            if(n%2==0) 
            System.out.println("Case #"+m+": "+"POSSIBLE");
            else
            System.out.println("Case #"+m+": "+"IMPOSSIBLE");
        for (int i = 1; i <= n; i++) 
        { 
            int temp = k; 
  
            while (temp <= n) 
            { 
                System.out.print(temp + " "); 
                temp++; 
            } 
            
            for(int j = 1; j < k; j++) 
                System.out.print(j + " "); 
      
            k--; 
            System.out.println(); 
        }
        // if(true) 
        //     System.out.println("Case #"+m+": "+"POSSIBLE");
        // else
        //     System.out.println("Case #"+m+": "+"IMPOSSIBLE");
        }
        System.exit(0);
    }
}