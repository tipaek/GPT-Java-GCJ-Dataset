import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; ++t) {
            int N = in.nextInt();
            int[][] arr = new int[N][N];
            for(int i = 0; i < N; ++i)
                for(int j = 0; j < N; ++j) arr[i][j] = in.nextInt();

            int trace = 0;
            for(int i = 0; i < N; ++i) trace += arr[i][i];
            int rowD = 0, colD = 0;
            for(int i = 0; i < N; ++i) {
                Set<Integer> myset = new HashSet<>();
                for(int j = 0; j < N; ++j)
                    myset.add(arr[i][j]);
                if(myset.size() < N) rowD += 1;
            }
            for(int j = 0; j < N; ++j) {
                Set<Integer> myset = new HashSet<>();
                for(int i = 0; i < N; ++i)
                    myset.add(arr[i][j]);
                if(myset.size() < N) colD += 1;
            }
            sb.append("Case #" + t + ": ");
            sb.append(trace + " " + rowD + " " + colD + "\n");
        }
        System.out.println(sb.toString());
    }
}
