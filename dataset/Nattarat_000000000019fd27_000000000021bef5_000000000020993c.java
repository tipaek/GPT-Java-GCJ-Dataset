import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        List<int[][]> list = new ArrayList<>();
        for(int t=0; t<T; t++) {
            int N = in.nextInt();
            int[][] mat = new int[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    mat[i][j] = in.nextInt();
                }
            }
            list.add(mat);
        }

        for(int i=0; i<T; i++) {
            output(list.get(i), i);
        }
    }

    private static void output(int[][] mat, int testCaseNo) {
        Set<Integer> rowSet;
        Map<Integer, Set<Integer>> colMap = new HashMap();

        int[] rowRepeat = new int[mat.length];
        int[] colRepeat = new int[mat.length];
        int k = 0;

        for(int r=0; r<mat.length; r++) {
            rowSet = new HashSet<>();
            for(int c=0; c<mat.length; c++) {
                if(r == c) k += mat[r][c];
                if(rowSet.contains(mat[r][c])) {
                    rowRepeat[r]++;
                }
                rowSet.add(mat[r][c]);

                Set<Integer> colList = colMap.getOrDefault(c, new HashSet<>());
                if(colList.contains(mat[r][c])) {
                    colRepeat[c]++;
                }
                colList.add(mat[r][c]);
                colMap.put(c, colList);
            }
        }

        rowRepeat = Arrays.stream(rowRepeat).filter(x -> x > 0).toArray();
        colRepeat = Arrays.stream(colRepeat).filter(x -> x > 0).toArray();
        System.out.println("Case #" + testCaseNo + ": " + k + " " + rowRepeat.length + " " + colRepeat.length);
    }
}
