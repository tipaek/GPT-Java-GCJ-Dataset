import java.util.Scanner;

/**
 *
 * @author Paul
 */
public class CodeJam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int sum = 0, r = 0, c = 0;
        for(int i=1; i<=t; i++)
        {
            int n = sc.nextInt();
            int ar[][] = new int[n][n];
            int br[][] = new int[n][n];
            
            for(int j=0; j<n; j++)
            {
                for(int k=0; k<n; k++)
                {
                    ar[j][k] = sc.nextInt();
                    br[j][k] = ar[j][k];
                }
            }
            
            for(int j=0; j<n; j++)
            {
                for(int k=0; k<n; k++)
                {
                    if(j==k)
                    {
                     sum = sum + ar[j][k];   
                    }
                }
            }
            
            for(int j=0; j<n; j++)
            {
                for(int m=0; m<n; m++)
                {
                   /* int k = m+1;
                    while(true)
                    {
                        if(ar[j][m] == ar[m][k])
                        {
                            r++;
                            break;
                        }
                        k++;
                        if(k<n)
                            break;
                    }*/
                    for(int k=m+1; k<n; k++)
                    {
                        
                        if(ar[j][m] == ar[m][k])
                        {
                            r++;
                            break;
                        }
                        
                        if(ar[m][j] == ar[k][m])
                        {
                            c++;
                            break;
                        }
                    
                    } 
                }
            }
            System.out.println("Case #"+i+": "+sum+" "+r+" "+c);
          /*  for(int j=0; j<n; j++)
            {
                for(int k=0; k<n; k++)
                {
                    System.out.print(ar[j][k]);
                }
            }*/
        }
    }
    
}
