import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int t=sc.nextInt();
       for(int i=0;i<t;i++)
       {int n=sc.nextInt();
           int a[][]=new int[n][3];
           for(int j=0;j<n;j++)
           {
           a[j][0]=sc.nextInt();
           a[j][1]=sc.nextInt();
           a[j][2]=j;
           }int flag=0;
           a= sortarr(a,n);
           int c1=0,c2=0,j1=0,j2=0;
           char re[]=new char[n];
           for(int j=0;j<n;j++)
           {
               if(a[j][0]>=c2)
           {
               c1=a[j][0];
               c2=a[j][1];
               re[a[j][2]]='C';
           }
           else if(a[j][0]>=j2)
           {
               j1=a[j][0];
               j2=a[j][1];
               re[a[j][2]]='J';
           }
           else
           {System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
           flag=1;
           break;}
           }if(flag==0)
            System.out.println("Case #"+(i+1)+": "+(new String(re)));
           }
       
       }
       
    
    static int[][] sortarr(int[][]a,int n)
    {
         for (int i=0;i <n; i++) 
        {
            for (int j = i + 1; j < n; j++) { 
                if (a[i][0] > a[j][0]) 
                {
                    int temp = a[i][0];
                    int temp1= a[i][1];
                    int temp2=a[i][2];
                    a[i][0] = a[j][0];
                    a[i][1] = a[j][1];
                    a[i][2] = a[j][2];
                    a[j][0] = temp;
                    a[j][1] = temp1;
                    a[j][2] = temp2;
                }
            }
        }
         return a;
    }
    
}
