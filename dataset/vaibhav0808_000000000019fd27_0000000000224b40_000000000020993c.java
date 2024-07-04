import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int t = 1;t<=T;t++) {
            int N = sc.nextInt();
            int[][] mat = new int[N][N];
            int trace = 0;
            int sameElementsRows = 0;
            int sameElementsCols = 0;
            for(int i=0;i<N;i++) {
                Set<Integer> rowElements = new HashSet();
                for(int j=0;j<N;j++) {
                    mat[i][j] = sc.nextInt();
                    rowElements.add(mat[i][j]);
                    if(i==j) {
                        trace+= mat[i][j];
                    }
                }
                if(rowElements.size() != N) {
                    sameElementsRows++;
                }
            }
            for(int j=0;j<N;j++) {
                Set<Integer> colElements = new HashSet();
                for(int i=0;i<N;i++) {
                    colElements.add(mat[i][j]);
                }
                if(colElements.size() != N) {
                    sameElementsCols++;
                }
            }
            System.out.println("Case #" + t + ": " + trace + " " 
            + sameElementsRows + " " + sameElementsCols);
            
        }
    }
}