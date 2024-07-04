
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(reader.readLine());
            StringBuilder ans = new StringBuilder();
            int c = 0, j = 0;
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++){
                String[] str = reader.readLine().split(" ");
                arr[i][0] = Integer.parseInt(str[0]);
                arr[i][1] = Integer.parseInt(str[1]);
            }

            Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[0]));
            for(int i=0;i<n;i++){
                if(c <= arr[i][0]){
                    c = arr[i][1]; ans.append("C");
                } else if( j<= arr[i][0]){
                    j = arr[i][1];ans.append("J");
                }else {
                    ans = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.printf("Case #%d: %s\n", t, ans);

        }

    }

}
