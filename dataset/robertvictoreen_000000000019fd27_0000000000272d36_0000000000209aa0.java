import java.util.*;
import java.io.*;
class Solution {
public static void main(String[] args) {
    
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int T = in.nextInt();

    int N;
    int K;

    for (int Tcase = 1; Tcase <= T; Tcase++) {
    	N = in.nextInt();
        K = in.nextInt();

        int[][] mat = new int[N][N];

        //System.out.println("n " + N + " K " + K);

        int trace = K / N;
        int carry = K % N;
        //use carry asap

        for (int i = 0; i < N; i++) {
            mat[i][i] = trace;
            if (carry > 0) {
                mat[i][i] += N - carry;
                carry -= N - carry;
            }
            //System.out.println("trace " + mat[i][i]);
        }

        String result = "POSSIBLE";
        HashMap<Integer, HashSet<Integer>> rowSet = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> colSet = new HashMap<>();
        for (int i = 0; i < N; i++) {
            rowSet.put(i, new HashSet<>());
            rowSet.get(i).add(mat[i][i]);
            colSet.put(i, new HashSet<>());
            colSet.get(i).add(mat[i][i]);
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (row == col) {
                    continue;
                }

                if (N % 2 == 0 || row % 2 == 0) for (int num = 1; num <= N; num++) {
                    //System.out.println("trying " + num);
                    if (!rowSet.get(row).contains(num) && !colSet.get(col).contains(num)) {
                        //System.out.println("setting " + num + " at row "+row+" and col "+col);
                        mat[row][col] = num;
                        rowSet.get(row).add(num);
                        colSet.get(col).add(num);
                        break;
                    }
                }

                if (N % 2 != 0 && row % 2 != 0) for (int num = N; num > 0; num--) {
                    //System.out.println("trying " + num);
                    if (!rowSet.get(row).contains(num) && !colSet.get(col).contains(num)) {
                        //System.out.println("setting " + num + " at row "+row+" and col "+col);
                        mat[row][col] = num;
                        rowSet.get(row).add(num);
                        colSet.get(col).add(num);
                        break;
                    }
                }

                if (mat[row][col] == 0) {
                    result = "IMPOSSIBLE";
                }
            }
        }

    	System.out.println("Case #" + Tcase + ": " + result);

        StringBuilder sb = new StringBuilder();;

        if (result.equals("POSSIBLE")) {

            for (int i = 0; i < N; i++) {
                sb = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    if (j > 0) {
                        sb.append(' ');
                    }
                    sb.append(mat[i][j]);
                }
                System.out.println(sb.toString());
            }
            
        }


    }
}
}