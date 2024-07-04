import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static List<Integer> matrixSizeList = new ArrayList<>();
    private static List<Integer> traceList = new ArrayList<>();
    private static List<Integer[][]> outputList = new ArrayList<>();

    public static void main(String[] args){
        setDataFromUserInput();
        setDataForOutput();
        printOutput();
    }


    private static void setDataForOutput(){
        for(int i=0; i<matrixSizeList.size(); i++){
            outputList.add(flipAndCheck(matrixSizeList.get(i), traceList.get(i)));
        }
    }

    private static Integer[][] flipAndCheck(int size, int sum){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                Integer[][] matrix = getLatinSquaredWithSwappedRows(size, i, j);
                if(calculateTrace(matrix) == sum) {
                    return matrix;
                }
            }
        }
        return null;
    }

    private static int calculateTrace(Integer[][] matrix){
        int trace = 0;
        for(int i=0; i<matrix.length; i++){
            trace += matrix[i][i];
        }
        return trace;
    }


    private static Integer[][] getLatinSquaredWithSwappedRows(int size, int row, int swapWith){
        Integer[][] square = generateLatinSquare(size);
        for(int i=0; i<size; i++){
            int temp = square[row][i];
            square[row][i] = square[swapWith][i];
            square[swapWith][i] = temp;
        }
        return square;
    }



    private static Integer[][] generateLatinSquare(int size){
        Integer[][] latinSquare = new Integer[size][size];
        List<Integer> latinSquareNumbers = new ArrayList<>();
        int k = size + 1;
        for(int i=0; i<size; i++){
            int temp = k;
            while(temp <= size){
                latinSquareNumbers.add(temp);
                temp++;
            }
            for(int j=1; j<k; j++){
                latinSquareNumbers.add(j);
            }
            k--;
        }
        int index = 0;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                latinSquare[i][j] = latinSquareNumbers.get(index);
                index++;
            }
        }
        return latinSquare;
    }

    private static int sumOfArray(int[] numbers){
        int sum = 0;
        for(int i=0; i<numbers.length; i++){
            sum += numbers[i];
        }
        return sum;
    }

    private static void setDataFromUserInput(){
        Scanner scan = new Scanner(System.in);
        int numberOfTestCases = scan.nextInt();
        scan.nextLine();
        for(int i=0; i<numberOfTestCases; i++){
            String numbers = scan.nextLine();
            String[] tokens = numbers.split(" ");
            matrixSizeList.add(Integer.parseInt(tokens[0]));
            traceList.add(Integer.parseInt(tokens[1]));
        }
    }

    private static void printMatrix(Integer[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    private static void printOutput(){
        for(int i=0; i<outputList.size(); i++){
            if(outputList.get(i) != null){
                System.out.println("Case #"+(i+1)+": POSSIBLE");
                printMatrix(outputList.get(i));
            }else{
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            }

        }
    }

}
