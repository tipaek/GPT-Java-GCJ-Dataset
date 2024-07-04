package codejam;

import java.util.Scanner;

public class CodeJam {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int total = Integer.valueOf(s.nextLine());
        
        for(int i=1; i<=total; i++){
            int colCount = 0;
            int rowCount = 0;
            int trace = 0;
            int mSize = Integer.valueOf(s.nextLine());
            int[][] matrix = new int[mSize][mSize];
            
            for(int j=0; j<mSize; j++){
                String tempStr = s.nextLine();
           
                String[] rowArr = tempStr.split(" ");
                if(checkForDuplicates(rowArr)) rowCount++;
                
                for(int k=0; k<rowArr.length; k++){
                    matrix[j][k] = Integer.valueOf(rowArr[k]);
                }
                
                trace += Integer.valueOf(rowArr[j]);
            }
            
            for(int j=0; j<mSize; j++){
                String[] colArr = new String[mSize];
                for(int k=0; k<mSize; k++){
                    colArr[k] = String.valueOf(matrix[k][j]);
                }
                
                if(checkForDuplicates(colArr)) colCount++;
               
            }
           
            System.out.println("Case #"+i+": " + trace + " " + rowCount + " " + colCount);
        }
    }
    
    private static <T> boolean checkForDuplicates(T... array) {
        for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                        if (array[i] != null && array[i].equals(array[j])) {
                                return true;
                        }
                }
        }

        return false;
    }   
}