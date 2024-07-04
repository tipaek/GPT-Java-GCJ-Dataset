import java.util.*;
class Ques
{
    public static void main(String args[])throws IOException
    {
        Scanner br=new Scanner(System.in);
        Ques ob=new Ques();
        
        System.out.println("Enter no. of test cases: ");
        int t=br.nextInt();
        while(t>0)
        {
            System.out.println("Enter the size of square matrix: ");
            int n=br.nextInt();
            int sum=0;
            int A[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    A[i][j]=br.nextInt();
                }
            }
            for(int i=0;i<n;i++)
            sum=sum+A[i][i];
            
            System.out.print(sum+" ");
            ob.fun();
            
        }
    }
    void fun(int s[][])
    {
        int v=0,c=0;String r="",co="";
        int l1=r.length();
         int l2=co.length(); int max1=-999999;
         int max2=-999999;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {  v=s[i][j];
                for(int k=0;k<n;k++)
                { if(v==s[i][k])
                     c++;
                } 
                r=r+c; c=0;
                for(int k=0;k<n;k++)
                { if(v==s[k][j])
                   c++;
                } 
                co=co+c;c=0;
             }
         }
         
        
         for(int i =0;i<l1;i++)
         {
             char ch=r.charAt(i);
             String g=""+ch;
             int h=Integer.parseInt(g);
             if(h>max1)
             max1 =h;
         }
          for(int i =0;i<l2;i++)
         {
             char ch=co.charAt(i);
             String g=""+ch;
             int h=Integer.parseInt(g);
             if(h>max2)
             max2 =h;
         }
        System.out.print(max1+" ");
        System.out.print(max2+" ");
            
        }
    }