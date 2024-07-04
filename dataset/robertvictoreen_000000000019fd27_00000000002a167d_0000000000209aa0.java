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

        if (!solve(rowSet, colSet, mat)) {
            result = "IMPOSSIBLE";
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

private static boolean solve(HashMap<Integer, HashSet<Integer>> rowSet, HashMap<Integer, HashSet<Integer>> colSet, int[][] mat) {
    int N = mat.length;
    int colOffset = 0;
    int col;
    for (int row = 0; row < N; row++) {
        for (int colI = 0; colI < N; colI++) {
            col = (colI + colOffset) % N;
            if (row == col) {
                continue;
            }

            for (int val = 1; val <= N; val++) {
                //System.out.println("trying " + val+ " at row "+row+" and col "+col);
                if (!rowSet.get(row).contains(val) && !colSet.get(col).contains(val)) {
                    //System.out.println("setting " + val + " at row "+row+" and col "+col);
                    //select it and backtrack
                    mat[row][col] = val;
                    rowSet.get(row).add(val);
                    colSet.get(col).add(val);
                    break;
                }
            }

            if (mat[row][col] == 0) {
                return false;
            }

        }
        colOffset++;
    }
    return true;
}
}