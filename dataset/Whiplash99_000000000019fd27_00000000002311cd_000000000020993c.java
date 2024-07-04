//created by Whiplash99
import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int i,N,k=0;

        int T=Integer.parseInt(br.readLine().trim());
        StringBuilder sb=new StringBuilder();

        while(T-->0)
        {
            N=Integer.parseInt(br.readLine().trim());
            HashSet<Integer> row[]=new HashSet[N];
            HashSet<Integer> col[]=new HashSet[N];

            for(i=0;i<N;i++)
            {
                row[i]=new HashSet<>();
                col[i]=new HashSet<>();
            }

            long sum=0;
            int matrix[][]=new int[N][N];
            for(i=0;i<N;i++)
            {
                String s[]=br.readLine().trim().split(" ");
                for(int j=0;j<N;j++) matrix[i][j]=Integer.parseInt(s[j]);
            }

            for(i=0;i<N;i++) sum+=matrix[i][i];
            int r=0,c=0;

            for(i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if(row[i].contains(matrix[i][j]))
                    {
                        r++;
                        break;
                    }
                    row[i].add(matrix[i][j]);
                }
            }

            for(i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if(col[i].contains(matrix[j][i]))
                    {
                        c++;
                        break;
                    }
                    col[i].add(matrix[j][i]);
                }
            }
            sb.append("Case #").append(++k).append(":").append(" ");
            sb.append(sum).append(" ").append(r).append(" ").append(c).append("\n");
        }
        System.out.println(sb);
    }
}