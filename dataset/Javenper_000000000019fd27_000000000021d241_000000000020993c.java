import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            
            int[][] matrix = new int[n][n];
            int k = 0;
            for(int x = 0; x < n; x++){
                
                for(int y = 0; y < n; y++){
                    
                    matrix[x][y] = Integer.parseInt(sc.next());
                    
                    if(x == y){
                        k += matrix[x][y];
                    }
                }
                
            }
            System.out.println("Case #" + (i+1) + ": " + k + " " + rowRepeated(matrix,n)+
                        " "+columnRepeated(matrix,n));
        }
    }
    
    private static int rowRepeated(int[][] m, int size){
        int countRowRepeated = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                for(int y = size - 1; (y > j) && (y < size); y--){
                    if(m[i][j] == m[i][y]){
                        ++countRowRepeated;
                        j = size;
                        break;
                    }
                }
                
            }
        }
        return countRowRepeated;
    }
    
    private static int columnRepeated(int[][] m, int size){
        int countColRepeated = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                for(int y = size - 1; (y > j) && (y < size); y--){
                    if(m[y][i] == m[j][i]){
                        ++countColRepeated;
                        j = size;
                        break;
                    }
                }
            }
        }
        return countColRepeated;
    }
}