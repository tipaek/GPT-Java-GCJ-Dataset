import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class program{
    public static void main(){
        
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int numberOfTestCases;
    
    if((line = stdin.readLine()) != null && line.length()!= 0){
        numberOfTestCases = Integer.parseInt(line);
    }else{
        return;
    }
    
    
    while ((line = stdin.readLine()) != null && line.length()!= 0) {
        int numberOfRows = Integer.parseInt(line);
        List<List<Integer>> matrix = new ArrayList<>();
        
        for(int i = 0; i<numberOfRows; i++){
            String[] inputRow = line.split(" ");
            List<String> numberList = Arrays.asList(inputRow);
            List<Integer> intList = new ArrayList<>();
            for(String number : numberList){
                intList.add(Integer.valueOf(number));
            }
            matrix.add(intList);
        }
        computeOutput(numberOfRows,matrix);
    }
    
    }
    
    public static void computeOutput(int numberOfRows,List<List<Integer>> matrix){
        int totalDuplicatesRows = 0;
        int totalDuplicatesColumn = 0;
        int sumOfDiagonal = 0;
        
        for(int i = 0; i<numberOfRows; i++){
          //Check Row
          List<Integer> currentList = matrix.get(i);
          Set<Integer> currentSet = new HashSet<Integer>(currentList);
          if(currentSet.size() != currentList.size()){
            totalDuplicatesRows++;
          }
          //Check Column
          int sizeOfRow = currentList.size();
          if(i+1 <= sizeOfRow){
            sumOfDiagonal = sumOfDiagonal+matrix.get(i).get(i);
            List<Integer> columnList = new ArrayList<Integer>();
            for(int x = 0; x<numberOfRows; x++){
                columnList.add(matrix.get(x).get(i));
            }
            Set<Integer> columnSet = new HashSet<Integer>(columnList);
            if(columnList.size() != columnSet.size()){
                totalDuplicatesColumn++;
            }
          }
          
        }
        System.out.println(sumOfDiagonal + " " + totalDuplicatesRows + " " + totalDuplicatesColumn);
    }
    
}