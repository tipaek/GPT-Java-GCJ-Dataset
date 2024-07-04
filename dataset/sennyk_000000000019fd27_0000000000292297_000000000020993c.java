import java.io.*;
import java.util.*;

public class Solution{
    public static void main (String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter (new OutputStreamWriter(System.out));
        
        int TestCases = Integer.parseInt(in.readLine());
        int[] Trace = new int[TestCases];
        int[] Row = new int[TestCases];
        int[] Column = new int[TestCases];
        for (int x = 0; x<TestCases; x++)
        {
            int size = Integer.parseInt(in.readLine());
            int[][] matrix= new int[size][size];
            for (int i = 0; i<size; i++){
                String line = in.readLine();
                String[] numbers = line.split(" ");
                for (int a = 0; a<size; a++){
                    matrix[i][a] = Integer.parseInt(numbers[a]);
                }
            }
            int TraceCounter = 0;
            for (int b = 0; b<size; b++)
            {
                TraceCounter+=matrix[b][b];
            }
            int RowCounter = 0;
            int ColumnCounter = 0;
            for (int c=0; c<size; c++)
            {
                for(int d=1; d<size; d++)
                {
                    if(matrix[c][0] == matrix[c][d])
                    {
                        RowCounter++;
                        break;
                    }
                }
            }
            for (int e=0; e<size; e++)
            {
                for(int f=1; f<size; f++)
                {
                    if(matrix[0][e] == matrix[f][e])
                    {
                        ColumnCounter++;
                        break;
                    }
                }
            }
            Trace[x] = TraceCounter;
            Row[x] = RowCounter;
            Column[x] = ColumnCounter;
        }
        for (int z=0;z<TestCases;z++)
        {
            int casenumber = z+1;
            out.println("Case #" + casenumber + ": " + Trace[z] + " " + Row[z] + " " + Column[z]);
        }
        out.close();
    }
}


