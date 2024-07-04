import java.io.BufferedReader;
import java.io.InputStreamReader;
class Practice {
    public static void main(String args[] ) throws Exception {
    
    	//Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());
        for(int x=1; x<=t; x++)
        {
            int n = Integer.parseInt(br.readLine());
            int a[][] = new int[n][n];
            int k=0, r=0, c=0;
            int row[] = new int[n];
            int col[] = new int[n];
            for(int i=0; i<n; i++)
            {   
                row[i] = 0;
                col[i] = 0;
                String s[] = br.readLine().split(" ");
                for(int j=0; j<n; j++)
                {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            for(int i=0; i<n; i++)
            {
                k = k + a[i][i];
                for(int j=0; j<n; j++)
                {
                    row[a[i][j]-1] = 1;
                    col[a[j][i]-1] = 1;
                }
                boolean flag1 = true;
                boolean flag2 = true;
                for(int j=0; j<n; j++)
                {
                    if(row[j] == 0 && flag1 == true)
                    {    
                        r++;
                        flag1=false;
                    }
                    if(col[j] == 0 && flag2 == true)
                    {
                        c++;
                        flag2 = false;
                    }
                    row[j] = 0;
                    col[j] = 0;
                }
                
            }
            System.out.println("\nCase #"+x+": "+k+" "+r+" "+c);
        }
    }
}

