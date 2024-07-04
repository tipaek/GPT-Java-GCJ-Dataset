import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
  
public class Solution
{ 
    public static void main(String[] args) throws IOException 
    { 
  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 
        int h = 1;
        while (h <= t) 
        { 
            int n = Integer.parseInt(br.readLine()); 
            int arr[][] = new int[n][n];
            int i, j, trace = 0, x = 0, y = 0; 
            for(i = 0; i < n; i++)
            {
            	int cnt[] = new int[100];
                StringTokenizer st = new StringTokenizer(br.readLine());
               for(j = 0; j < n; j++)
               {
                   arr[i][j] = Integer.parseInt(st.nextToken());
                   if (i == j)
                   trace += arr[i][j];
                   cnt[arr[i][j]]++;
                   if(cnt[arr[i][j]] > 1)
                   {
                       if(x <= i)
                       x++;
                   }
                }      
            }  
            for (i = 0; i < n; i++)
            {
                int col[] = new int[100];
                for (j = 0; j < n; j++)
                {
                    col[arr[j][i]]++;
                    if(col[arr[j][i]] > 1)
                    {
                        if(y <= j)
                            y++;
                    }
                }
            }
            System.out.println("Case #"+(h)+": "+trace+" "+x+" "+y); 
            h++;
        } 
        
    } 
} 