import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;


public class Solution {
    public static void main(String args[])
    {
        String input = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            input = reader.readLine();
            
            int numOfCases = Integer.parseInt(input);
            
            for(int caseNum = 1; caseNum <= numOfCases; ++caseNum)
            {
                input = reader.readLine();
                
                int n = Integer.parseInt(input);
                int trace = 0;
                int repeatedRows = 0;
                int repeatedColumns = 0;
                boolean[] isColumnRepeated =  new boolean[n];
                
                ArrayList<HashSet<String>> columnsChars = new ArrayList<HashSet<String>>(n);
                
                // Initialize arraylist.
                for (int i = 0; i < n; ++i)
                {
                    isColumnRepeated[i] = false;
                    columnsChars.add(new HashSet<String>());
                }
                
                for (int i = 0; i < n; ++i)
                {
                    input = reader.readLine();
                    
                    String[] row = input.split(" ");
                    
                    boolean isRowRepeated = false;
                    
                    trace += Integer.parseInt(row[i]);
                    
                    HashSet<String> rowChars = new HashSet<String>();
                    
                    //Checkt the repeated rows and build columns hashsets;
                    for(int j = 0; j < n; ++j)
                    {
                        String e = row[j];
                        
                        HashSet<String> columnChars = columnsChars.get(j);
                        
                        if(!isColumnRepeated[j] && columnChars.contains(e))
                        {
                            isColumnRepeated[j] = true;
                            ++repeatedColumns;
                        }
                        else
                        {
                            columnChars.add(e);
                        }
                        
                        if(!isRowRepeated && rowChars.contains(e))
                        {
                            isRowRepeated = true;
                            ++repeatedRows;
                        }
                        else
                        {
                            rowChars.add(e);
                        }
                    }
                }
                
                System.out.println("Case #" + caseNum + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}