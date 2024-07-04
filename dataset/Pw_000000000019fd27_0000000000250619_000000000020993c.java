import java.util.*;

class Solution{
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        for(int t = 0;t< tc;t++){
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            for(int r = 0;r<N;r++){
                for(int c = 0;c<N;c++){
                    matrix[r][c] = in.nextInt();
                }
            }
            solve(matrix,t);
        }
    }
    private static void solve(int[][] matrix, int caseNo){
        int trace = 0;
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix.length];
        int rDup = 0;
        int cDup = 0;
        HashSet[] rowsS = new HashSet[matrix.length];
        HashSet[] colsS = new HashSet[matrix.length];
        for(int r = 0;r<matrix.length;r++){
            for(int c = 0;c<matrix.length;c++){
                if(r==c)
                    trace+=matrix[r][c];
                if(rowsS[r].contains(matrix[r][c])){
                    rows[r]++;
                    if(rows[r] == 2)
                        rDup++;
                }else{
                    rowsS[r].add(matrix[r][c]);
                }
                if(colsS[c].contains(matrix[r][c])){
                    cols[c]++;
                    if(cols[c] == 2)
                        cDup++;
                }else{
                    colsS[c].add(matrix[r][c]);
                }
            }
        }
        System.out.println("Case #"+caseNo+": "+ trace+" "+ rDup+" "+ cDup);
        
    }
}