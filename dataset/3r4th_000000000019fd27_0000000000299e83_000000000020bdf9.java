import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int numShifts = in.nextInt();
            int[][] ex = new int[numShifts][2];
            for(int a = 0; a < numShifts; a++){
                for(int b = 0; b < 2; b++){
                    ex[a][b] = in.nextInt();
                }
            }
            Arrays.sort(ex, (a, b) -> Integer.compare(a[0], b[0]));

            System.out.println("Case #" + i + ": " + solve(ex));
        }
    }

    public static String solve(int[][] ex){
        String result = "";
        int[] cShift = new int[]{-1, -1};
        int[] jShift = new int[]{-1, -1};
        for (int i = 0; i < ex.length; i++){
            //Check if c can take shift
            if(cShift[0] == -1 && cShift[1] == -1){
                cShift[0] = ex[i][0];
                cShift[1] = ex[i][1];
                result = result + "C";
                continue;
            } else if (cShift[1] <= ex[i][0]){
                cShift[0] = ex[i][0];
                cShift[1] = ex[i][1];
                result = result + "C";
                continue;
            }
            // check if j can take shift
            if(jShift[0] == -1 && jShift[1] == -1){
                jShift[0] = ex[i][0];
                jShift[1] = ex[i][1];
                result = result + "J";
                continue;
            } else if (jShift[1] <= ex[i][0]){
                jShift[0] = ex[i][0];
                jShift[1] = ex[i][1];
                result = result + "J";
                continue;
            } else {
                return "IMPOSSIBLE";
            }

        }

        return result;
    }
}