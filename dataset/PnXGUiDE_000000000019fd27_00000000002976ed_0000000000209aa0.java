import java.util.*;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int K = in.nextInt();
            boolean isPossible = !(K == N + 1 || K == Math.pow(N, 2) - 1);

            System.out.printf("Case #%d: %s\n", t, isPossible ? "POSSIBLE" : "IMPOSSIBLE");
            
            if(isPossible) {
                // Sum of subsets
                int[][] num = new int[N][N];
                int k = K;
                int p = 0;

                while(k-- > 0) {
                    num[p][p++]++;
                    p %= N;
                }

                if(K % N == 1 || K % N == (N - 1)) {
                    num[N-1][N-1]--;
                    num[N-2][N-2]++;
                }

                for(int i = 0; i < N; i++) {
                    List<Integer>[] possibles = new ArrayList[N];
                    int[] count = new int[N];

                    // create possibles list
                    for(int j = 0; j < N; j++) {
                        if(i == j) continue;
                        possibles[j] = new ArrayList<>();
                        for(int x = 1; x <= N; x++) {
                            possibles[j].add(x);
                        }
                        for(int h = 0; h < N; h++) {
                            if(num[i][h] == 0) continue;
                            possibles[j].remove(Integer.valueOf(num[i][h]));
                        }
                        for(int v = 0; v < N; v++) {
                            if(num[v][j] == 0) continue;
                            possibles[j].remove(Integer.valueOf(num[v][j]));
                        }
                        count[j] = possibles[j].size();
                    }

                    for(int j = 0; j < N; j++) { 
                        if(i == j) continue;

                        int min = 9999;
                        int minIdx = -1;
    
                        for(int x = 0; x < N; x++) {
                            if(count[x] < min && count[x] > 0) {
                                min = count[x];
                                minIdx = x;
                            }
                        }

                        count[minIdx] = 9999;

                        num[i][minIdx] = possibles[minIdx].get(0);
                        
                        for(int x = 0; x < N; x++) {
                            if(x == i) continue;
                            possibles[x].remove(Integer.valueOf(num[i][minIdx]));
                        }
                    }
                }

                for(int i = 0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        System.out.print(num[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}