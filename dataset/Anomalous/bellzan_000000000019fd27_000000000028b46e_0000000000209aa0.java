import java.io.*;
import java.util.*;

class Solution {
    static int[][] currentGrid;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int T = Integer.parseInt(tokenizer.nextToken());
        
        for (int i = 0; i < T; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            K = Integer.parseInt(tokenizer.nextToken());
            currentGrid = new int[N][N];
            int[] sequence = new int[N];
            
            int startA = (K / N) - 5;
            int endA = (K / N) + 6;
            boolean possible = false;

            if (K % N == 0) {
                possible = true;
                sequence[0] = K / N;
                for (int j = 1; j < N; j++) {
                    sequence[j] = j;
                    if (j == K / N) {
                        sequence[j] = N;
                    }
                }
            }

            if (!possible && N != 2) {
                for (int a = startA; a <= endA; a++) {
                    int goal = K - a * (N - 2);
                    for (int j = 1; j <= goal / 2; j++) {
                        int b = j, c = goal - j;
                        if (b != c && b != a && c != a && b > 0 && b < N && c > 0 && c < N) {
                            possible = true;
                            sequence[0] = a;
                            sequence[1] = c;
                            sequence[N - 1] = b;
                            for (int k = 2; k < N - 1; k++) {
                                sequence[k] = k;
                                if (k == a) sequence[k] = N;
                                else if (k == c) sequence[k] = 1;
                                else if (k == b) sequence[k] = N - 1;
                            }
                            break;
                        }
                    }
                    if (possible) break;
                }
            }

            if (possible) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        currentGrid[j][k] = sequence[(k + N - j) % N];
                    }
                }
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                for (int[] row : currentGrid) {
                    for (int val : row) {
                        System.out.print(val + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
        reader.close();
    }
}