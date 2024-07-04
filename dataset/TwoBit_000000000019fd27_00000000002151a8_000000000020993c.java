import java.io.*;
import java.util.*;

public class Solution 
{
    public static void main(String[] args) throws IOException 
    {
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       
       int T = Integer.parseInt(input.readLine());
       
       for(int currCase = 1; currCase <= T; currCase++)
       {
           int N = Integer.parseInt(input.readLine());
           int[][] matrix = new int[N][N];
           //First index: choose which row or column is in use, Second index: choose if it is a row or column (0 for row, 1 for column)
           HashSet<Integer>[][] seen = new HashSet[N][2];
           boolean[][] repeatFound = new boolean[N][2];
           
           int rowRepeat = 0;
           int columnRepeat = 0;
           int trace = 0;
           
           for(int i = 0; i < N; i++)
           {
               seen[i][0] = new HashSet<>();
               seen[i][1] = new HashSet<>();             
           }
           
           for(int i = 0; i < N; i++)
           {               
               String[] vals = input.readLine().split(" ");
               
               for(int j = 0; j < N; j++)
               {
                   int toCheck = Integer.parseInt(vals[j]);  
                   
                   if(i == j)
                       trace += toCheck;
                   
                   matrix[i][j] = toCheck;
                   
                   if(seen[i][0].contains(toCheck) && !repeatFound[i][0])
                   {
                       rowRepeat++;
                       repeatFound[i][0] = true;
                   }else
                   {
                       seen[i][0].add(toCheck);
                   }
                   
                   if(seen[j][1].contains(toCheck) && !repeatFound[j][1])
                   {
                       columnRepeat++;
                       repeatFound[j][1] = true;
                   }else
                   {
                       seen[j][1].add(toCheck);
                   }
               }
           }                        
           
           System.out.println("Case #" + currCase + ": " + trace + " " + rowRepeat + " " + columnRepeat);
       }
    }
}
