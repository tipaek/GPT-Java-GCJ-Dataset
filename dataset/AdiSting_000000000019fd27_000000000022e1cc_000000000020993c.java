import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vestigium
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int cases = 1;
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int mat[][] = new int[n][n];
            for (int i=0; i<n; i++)         // input matrix
            {
                for (int j=0; j<n; j++)
                {
                    mat[i][j] = sc.nextInt();
                }
            }

            int k = 0;

            for (int i=0,j=0; i<n && j<n; i++,j++ )
            {
                k+=mat[i][j];
            }

            int r=0,c=0;

            for (int i=0; i<n; i++)
            {
                Map<Integer,Integer> map = new HashMap<>();
                for (int j=0; j<n; j++)
                {
                    int key = mat[i][j];
                    if(map.containsKey(key))
                    {
                        int count = map.get(key);
                        map.put(key,++count);
                    }
                    else
                    {
                        map.put(key,1);
                    }
                }
                for (int v: map.values())
                {
                    if (v > 1)
                    {
                        r++;
                        break;
                    }

                }
            }

            for (int i=0; i<n; i++)
            {
                Map<Integer,Integer> map = new HashMap<>();
                for (int j=0; j<n; j++)
                {
                    int key = mat[j][i];
                    if(map.containsKey(key))
                    {
                        int count = map.get(key);
                        map.put(key,++count);
                    }
                    else
                    {
                        map.put(key,1);
                    }
                }
                for (int v: map.values())
                {
                    if (v > 1)
                    {
                        c++;
                        break;
                    }

                }
            }

            System.out.println("Case #"+cases+": "+k+" "+r+" "+c);
            cases++;

        }

    }

}
