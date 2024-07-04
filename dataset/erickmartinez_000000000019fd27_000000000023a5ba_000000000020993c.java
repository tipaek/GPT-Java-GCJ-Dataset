import java.util.HashSet;
import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for(int i = 0 ; i< t ; i++){
            int n = scanner.nextInt();
            int matrix[][] = new int[n][n];

            for(int row = 0; row < n; row++){
                for(int column = 0; column < n ; column++){
                    matrix[row][column] = scanner.nextInt();
                }
            }

            validateMatrix(matrix , n, t);
        }

    }

    public static void validateMatrix(int[][] matrix, int n, int t){
        int duplicatesRows = 0;
        int duplicatesColumn = 0;
        int trace = 0;

        for(int row = 0 ; row < n ; row++){
            HashSet<Integer> seenColumns = new HashSet<>();
            HashSet<Integer> seenRows = new HashSet<>();
            trace += matrix[row][row];
            
            //Iterate through rows
            for(int column = 0 ; column < n ; column++){
                if(seenRows.contains(matrix[row][column])){
                    duplicatesRows++;
                    break;
                }else{
                    seenRows.add(matrix[row][column]);
                }
            }
            //Iterate through columns
            for(int column = 0 ; column < n ; column ++){
                if(seenColumns.contains(matrix[column][row])){
                    duplicatesColumn++;
                    break;
                }else{
                    seenColumns.add(matrix[column][row]);
                }
            }
        }
        System.out.println("Case #"+t+": "+trace+" "+duplicatesRows+" "+duplicatesColumn);
    }
}