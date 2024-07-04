import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.next());
        
        for(int i=0;i<t;i++)
        {   String ans="J";
            boolean cond=true;
            int n=Integer.parseInt(sc.next());
            int[][] arr=new int[n][2];
            arr[0][0]=Integer.parseInt(sc.next());
            arr[0][1]=Integer.parseInt(sc.next());
            int count;
            boolean one=true;
            for(int j=1;j<n;j++)
            {   count=0;
                one=true;
                arr[j][0]=Integer.parseInt(sc.next());
                arr[j][1]=Integer.parseInt(sc.next());
                if(cond)
                {
                    for(int k=0;k<j;k++)
                    {
                        if((arr[j][0]<arr[k][1]&& arr[j][0]>=arr[k][0])||(arr[k][0]<arr[j][1]&& arr[k][0]>=arr[j][0]))
                        {
                            count++;
                            if(one){
                            if(ans.charAt(k)=="C".charAt(0))ans+="J";
                            else ans+="C";
                                one=false;
                            }
                            if(count>=2)cond=false;
                        }
                        
                    }if(one)ans+="C";
                }
                
            }
            if(cond)System.out.println("Case #"+(i+1)+": "+ans);
            else System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
        }
    }
}