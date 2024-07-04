import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vestigium {

    private static List<Integer[][]> matrixList = new ArrayList<>();
    private static List<Integer> matrixSizeList = new ArrayList<>();

    public static void main(String[] arg){
        setDataFromUserInput();
        printOutput();
    }

    private static void setDataFromUserInput(){

        Scanner scan = new Scanner(System.in);

        int numberOfTestCases = scan.nextInt();
        for(int i=0; i<numberOfTestCases; i++){
            int sizeOfMatrix = scan.nextInt();
            Integer[][] matrix = new Integer[sizeOfMatrix][sizeOfMatrix];
            scan.nextLine();
            for(int j=0; j<sizeOfMatrix; j++){
                String numbers = scan.nextLine();
                String[] tokens = numbers.split(" ");
                int k = 0;
                for (String token : tokens){
                    matrix[j][k++] = Integer.parseInt(token);
                }
            }
            matrixList.add(matrix);
            matrixSizeList.add(sizeOfMatrix);
        }

    }


    private static void printOutput(){
        for(int i=0; i<matrixList.size(); i++){
            int trace = calculateTrace(matrixList.get(i), matrixSizeList.get(i));
            int duplicateRowCount = checkRows(matrixList.get(i), matrixSizeList.get(i));
            int duplicateColCount = checkCols(matrixList.get(i), matrixSizeList.get(i));
            System.out.println("Case #"+(i+1)+": "+trace+" "+duplicateRowCount+" "+duplicateColCount);
        }
    }

    private static int calculateTrace(Integer[][] matrix, int size){
        int trace = 0;
        for(int i=0; i<size; i++){
            trace += matrix[i][i];
        }
        return trace;
    }


    private static int checkRows(Integer[][] matrix, int size){
        int count = 0;

        for(int i=0; i<size; i++){
            int[] row = new int[size];
            for(int j=0; j<size; j++){
                row[j] = matrix[i][j];
            }
            if(containsDuplicate(row))
                count++;
        }

        return count;
    }

    private static int checkCols(Integer[][] matrix, int size){
        int count = 0;

        for(int j=0; j<size; j++){
            int[] col = new int[size];
            for(int i=0; i<size; i++){
                col[i] = matrix[i][j];
            }
            if(containsDuplicate(col))
                count++;
        }

        return count;
    }

    private static boolean containsDuplicate(int[] numbers){
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                if(numbers[i] == numbers[j])
                    return true;
            }
        }
        return false;
    }


}
