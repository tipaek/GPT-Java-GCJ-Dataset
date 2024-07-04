import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by mohan on 05, Apr, 2020
 */
public class Solution {

    public static void main(String... args){

        Map<Integer, List<Integer>> testCaseIdVskrcMap=new HashMap<>();

        Scanner scanner=new Scanner(System.in);
        int testCases=scanner.nextInt();

        for(int t=0;t<testCases;t++){
            int squareArraySize = scanner.nextInt();
            //scanner.nextLine();

            //Read Array
            int [][] array=new int[squareArraySize][squareArraySize];
            for (int i=0;i<array.length;i++){
                for (int j=0;j<array[i].length;j++){
                    array[i][j]=scanner.nextInt();
                }
            }
            scanner.nextLine();
            testCaseIdVskrcMap.put(t+1,getDuplicateCountAndTrace(array));

        }

        for (Map.Entry<Integer,List<Integer>> m:testCaseIdVskrcMap.entrySet()) {
            String appendN="";
            if(m.getKey() < testCases){
                appendN="\n";
            }
            System.out.print("Case #"+m.getKey()+": "+m.getValue().stream().map(String::valueOf).collect(Collectors.joining(" "))+appendN);
        }
    }

    private static List<Integer> getDuplicateCountAndTrace(int[][] array) {
        int rowDuplicateCount = 0,columnDuplicateCount=0,trace=0;

        for (int i=0;i<array.length;i++){
            //resetting the variables
            boolean rowDuplicateExists=false,columnDuplicateExists=false;
            List<Integer> rowDataList=new ArrayList<>();
            List<Integer> columnDataList=new ArrayList<>();

            trace += array[i][i];
            for (int j=0;j<array[i].length;j++){
                int rowData = array[i][j];
                int columnData = array[j][i];

                //check for row duplicate
                if(rowDataList.contains(rowData)){
                    rowDuplicateExists = true;
                }else{
                    rowDataList.add(rowData);
                }

                //check for column duplicate
                if(columnDataList.contains(columnData)){
                    columnDuplicateExists = true;
                }else{
                    columnDataList.add(columnData);
                }

            }
            if(rowDuplicateExists){
                rowDuplicateCount++;
            }

            if(columnDuplicateExists){
                columnDuplicateCount++;
            }
        }
        List<Integer> results=new ArrayList<>();;
        results.add(trace);
        results.add(rowDuplicateCount);
        results.add(columnDuplicateCount);
        return results;
    }
}
