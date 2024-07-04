import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        boolean DEBUG = false;
        Scanner in = null;
        try {
            in = DEBUG?new Scanner(new FileInputStream("test.in")):new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();
            Integer[][] matrix = new Integer[n][];
            for(int j = 0; j < n; ++j) {
                Integer[] row = new Integer[n];
                Arrays.fill(row, 0);
                matrix[j] = row;
            }
            boolean found = indicium(matrix, n, k);
            System.out.println("Case #" + i + ": " + (found?"POSSIBLE":"IMPOSSIBLE"));
            if(found) {
                for(int j = 0; j < n; ++j) {
                    System.out.print(format(matrix[j]));
                    System.out.print('\n');
                }
            }
        }
    }

    static boolean indicium(Integer[][] matrix, int n, int k) {
        for(int i = 1; i <= n; ++i) {
            matrix[0][0] = i;
            if(fillDia(matrix, n, k-i, 1))
                return true;
        }
        return false;
    }

    static boolean fillDia(Integer[][] matrix, int n, int k, int place) {
        if(place == n && k == 0) {
            return fill(matrix, n, 0, 0);
        } else if(place == n) {
            return false;
        } else {
            for(int i = 1; i <= n; ++i) {
                matrix[place][place] = i;
                if(fillDia(matrix, n, k-i, place+1))
                    return true;
            }
            return false;
        }
    }
    static boolean fill(Integer[][] matrix, int n, int c, int r) {
        if(matrix[c][r] != 0) {
            if(c == n-1 && r == n-1)
                return true;
            c = (c+1)%n;
            if(c == 0)
                ++r;
            return fill(matrix, n, c, r);
        } else {
            for(int i = 1; i <= n; ++i) {
                matrix[c][r] = i;
                if(isValid(matrix)) {
                    int newC = (c+1)%n;
                    int newR = r;
                    if(newC == 0)
                        ++newR;
                    boolean success = fill(matrix, n, newC, newR);
                    if(success)
                        return true;
                }
            }
            return false;
        }

    }

    static boolean isValid(Integer[][] matrix) {
        for(int i = 0; i < matrix.length; ++i) {
            HashMap<Integer, Integer> exist = new HashMap<>();
            for (int j = 0; j < matrix.length; ++j) {
                if(exist.containsKey(matrix[i][j])) {
                    return false;
                } else if(matrix[i][j] != 0){
                    exist.put(matrix[i][j], 0);
                }
            }
        }
        for (int i = 0; i < matrix.length; ++i) {
            HashMap<Integer, Integer> exist = new HashMap<>();
            for (int j = 0; j < matrix.length; ++j) {
                if(exist.containsKey(matrix[j][i])) {
                    return false;
                } else if(matrix[j][i] != 0){
                    exist.put(matrix[j][i], 0);
                }
            }
        }
        return true;
    }

    static String format(Integer[] matrix) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < matrix.length; ++i) {
            sb.append(matrix[i]);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}