import java.io.*;
import java.util.*;
import java.lang.*;
import java.time.*;
public class Solution {
    
    static Scanner sc;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        for(int casenum = 1; casenum <= n; casenum++) {
            solve(casenum);
         }
    }
    
    private final static String IMPOSSIBLE = "IMPOSSIBLE";
    private final static String POSSIBLE = "POSSIBLE";
    
    private static void solve(int casenum) {
        Integer dimension = sc.nextInt();
        Integer trace = sc.nextInt();
        
        StringBuilder result = new StringBuilder();
        
        List<Integer> possibleValues = new ArrayList<Integer>();
        for (int i=1; i<=dimension; i++){
            possibleValues.add(i*dimension);    
        }
            
        StringBuilder printLatinSquare = new StringBuilder();
        if (possibleValues.contains(trace)) {
            result.append(POSSIBLE);
            int value = trace / dimension;
            printLatinSquare = createLatinSquare(value, dimension);
        } else {
            result.append(IMPOSSIBLE);
        }
        
        
        StringBuilder sb = new StringBuilder();
        sb.append("Case #");
        sb.append(casenum);
        sb.append(": ");
        sb.append(result);
        if (printLatinSquare.length() != 0) {
            sb.append("\n");
            sb.append(printLatinSquare);
        } 
        
        System.out.println(sb);
    }
    
    private static StringBuilder createLatinSquare(int pivot, int dimension) {
        // List<int[]> latinSquare = new ArrayList<>();
        StringBuilder printLatinSquare = new StringBuilder();
        // 1,2,3,4,5,..,dim
        int temp = 1;
        int[] row = new int[dimension];
        for(int j=0; j<dimension; j++){
            int element = pivot+j;
            if (element<=dimension) {
                row[j] = element;
            } else {
                row[j] = temp;
                temp++;
            }
        }
        printLatinSquare.append(printRow(row));
        printLatinSquare.append("\n");
        
        for (int j= 1; j<dimension; j++) {
            row = shiftRight(row);
            //latinSquare.add(row);
            printLatinSquare.append(printRow(row));
            if (j != dimension -1)
                printLatinSquare.append("\n");
        }
        return printLatinSquare;
        
    }
    
    private static int[] shiftRight(int[] array) {
        int size = array.length;
        int[] result = new int[size];
        for (int i=0; i<size; i++){
            if (i == 0) {
                result[i] = array[size-1];
            } else {
                result[i] = array[i-1];
            }
        }
        return result;
    }
    
    private static String printRow(int[] row) {
        String result = "";
        for (int i=0; i<row.length; i++) {
            result = result.concat(String.valueOf(row[i]));
            result = result.concat(" ");
        }
        
        return result;
    }
    
}