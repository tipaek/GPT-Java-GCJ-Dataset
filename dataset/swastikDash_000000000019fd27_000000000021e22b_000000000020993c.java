import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    static List<Integer> columnsRepeated;
    static List<Integer> rowsRepeated;
    static int[][] matrix;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int tests = 1; tests <= cases; tests++) {
            columnsRepeated = new ArrayList<>();
            rowsRepeated = new ArrayList<>();

            n = Integer.parseInt(br.readLine());

            matrix = new int[n][n];


            for (int i = 0; i < n; i++) {
                String[] inpStringArray = br.readLine().trim().split(" ");
                findRowsRepeated(inpStringArray,i);
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(inpStringArray[j]);
                }
            }
            findColumnsRepeated();

            System.out.println("Case #"+tests+" : "+findTrace() + " " + rowsRepeated.size() + " " + columnsRepeated.size());
        }
    }

    private static void findRowsRepeated(String[] inpString, int rowNumber) {
        HashMap<String, Boolean> hasSeen = new HashMap<>();
        for (int j = 0; j < n; j++) {

            if (hasSeen.containsKey(inpString[j])){
                rowsRepeated.add(rowNumber);
                break;
            }
            else
                hasSeen.put(inpString[j],true);
        }
    }

    public static void findColumnsRepeated(){

        for (int columnNumber = 0; columnNumber < n; columnNumber++) {
            HashMap<Integer, Boolean> hasSeen = new HashMap<>();

            for (int ofRow = 0; ofRow < n; ofRow++) {
                int x = matrix[ofRow][columnNumber];

                if (hasSeen.containsKey(x)){
                    columnsRepeated.add(columnNumber);
                    break;
                }
                else
                    hasSeen.put(x,true);
            }

        }


    }

    private static int findTrace() {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }


}
