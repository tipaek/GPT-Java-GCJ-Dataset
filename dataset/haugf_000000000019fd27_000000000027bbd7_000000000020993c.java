import java.util.HashSet;
import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        for(int i=0;i<t;i++)
        {
            //size of latin matrix
            int n = stdin.nextInt();

            int row=0;
            int col=0;

            int trace=0;

            int[][] grid = new int[n][n];

            for(int j=0;j<n;j++) //col
            {
                //for finding dupliacte rows
                HashSet<Integer> hRow = new HashSet<Integer>(); 
                boolean foundRow = false;

                for(int k=0;k<n;k++) //row
                {
                    grid[j][k] = stdin.nextInt();

                    if(foundRow != true)                //if we haven't found a duplicate yet in this row
                        if(hRow.contains(grid[j][k]))   //if we haven't check if this is a duplicate
                            foundRow=true;              //make it trrue because we found one
                        else
                            hRow.add(grid[j][k]);
                    if(j==k)
                        trace+= grid[j][k];
                }
                if(foundRow)
                    row++;
            }

            //find duplicates in columns
            for(int j=0;j<n;j++)
            {
                HashSet<Integer> hCol = new HashSet<Integer>(); 
                boolean foundCol = false;

                for(int k=0;k<n;k++)
                {
                    if(!foundCol)
                        if(hCol.contains(grid[k][j]))
                            foundCol=true;
                        else
                            hCol.add(grid[k][j]);

                }
                if(foundCol)
                    col++;
            }

            System.out.println("Case #"+(i+1)+": "+trace+" "+row+" "+col);

        }
    }
}