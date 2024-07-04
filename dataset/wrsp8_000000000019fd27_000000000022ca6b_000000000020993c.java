import java.util.*;
public class Solution{
    
    static int[][] matrix;
    static Scanner in;
    static int trace;
    static int erow;
    static int ecol;
    static int size;
    
    
    public static void main(String[] args){
        in = new Scanner(System.in);
        int cases = in.nextInt();
        
        for(int i = 0; i<cases; i++){
            parse();
            solve();
            System.out.println("Case #"+(i+1)+": "+trace+" "+erow+" "+ecol);
        }
    }
    
    private static void parse(){
        size = in.nextInt();
        matrix = new int[size][size];
        for(int i = 0; i < size ; i++){
            for(int j=0; j<size;j++){
                matrix[i][j] =  in.nextInt();
            }
        }
    }
    
    private static void solve(){
        trace =0;
        erow = 0;
        ecol = 0;
        for(int i = 0; i<size; i++){
            trace +=matrix[i][i];
        }
        //row check
        for(int row = 0; row<size; row++){
            loop:
            for(int col = 0; col<size; col++){
                for(int i = col+1; i<size; i++){
                    if(matrix[row][col]==matrix[row][i]){
                        erow++;
                        break loop;
                    }
                }
            }
        }
        
        for(int row = 0; row<size; row++){
            loop:
            for(int col = 0; col<size; col++){
                for(int i = col+1; i<size; i++){
                    if(matrix[col][row]==matrix[i][row]){
                        ecol++;
                        break loop;
                    }
                }
            }
        }
    }
    
    
}