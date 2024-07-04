import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static long interest_finder (int[][] arr, long c_sum)
    {
        // take a walk for the sum
        long arrsum = 0;
        int celim = 0;
        ArrayList<Integer> elim_r = new ArrayList<>();
        ArrayList<Integer> elim_c = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != -1) {
                    arrsum += arr[i][j];
                    int part_sum = 0;
                    int part_cnt = 0;
                    if (j > 0) {
                        for (int t = j - 1; t >= 0; t--) {
                            if (arr[i][t] != -1) {
                                part_sum += arr[i][t];
                                part_cnt++;
                                break;
                            }
                        }
                    }
                    if (j < arr[0].length - 1) {
                        for (int t = j + 1; t < arr[0].length; t++) {
                            if (arr[i][t] != -1) {
                                part_sum += arr[i][t];
                                part_cnt++;
                                break;
                            }
                        }
                    }
                    if (i > 0) {
                        for (int t = i - 1; t >= 0; t--) {
                            if (arr[t][j] != -1) {
                                part_sum += arr[t][j];
                                part_cnt++;
                                break;
                            }
                        }
                    }
                    if (i < arr.length - 1) {
                        for (int t = i + 1; t < arr.length; t++) {
                            if (arr[t][j] != -1) {
                                part_sum += arr[t][j];
                                part_cnt++;
                                break;
                            }
                        }
                    }
                    if (part_cnt > 0) {
                        if (arr[i][j]*part_cnt < part_sum) {
                            //arr[i][j] = -1;
                            elim_r.add(i);
                            elim_c.add(j);
                            celim++;
                        }
                    }
                }
            }
        }
        // overwrite the arrays
        for (int i = 0; i < celim; i++)
        {
            arr[elim_r.get(i)][elim_c.get(i)] = -1;
        }
        if (celim > 0)
            return interest_finder(arr, c_sum+arrsum);
        else
            return c_sum + arrsum;
    }

    public static void main(String[] args) {
        FastReader keyboard = new FastReader();
        int T = keyboard.nextInt();
        for (int i = 0; i < T; i++) {
            int R, C;
            R = keyboard.nextInt();
            C = keyboard.nextInt();
            int[][] arr = new int[R][C];
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    arr[j][k] = keyboard.nextInt();
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + interest_finder(arr, 0L));
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
