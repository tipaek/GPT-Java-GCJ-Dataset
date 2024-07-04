import java.util.*;
class Solution
{
    public static Scanner sc = new Scanner(System.in);
    public static void merge(int m[],String n[],int start, int mid, int end)
    {
        int p=start;int q=mid+1;
        int arr[] = new int[end-start+1];
        String s[] = new String[end-start+1];
        int k=0;
        for(int i=start;i<=end;i++)
        {
            if(p>mid)
            {
                arr[k] = m[q];
                s[k++] = n[q++];
            }
            else if (q>end)
            {
                arr[k] = m[p];
                s[k++] = n[p++];
            }
            else if(m[p]<m[q])
            {
                arr[k] = m[p];
                s[k++] = n[p++];
            }
            else
            {
                arr[k] = m[q];
                s[k++] = n[q++];
            }
        }
        for(int t=0;t<k;t++)
        {
            m[start] = arr[t];
            n[start++] = s[t];
        }
    }
    public static void merge_sort(int m[],String n[], int start, int end)
    {
        if(start<end)
        {
            int mid = (start + end) /2;
            merge_sort(m,n,start,mid);
            merge_sort(m,n,mid+1,end);
            merge(m,n,start,mid,end);
        }
    }
    public static String check (String a[],int l[], int n)
    {
        String arr[] = new String[n];
        int ll[] = new int[n];
        int c=0;
        String p="";
        int flag=1;
        int end[] = new int[n];
        int max1 = 0;
        String v="";
        String b="";
        int max2 = 0;
        int beg[] = new int[n];
        for(int i=n-1;i>=0;i--)
        {
            arr[c]=a[i];
            ll[c] = l[i];
            beg[c] = ll[c]-1;
            if(beg[c]>max1)
            {    v=arr[c].substring(0,beg[c]+1);
                 max1 = beg[c];
                }
            end[c] = arr[c].length() - ll[c];
            if(end[c]>max2)
            {    b=arr[c].substring(beg[c]+2,arr[c].length());
                 max2 = end[c];
                }
            c++;
        }
        p=v+b;
        for(int i=0;i<n;i++)
        {
            String q = a[i].substring(0,l[i]);
            String w = a[i].substring(l[i]+1,a[i].length());
            if(p.contains(q)==false || p.contains(w)==false)
            flag++;
        }
        if(flag==1)
        return p;
        else
        return "*";
    }
    public static void main(String args[])
    {
        int t = sc.nextInt();
        int d=1;
        while(t-->0)
        {
            int n = sc.nextInt();
            String a[] = new String[n];
            int l[] = new int[n];
            for(int i=0;i<n;i++)
            {    
                a[i]= sc.next();
                l[i] = a[i].indexOf("*");
            }
            merge_sort(l,a,0,n-1);
            System.out.println("Case #"+d+": "+check(a,l,n));
            d++;
        }
    }
}