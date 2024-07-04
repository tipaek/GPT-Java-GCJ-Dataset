
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String... args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = input.nextInt();
        
        
        for (int i = 1; i <= cases; i++) {
            int t = input.nextInt();
            int[][] tasks = new int[t][2];
            Set<Integer> cUpper = new HashSet<>();
            Set<Integer> cLower = new HashSet<>();
            Set<Integer> jUpper = new HashSet<>();
            Set<Integer> jLower = new HashSet<>();
            String result = "";
            char[] resultArr = new char[t];
            
            for (int j = 0; j < t; j++) {
                tasks[j][0] = input.nextInt();
                tasks[j][1] = input.nextInt();
            }
            
            for (int j = 0; j < t; j++) {
                // for every task
                if (checkBounds(cUpper, cLower, tasks[j][1], tasks[j][0])) {
                    cUpper.add(tasks[j][1]);
                    cLower.add(tasks[j][0]);
                    resultArr[j] = 'C';
                } else if (checkBounds(jUpper, jLower, tasks[j][1], tasks[j][0])) {
                    jUpper.add(tasks[j][1]);
                    jLower.add(tasks[j][0]);
                    resultArr[j] = 'J';
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            
            if (!result.equals("IMPOSSIBLE"))
                result = new String(resultArr);
            
            System.out.println("Case #" + i + ": " + result);
        }
        
        input.close();
        
    }
    
    public static boolean checkBounds(Set<Integer> uppers, Set<Integer> lowers, int up, int low) {
        if (uppers.isEmpty())
            return true;
        for (Integer i : uppers) {
            if (low >= i)
                return true;
        }
        for (Integer i : lowers) {
            if (up <= i)
                return true;
        }
        return false;
    }
}
