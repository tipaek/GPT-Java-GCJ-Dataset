
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int numCases = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numCases; i++) 
        {
            int size = Integer.parseInt(scan.nextLine());
            Integer[][] testCase = new Integer[size][size];
            int trace = 0, repeatedRows = 0, repeatedCols=0;
            for(int j = 0; j < size; j++)
            {
                String line = scan.nextLine();
                String[] stringRow = line.split(" ");
                Integer[] row = new Integer[size];
                for(int k = 0; k < size; k++)
                {
                    row[k] = Integer.parseInt(stringRow[k]);
                    
                }
                HashSet<Integer> setRow;
                setRow = new HashSet<>(Arrays.asList(row));
                if (setRow.size() != row.length) {
                    repeatedRows += 1;
                }
                testCase[j] = row;
                trace += testCase[j][j];
            }
            for(int j = 0; j < size; j++)
            {
                Integer[] column = new Integer[size];
                HashSet<Integer> setCol;
                for(int k = 0; k < size; k++)
                {
                    column[k] = testCase[k][j];
                }
                setCol = new HashSet<>(Arrays.asList(column));
                if(setCol.size() != column.length)
                {
                    repeatedCols+=1;
                }
            }
            System.out.println("Case #" + (i+1) +": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
    
}
