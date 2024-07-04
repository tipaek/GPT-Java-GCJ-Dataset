import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int t;
        t = scan.nextInt();
        int trace=0;
        int r=0,c=0;
        int array[][];
        for(int i=0;i<t;i++)
        {
            
            int n = scan.nextInt();
            array = new int [n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    array[j][k] = scan.nextInt();
                    if(j==k)
                        trace+=array[j][k];
                }
            }
            for(int j=0;j<n-1;j++)
            {
                for(int k=0;k<n-1;k++)
                {
                    if(array[j][k] == array[j+1][k])
                        r+=1;
                    if(array[j][k] == array[j][k+1])
                        c+=1;
                    
                }
            }
            System.out.println(trace,r,c);
        }
    }
}