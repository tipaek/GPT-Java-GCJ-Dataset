import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = sc.nextInt();
        for (int k = 1; k <= testCase; k++) {
            System.out.printf("Case #%d: ", k);
            int N = sc.nextInt();
            int matrix[][] = new int[N][N];

            String ans = "";
            int trace = 0;
            int r = 0;
            int c = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                Set<Integer> s = new HashSet<Integer>(Arrays.stream(matrix[i]).boxed().collect(Collectors.toList()));
                if (s.size() < N) {
                    r++;
                }
            }
            for (int j = 0; j < N; j++) {
                Set<Integer> s = new HashSet<Integer>();
                for (int i = 0; i < N; i++) {
                    s.add(matrix[i][j]);
                }
                if (s.size() < N) {
                    c++;
                }
            }

            System.out.println(trace + " "  + r + " " + c);

        }
    }
}