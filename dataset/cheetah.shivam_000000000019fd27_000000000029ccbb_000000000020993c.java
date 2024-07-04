import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Solution {
  public static void main(String [] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());
    for (int i = 0;i< numberOfTestCases;i++){
      int sizeOfMatrix = Integer.parseInt(bufferedReader.readLine());
      int [][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
      for(int j=0;j< sizeOfMatrix;j++){
        String  lineInput = bufferedReader.readLine();
        String[] inputLines = lineInput.split(" ");
        for(int k =0;k< sizeOfMatrix;k++){
          matrix[j][k] = Integer.parseInt(inputLines[k]);

        }
      }
      calculateOutput(matrix,i);
    }
  }

   public static void calculateOutput(int [][] matrix,int caseNumber){
    int numberOfRowWithReapetedValues =0;
    int numberOfColoumnWithRepeatedValues =0;
    int truceCount = 0;
    for (int i=0;i<matrix.length;i++){
      int[] columnNumberCount = new int[matrix.length];
      int[] rowNumberCount = new int[matrix.length];
      for(int j =0;j<matrix.length;j++){
        columnNumberCount[matrix[i][j]-1] = columnNumberCount[matrix[i][j]-1] +1;
        rowNumberCount[matrix[j][i]-1] = rowNumberCount[matrix[j][i]-1] +1;
        if(i == j){
          truceCount = truceCount + matrix[i][j];
        }
      }
      for(int temp=0;temp<columnNumberCount.length;temp++){
        if(columnNumberCount[temp] > 1){
          numberOfColoumnWithRepeatedValues++;
          break;
        }

      }
      for(int temp=0;temp<rowNumberCount.length;temp++){
        if(rowNumberCount[temp] > 1){
          numberOfRowWithReapetedValues++;
          break;
        }
      }

    }
    String outputString = String.format("Case #"+(caseNumber+1)+": "+truceCount+" "+numberOfColoumnWithRepeatedValues+" "+numberOfRowWithReapetedValues);
     System.out.println(outputString);
  }
}