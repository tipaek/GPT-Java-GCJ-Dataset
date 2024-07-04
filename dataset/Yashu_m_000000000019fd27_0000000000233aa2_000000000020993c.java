import java.io.*;
import java.util.*;
import java.util.Arrays;
class Main
{
    public static void main(String[] args)
    {
    Scanner sc= new Scanner(System.in);
    int t=sc.nextInt();
    int r1=1;
    while(r1<=t)
    {
        int n=sc.nextInt();
        int[][] a= new int[n][n];
        int  k=0,r=0,c=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j]=sc.nextInt();
                if(i==j)
                k=k+a[i][j];
                
            }
            
            Arrays.sort(a[i]);
            for(int w=0;w<n-1;w++)
            {
                if(a[i][w]==a[i][w+1])
                {r++;
                break;}
            }
        }
                for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int e = 0; e < n- 1 - j; e++){ 
                    if(a[e][i] > a[e + 1][i]){
                        int temp = a[e][i];
                        a[e][i] = a[e + 1][i];
                        a[e+ 1][i] = temp;
                    }
                }
            }
        }
        for(int j=0;j<n;j++)
        {
            for(int i=0;i<n-1;i++)
            {
                if(a[i][j]==a[i+1][j])
                {
                    c++;
                    break;
                }
            }
        }

        System.out.println("Case #"+r1+": "+k+" "+r+" "+c);
        r1++;
    }
    }
}