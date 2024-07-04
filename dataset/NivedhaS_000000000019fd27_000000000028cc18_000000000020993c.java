import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int x = 0 ; x < t ; x++){
            int n = sc.nextInt();
            int trace = 0;
            int numR = 0;
            int numC = 0;
            int matrix[][] = new int[n][n];
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            HashSet<Integer> row = null;
            List<HashSet<Integer>> column = new ArrayList<HashSet<Integer>>();
            for(int i = 0 ; i < n ; i++){
                HashSet<Integer> newCol = new HashSet<Integer>();
                column.add(newCol);
            }
            boolean columnRepeat[] = new boolean[n];
            for(int i = 0 ; i< n ; i++){
                row = new HashSet<Integer>();
                for(int j = 0 ; j < n ; j++){
                    if(i == j ){
                        trace += matrix[i][j];
                    }
                    if(!row.add(matrix[i][j])){
                        numR++;
                    }
                    if(!column.get(j).add(matrix[i][j])){
                        columnRepeat[j] = true;
                    }
                }
            }
            for(int i = 0 ; i < n ; i++){
                if(columnRepeat[i]){
                    numC++;
                }
            }
            System.out.printf("Case #%d: %d %d %d\n",x,trace,numR,numC);
        }
    }
}