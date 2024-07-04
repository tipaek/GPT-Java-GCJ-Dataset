import java.io.*;
import java.util.*;
class Vestigium
{
public static void main() throws Exception
{
    try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- != 0)
        {   int z =0;
            z++;
            int N = Integer.parseInt(br.readLine());
            int M[][] = new int [N][N];
            for(int i=0; i<N; i++)
            {   StringTokenizer str = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++)
                {
                    M[i][j] = Integer.parseInt(str.nextToken());
                }
            }
            //System.out.println(M[0][0]);
            //System.out.println(M[N-1][N-1]);
            int diag = 0;
            for(int i=0; i<N; i++)
            {
                for (int j=0; j<N; j++)
                {
                    if(i==j)
                    {
                        diag = diag + M[i][j];
                    }
                }
            }
            int row = 0;
            for(int i=0; i<N; i++)
            {   int row_copy = row;
                for(int j=0; j<N-1; j++)
                {
                    for(int k=j+1; k<N; k++)
                    {
                        if(M[i][j] == M[i][k])
                         {
                          row++;
                          break;
                          } 
                    }
                    if(row!=row_copy)
                    {row_copy = row;
                        break;}
                
                }
                
            }
            int col = 0;
            for(int i=0; i<N; i++)
            {   int col_copy = col;
                for(int j=0; j<N-1; j++)
                {
                    for(int k=j+1; k<N; k++)
                    {
                        if(M[j][i] == M[k][i])
                         {
                          col++;
                          break;
                          } 
                    }
                    if(col!=col_copy)
                    { col_copy = col;
                      break;
                    }
                }
                
            }
            
            System.out.println("Case #"+z+":"+ diag+" "+row+" "+col);
            
            
        }
    }
    
    catch(Exception e)
    {
        return;
    }
}
}