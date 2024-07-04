 import java.util.*;
import java.io.*;
class Solution
{
    static void sort(int[][] a,int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(a[i][0]>a[j][0])
                {
                    int[] t=a[i];
                    a[i]=a[j];
                    a[j]=t;
                }
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            int n=sc.nextInt();
            int[][] a=new int[n][2];
            for(int i=0;i<n;i++)
            {
                a[i][0]=sc.nextInt();
                a[i][1]=sc.nextInt();
            }
            HashMap<HashSet<Integer>,Stack<Integer>> h=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> tm=new HashSet<>();
                tm.add(a[i][0]);
                tm.add(a[i][1]);
                if(h.get(tm)==null)
                h.put(tm,new Stack<Integer>());
                h.get(tm).push(i);
            }
            sort(a,n);
            HashMap<Integer,String> mh=new HashMap<>();
            int mje=0;
            int mce=0;
            boolean f=true;
            for(int[] i:a)
            {
                HashSet<Integer> tm=new HashSet<>();
                tm.add(i[0]);
                tm.add(i[1]);
                if(mh.size()==0)
                {
                    mje=i[1];
                    mh.put(h.get(tm).pop(),"J");
                }
                else if(i[0]>=mje)
                {
                    mje=(int)Math.max(mje,i[1]);
                    mh.put(h.get(tm).pop(),"J");
                }
                else if(i[0]>=mce)
                {
                    mce=(int)Math.max(mce,i[1]);
                    mh.put(h.get(tm).pop(),"C");
                }
                else
                {
                    f=false;
                    break;
                }
            }
            if(f)
            {
                String s="";
                for(int i=0;i<n;i++)
                s+=mh.get(i);
                System.out.println("Case #"+k+": "+s);
            }
            else
            System.out.println("Case #"+k+": "+"IMPOSSIBLE");
        }
    }
}