import java.util.*;

public class First
{
    
   
    
    
    public static void main(String args[])
    {
        Scanner objScanner =new Scanner(System.in);
        int t=objScanner.nextInt();
        int count=0;
        while(t-->0)
        {
         int n=objScanner.nextInt();
         int arr[][]=new int[n][n];
         for(int i=0;i<n;i++)
         {
             for(int j=0;j<n;j++)
             {
                arr[i][j]=objScanner.nextInt();
             }
         }
         int sum=0;
         for(int i=0;i<n;i++)
         {
             for(int j=0;j<n;j++)
             {
                 if(i==j){
                     
                     sum=sum+arr[i][j];
                     
                 }
                 }
             }
         }
         count++;
         
         
         System.out.println("Case #"+count+":"+" "+sum);
         
         
            
        }
        
    }
