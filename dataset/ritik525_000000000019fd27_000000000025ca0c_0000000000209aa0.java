import java.util.*;

class Solution
{

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            int n=sc.nextInt();
            int l=sc.nextInt();
            int arr1[]=new int[n-1];
            int d=1;
            for(int i=0;i<n-1;i++)
            {
                if(d==l/n)
                d++;
                arr1[i]=d;
                d++;

                
            }
          
        
            int arr[][]=new int[n][n];
            
            if(l%n!=0)
            {
            System.out.println("Case #"+k+": "+"IMPOSSIBLE");
            }
            else
            {
                
                 int m=l/n;
                 for(int i=0;i<n;i++)
                 arr[i][i]=m;
                for(int i=0;i<n;i++)
                {
                   
                    if(i>0)
                    {
                        int temp=arr1[n-2];
                        for(int z=n-2;z>0;z--)
                        {
                           arr1[z]=arr1[z-1];

                        }
                        arr1[0]=temp;
                    }
           
               
                  int e=0;
                    for(int j=0;j<n;j++)
                    {

                      if(j==i)  
                      continue;
                      else
                      {
                          arr[i][j]=arr1[e];
                         e++;
                      }
                    }
                    
                
                }
                System.out.println("Case #"+k+": "+"POSSIBLE");
               for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        System.out.print(arr[i][j]+" ");
                        
                    }
                    System.out.println();
                }
              
            }
        }
    }
}