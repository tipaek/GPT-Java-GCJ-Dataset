//Author Raphael Stobbe

import java.util.*;

public class Solution{

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = Integer.parseInt(scanner.nextLine());
        String currentLine;
        Integer sizeOfMatrix;
        int[][] currentMatrix;
        int[] result = new int[numberOfTests * 3];

        for(int i = 0; i < numberOfTests; i++){
            sizeOfMatrix = Integer.parseInt(scanner.nextLine());
            currentMatrix = new int[sizeOfMatrix][sizeOfMatrix];

            //Fill currentMatrix
            for(int j = 0; j < sizeOfMatrix; j++){
                currentLine = scanner.nextLine();

                String currentString = "";
                int lastCut = 0;
                int counter = 0;
                for(int k = 0; k < currentLine.length(); k++){
                    if(currentLine.charAt(k) == ' '){
                        currentString = currentLine.substring(lastCut, k);
                        currentMatrix[j][counter] = Integer.parseInt(currentString);
                        lastCut = k + 1;
                        counter++;
                    }
                }
                currentString = currentLine.substring(lastCut, currentLine.length());
                currentMatrix[j][counter] = Integer.parseInt(currentString);
            }
            result[0 + i*3] = addition(currentMatrix);
            result[1 + i*3] = numberOfDoubleRows(currentMatrix);
            result[2 + i*3] = numberOfDoubleColumns(currentMatrix);
        }

        for (int i = 0; i < result.length; i = i+3){
            System.out.println("Case #" + (i + 1) + ": "
                    + result[0 + i] + " "
                    + result[1 + i] + " "
                    + result[2 + i]);
        }
    }

    public static int addition(int[][] currentMatrix){
        int output = 0;
        for(int i = 0; i < currentMatrix.length; i++){
            output += currentMatrix[i][i];
        }
        return output;
    }

    public static int numberOfDoubleRows(int[][] currentMatrix){
        int output = 0;
        int currentMatrixLength = currentMatrix.length;

        for(int i = 0; i < currentMatrixLength; i++){

            for(int j = 0; j < (currentMatrixLength - 1); j++){
                for(int k = j+1; k < currentMatrixLength; k++){
                    if(currentMatrix[i][j] == currentMatrix[i][k]){
                        output++;
                    }
                }
            }
        }
        return output;
    }

    public static int numberOfDoubleColumns(int[][] currentMatrix){
        int output = 0;
        int currentMatrixLength = currentMatrix.length;

        for(int i = 0; i < currentMatrixLength; i++){

            for(int j = 0; j < (currentMatrixLength - 1); j++){
                for(int k = j+1; k < currentMatrixLength; k++){
                    if(currentMatrix[j][i] == currentMatrix[k][i]){
                        output++;
                    }
                }
            }
        }
        return output;
    }
}