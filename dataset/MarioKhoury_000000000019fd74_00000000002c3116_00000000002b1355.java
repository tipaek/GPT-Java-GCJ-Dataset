import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 1; i <= t; ++i){
            int R = scan.nextInt();
            int C = scan.nextInt();
            int[][] stage = new int[R][];
            for(int j = 0; j < R; ++j){
                stage[j] = new int[C];
                for(int k = 0; k < C; ++k){
                    stage[j][k] = scan.nextInt();
                }
            }
            int total = getRoundInterest(stage);
            int interest = total;
            stage = newRound(stage);
            int newInterest = getRoundInterest(stage);
            while(newInterest < interest){
                total += newInterest;
                interest = newInterest;
                stage = newRound(stage);
                newInterest = getRoundInterest(stage);
            }
            System.out.println("Case #" + i + ": " + total);
        }
    }
    
    private static int getRoundInterest(int[][] matrix){
        int interest = 0;
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                if(matrix[i][j] != -1){
                    interest += matrix[i][j];
                }
            }
        }
        return interest;
    }
    
    private static int[][] newRound(int[][] matrix){
        int[][] newMatrix = new int[matrix.length][];
        for(int i = 0; i < matrix.length; ++i){
            newMatrix[i] = new int[matrix[i].length];
            for(int j = 0; j < matrix[i].length; ++j){
                if(matrix[i][j] != -1){
                    if(elim(i,j,matrix)) {
                        newMatrix[i][j] = -1;
                    }else{
                        newMatrix[i][j] = matrix[i][j];
                    }
                }else{
                    newMatrix[i][j] = -1;
                }
            }
        }
        return newMatrix;
    }
    
    private static boolean elim(int i, int j, int[][] matrix){
        int skill = matrix[i][j];
        if(skill == -1) return true;
        double avg = 0;
        int denom = 4;
        int left = leftNeigh(i,j,matrix);
        int right = rightNeigh(i,j,matrix);
        int top = topNeigh(i,j,matrix);
        int bottom = bottomNeigh(i,j,matrix);
        if(left == 0) --denom;
        if(right == 0) -- denom;
        if(top == 0) --denom;
        if(bottom == 0) --denom;
        if(denom == 0) return false;
        avg = left + right + top + bottom;
        avg = avg/denom;
        if(skill < avg) return true;
        else return false;
    }
    
    private static int leftNeigh(int i, int j, int[][] matrix){
        while(i > 0){
            --i;
            if(matrix[i][j] > -1) return matrix[i][j];
        }
        return 0;
    }
    
    private static int rightNeigh(int i, int j, int[][] matrix){
        while(i < matrix.length - 1){
            ++i;
            if(matrix[i][j] > -1) return matrix[i][j];
        }
        return 0;
    }
    
    private static int topNeigh(int i, int j, int[][] matrix){
        while(j > 0){
            --j;
            if(matrix[i][j] > -1) return matrix[i][j];
        }
        return 0;
    }
    
    private static int bottomNeigh(int i, int j, int[][] matrix){
        while(j < matrix[0].length - 1){
            ++j;
            if(matrix[i][j] > -1) return matrix[i][j];
        }
        return 0;
    }
}