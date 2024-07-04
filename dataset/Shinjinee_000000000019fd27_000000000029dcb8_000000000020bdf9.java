import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int i=1; i<=t; i++)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][2];
            
            for (int j=0; j<n; j++)
            {
                for (int k=0; k<2; k++)
                {
                    arr[j][k]=sc.nextInt();
                }
            }
            
            String s="CJ";
            int cp=1, jp=1;
            int ct[][]=new int[n][2];
            int jt[][]=new int[n][2];
            
            ct[0][0]=arr[0][0];
            ct[0][1]=arr[0][1];
            jt[0][0]=arr[1][0];
            jt[0][1]=arr[1][1];
            
            for (int j=2; j<n; j++)
            {
                if (checkFrame(ct, cp, arr[j][0], arr[j][1]))
                {
                    s=s+"C";
                    ct[cp][0]=arr[j][0];
                    ct[cp][1]=arr[j][1];
                    cp++;
                }
                else if (checkFrame(jt, jp, arr[j][0], arr[j][1]))
                {
                    s=s+"J";
                    jt[jp][0]=arr[j][0];
                    jt[jp][1]=arr[j][1];
                    jp++;
                }
                else
                {
                    System.out.println("Case #"+i+": IMPOSSIBLE");
                    break;
                }
            }
            if (s.length()==n)
            {
                System.out.println("Case #"+i+": "+s);
            }
        }
    }
    static boolean checkFrame(int t[][], int len, int s, int e)
    {
        int c=0;
        for (int i=0; i<len; i++)
        {
            if(e<=t[i][0] || s>=t[i][1])
            {
                c++;
            }
        }
        if (c==len)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}