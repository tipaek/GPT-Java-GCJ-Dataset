import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static int lastTestArg = 1;

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int tests = in.nextInt();

        for (int i=1;i <=tests;i++){
            executeTest(in, i);
        }
    }

    static void executeTest(Scanner in, int test){
        int size = in.nextInt();

        int[][] matrix = new int[size][size];

        for (int j=0;j<size;j++){
            for (int i=0;i< size;i++){
                matrix[j][i] = in.nextInt();
            }
        }

        int trace = calculateTrace(matrix);
        int rowsRepetitions = calculateRowsRepetitions(matrix);
        int columsRepetitions = calculateColumnsRepetitions(matrix);

        System.out.println("Case #"+test+": "+trace + " "+rowsRepetitions+" "+columsRepetitions);

        // last test + size of test + the size argument
        lastTestArg = lastTestArg + size + 1;
    }
    static int[] getRows(String[] strs) {
        int[] row= new int[strs.length];
        int i=0;
        for(String str:strs){
            row[i]=Integer.parseInt(str.trim());//Exception in this line
            i++;
        }
        return row;
    }

    static int calculateColumnsRepetitions(int[][] matrix){
        int count = 0;
        for (int i=0;i < matrix.length; i++){
            List<Integer> pastValues = new ArrayList<>();
            for (int j=0;j < matrix.length; j++){
                if (pastValues.contains(matrix[j][i])){
                    count++;
                    break;
                } else{
                    pastValues.add(matrix[j][i]);
                }
            }
        }


        return count;
    }

    static int calculateRowsRepetitions(int[][] matrix){
        int count = 0;
        for (int i=0;i < matrix.length; i++){
            List<Integer> pastValues = new ArrayList<>();
            for (int j=0;j < matrix.length; j++){
                if (pastValues.contains(matrix[i][j])){
                    count++;
                    break;
                } else{
                    pastValues.add(matrix[i][j]);
                }
            }
        }


        return count;
    }
    static int calculateTrace(int[][] matrix){
        int sum = 0;

        for (int i=0;i < matrix.length; i++){
            sum+=matrix[i][i];
        }

        return sum;
    }
}

