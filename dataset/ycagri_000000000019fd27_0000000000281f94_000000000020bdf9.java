import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author ycagri
 */
public class Solution {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = s.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activityCount = s.nextInt();
            int[] times = new int[activityCount * 2];
            int[] span = new int[1441];

            for (int j = 0; j < activityCount; j++) {
                times[j * 2] = s.nextInt();
                times[j * 2 + 1] = s.nextInt();
                
                for(int k = times[j * 2]; k < times[j * 2 + 1];  k++)
                    span[k]++;
            }

            System.out.println(String.format(parseActivities(i, activityCount, times, span)));
        }
    }

    private static String parseActivities(int testCase, int activityCount, int[] times, int[] span) {
        char[] result = new char[activityCount];
        for (int j = 0; j < activityCount; j++) {
            if (result[j] != 0) {
                continue;
            }

            result[j] = 'C';
            boolean overlaps = false;
            for (int k = times[2 * j]; k < times[2*j+1]; k++) {
                if(span[k] >= 3)
                    return String.format("Case #%d: IMPOSSIBLE", testCase);
                
                if(span[k] == 2){
                    overlaps = true;
                }
            }
            
            for(int k = j+1; k< activityCount; k++){
                if((times[2*k] >= times[2 * j] && times[2*k] < times[2 * j +1]) ||
                        (times[2*k+1] > times[2 * j] && times[2*k+1] <= times[2 * j +1])){
                    result[k] = 'J';
                }
            }
        }

        return String.format("Case #%d: %s", testCase, new String(result));
    }
}