import java.util.Arrays;
import java.util.Scanner;


public class Solution {
    public static void main(String argv[]){
        Scanner scanner = new Scanner(System.in);
        
        int numberOfTestCases = scanner.nextInt();
        
        for(int i = 0; i< numberOfTestCases; i++){
            int traceOfMatrix = 0,countOfRows = 0,countOfColumns = 0;
            int number = scanner.nextInt(); //number represent rows and columns of matrix
            int[][] matrix = new int[number][number]; 
            Boolean[] flagsForColumns = new Boolean[number];
            Arrays.fill(flagsForColumns, true);
            for(int j=0; j<number; j++){
                boolean flagForRows = true;
                for(int k=0; k<number; k++){
                    matrix[j][k] = scanner.nextInt();
                    if(j==k){
                        traceOfMatrix += matrix[j][k];
                    }
                    if(k!=0){
                        if(flagForRows){
                            int b = k -1;
                            while(true){ 
                                if(matrix[j][k] == matrix[j][b]){   
                                    countOfRows++;
                                    flagForRows = false;
                                    break;
                                }
                                if(b == 0) break;
                                b--;
                            }
                        }
                    }
                }
                if(j!=0){
                   
                    for(int k = 0; k<number; k++){
                        if(flagsForColumns[k]){
                            int b = j-1;
                            while(true){
                                if(matrix[j][k] == matrix[b][k]){
                                    countOfColumns++;
                                    flagsForColumns[k] = false;
                                    break;
                                }
                                if(b == 0) break;
                                b--;
                            }
                        }
                    }
                }
                
            }
            System.out.println("Case #"+(i+1)+": "+traceOfMatrix+" "+countOfRows+" "+countOfColumns);
            
        }
    }
}