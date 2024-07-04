import java.util.*;
class Ques
{
    public static void main(String args[])
    {
        Scanner br=new Scanner(System.in);
        //System.out.println("Enter no. of test cases: ");
        int t=br.nextInt();
        while(t>0)
        {
             int v=0,c=0;String r="",co="";
          int l1=0;
         int l2=0; int max1=-999999;
         int max2=-999999;
          //  System.out.println("Enter the size of square matrix: ");
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
             System.out.print("Case #"+t+": "+sum+" ");
            
         
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {  v=A[i][j];
                for(int k=0;k<n;k++)
                { if(v==A[i][k])
                     c++;
                } 
                r=r+c; c=0;
                for(int k=0;k<n;k++)
                { if(v==A[k][j])
                   c++;
                } 
                co=co+c;c=0;
             }
         }
         
        l1=r.length();
        l2=co.length();
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
        System.out.println();
        t--;
    }    
    }
   
    }