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
            Integer[][] matrix = generateLatinSquare(matrixSizeList.get(i));
            String comboInput = "";
            for(int j=0; j<matrixSizeList.get(i); j++){
                comboInput += j;
            }
            List<String> combinations = combo(comboInput);
            for(int j=0; j<combinations.size(); j++){
                String combo = combinations.get(j);
                Integer[][] output = applyCombinationOnMatrix(matrix, combo);
                if(calculateTrace(output) == traceList.get(i)) {
                    outputList.add(output);
                    break;
                }else if(j == combinations.size()-1){
                    outputList.add(null);
                }
            }
        }
    }


    private static List<String> combo(String num){
        if(num.length() <= 1) return new ArrayList<String>(){{add(num);}};

        List<String> numbers = new ArrayList<>();

        for(int i=0; i<num.length(); i++){
            String head, tail;
            if(i < num.length()-1){
                head = num.substring(i, i+1);
                tail = num.substring(0, i) + num.substring(i+1);
            }
            else{
                head = num.substring(num.length()-1);
                tail = num.substring(0, num.length()-1);
            }
            List<String> tailCombinations = combo(tail);
            for(String s : tailCombinations){
                numbers.add(head + s);
            }

        }
        return numbers;
    }

    private static int calculateTrace(Integer[][] matrix){
        int trace = 0;
        for(int i=0; i<matrix.length; i++){
            trace += matrix[i][i];
        }
        return trace;
    }

    private static Integer[][] applyCombinationOnMatrix(Integer[][] matrix, String combo){
        Integer[][] output = new Integer[matrix.length][matrix.length];

        for(int i=0; i<output.length; i++){
            for(int j=0; j<output.length; j++){
                int rIndex = Integer.parseInt(combo.charAt(i)+"");
                output[i][j] = matrix[rIndex][j];
            }
        }


        return output;
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
