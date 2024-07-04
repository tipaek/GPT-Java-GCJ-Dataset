import java.util.Scanner;
public class Solution 
{
        public static void main(String args[])
            {
            Scanner scan=new Scanner(System.in);
            int t=scan.nextInt();
            int p=0;
            while(p<t)
            {
                int n=scan.nextInt();
                int arr[][]=new int[n][n];
                int no_row=0;
                int no_col=0;
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        arr[i][j]=scan.nextInt();
                        
                    }
                }
                // till now we have scanned all the values...
                for(int i=0;i<n;i++)
                {
                    int repeat[]=new int[n+1];
                    for(int j=0;j<n;j++)
                    {
                        if(repeat[arr[i][j]]==1)
                        {
                            no_row+=1;
                            break;
                        }
                        else 
                        {
                            repeat[arr[i][j]]=1;
                        }
                    }
                }
                
                
                for(int i=0;i<n;i++)
                {
                    int repeat[]=new int[n+1];
                    for(int j=0;j<n;j++)
                    {
                        if(repeat[arr[j][i]]==1)
                        {
                            no_col+=1;
                            break;
                        }
                        else 
                        {
                            repeat[arr[j][i]]=1;
                        }
                    }
                }
                
                
                // now calculating the trace of the matrix...
                int trace=0;
                for(int i=0;i<n;i++)
                {
                    trace+=arr[i][i];
                }
                
                System.out.println("Case #"+(p+1)+": "+trace+" "+no_row+" "+no_col);
                p+=1;
            }
      }
}