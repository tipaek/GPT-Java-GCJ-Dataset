import java.util.*;
import java.util.Scanner;

/**
 * Created by wenchihhsieh on 2017/4/15.
 */
public class Solution {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int k = 1; k <= num; k++) {
            int n = scanner.nextInt();
            int sum = scanner.nextInt();
            System.out.println("Case #" + k + ": " + helper(n, sum));
        }
    }

    static String helper(int n, int sum) {
        if(sum < n || sum > n * n) {
            return "IMPOSSIBLE";
        }
        List<char[]>combineList = new ArrayList<>();
        if(sum == ((1 + n) * n )/2){
            char combine[] = new char[n];
            for(int i = 0; i < n; i++) {
                combine[i] = (char)(i + 1 + '0');
            }
            combineList.add(combine);
        }
        if(sum % n == 0) {
            char combine[] = new char[n];
            int div = sum / n;
            for(int i = 0; i < n; i++) {
                combine[i] = (char)(div+'0');
            }
            combineList.add(combine);
        }
        if(combineList.isEmpty()) {
            findCandidate(combineList, n, sum, new char[n], 0);
        }

        for(int i = 0; i < combineList.size(); i++) {
            String testResult = testCombine(combineList.get(i), n);
            if(testResult != null) {
                return "POSSIBLE" + testResult;
            }
        }
        return "IMPOSSIBLE";

    }

    private static void findCandidate(List<char[]>combineList, int n, int sum, char current[], int index) {
        if(sum < 0) return;
        if(index == n) {
            if( sum == 0) {
                char result[] = current.clone();
                combineList.add(result);
            } else{
                return;
            }
        }

        int last = index == 0? 1: current[index - 1];
        for(int i = last; i < n; i++) {
            current[index] = (char)(i + '0');
            findCandidate(combineList, n, sum - i, current,index + 1);
        }
    }

    private static String testCombine(char combine[], int n) {
        // System.out.println(n);
        // System.out.println("testCombine " + new String(combine));

        char array[][] = new char[n][n];
        for(int i = 0; i < n; i++) {
            array[i] = new char[n];
        }
        Set[] rowSet = new Set[n];
        Set[] colSet = new Set[n];
        for(int i = 0; i < n; i++){
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
        }
        for(int i = 0; i < n; i++) {
            char c = combine[i];
            array[i][i] = c;
            rowSet[i].add(c);
            colSet[i].add(c);
        }

        return helper(array, rowSet, colSet, 1, n );
    }

    private static String helper(char array[][], Set[] rowSet, Set[] colSet, int index, int n) {
        // System.out.println(getArray(array, n));
        int row = index / n;
        int col = index % n;
        if(row == col) {
            return helper(array, rowSet, colSet, index + 1, n);
        }
        if(index == n * n) {
            return getArray(array, n);
        }


        for(int i = 1; i <= n; i++) {
            Set<Character>rs = rowSet[row];
            Set<Character>cs = colSet[col];
            char c = (char)( i + '0');
            if(!rs.contains(c) && !cs.contains(c)) {
                rs.add(c);
                cs.add(c);
                array[row][col] = c;
                String result = helper(array, rowSet, colSet, index + 1, n);
                if(result != null) {
                    return result;
                }
                rs.remove(c);
                cs.remove(c);
            }
        }
        return null;
    }

    private static String getArray(char array[][], int n){
        // System.out.println("n " + n + " len " + array.length);
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < n; i++) {
            builder.append("\n");
            for(int j = 0; j < n; j++) {
                builder.append(array[i][j]).append(" ");
            }
        }
        return builder.toString();
    }

}
