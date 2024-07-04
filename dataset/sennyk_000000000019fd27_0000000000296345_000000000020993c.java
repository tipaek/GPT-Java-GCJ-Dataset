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
            boolean RowBool = false;
            boolean ColumnBool = false;
            int RowCounter =0;
            int ColumnCounter =0;
            for (int c=0; c<size; c++)
            {
                int smin1 = size-1;
                RowBool = false;
                for (int g=0;g<smin1;g++)
                {
                    for(int d=g+1; d<size; d++)
                     {
                         if(matrix[c][g] == matrix[c][d])
                         {
                               RowBool=true;
                          }
                      }
                }
                if (RowBool == true)
                    {
                        RowCounter++;
                    }
            }
            for (int e=0; e<size; e++)
            {
                int smin1 = size-1;
                ColumnBool = false;
                for (int h=0;h<smin1;h++)
                {
                    for(int f=h+1; f<size; f++)
                    {
                        if(matrix[h][e] == matrix[f][e])
                        {
                            ColumnBool=true;
                        }
                    }
                }
                if (ColumnBool == true)
                    {
                        ColumnCounter++;
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


