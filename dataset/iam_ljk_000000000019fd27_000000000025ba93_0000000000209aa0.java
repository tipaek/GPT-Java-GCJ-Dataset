import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.StringTokenizer;


public class Solution
{
    static int n,k;
    static Integer a[][];
    static boolean done;
    static Scanner scan = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);


    static void startingMethod()
    {
        a=new Integer[n][n];
        for(int i=0;i<n;i++) Arrays.fill(a[i],0);
        done=false;
    }

    static void PrintInNormalManner()
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++) pw.print(a[i][j]+" ");
            pw.println();
        }
    }

    static void PrintInReverseManner()
    {
        for(int i=0;i<n;i++)
        {
            for(int j=n-1;j>=0;j--) pw.print(a[i][j]+" ");
            pw.println();
        }
    }

    static int SumOfMainDiagonal()
    {
        int ans=0;
        for(int i=0;i<n;i++) ans+=a[i][i];
        return  ans;
    }

    static int SumOfSecondDiagonal()
    {
        int ans=0;
        for(int i=0;i<n;i++) ans+=a[i][n-i-1];
        return ans;
    }

    static boolean CheckForCorrectness(int i,int j,int p)
    {
        for(int l=0;l<n;l++)
        {
            if(a[i][l]==p || a[l][j]== p) return false;
        }
        return true;
    }

    static void ThisIsNotMainButMainHeart()
    {
        if(done==true) return;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i][j]==0)
                {
                    for(int p=1;p<=n;p++)
                    {
                        if(CheckForCorrectness(i,j,p))  {   a[i][j]=p;  ThisIsNotMainButMainHeart();  a[i][j]=0;  }
                    }
                    return;
                }
            }
        }

        if(SumOfMainDiagonal()==k) { done=true; pw.println("POSSIBLE"); PrintInNormalManner(); }
        else if(SumOfSecondDiagonal()==k) { done=true; pw.println("POSSIBLE"); PrintInReverseManner();}
    }




    public static void main(String[] stp) throws Exception
    {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t=Integer.parseInt(st.nextToken()),i;

        int ncase=1;
        while(t-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());k=Integer.parseInt(st.nextToken());
            startingMethod();
            pw.print("Case #"+ncase+": ");
            ncase++;
            if(n==5)
            {
                if(k <= 4|| k == 6 || k == 24 || k >=26);
                else ThisIsNotMainButMainHeart();
            }
            else ThisIsNotMainButMainHeart();
            if(done==false) pw.println("IMPOSSIBLE");
        }
        pw.flush();
    }





}