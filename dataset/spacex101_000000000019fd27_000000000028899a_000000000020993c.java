import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    static Scanner scanner;
    static String [] words;
    static ArrayList<String> lines = new ArrayList<String>();
    public static void main(String[] args) throws IOException {
        scanner = new Scanner(new File("Solution.in"));
        PrintWriter writer = new PrintWriter(new FileWriter("Solution.out"));
        int testCases = scanner.nextInt();
        for(int i = 0; i <testCases; i++){
            int n = scanner.nextInt();
            int sameRows = 0;
            int sameCols = 0;
            boolean sameRow = false;
            boolean sameCol = false;
            int[][] matrix = new int[n][n];
            int sum = 0;
            for(int j = 0; j < n; j++){
                for(int h = 0; h < n; h++){
                    matrix[j][h] = scanner.nextInt();
                }
            }

            for(int row = 0; row< n; row++){
                for(int val = 0; val < n; val++){
                    for(int col = 0; col< n; col++){
                        if((matrix[row][val] == matrix[row][col])&&( val !=col)){
                            sameRow = true;
                            System.out.println(val + " " +col);
                        }
                    }
                }
                if(sameRow == true){
                    sameRows +=1;
                }
                sameRow = false;
            }
            for(int col = 0; col< n; col++){
                for(int val = 0; val < n; val++){
                    for(int row = 0; row< n; row++){
                        if((matrix[val][col] == matrix[row][col])&& (val !=row)){
                            sameCol = true;
                            System.out.println(val + " " +row);
                        }
                    }
                }
                if(sameCol == true){
                    sameCols +=1;
                }
                sameCol = false;
            }
            for(int j = 0; j < n; j++){
                sum+= matrix[j][j];
            }
            writer.println("Case #" + i + ": " + sum + " " + sameRows +  " " + sameCols );
        }

        writer.close();
    }
}