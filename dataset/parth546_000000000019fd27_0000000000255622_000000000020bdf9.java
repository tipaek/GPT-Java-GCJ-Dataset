import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static boolean[] j,c;
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
        j=new boolean[24*60+1];
        c=new boolean[24*60+1];
        int[] s=new int[n],e=new int[n];
        for(int i=0;i<n;i++)
        {
            s[i]=sc.nextInt();
            e[i]=sc.nextInt();
        }
        String ans="";
        for(int i=0;i<n;i++)
        {
            if(isFree(c,s[i],e[i])) {
                ans+="C";
                continue;
            }
            if(isFree(j,s[i],e[i])) {
                ans+="J";
                continue;
            }
                ans="IMPOSSIBLE";
                break;

        }
        System.out.println("Case #"+(testCaseNumber+1)+": "+ans);
    }
    static boolean isFree(boolean[] name, int start,int end)
    {
        for(int i=start+1;i<=end-1;i++)
        {
            if(name[i])
                return false;
        }
        makeBusy(name, start, end);
        return true;
    }
    static void makeBusy(boolean[] name,int start,int end)
    {
        for(int i=start;i<=end;i++)
            name[i]=true;
    }

}
