import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            String[] result = new String[num];
            
            for (int j = 0; j < num; j++) {
                result[j] = sc.next();
            }
            
            Arrays.sort(result, (t1, t2) -> t2.length() - t1.length());
            
            String finalResult = result[0];
            boolean isValid = true;
            
            for (int k = 1; k < result.length; k++) {
                String s1 = finalResult.substring(1);
                String s2 = result[k].substring(1);
                
                if (s1.indexOf(s2) != (s1.length() - s2.length())) {
                    finalResult = "*";
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                finalResult = result[0];
            }
            
            System.out.println("Case #" + (i + 1) + ": " + finalResult);
        }
        
        sc.close();
    }
}