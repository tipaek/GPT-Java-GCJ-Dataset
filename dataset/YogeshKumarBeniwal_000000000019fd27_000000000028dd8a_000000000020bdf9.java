import java.util.*;

public class Solution 
{
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        for(int ii=0; ii<t; ii++)
        {
            int n = in.nextInt();
            int s[] = new int[n];
            int e[] = new int[n];
            int ind[] = new int[n];
            char ch[] = new char[n];
            for(int i=0; i<n; i++)
            {
                s[i] = in.nextInt();
                e[i] = in.nextInt();
                ind[i] = i;
            }
            MeargSort(s, e, ind);
            int jn=0;
            int cn=0;
            int j[] = new int[2];
            int c[] = new int[2];
            for(int i=0; i<n; i++)
            {
                int st = s[i];
                int en = e[i];
                if(jn == 0)
                {
                    j[1] = en;
                    j[0] = st;
                    ch[ind[i]]='J';
                    jn++;
                    continue;
                }
                if(st>=j[1])
                {
                    j[1] = en;
                    j[0] = st;
                    ch[ind[i]]='J';
                    continue;
                }
                if(cn==0)
                {
                    c[1] = en;
                    c[0] = st;
                    ch[ind[i]]='C';
                    cn++;
                    continue;
                }
                if(st>=c[1])
                {
                    c[1] = en;
                    c[0] = st;
                    ch[ind[i]]='C';
                    continue;
                }
                jn=0;
                System.out.println("Case #"+(ii+1)+": IMPOSSIBLE");
                break;
            }
            if(jn!=0)
            {
                System.out.println("Case #"+(ii+1)+": " + Cs(ch));
            }
        }
    }
    public static void MeargSort(int s[], int e[], int ind[])
    {
        for (int i = 1; i < s.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(s[j] < s[j-1]){
                    int temp = s[j];
                    s[j] = s[j-1];
                    s[j-1] = temp;
                    temp = e[j];
                    e[j] = e[j-1];
                    e[j-1] = temp;
                    temp = ind[j];
                    ind[j] = ind[j-1];
                    ind[j-1] = temp;
                }
            }
        }
    }
    public static String Cs(char a[])
    {
        String s="";
        for(int i=0; i<a.length; i++)
        {
            s+=a[i];
        }
        return s;
    }
}