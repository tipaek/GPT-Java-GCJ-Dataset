import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        
        for(int t = 1; t <= T; t++) {
            ///////////////////////
            
            int n = in.nextInt();
            
            
            int [][] ar = new int[n][n];
            for (int r = 0; r < ar.length; r++)
            {
                for (int c = 0; c < ar[r].length; c++)
                {
                    ar[r][c] = in.nextInt();
                }
            }
            
            
            
            int row = 0;
            for (int r = 0; r < ar.length; r++)
            {
                int current = 0;
                int rowError = 0;
                for (int c = 0; c < ar[r].length; c++)
                {   
                    current = ar[r][c];
                    for (int j = c+1; j < ar[r].length; j++)
                    {
                        if (ar[r][j] == current)
                        {
                            rowError++;
                            break;
                        }
                    }
                    
                }
                if (rowError > 0) row++;
            }
            
            
            int col = 0;
            for (int c = 0; c < ar.length; c++)
            {
                int current = 0;
                int cError = 0;
                for (int r = 0; r < ar[c].length; r++)
                {
                    
                    current = ar[r][c];
                    for (int j = r+1; j < ar[c].length; j++)
                    {
                        if (current == ar[j][c])
                        {
                            cError++;
                            break;
                        }
                    }
                    
                }
                if (cError > 0) col++;
            }
            
            
            int trace = 0;
            for (int r = 0; r < ar.length; r++)
            {
                trace += ar[r][r];
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + row + " " + col);
            
            
            
            ///////////////////////
            
        }
    }
}