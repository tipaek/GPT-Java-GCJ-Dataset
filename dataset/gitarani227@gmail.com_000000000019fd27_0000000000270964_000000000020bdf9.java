import java.util.*;
class Solution{
   
    public static void main(String[] args)
    {
        Scanner ob=new Scanner(System.in);
        int t=ob.nextInt();
        int o=1;
        while(t!=0)
        {
            int n=ob.nextInt();
            char[] dp=new char[1441];
            char[] dc=new char[1441];
            int[][] arr=new int[2][n];
                for(int i=0;i<n;i++)
                {
                    
                    arr[0][i]=ob.nextInt();
                    arr[1][i]=ob.nextInt();
                }
               
            int flag=0 , tag=0;
            String str="";
            for(int j=0;j<n;j++)
            {
                flag=0;
                tag=0;
                // System.out.println(arr[0][j] +"  "+arr[1][j]+"______");
                for(int k=arr[0][j]+1 ; k<=arr[1][j]-1;k++)
                {
                    if(dp[k]=='C')
                        {flag=1;
                            break;
                        }
                }
                if(flag==0)
                {
                    for(int i=arr[0][j];i<=arr[1][j];i++)
                    {
                        dp[i]='C';
                    }
                    // System.out.println(j +"  true C--------");
                    str+="C";
                    continue;
                }
                for(int k=arr[0][j]+1 ; k<=arr[1][j]-1;k++)
                {
                    if(dc[k]=='J')
                        {
                            tag=1;
                            break;
                        }
                }
                if(tag==0 )
                {
                    for(int i=arr[0][j];i<=arr[1][j];i++)
                    {
                        dc[i]='J';
                    }
                    str+="J";
                    // System.out.println(j +"  true J__________");
                    continue;
                }
                else if(tag==1 && flag==1)
                {
                    str="IMPOSSIBLE";
                    break;
                }
                    
         
            }
            
            System.out.println("Case #"+o+": "+str);
            o++;
            t--;
        }
     }
}