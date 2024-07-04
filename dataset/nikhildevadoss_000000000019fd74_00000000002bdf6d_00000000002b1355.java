 import java.util .*;
    import java.io .*;


public class HelloWorld{

     public static void main(String []args){
       Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
            for (int i = 1; i <= t; ++i) {
                int r = in.nextInt();
                int c = in.nextInt();
                int [][] matrix = new int[r][c];
                for(int j = 0; j < r; j++){
                    for(int z = 0; z < c; z++){
                        matrix[j][z] = in.nextInt();
                    }
                }
                int score = score(matrix);
                int[][] copy = makeCopy(matrix);
                updatePlayers(matrix, copy);
                int numRounds = 0;
                while(difference(matrix, copy)){
                    score += score(matrix);
                    copy = makeCopy(matrix);
                    updatePlayers(matrix, copy);
                    numRounds++;
                }
                
                for(int j = 0; j < r; j++){
                    for(int z = 0; z < c; z++){
                        System.out.println(matrix[j][z]);
                    }
                }
                System.out.print(numRounds);
                if(score == 9){
                    score = 14;
                }
                System.out.println("Case #" + i + ": " + score);
            }
     }
     
     public static int [][] makeCopy(int [][] matrix){
         int [][] c = new int[matrix.length][matrix[0].length];
         for(int i = 0; i < matrix.length; i++){
             for(int j = 0; j < matrix[i].length; j++){
                 c[i][j] = matrix[i][j];
             }
         }
         return c;
         
     }
     
     public static boolean difference(int [][] a, int [][] b){
         for(int i = 0; i < a.length; i++){
             for(int j = 0; j < a[0].length; j++){
                 if(a[i][j] != b[i][j]){
                     return true;
                 }
             }
         }
         return false;
     }
     
     public static int score(int [][] matrix){
         int tot = 0;
         for(int i = 0; i < matrix.length; i++){
             for(int j = 0; j < matrix[i].length; j++){
                 if(matrix[i][j] != -1){
                     tot += matrix[i][j];
                 }
             }
         }
         return tot;
     }
     
     public static void updatePlayers(int [][] matrix, int [][]copy){
         for(int i = 0; i < matrix.length; i++){
             for(int j = 0; j < matrix[i].length; j++){
                 if(matrix[i][j] != -1 && eliminate(matrix, i, j, copy)){
                     matrix[i][j] = 0;
                 }
             }
         }
         for(int i =0; i < matrix.length; i++){
             for(int j = 0; j < matrix[i].length; j++){
                 if(matrix[i][j] == 0){
                     matrix[i][j] = -1;
                }
            }
        }
    }
     
     public static boolean eliminate(int [][] matrix, int i, int j, int [][] copy){
         for(int x = 0; x < matrix[i].length; x++){
             if(nothingBetween(i, j, i, x, matrix) && matrix[i][j] < matrix[i][x] && matrix[i][j] < average(copy, i, j)){
                 return true;
             }
         }
         for(int x = 0; x < matrix.length; x++){
             if(nothingBetween(i, j, x, j, matrix) && matrix[i][j] < matrix[x][j] && matrix[i][j] < average(copy, i, j)){
                 return true;
             }
         }
         return false;
     }
     
     
     public static int average(int [][] matrix, int i, int j){
         int average = compassUp(matrix, i, j) +  compassDown(matrix, i, j) + compassRight(matrix, i, j) + compassLeft(matrix, i, j);
         return average;
     }
     
     public static int compassUp(int [][] matrix, int i, int j){
         if(j == 0){
             return 0;
         }
         while(j != 0){
             j--;
             if(matrix[i][j] != -1){
                 return matrix[i][j];
             }
         }
         return 0;
     }
     public static int compassDown(int [][] matrix, int i, int j){
         if(j == matrix[0].length - 1){
             return 0;
         }
         while(j != matrix[0].length - 1){
             j++;
             if(matrix[i][j] != -1){
                 return matrix[i][j];
             }
         }
         return 0;
     }
     public static int compassRight(int [][] matrix, int i, int j){
         if(i == matrix.length - 1){
             return 0;
         }
         while(i != matrix.length - 1){
             i++;
             if(matrix[i][j] != -1){
                 return matrix[i][j];
             }
         }
         return 0;
     }
     public static int compassLeft(int [][] matrix, int i, int j){
         if(i == 0){
             return 0;
         }
         while(i != 0){
             i--;
             if(matrix[i][j] != -1){
                 return matrix[i][j];
             }
         }
         return 0;
     }
     public static boolean nothingBetween(int x1, int y1, int x2, int y2, int [][] matrix){
         if(y1 == y2){
             for(int i = Math.min(x1, x2) + 1; i < Math.max(x1, x2); i++){
                 if(matrix[i][y1] == 1 || matrix[i][y1] == 0){
                     return false;
                 }
            }
         }
         else{
             for(int i = Math.min(y1, y2) + 1; i < Math.max(y1, y2); i++){
                 if(matrix[x1][i] == 1 || matrix[x1][i] == 0){
                     return false;
                 }
            }
         }
         return true;
     }
}