import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    public static void main (String Args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        int casesDone = 1;
        while (casesDone <= cases) {
            int len = Integer.parseInt(in.readLine());
            int[][] arr = new int[len][len];
            int trace = 0;
            int rowDup = 0;
            int colDup = 0;
            for (int  i = 0; i < len; i++) {
                String[] splited = in.readLine().split(" ");
                HashSet<Integer> rep = new HashSet<>();
                for (int j = 0; j < len; j++) {
                    arr[i][j] = Integer.parseInt(splited[j]);
                    rep.add(arr[i][j]);
                }
                if (rep.size() < len) {
                    rowDup++;
                }
                rep.clear();
            }
            for (int i = 0; i < len; i++) {
                HashSet<Integer> rep = new HashSet<>();
                for (int j = 0; j < len; j++) {
                    if (i == j) {
                        trace += arr[i][j];
                    }
                    rep.add(arr[j][i]);
                }
                if (rep.size() < len) {
                    colDup++;
                }
                rep.clear();
            }
            System.out.println("case #" + casesDone + ": " + trace + " "+ rowDup + " " +colDup);
            casesDone++;
        }
    }
}
