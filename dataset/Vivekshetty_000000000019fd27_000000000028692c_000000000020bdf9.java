import java.util.Scanner;
import java.io.*;

public class Solution{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        for(int k = 0; k<n ; k++)
        {
            int t = in.nextInt();
            String o ;
            int x = 0;
            o = "C";
            int [][] arr = new int[t+1][2];
            for(int j = 0;j<t;j++)
            {
                arr[j][0] = in.nextInt();
                arr[j][1] = in.nextInt();
            }
            for(int i = 1;i<t;i=i+1)
            {
                
                
                    if((arr[i][0]>=arr[i-1][0]) && (arr[i][0]<=arr[i-1][1]))
                    {
                        o = o+"J";
                        x++;
                    }
                    
                    else if((arr[i][1]>=arr[i-1][0]) && (arr[i][1]<=arr[i-1][1])) 
                    {
                        o = o+"J";
                        
                    }
                    else
                    o = o+"C";
                
            }
            if(x>1)
            {
                System.out.println("Case #"+(k+1)+": IMPOSSIBLE");
            }
            else
            System.out.println("Case #"+(k+1)+": "+o);
            
        }
        
        }
     }