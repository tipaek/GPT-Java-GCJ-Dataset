//Author Raphael Stobbe

import java.util.*;

public class Solution{
    
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = Integer.parseInt(scanner.nextLine());
        String currentLine;
        Integer sizeOfMatrix;
        int[][] currentMatrix;
        
        for(int i = 0; i < numberOfTests; i++){
            sizeOfMatrix = Integer.parseInt(scanner.nextLine());
            currentMatrix = new int[sizeOfMatrix][sizeOfMatrix];
            
            //Fill currentMatrix
            for(int j = 0; i < sizeOfMatrix; i++){
                currentLine = scanner.nextLine();
                
                char currentChar;
                for(int k = 0; k < currentLine.length(); k = k+2){
                    currentChar = currentLine.charAt(k);
                    currentMatrix[j][(k/2)] = (int)currentChar - 48;
                }
            }
            System.out.println("Case #" + i + ": "
            + addition(currentMatrix) + " "
            + numberOfDoubleRows(currentMatrix) + " "
            + numberOfDoubleColumns(currentMatrix));
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
                for(int k = 1; k < currentMatrixLength; k++){
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
                for(int k = 1; k < currentMatrixLength; k++){
                    if(currentMatrix[j][i] == currentMatrix[k][i]){
                        output++;
                    }
                }
            }
        }
        return output;
    }
}