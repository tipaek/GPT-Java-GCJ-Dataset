import java.util.*;

public class Solution 
{
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        for(int ii=0; ii<t; ii++)
        {
            int n = in.nextInt();
            Task jt[] = new Task[n];
            Task ct[] = new Task[n];
            char ss[] = new char[n];
            int jj=0;
            int cc=0;
            for(int j=0; j<n; j++)
            {
                int s = in.nextInt();
                int e = in.nextInt();
                if(jj==0)
                {
                    jj++;
                    jt[0] = new Task();
                    jt[0].s = s;
                    jt[0].e = e;
                    ss[j]='J';
                    continue;
                }
                else if(IsPossible(jt, s, e, jj))
                {
                    jt[jj] = new Task();
                    jt[jj].s = s;
                    jt[jj].e = e;
                    ss[j]='J';
                    jj++;
                    continue;
                }
                else if(IsPossible(ct, s, e, cc))
                {
                    ct[cc] = new Task();
                    ct[cc].s = s;
                    ct[cc].e = e;
                    ss[j]='C';
                    cc++;
                    continue;
                }
                jj=0;
                System.out.println("Case #"+(ii+1)+": IMPOSSIBLE");
                break;
            }
            if(jj!=0)
            {
                System.out.println("Case #"+(ii+1)+": " + Cs(ss));
            }
        }
    }
    static class Task
    {
        int s=0;
        int e=0;
    }
    /*
    public static void printArr(Task x[], int s)
    {
        System.out.println("eeeeeeeeeeeeeeeeee "+s);
        for(int i=0; i<s; i++)
        {
            System.out.println("qqqqqqqqqqqqqqqq "+x[i].s);
        }
    }
    */
    public static boolean IsPossible(Task a[], int s, int e, int size)
    {
       //printArr(a, size);
       for(int i=0; i<size; i++)
       {
           if(s<a[i].s && e<=a[0].s)
            {
                //System.out.println("/////////////////////////// "+s+" "+e +"wwww"+a[i].s+" "+a[0].e);
                continue;
            }
            else if(s>=a[i].e)
            {
                //System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvv "+s+" "+e);
                continue;
            }
           //System.out.println("ffffffffffffffffffffffffffffff "+s+" "+e);
            return false;
       }
       //System.out.println("ttttttttttttttttttttttttttttttt "+s+" "+e);
       return true; 
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