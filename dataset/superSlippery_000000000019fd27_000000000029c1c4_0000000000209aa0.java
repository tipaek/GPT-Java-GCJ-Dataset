import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int validateInput(int N, int K) {
        if(K == 0 || N % K == 0) {
            return -1;
        }
        int res = K / N;
        if(res < N) {
            return -1;
        }
        return res;
    }

    public static int[][] findMatrix(int N, int[] d) {
        int res[][] = new int[N][N];
        int i, j, p;
        for(i = 0; i < N; i++) {
            res[i][i] = d[i];
        }

        for(i = 0; i < N; i++) {
            helper(res, i, 0);
        }
        return res;
    }

    public static void helper(int[][] res, int row, int currentNOfCells) {
        if(currentNOfCells == res.length -1) {
            return;
        }
        if(row >= res.length) {
            return;
        }
        int[] unique = new int[res.length + 1];
        int[] mostRestrictedUnique = null;
        int i;
        int mostRestricted = -1;
        int maxRestrictions = 0;
        for(int j = 0; j < res.length; j++) {
            if(res[row][j] != 0) {
                continue;
            }
            int restrictions = 0;
            for(i = j - 1; i >= 0; i--) {//left
                if(res[row][i] != 0 && unique[res[row][i]] == 0) {
                    unique[res[row][i]] = 1;
                    restrictions++;
                }
            }
            for(i = j + 1; i < res.length; i++) {//right
                if(res[row][i] != 0 && unique[res[row][i]] == 0) {
                    unique[res[row][i]] = 1;
                    restrictions++;
                }
            }

            for(i = row + 1; i < res.length; i++) {//down
                if(res[i][j] != 0 && unique[res[i][j]] == 0) {
                    unique[res[i][j]] = 1;
                    restrictions++;
                }
            }
            for(i = row - 1; i >= 0; i--) {//down
                if(res[i][j] != 0 && unique[res[i][j]] == 0) {
                    unique[res[i][j]] = 1;
                    restrictions++;
                }
            }
            if(restrictions > maxRestrictions) {
                maxRestrictions = restrictions;
                mostRestricted = j;
                mostRestrictedUnique = unique.clone();
                Arrays.fill(unique, 0);
            }
        }
        if(mostRestrictedUnique == null) {
            return;
        }
            int numToPut = -1;
        for(i = 1; i < mostRestrictedUnique.length; i++) {
            if(mostRestrictedUnique[i] == 0) {
                numToPut = i;
                break;
            }
        }
        if(maxRestrictions > 0 && numToPut != -1) {
            res[row][mostRestricted] = numToPut;
            helper(res, row, currentNOfCells + 1);
        } else {
            throw new RuntimeException("Cant build up the matrix");
        }
    }

    static String matrixToString(int[][] arr) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                builder.append(arr[i][j]);
                if(j != arr.length - 1) {
                    builder.append(" ");
                }
            }
            if(i != arr.length - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseN = scanner.nextInt();
        int testCase = 1;
        StringBuilder builder = new StringBuilder();
        while(testCase <= testCaseN) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            String res = null;
            if(N * N < K || K < N) {
                builder.append("Case #" + testCase + ": IMPOSSIBLE\n");
            } else {
                int[] d = new int[N];

                int s = 0;
                for(int i = 0; i < N; i++) {
                    if(N - i < K - s) {
                        d[i] = K - s - (N - i) + 1;
                        if(d[i] > N) {
                            d[i] = N;
                        }
                    } else {
                        d[i] = 1;
                    }
                    s += d[i];
                }
                try {
                    int[][] matrix = findMatrix(N, d);
                    res = matrixToString(matrix);
                    builder.append("Case #" + testCase + ": POSSIBLE \n");
                    builder.append(res);
                    builder.append("\n");
                } catch (Exception ex) {
                    builder.append("Case #" + testCase + ": IMPOSSIBLE\n");
                }
            }
            testCase++;
        }

        System.out.println(builder.toString());

    }
}
