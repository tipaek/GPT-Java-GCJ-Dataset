import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[] ) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();
        for(int z=0;z<T;z++)
        {
            StringBuilder line = new StringBuilder();
            result.append("Case #");
            int N = Integer.parseInt(reader.readLine());
            int [][]M = new int[N][N];
            int r = 0, c = 0, k=0;
            for(int i=0;i<N;i++)
            {
                String []v = reader.readLine().split(" ");
                for(int j=0;j<N;j++)
                {
                    M[i][j] = Integer.parseInt(v[j]);
                }
            }

            for(int i=0;i<N;i++)
            {
                boolean cf = false,rf = false;
                for(int j=0;j<N;j++)
                {
                    if(i==j)
                        k += M[i][j];
                }

                //row
                for(int l=0;l<N;l++)
                {
                    for(int m=l+1;m<N;m++)
                    {
                        if(M[i][l]==M[i][m])
                        {
                            rf = true;
                            break;
                        }
                    }
                    if(rf)
                    {
                        r++;
                        break;
                    }
                }

                //column
                for(int l=0;l<N;l++)
                {
                    for(int m=l+1;m<N;m++)
                    {
                        if(M[l][i]==M[m][i])
                        {
                            cf = true;
                            break;
                        }
                    }
                    if(cf)
                    {
                        c++;
                        break;
                    }
                }
            }

            result.append(z+1);
            result.append(": ");
            result.append(k);
            result.append(" ");
            result.append(r);
            result.append(" ");
            result.append(c);
            result.append("\n");
        }
        System.out.print(result.toString().trim());
    }
}
