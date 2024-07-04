import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[]args)
    {
        Scanner scan=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=scan.nextInt();
        for(int tCount=1;tCount<=t;tCount++)
        {
            int r=scan.nextInt();
            int c=scan.nextInt();
            int [][]grid=new int[r][c];
            boolean [][]eliminated=new boolean[r][c];
            for(int i=0;i<r;i++)
                for(int j=0;j<c;j++)
                    grid[i][j]=scan.nextInt();
            int result=0;
            while(true)
            {
                for(int i=0;i<r;i++)
                    for(int j=0;j<c;j++)
                    {
                        eliminated[i][j]=false;
                        if(grid[i][j]!=0)
                        {
                            result+=grid[i][j];
                            int compassNumber=0;
                            int compassSkill=0;
                            for(int k=i-1;k>=0;k--)
                                if(grid[k][j]!=0)
                                {
                                    compassNumber++;
                                    compassSkill+=grid[k][j];
                                    break;
                                }
                            for(int k=i+1;k<r;k++)
                                if(grid[k][j]!=0)
                                {
                                    compassNumber++;
                                    compassSkill+=grid[k][j];
                                    break;
                                }
                            for(int k=j-1;k>=0;k--)
                                if(grid[i][k]!=0)
                                {
                                    compassNumber++;
                                    compassSkill+=grid[i][k];
                                    break;
                                }
                            for(int k=j+1;k<c;k++)
                                if(grid[i][k]!=0)
                                {
                                    compassNumber++;
                                    compassSkill+=grid[i][k];
                                    break;
                                }
                            if(grid[i][j]<(float)compassSkill/compassNumber)
                                eliminated[i][j]=true;
                        }
                    }
                boolean done=true;
                for(int i=0;i<r;i++)
                    for(int j=0;j<c;j++)
                        if(eliminated[i][j])
                        {
                            grid[i][j]=0;
                            done=false;
                        }
                if(done)
                    break;
            }
            System.out.println("Case #"+tCount+": "+result);
        }
    }
}
