import java.util.*;
import java.io.*;
public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; ++k) {
        //   runCase(i);
            int n = in.nextInt();
            
            int counter = 0, counterRows = 0, counterColumns = 0;
            
            String[] digitsColumnsArr = new String[n];
            Arrays.fill(digitsColumnsArr, "");
            ArrayList<Integer> digitsRowsArr = new ArrayList<Integer>();
            
            ArrayList<Integer> indexesColArr = new ArrayList<Integer>();
            
            
            for (int i = 0; i < n; i++) {
                boolean flagRows = false;
                digitsRowsArr.clear();
                for (int j = 0; j < n; j++) {
                    int number = in.nextInt();
                    
                    if (i == j) {
                        counter+=number;
                    }
                    
                    if (digitsRowsArr.contains(number) && !flagRows) {
                        flagRows = true;
                        counterRows++;
                    }
                    digitsRowsArr.add(number);
                    
                    if (digitsColumnsArr[j].contains(',' + Integer.toString(number) + ',') && !indexesColArr.contains(j)){
                        indexesColArr.add(j);
                    }
                    digitsColumnsArr[j] += ',' + Integer.toString(number) + ','; 
                }
            }
            
            System.out.println("Case #" + k + ": " + counter + " " + counterRows + " " + indexesColArr.size());
        
        }
    }
}