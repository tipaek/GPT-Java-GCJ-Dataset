
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    
    private final static String possible = "POSSIBLE";
    private final static String impossible = "IMPOSSIBLE";
    
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);
        
        int T, N, K;
        T = input.nextInt();     
        Map<Integer, List<int[]>> dyn = new HashMap<>();
        
        for (int i = 0; i < T; i++) {            
            N = input.nextInt();
            K = input.nextInt();
            String res = solution(dyn, N, K);
            output.println(String.format("Case #%d: %s",(i+1), res));
            output.flush();
        }
    }
    
    public static String createMatrixAnsStr(int[][] mat) {
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                builder.append(mat[i][j]);
                if (j < (mat[0].length -1)) {
                    builder.append(' ');
                }
            }
            
            if (i < (mat.length - 1)) {
                builder.append("\n");
            }
        }
        
        return builder.toString();
        
    }
    
    public static String solution(Map<Integer, List<int[]>> dyn, int N, int K) {
        StringBuilder builder = new StringBuilder();
        
        List<int[]> vec = fullSearch(dyn, K, N);
        
        if (vec.size() == 0) {
            return impossible;
        }        
        
        builder.append(possible);
        builder.append("\n");
        
        for (int[] l : vec) {
           int[][] mat = createMatrix(l, N);
           if (mat != null) {
               builder.append(createMatrixAnsStr(mat));
               return builder.toString();
           }
        }
        
        return impossible;        
    }
    
    public static int[][] createMatrix(int[] diag, int N) {
        int sz = diag.length;
        boolean[][] rowStatus = new boolean[sz + 1][sz + 1];
        boolean[][] colStatus = new boolean[sz + 1][sz + 1];
        
        int[][] res = new int[sz][sz];
        for (int i = 0; i < diag.length; i++) {
            rowStatus[i][diag[i]] = true;
            colStatus[i][diag[i]] = true;
            res[i][i] = diag[i];
        }
        
        if (!fillMatrixFullSreach(res, rowStatus, colStatus, 0, 0, N)) {
            return null;
        }
        
        return res;
    }
        
    public static boolean fillMatrixFullSreach(int[][] matrix, boolean[][] rowStatus, boolean[][] colStatus, int row, int col, int N) {        
        int cr = row;
        int cc = col;
        
        // we reset
        if (cc == matrix[0].length) {
            cc = 0;
            cr++;
        }
        
        // we have made it past this means we were successfull
        if (cr == matrix.length) {
            return true;
        }
        
        // we continue since its set allready
        if (cc == cr) {
            return fillMatrixFullSreach(matrix, rowStatus,colStatus, cr, cc + 1, N);
        }
        
        for (int i = 1; i <= N; i++) {
            
            // invalidPlacement
            if (rowStatus[cr][i] || colStatus[cc][i]) {
                continue;
            }
            
            rowStatus[cr][i] = true;
            colStatus[cc][i] = true;
            
            matrix[cr][cc] = i;
            
            if (fillMatrixFullSreach(matrix, rowStatus, colStatus, cr, cc + 1, N)) {
                return true;
            }
            
            rowStatus[cr][i] = false;
            colStatus[cc][i] = false;
            
            matrix[cr][cc] = 0;
            
        }
        
        return false;
    }

    public static List<int[]> fullSearch(Map<Integer, List<int[]>> dyn, int target, int N) {
        List<int[]> res = new ArrayList<>();
        
        if (dyn.containsKey(target)) {
            List<int[]> list = dyn.get(target);
            for (int[] l : list) {
                if (l.length == N) {
                    res.add(l);
                }
            }
            
            return res;
        }
        
        List<int[]> result = new ArrayList<>();
        int[] carrie = new int[N];
        
        fullSearch(dyn, result, carrie, target, 0, 0, N);
        
        return result;
    }
    
    
    private static void fullSearch(Map<Integer, List<int[]>> dyn, List<int[]> container,  int[] currArr, int target, int curr, int currNdx, int N) {        
        if (curr == target && currNdx == currArr.length) {
            // we have reached our target sum
            
            // copy array            
            int[] copy = new int[currNdx];
            System.arraycopy(currArr, 0, copy, 0, currNdx);
            container.add(copy);            
        }
        
        if (currNdx == currArr.length) {
            return;
        }
        
        int diff = target - curr;
        if (diff == 0) {
            return;
        }
        
        if (dyn.containsKey(diff)) {
            List<int[]> list = dyn.get(diff);
            for (int[] l : list) {                
                System.arraycopy(l, 0, currArr, currNdx, l.length);
                
                int[] copy = new int[currNdx];
                System.arraycopy(currArr, 0, copy, 0, currNdx);
                container.add(copy);    
            }
        }
        
        // full search for the diff
        
        for (int i = 1; i <= N; i++) {
            int sum = curr + i;
            if (sum > target) {
                break;
            }
            
            currArr[currNdx] = i;
            
            fullSearch(dyn, container, currArr, target, sum, currNdx + 1, N);
        }
    }

}
