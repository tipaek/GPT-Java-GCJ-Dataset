import java.util.*;
class Solution{
    public static void main(String[]args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int p=1;
        while(p<=t)
        {  
            int n=s.nextInt();
            int [][]a=new int[n][n];
            ArrayList<Integer>arr=new ArrayList<>();
             int r=0,c=0,trace=0,not=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=s.nextInt();
                    if(arr.contains(a[i][j])&&not==0)
                   {            r++;
                                not=1;
                   }
                  else
                   arr.add(a[i][j]);
                }
                arr=new ArrayList<>();
                not=0;
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                   
                    if(arr.contains(a[j][i])&&not==0)
                   {            c++;
                                not=1;
                   }
                 else
                   arr.add(a[j][i]);
                       if(i==j)
                       trace+=a[i][j];
                }
                arr=new ArrayList<>();
                not=0;
            }
            System.out.println("case #"+p+" :"+" "+trace+" "+r+" "+c);
            p++;
        }
    }
}