import java.util.Scanner;
import java.util.*;

class Solution{

    public static void helper(int caseNo, int size, int[][] matrix){
        Set<Integer> set = new HashSet<>();
        int rows = 0;
        int cols = 0;
        int trace = 0;
        for(int i=0;i<size;i++){
            set = new HashSet<>();
            for(int j=0;j<size;j++){
                set.add(matrix[i][j]);
                if(i == j) trace = trace + matrix[i][j];
            }
            if(set.size() != size){
                rows = rows + 1;
            }
        }

        for(int i=0;i<size;i++){
            set = new HashSet<>();
            for(int j=0;j<size;j++){
                set.add(matrix[j][i]);
            }
            if(set.size() != size){
                cols = cols + 1;
            }
        }

        System.out.println("Case #"+caseNo +": "+trace+" "+rows+" "+cols);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for(int n=1;n<=cases;n++){
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    matrix[i][j] = scanner.nextInt();
                }
            }
            helper(n, size, matrix);
        }
        scanner.close();
    }
}