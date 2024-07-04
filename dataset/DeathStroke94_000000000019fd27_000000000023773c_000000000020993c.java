import java.util.*;
import java.io.*;

class solution
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine());
            int mat[][] = new int[n][n];
            for(int i=0; i<n; i++)
            {
                String[] temp = br.readLine().split(" ");
                for(int j=0; j<temp.length; j++)
                    mat[i][j] = Integer.parseInt(temp[j]);                
            }
            checkMatrix(mat,n);
        }
    }
    static void checkMatrix(int[][] mat, int n, int t)
    {
        int sum = 0, caseNo = t+1, c = 0, r = 0; 
        HashMap<Integer,Integer> mapRow = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> mapCol = new HashMap<Integer,Integer>();
        for(int i=0; i<n; i++)
        {
            sum += mat[i][i];
            mapRow.put(mat[0][0],1);
            mapCol.put(mat[0][0],1);
            for(int j=1; j<n; j++)
            {
                if(mapRow.containsKey(mat[i][j]) == true)
                {
                    c++;
                    break;
                }
                else
                {
                    mapRow.put(mat[i][j],1);
                }
            }
            for(int j=1; j<n; j++)
                if(mapCol.containsKey(mat[j][i]) == true)
                {
                    r++;
                    break;
                }
                else
                {
                    mapCol.put(mat[j][i],1);
                }
        }
        System.out.println("Case #"+caseNo+": "+sum+" "+c+" "+r);   
    }
}