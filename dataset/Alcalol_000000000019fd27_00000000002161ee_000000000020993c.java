import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        //Set up input scanner
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        //Receive first line (How many cases?)
        int caseCount = in.nextInt();

        for(int i = 1; i <= caseCount; i++){
            //Pass input to question method
            Q_One(i, in);
        }
    }

    public static void Q_One(int ident, Scanner in){
        int matrixSize = in .nextInt();

        HashSet[] rowArray = new HashSet[matrixSize];
        HashSet[] colArray = new HashSet[matrixSize];
        int diagTotal = 0;
        int rowFails = 0;
        int colFails = 0;

        for(int initCounter = 0; initCounter < matrixSize; initCounter++){
            rowArray[initCounter] = new HashSet();
            colArray[initCounter] = new HashSet();
        }

        //i = rows
        //j = cols
        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                int curNumber = in.nextInt();
                if(i == j){
                    diagTotal += curNumber;
                }

                rowArray[i].add(curNumber);
                colArray[j].add(curNumber);

            }
        }


        for(HashSet row : rowArray){
            if(row.size() != matrixSize){
                rowFails += 1;
            }
        }
        for(HashSet col : colArray){
            if(col.size() != matrixSize){
                colFails += 1;

            }
        }

        String output = diagTotal + " " + rowFails + " " + colFails;
        Print_Result(ident, output);

    }

    public static void Print_Result(int ident, String output){
        //Print result
        System.out.println("Case #" + ident + ": " + output);
    }
}
