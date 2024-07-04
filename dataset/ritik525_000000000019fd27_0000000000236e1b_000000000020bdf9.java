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
            int s[]=new int[n];
            int e[]=new int[n];
        for(int i=0;i<n;i++)
        {
           s[i]=sc.nextInt();
           e[i]=sc.nextInt();
        }
        String g="C";
       int temp2=e[0];
        int temp1=s[1];
        
        for(int i=1;i<n;i++)
        {
            if(temp2<=temp1){
            g=g+"C";
            temp2=e[i];
            }
            else{
                if(i!=n-1){
            g=g+"J";
            temp1=s[i+1];
                }
            }
        }
        if(g.length()!=n)
        System.out.println("case #"+k+": "+"IMPOSSIBLE");
        else
        System.out.println("case #"+k+": "+g);
        }
    }
}