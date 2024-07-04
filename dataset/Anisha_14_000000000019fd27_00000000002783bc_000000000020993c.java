import java.util.*; 
import java.io.*;
class Ques
{
    public static void main(String args[])
    {
        Scanner br=new Scanner(System.in);
         int v=0,c=0;
         String r="",co="";
         int l1=0;int l2=0;
         int max1=0;int max2=0;
         int N=0,sum=0;
        //System.out.println("Enter no. of test cases: ");
        int T=br.nextInt();
        while(T>0)
        {max1=-999999;
        max2=-999999;
        
          //  System.out.println("Enter the size of square matrix: ");
            N=br.nextInt();
            sum=0;
           int A[][]=new int[N][N];
            
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    A[i][j]=br.nextInt();
                }
            }
            for(int i=0;i<N;i++)
            sum=sum+A[i][i];
            System.out.print("Case #"+t+": "+sum+" ");
      for(int i=0;i<n;i++)
        {
            for(int j=0;j<N;j++)
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
         
        l1=r.length();r="";
        l2=co.length();co="";
         for(int i =0;i<l1;i++)
         {
             char ch=r.charAt(i);
             String g=""+ch;
             int h=Integer.parseInt(g);
             if((h-1)>max1)
             max1 =h-1;
         }
          for(int i = 0;i<l2;i++)
         {
             char ch=co.charAt(i);
             String g=""+ch;
             int h=Integer.parseInt(g);
             if((h-1)>max2)
             max2 =h-1;
         }
        System.out.print(max1+" ");
        System.out.print(max2+" ");
        System.out.println();
        T--;
    }    
    }
   
    }