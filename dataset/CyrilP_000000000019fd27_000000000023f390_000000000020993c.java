import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int i = 0; i<T; i++){
            int N = sc.nextInt();
            int trace = 0;
            int invalidCols = 0;
            int invalidRows = 0;
            BitSet[] colSets = new BitSet[N];
            BitSet rowSet = new BitSet(N);
            BitSet countedCol = new BitSet(N);
            BitSet countedRow = new BitSet(N);
            int[][] matrix = new int[N][N];
            for(int j = 0; j<N; j++){
                rowSet.clear();
                for(int k = 0; k<N; k++){
                    if(j==0){
                        colSets[k] = new BitSet(N);
                    }
                    matrix[j][k] = sc.nextInt();
                    if(j==k) {
                        trace += matrix[j][k];
                    }
                    if(rowSet.get(matrix[j][k]) && !countedRow.get(j)){
                        countedRow.set(j);
                        invalidRows += 1;
                    }
                    else if(!rowSet.get(matrix[j][k])){
                        rowSet.set(matrix[j][k]);
                    }
                    if(colSets[k].get(matrix[j][k]) && !countedCol.get(k)){
                        countedCol.set(k);
                        invalidCols += 1;
                    }
                    else if(!colSets[k].get(matrix[j][k])){
                        colSets[k].set(matrix[j][k]);
                    }
                }
            }
            sb.append(String.format("Case #%d: %d %d %d\n", i+1, trace, invalidRows, invalidCols));
        }
        System.out.println(sb);
    }
}
