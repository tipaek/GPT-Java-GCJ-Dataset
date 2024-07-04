import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int size = scanner.nextInt();
            int[][] times = new int[size][2];
            
            for (int j = 0; j < size; j++) {
                times[j][0] = scanner.nextInt();
                times[j][1] = scanner.nextInt();
            }
            
            Arrays.sort(times, Comparator.comparingInt(a -> a[0]));
            
            int c_end = -1;
            int j_end = -1;
            StringBuilder ret = new StringBuilder();
            
            for (int j = 0; j < size; j++) {
                if (times[j][0] >= c_end && !ret.toString().equals("IMPOSSIBLE")) {
                    c_end = times[j][1];
                    ret.append("C");
                } else if (times[j][0] >= j_end && !ret.toString().equals("IMPOSSIBLE")) {
                    j_end = times[j][1];
                    ret.append("J");
                } else {
                    ret = new StringBuilder("IMPOSSIBLE");
                }
            }
            System.out.println(ret);
        }
        
        scanner.close();
    }
}