import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Solution{
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int not = Integer.parseInt(br.readLine());

        int ii = 1;
        while (not-- != 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int r = 0;
            int c = 0;
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int k = 0;
                Set<Integer> set = new HashSet<>();
                for (String s : input) {
                    int x = Integer.parseInt(s);
                    set.add(x);
                    arr[i][k++] = x;
                }
                if (set.size() != n) r++;
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    set.add(arr[j][i]);
                }
                if (set.size() != n) c++;
            }
            int k = 0;
            for (int i = 0; i < n; i++) {
                k += arr[i][i];
            }
            System.out.println("Case #"+ii+": "+k+" "+r+" "+c);
            ii++;
        }
    }
}