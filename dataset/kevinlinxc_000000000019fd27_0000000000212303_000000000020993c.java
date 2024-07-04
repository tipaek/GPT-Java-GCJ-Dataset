import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        InputStream is =  System.in;
        List<String> rows = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int expectedSum =0;
                int trace = 0;
                int rowCount = 0;
                int columnCount = 0;
                int mazeSize = scanner.nextInt();
                for (int i =1; i<=mazeSize; i++){
                    expectedSum+=i;
                }
                //dealing with trace and arrays
                for (int i = 0; i<mazeSize; i++){
                    String currentRow = scanner.nextLine();
                    rows.add(currentRow);
                    trace += currentRow.charAt(2*i);
                    int actualRowSum = currentRow.chars().reduce(0, Integer::sum);
                    if (actualRowSum != expectedSum){
                        rowCount++;
                    }

                }
                //dealing with columns
                int[] columnArray = new int[mazeSize];
                for(String i : rows){
                    for(int j =0; j<mazeSize;j++){
                        columnArray[j]+= i.charAt(2*j);
                    }
                }
                for (int i =0; i< mazeSize;i++){
                    if (columnArray[i] != expectedSum){
                        columnCount++;
                    }
                }
                System.out.println("Case #" + testNumber + ": " + trace + " " + rowCount + " " + columnCount);
            }
        }
    }
}
