import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException
    {
		Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        input.nextLine();
        for (int p=1; p<=num; p++)
        {
            int n = input.nextInt();
            int [][] mat = new int [n][n];
            for (int r=0; r<n; r++)
            {   
                input.nextLine();
                for (int c=0; c<n; c++)
                    mat[r][c]= input.nextInt();
            }
            int trace = 0;
            for (int k=0; k<n; k++)
                trace += mat[k][k]; 
            boolean yup=false;
            int rpeats=0;
            for (int r=0; r<n; r++)
            {
                for (int c=0; c<n; c++)
                {
                    int x=mat[r][c];
                    for (int q=c+1; q<n; q++)
                    {
                        if (x==mat[r][q])
                            yup=true;
                    }
                }
                if (yup==true)
                {
                    rpeats++;
                    yup=false;
                }
            }
            yup=false;
            int cpeats=0;
            for (int c=0; c<n; c++)
            {
                for (int r=0; r<n; r++)
                {
                    int y=mat[r][c];
                    for (int q=r+1; q<n; q++)
                    {
                        if (y==mat[q][c])
                            yup=true;
                    }
                }
                if (yup==true)
                {
                    cpeats++;
                    yup=false;
                }
            }
            System.out.println("Case #" + p + ": "+ trace + " " + rpeats + " " + cpeats);

        }
		input.close();
    }
}