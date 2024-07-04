import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by HelenHan on 3/6/20.
 */
public class Solution {
    
    public static void solve(int N, int K, int index) {
        int[][] candidate = new int[N][N];
        boolean possible  = helper(N, K, candidate);

        if (!possible) {
            System.out.println("Case #" + index + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + index + ": POSSIBLE");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(candidate[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    public static boolean helper(int N, int K, int[][] candidate) {
        HashMap<Integer, HashMap<Integer, List<Integer>>> answer = new
                HashMap<>();
        for (int i = 2; i <= 5; i++) {
            answer.put(i, new HashMap<>());
        }
        answer.get(2).put(4, Arrays.asList(2, 1, 1, 2));
        answer.get(2).put(2, Arrays.asList(1, 2, 2, 1));

        answer.get(3).put(3, Arrays.asList(1, 2, 3, 3, 1, 2, 2, 3, 1));
        answer.get(3).put(6, Arrays.asList(2, 3, 1, 3, 1, 2, 1, 2, 3));
        answer.get(3).put(9, Arrays.asList(3, 2, 1, 1, 3, 2, 2, 1, 3));

        answer.get(4).put(4, Arrays.asList(1, 4, 2, 3, 4, 1, 3, 2, 2, 3, 1, 4, 3, 2, 4, 1));
        answer.get(4).put(6, Arrays.asList(1, 4, 2, 3, 4, 2, 3, 1, 2, 3, 1, 4, 3, 1, 4, 2));
        answer.get(4).put(7, Arrays.asList(3, 2, 1, 4, 4, 1, 3, 2, 1, 4, 2, 3, 2, 3, 4, 1));
        answer.get(4).put(8, Arrays.asList(2, 4, 1, 3, 4, 2, 3, 1, 3, 1, 2, 4, 1, 3, 4, 2));
        answer.get(4).put(9, Arrays.asList(4, 2, 1, 3, 2, 1, 3, 4, 3, 4, 2, 1, 1, 3, 4, 2));
        answer.get(4).put(10, Arrays.asList(3, 4, 1, 2, 4, 2, 3, 1, 1, 3, 2, 4, 2, 1, 4, 3));
        answer.get(4).put(11, Arrays.asList(3, 1, 2, 4, 2, 4, 3, 1, 4, 3, 1, 2, 1, 2, 4, 3));
        answer.get(4).put(12, Arrays.asList(3, 2, 1, 4, 1, 3, 4, 2, 2, 4, 3, 1, 4, 1, 2, 3));
        answer.get(4).put(13, Arrays.asList(2, 3, 4, 1, 1, 4, 2, 3, 4, 1, 3, 2, 3, 2, 1, 4));
        answer.get(4).put(14, Arrays.asList(4, 1, 3, 2, 1, 3, 2, 4, 3, 2, 4, 1, 2, 4, 1, 3));
        answer.get(4).put(16, Arrays.asList(4, 2, 1, 3, 1, 4, 3, 2, 2, 3, 4, 1, 3, 1, 2, 4));

        answer.get(5).put(5, Arrays.asList(1, 3, 4, 5, 2, 5, 1, 2, 4, 3, 4, 2, 1, 3, 5, 2, 5, 3, 1, 4, 3, 4, 5, 2, 1));
        answer.get(5).put(7, Arrays.asList(1, 5, 3, 2, 4, 2, 1, 5, 4, 3, 4, 3, 2, 5, 1, 3, 2, 4, 1, 5, 5, 4, 1, 3, 2));
        answer.get(5).put(8, Arrays.asList(1, 3, 2, 4, 5, 4, 2, 5, 3, 1, 3, 4, 1, 5, 2, 2, 5, 3, 1, 4, 5, 1, 4, 2, 3));
        answer.get(5).put(9, Arrays.asList(4, 2, 5, 1, 3, 3, 1, 4, 5, 2, 2, 3, 1, 4, 5, 1, 5, 3, 2, 4, 5, 4, 2, 3, 1));
        answer.get(5).put(10, Arrays.asList(4, 2, 3, 1, 5, 3, 1, 5, 4, 2, 1, 3, 2, 5, 4, 5, 4, 1, 2, 3, 2, 5, 4, 3, 1));
        answer.get(5).put(11, Arrays.asList(2, 1, 3, 4, 5, 1, 2, 5, 3, 4, 5, 3, 4, 1, 2, 4, 5, 1, 2, 3, 3, 4, 2, 5, 1));
        answer.get(5).put(12, Arrays.asList(3, 4, 2, 5, 1, 2, 3, 4, 1, 5, 4, 5, 1, 3, 2, 5, 1, 3, 2, 4, 1, 2, 5, 4, 3));
        answer.get(5).put(13, Arrays.asList(1, 2, 5, 3, 4, 5, 4, 2, 1, 3, 2, 3, 4, 5, 1, 4, 1, 3, 2, 5, 3, 5, 1, 4, 2));
        answer.get(5).put(14, Arrays.asList(5, 3, 2, 4, 1, 4, 2, 1, 3, 5, 2, 1, 3, 5, 4, 3, 5, 4, 1, 2, 1, 4, 5, 2, 3));
        answer.get(5).put(15, Arrays.asList(5, 1, 4, 3, 2, 2, 5, 1, 4, 3, 1, 2, 3, 5, 4, 3, 4, 2, 1, 5, 4, 3, 5, 2, 1));
        answer.get(5).put(16, Arrays.asList(4, 2, 5, 3, 1, 3, 4, 2, 1, 5, 5, 3, 1, 2, 4, 2, 1, 4, 5, 3, 1, 5, 3, 4, 2));
        answer.get(5).put(17, Arrays.asList(2, 5, 3, 4, 1, 5, 3, 4, 1, 2, 1, 4, 5, 2, 3, 4, 2, 1, 3, 5, 3, 1, 2, 5, 4));
        answer.get(5).put(18, Arrays.asList(3, 2, 4, 1, 5, 1, 5, 3, 4, 2, 2, 4, 5, 3, 1, 5, 3, 1, 2, 4, 4, 1, 2, 5, 3));
        answer.get(5).put(19, Arrays.asList(5, 2, 1, 3, 4, 3, 4, 5, 2, 1, 1, 3, 4, 5, 2, 4, 5, 2, 1, 3, 2, 1, 3, 4, 5));
        answer.get(5).put(20, Arrays.asList(5, 4, 1, 3, 2, 1, 5, 3, 2, 4, 4, 2, 5, 1, 3, 3, 1, 2, 4, 5, 2, 3, 4, 5, 1));
        answer.get(5).put(21, Arrays.asList(4, 5, 1, 2, 3, 5, 2, 4, 3, 1, 2, 3, 5, 1, 4, 1, 4, 3, 5, 2, 3, 1, 2, 4, 5));
        answer.get(5).put(22, Arrays.asList(4, 1, 5, 2, 3, 5, 4, 2, 3, 1, 3, 5, 4, 1, 2, 1, 2, 3, 5, 4, 2, 3, 1, 4, 5));
        answer.get(5).put(23, Arrays.asList(4, 5, 3, 2, 1, 5, 4, 2, 1, 3, 3, 1, 5, 4, 2, 2, 3, 1, 5, 4, 1, 2, 4, 3, 5));
        answer.get(5).put(25, Arrays.asList(5, 2, 3, 4, 1, 3, 5, 2, 1, 4, 1, 4, 5, 3, 2, 2, 1, 4, 5, 3, 4, 3, 1, 2, 5));


        if (answer.containsKey(N) && answer.get(N).containsKey(K)) {
            List<Integer> list = answer.get(N).get(K);
            int k = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    candidate[i][j] = list.get(k);
                    k++;
                }

            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int T = Integer.parseInt(t[0]);

        for (int j = 1; j <= T; j++) {
            String[] n = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int N = Integer.parseInt(n[0]);
            int K = Integer.parseInt(n[1]);

            solve(N, K, j);
        }

        bufferedReader.close();
    }
}