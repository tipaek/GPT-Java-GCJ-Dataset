import java.util.*;
public class Solution
{
   
    public static void main(String args[])
    {
    Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int a0=0;a0<t;a0++)
        {
        int r=sc.nextInt();
        int s=sc.nextInt();
        int arr[]=new int[r*s];
        int a=r*(s-1);
        int b=r-1;
        int count=0;
        ArrayList<Integer> l=new ArrayList<Integer>();
        while(b>0)
        {
        for(int i=0;i<(s-1);i++)
        {
    
        l.add(a);
        l.add(b);
        count++;
        a--;
        }
        b--;
        }
        System.out.println("Case #"+(a0+1)+": "+count);
        for(int i=0;i<count*2;i=i+2)
        {
        System.out.println(l.get(i)+" "+l.get(i+1));
        }
        }
   
   
    }


}