import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution 
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int k, r, c;
        
        for(int i=0; i<t ;i++)
        {
            k = r = c = 0;
            int total = 0;
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            
            for(int j=0; j<n; j++)
            {
                String line = br.readLine();
                String[] ss = line.split(" ");
                for(int l=0; l<n; l++)
                {
                    arr[j][l] = Integer.parseInt(ss[l]);
                }
            }
            
            for(int j=0; j<n; j++)
            {
                for(int l=0; l<n; l++)
                {
                    if(j == l)
                    {
                        k += arr[j][l];
                    }
                }
            }
            
            for(int j=0; j<n; j++)
            {
                total = 0;
                for(int l=0; l<n; l++)
                {
                    for(int q=l+1; q<n; q++)
                    {
                        if(arr[j][l] == arr[j][q])
                        {
                            total++;
                        }
                    }
                }
                if(total > 0)
                {
                    r++;
                }
            }
            
            total = 0;
            
            for(int j=0; j<n; j++)
            {
                total = 0;
                for(int l=0; l<n; l++)
                {
                    for(int q=l+1; q<n; q++)
                    {
                        if(arr[l][j] == arr[q][j])
                        {
                            total++;
                        }
                    }
                }
                if(total > 0)
                {
                    c++;
                }
            }
            
            System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
        }
        br.close();
    }
}