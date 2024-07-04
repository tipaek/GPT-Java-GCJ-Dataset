import java.util.*;    
import java.io.*;
import java.util.ArrayList;

public class Solution 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 0; i < cases; i++)
        {
            int size = in.nextInt();;

            // Parse matrix and find values
            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;
            int currentVal;
            
            // array of column arraylist
            ArrayList<Integer>[] columnCheck = new ArrayList[size]; 
  
            // initializing 
            for (int j = 0; j < size; j++) 
                columnCheck[j] = new ArrayList<Integer>(); 

            boolean[] colDup = new boolean[size]; 
            
            for (int j = 0; j < size; j++)
            {
                boolean rowDup = false;
                ArrayList<Integer> rowCheck = new ArrayList<Integer>();
                for (int k = 0; k < size; k++)
                {
                    currentVal = in.nextInt();;
                    
                    // Trace
                    if (j == k)
                        trace += currentVal;

                    // Rowcheck
                    if (!rowCheck.contains(currentVal))
                        rowCheck.add(currentVal);
                    else if (rowCheck.contains(currentVal) && !rowDup)
                    {
                        repeatedRows++;
                        rowDup = true;
                    }
                    
                    // Column check
                    if (!columnCheck[k].contains(currentVal))
                        columnCheck[k].add(currentVal);
                    else if (columnCheck[k].contains(currentVal) && !colDup[k])
                    {
                        repeatedColumns++;
                        colDup[k] = true;
                    }
                        
                }
            }
            
            System.out.println("Case #" + i +": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }
} 