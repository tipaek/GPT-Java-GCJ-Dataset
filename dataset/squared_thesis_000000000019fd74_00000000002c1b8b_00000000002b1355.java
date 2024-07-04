

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static List<Integer[][]> cases = new ArrayList<>();
    private static List<Integer> rows = new ArrayList<>();
    private static List<Integer> cols = new ArrayList<>();
    private static List<String> outputList = new ArrayList<>();


    public static void main(String[] args){
        setDataFromUserInput();
        setDataForOutput();
        printOutput();
    }


    private static void setDataForOutput(){
        for(int i=0; i<cases.size(); i++){
            outputList.add(getCompetitionInterest(cases.get(i), rows.get(i), cols.get(i)) + "");
        }
    }

    private static int getCompetitionInterest(Integer[][] matrix, int r, int c){

        int totalInterest = roundInterest(matrix, r, c);

        while(!isFinalRound(matrix, r, c)) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {

                    if (i - 1 >= 0 && matrix[i - 1][j] < matrix[i][j]) {
                        matrix[i - 1][j] = 0;
                    }
                    if (i + 1 < r && matrix[i + 1][j] < matrix[i][j]) {
                        matrix[i + 1][j] = 0;
                    }
                    if (j - 1 >= 0 && matrix[i][j - 1] < matrix[i][j]) {
                        matrix[i][j - 1] = 0;
                    }
                    if (j + 1 < r && matrix[i][j + 1] < matrix[i][j]) {
                        matrix[i][j + 1] = 0;
                    }
                }
            }

            totalInterest += roundInterest(matrix, r, c);

        }


        return totalInterest;
    }

    private static int roundInterest(Integer[][] matrix, int r, int c){
        int interest = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                interest += matrix[i][j];
            }
        }
        return interest;
    }

    private static boolean isFinalRound(Integer[][] matrix, int r, int c){

        for(int i=0; i<r; i++){
            Set<Integer> rowSet = new HashSet<>();
            for(int j=0; j<c; j++){
                if(matrix[i][j] != 0){
                    rowSet.add(matrix[i][j]);
                }
            }
            if(rowSet.size() > 1){
                return false;
            }
        }
        for(int j=0; j<c; j++){
            Set<Integer> colSet = new HashSet<>();
            for(int i=0; i<r; i++){
                if(matrix[i][j] != 0){
                    colSet.add(matrix[i][j]);
                }
            }
            if(colSet.size() > 1){
                return false;
            }
        }

        return true;
    }





    private static void setDataFromUserInput(){
        Scanner scan = new Scanner(System.in);
        int numberOfTestCases = scan.nextInt();
        scan.nextLine();
        for(int i=0; i<numberOfTestCases; i++){
            String numbers = scan.nextLine();
            String[] tokens = numbers.split(" ");
            int rowCount = Integer.parseInt(tokens[0]);
            int colCount = Integer.parseInt(tokens[1]);
            Integer[][] matrix = new Integer[rowCount][colCount];
            for(int j=0; j<rowCount; j++){
                String nums = scan.nextLine();
                String[] toks = nums.split(" ");
                for(int k=0; k<toks.length; k++){
                    matrix[j][k] = Integer.parseInt(toks[k]);
                }
            }
            cases.add(matrix);
            rows.add(rowCount);
            cols.add(colCount);
        }
    }


    private static void printOutput(){
        for(int i=0; i<outputList.size(); i++){
            System.out.println("Case #"+(i+1)+": "+ outputList.get(i));
        }
    }

}
