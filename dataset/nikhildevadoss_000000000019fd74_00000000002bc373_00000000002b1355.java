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
                updatePlayers(matrix);
                int numRounds = 0;
                while(difference(matrix, copy)){
                    score += score(matrix);
                    copy = makeCopy(matrix);
                    updatePlayers(matrix);
                    numRounds++;
                }
                
                for(int j = 0; j < r; j++){
                    for(int z = 0; z < c; z++){
                        System.out.println(matrix[j][z]);
                    }
                }
                System.out.print(numRounds);
                
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
     
     public static void updatePlayers(int [][] matrix){
         for(int i = 0; i < matrix.length; i++){
             for(int j = 0; j < matrix[i].length; j++){
                 if(matrix[i][j] != -1 && eliminate(matrix, i, j)){
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
     
     public static boolean eliminate(int [][] matrix, int i, int j){
         for(int x = 0; x < matrix[i].length; x++){
             if(nothingBetween(i, j, i, x, matrix) && matrix[i][j] < matrix[i][x]){
                 return true;
             }
         }
         for(int x = 0; x < matrix.length; x++){
             if(nothingBetween(i, j, x, j, matrix) && matrix[i][j] < matrix[x][j]){
                 return true;
             }
         }
         return false;
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