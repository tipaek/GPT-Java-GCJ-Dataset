import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int k=1;
        while(t-->0)
        {
            int n=sc.nextInt();
            int[][] arr=new int[n][n];
            int trace=0;
            int res,row=0,col=0;
            for(int i=0;i<n;i++)
            {
                
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=sc.nextInt();
                   
                    if(i==j)
                    trace+=arr[i][j];
                }
            }
            for(int i=0;i<n;i++)
            {
                HashMap<Integer,Integer> hp=new HashMap();
                for(int j=0;j<n;j++)
                {
                    //arr[i][j]=sc.nextInt();
                    if(!hp.containsKey(arr[i][j]))
                    hp.put(arr[i][j],1);
                    else
                    {
                        row++;
                        break;
                    }
                    
                }
            }
            for(int i=0;i<n;i++)
            {
                HashMap<Integer,Integer> hp=new HashMap();
                for(int j=0;j<n;j++)
                {
                    if(!hp.containsKey(arr[j][i]))
                    hp.put(arr[j][i],1);
                    else
                    {
                        col++;
                        break;
                    }
                }
            }
            
          /*  for(int i=0;i<n;i++)
            {
                res=arr[i][0];
                for(int j=1;j<n;j++)
                {
                    res=res^arr[i][j];
                }
                if(res==0)
                    {
                        row++;
                        //break;
                    }
            }
            for(int i=0;i<n;i++)
            {
                res=arr[0][i];
                for(int j=1;j<n;j++)
                {
                    res=res^arr[j][i];
                    
                }
                if(res==0)
                    {
                        col++;
                      //  break;
                        
                    }
            }*/
            System.out.println("Case #"+k+": "+trace+" "+row+" "+col);
            k++;
        }
    }
}