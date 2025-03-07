import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args)
    {
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            eachCase(i);
        }
    }
    static void eachCase(int testCaseNumber)
    {
        int n=sc.nextInt();
        j=new boolean[24*60+10];
        c=new boolean[24*60+10];
        int[] s=new int[n],e=new int[n];
        for(int i=0;i<n;i++)
        {
            s[i]=sc.nextInt();
            e[i]=sc.nextInt();
        }
        String ans="";
        for(int i=0;i<n;i++)
        {
            if(free(j,s[i],e[i])) {
                ans+="J";
                continue;
            }
            else if(free(c,s[i],e[i]))
            {
                ans+="C";
                continue;
            }
                ans="IMPOSSIBLE";
                break;

        }
        System.out.println("Case #"+(testCaseNumber+1)+": "+ans);
    }
    static boolean[] j,c;
    static boolean free(boolean[] name, int start,int end)
    {
        for(int i=start;i<=end;i++)
        {
            if(name[i])
                return false;
        }
        busy(name, start, end);
        return true;
    }
    static void busy(boolean[] name,int start,int end)
    {
        for(int i=start;i<end;i++)
            name[i]=true;
    }

}
