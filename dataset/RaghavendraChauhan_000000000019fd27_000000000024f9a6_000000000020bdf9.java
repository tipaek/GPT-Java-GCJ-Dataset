import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
        int p=t;
        String a[]=new String[t];
        while(p-->0)
        {
            int n=sc.nextInt();
            char ch[]=new char[n];
            ArrayList<AB> arr=new ArrayList<>();
            HashMap<AB,Integer> h=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int x=sc.nextInt();
                int y=sc.nextInt();
                AB ab=new AB(x,y);
                arr.add(ab);
                h.put(ab,i);
            }
            Collections.sort(arr,(n1,n2)->(n1.a>n2.a)?1:((n1.a==n2.a)?((n1.b>n2.b)?1:-1):-1));
            
        int flag=0;
        AB c=new AB(0,0);
        AB j=new AB(0,0);
        String s="";
        for(int i=0;i<arr.size();i++)
        {
            AB cur=arr.get(i);
            int m=h.get(cur);
            if(cur.a>=c.b)
            {ch[m]='C';c=new AB(cur.a,cur.b);}
            else if(cur.a>=j.b)
            {ch[m]='J';j=new AB(cur.a,cur.b);}
            else
            {flag=1;break;}
        }
        if(flag==1)
        a[t-p-1]="IMPOSSIBLE";
        else{
            for(int v=0;v<n;v++)
            s=s+ch[v];
        a[t-p-1]=s;}
        
    }
   for(int i=1;i<=t;i++)
      System.out.println("Case #"+i+": "+a[i-1]);
}}
class AB
{
    int a,b;
    AB(int x1,int x2)
    {
        a=x1;
        b=x2;
    }
}