import java.util.*;
import java.lang.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.next());
        for(int i=0;i<t;i++)
        {    String s="";
            int n=Integer.parseInt(sc.next());
            int[][] arr =new int[n][2];
            //char[] carr=new char[n];
            int count[]=new int[n];
            boolean cond=true;
            s+="C";
            arr[0][0]=Integer.parseInt(sc.next());
            arr[0][1]=Integer.parseInt(sc.next());
            boolean one=true;
            for(int j=1;j<n;j++)
            {one =true;
              int num=0;
                arr[j][0]=Integer.parseInt(sc.next());
                arr[j][1]=Integer.parseInt(sc.next());
                if(cond)
                for(int k=0;k<j;k++)
                {
                    if((arr[k][0]<arr[j][0]&& arr[k][1]>arr[j][0]))
                    {
                        count[k]++;
                        num++;
                       if(one) {if(s.charAt(k)=="C".charAt(0))s+="J";
                        else s+="C";
                        one=false;}
                    }
                    else if(arr[j][0]<arr[k][0]&&arr[j][1]>arr[k][0])
                    {
                     count[j]++;
                     num++;
                     if(one) {if(s.charAt(k)=="C".charAt(0))s+="J";
                        else s+="C";
                        one=false;}

                    }
                    
                }if(one)s+="C";
                if(num>=2){cond=false;}

            }
           
            if(cond)System.out.println("Case #"+(i+1)+": "+s);
            else System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            
        }
    }
}