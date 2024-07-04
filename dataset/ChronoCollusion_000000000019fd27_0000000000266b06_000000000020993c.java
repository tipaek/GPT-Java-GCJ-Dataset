import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int simX = 0;
            int simY = 0;
            int trace = 0;

            Integer[][] matrix = new Integer[n][n];
            Integer[][] rotated = new Integer[n][n];

            for(int x = 0; x<n;x++) {
                for (int y=0; y<n; y++) {
                    int m = in.nextInt();
                    matrix[x][y]=m;
                    rotated[n - y - 1][x] = m;
                    if(x==y) {
                        trace+=m;
                    }
                }
            }

            for(Integer[] row : matrix) {
                List<Integer> sub = new ArrayList<Integer>(n);
                sub = Arrays.asList(row);
                Collections.sort(sub);

                int prev = -1;
                for(Integer loop : sub) {
                    if (loop==prev) {
                        simX++;
                        break;
                    }else{
                        prev=loop;
                    }
                }

            }
            for(Integer[] row : rotated) {
                List<Integer> sub = new ArrayList<Integer>(n);
                sub = Arrays.asList(row);
                Collections.sort(sub);

                int prev = -1;
                for(Integer loop : sub) {
                    if (loop==prev) {
                        simY++;
                        break;
                    }else{
                        prev=loop;
                    }
                }

            }

            System.out.println(String.format("Case #%s: %s %s %s", i,trace,simX,simY));
        }
    }
}
  