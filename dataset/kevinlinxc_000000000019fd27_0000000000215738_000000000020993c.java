import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        InputStream is =  System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                List<String> rows = new ArrayList<>();
                List<StringBuilder> columns = new ArrayList<>();
                int trace = 0;
                int rowCount = 0;
                int columnCount = 0;
                int squareSize = scanner.nextInt();
                scanner.nextLine();
                for(int i =0; i<squareSize;i++){
                    columns.add(new StringBuilder());
                }
                //dealing with trace and arrays
                for (int i = 0; i<squareSize; i++){
                    String currentRow = scanner.nextLine();
                    String noSpaces = currentRow.replaceAll(" ","");
                    rows.add(noSpaces);
                    for(int j =0; j< squareSize;j++){
                        char k = noSpaces.charAt(j);
                        columns.get(j).append(k);
                    }
                    trace += Character.getNumericValue(noSpaces.charAt(i));

                }
                List<String> actualColumn = new ArrayList<>();
                for(StringBuilder x:columns){
                    actualColumn.add(x.toString());
                }
                for(String x: rows){
                    if(!check(squareSize,x)){
                        rowCount++;
                    }
                }
                for (String y: actualColumn){
                    if(!check(squareSize,y)){
                        columnCount++;
                    }
                }
                System.out.println("Case #" + testNumber + ": " + trace + " " + rowCount + " " + columnCount);
            }
        }
    }
    private static boolean check(int squareSize, String rorc){
        char[] rorc2 = rorc.toCharArray();
        List<Integer> help = new ArrayList<>();
        for (int i =0; i< rorc2.length;i++){
            help.add(Character.getNumericValue(rorc2[i]));
        }
        for (int i =1; i<=squareSize;i++){
            if(!help.contains(i)){
                return false;
            }
        }
        return true;
    }
}
