import java.util.Scanner;
import java.io.*;

public class Solution{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i<n ; i++)
        {
            int t = in.nextInt();
            String o = "C";
            int x = 0;
            int [][] arr = new Int[t+1][2];
            for(int i = 0;i<t;i++)
            {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
            }
            for(int i = 1;i<t;i=i+1)
            {
                
                
                    if((arr[i][0]>=arr[i-1][0]) && (arr[i][0]<=arr[i-1][1]))
                    {
                        o = o+"J";
                        x++;
                    }
                    else
                    o = o+"C";
                
            }
            if(x>1)
            {
                System.out.println('IMPOSSIBLE');
            }
            else
            System.out.println(o);
            
        }
        
        }
     }