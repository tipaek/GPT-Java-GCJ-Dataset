import java.util.*;

public class Solution {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();
        for (int i = 0; i < testcases; i++){
            int size = scanner.nextInt();
            String[] inputArray = new String[size];
            scanner.nextLine();
            for(int j =0; j < size; j++){
                String s = scanner.nextLine();
                inputArray[j] = s;
            }
            int[][] matrix = creatematrixMatrix(inputArray);
            printSolution(i,matrix);
        }

        scanner.close();

    }


    public static void printSolution(int testcase, int[][] matrix){
        int diag = diagonal(matrix);
        int rows = rows(matrix);
        int columns = columns(matrix);

        System.out.printf("Case #%s: %s %s %s\n", testcase+1,diag,rows,columns);
    }

    private static int columns(int[][] matrix) {
        int counter =  0;
        for(int i = 0; i < matrix.length; i++){
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < matrix.length; j++){
                boolean add = set.add(matrix[j][i]);
                if (!add){
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }

    private static int rows(int[][] matrix) {
        int counter =  0;
        for(int i = 0; i < matrix.length; i++){
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < matrix.length; j++){
                boolean add = set.add(matrix[i][j]);
                if (!add){
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }

    public static int[][] creatematrixMatrix(String[] input){
        int[][]matrix = new int [input.length][input.length];
        for(int i = 0; i < input.length; i++){
            String[] temp = input[i].split(" ");
            for(int j = 0; j < temp.length;j++){
                matrix[i][j] = Integer.parseInt(temp[j]);
            }
        }
        return matrix;
    }

    public static int diagonal(int[][]matrix){
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            sum += matrix[i][i];
        }
        return sum;
    }

}
