import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String args[])throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int z=1;z<=t;z++)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            String s=sc.next();
            int len=s.length();
            System.out.print("Case #"+z+": ");
            int arr[][]=new int[3601][3601];
            int stx=1500,sty=1500;
            if(x==0 && y==0)
            {
                System.out.println(0);
            }
            else
            {
                int min=5000;
                int i=stx+x,j=sty+y,ptr=0;
                while(ptr<len)
                {
                    int my_dist=Math.abs(i-stx)+Math.abs(j-sty);
                    if(my_dist<=ptr)
                    {
                        min=Math.min(min,ptr);
                    }
                    char ch=s.charAt(ptr);
                    if(ch=='N')
                    j++;
                    else if(ch=='S')
                    j--;
                    else if(ch=='E')
                    i++;
                    else
                    i--;
                    
                    ptr++;
                }
                int my_dist=Math.abs(i-stx)+Math.abs(j-sty);
                if(my_dist<=ptr)
                {
                    min=Math.min(min,ptr);
                }
                
                if(min==5000)
                {
                    System.out.println("IMPOSSIBLE");
                }
                else
                System.out.println(min);
            }
        }
    }
}