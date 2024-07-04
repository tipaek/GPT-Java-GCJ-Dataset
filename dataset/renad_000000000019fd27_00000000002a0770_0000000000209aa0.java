import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String [] args){
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_cases = sc.nextInt();
        sc.nextLine();
        
        for(int i=0; i< test_cases; i++){
            String [] inpArr = sc.nextLine().split(" ");
            int n = Integer.parseInt(inpArr[0]);
            int trace = Integer.parseInt(inpArr[1]);
            int j;
            boolean possible = false;
            for(j =1; j<= n; j++){
                if(j*n == trace)
                {
                   possible = true;
                   break;
                }
            }
            if(possible)
                System.out.println("Case #" + (i+1) + ": POSSIBLE");
            else
                System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            
            
        }
    }
}