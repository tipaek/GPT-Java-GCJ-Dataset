import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int testCases = Integer.parseInt(s);
        int caseNumb = 1;

        while( testCases > 0)
        {
            s = br.readLine();
            int matrixSize = Integer.parseInt(s);
            readArray(br, matrixSize, caseNumb);

            testCases--;
            caseNumb++;
        }
    }

    private static void readArray(BufferedReader br, int matrixSize, int caseNumb) throws IOException
    {
        int trace = 0;
        List<Set<Integer>> columns = new ArrayList<>();
        Set<Integer> failedRows = new HashSet<>();
        Set<Integer> failedCols = new HashSet<>();

        int wrongRowCount = 0;
        int wrongColCount = 0;

        for( int i = 0; i < matrixSize ; i++)
        {
            String s = br.readLine();
            String[] elements = s.split(" ");

            Set<Integer> row = new HashSet<>();

            for(int j = 0; j < matrixSize; j++)
            {
                if(columns.size() < j+1)
                    columns.add(new HashSet<>());

                int elem = Integer.parseInt( elements[j] );
                if(i == j)
                {
                    trace += elem;
                }

                if( row.contains(elem) && !failedRows.contains(i) )
                {
                    wrongRowCount++;
                    failedRows.add(i);
                }
                else
                {
                    row.add(elem);
                }

                if( columns.get(j).contains(elem) && !failedCols.contains(j) )
                {
                    wrongColCount++;
                    failedCols.add(j);
                }
                else
                {
                    columns.get(j).add(elem);
                }
            }
        }

        System.out.println("Case #"+ caseNumb +": " + trace + " " + wrongRowCount + " " + wrongColCount);
    }
}

