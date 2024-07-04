import java.util.*;
public class Solution
{
public static void main(String[] args)
{
Scanner sc= new Scanner(System.in);
int h=sc.nextInt();
for(int l=1;l<=h;l++)
{
    int n=sc.nextInt();
    int arr[][]=new int[n][n];
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            arr[i][j]=sc.nextInt();
        }
    }
    int sum=0;
    for(int i=0;i<n;i++)
    sum+=arr[i][i];
    int ctr=0;
    int ctro=0;
    for(int i=0;i<n;i++)
    {
        ctr=0;
        for(int j=0;j<n;j++)
        {
            int defau=arr[i][j];
            
            for(int k=j+1;k<n;k++)
            {
                if(defau==arr[i][k])
                ctr++;
            }
        }
        if(ctr>0)
        ctro++;
    }
    int ctco=0;
    for(int j=0;j<n;j++)
    {
        ctr=0;
        for(int i=0;i<n;i++)
        {
            
            int defau=arr[i][j];
            
            for(int k=0;k<n;k++)
            {
                if(k==i)
                continue;
                if(defau==arr[k][j])
                {
                    ctr++;
                    
                }
                
            }
            
            
        }
        if(ctr>0)
            ctco++;
        
    }
    System.out.println("Case #"+l+": "+sum+" "+ctro+" "+ctco);
}
}
}