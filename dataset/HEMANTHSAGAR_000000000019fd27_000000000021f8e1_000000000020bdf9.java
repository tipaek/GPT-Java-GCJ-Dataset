import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i1=1;i1<=t;i1++)
        {
            int n1=sc.nextInt();
            int[][] arr=new int[n1][2];
            int[][] arrt=new int[n1][2];
            for(int i2=0;i2<n1;i2++)
            {
                arr[i2][0]=sc.nextInt();
                arr[i2][1]=sc.nextInt();
                arrt[i2][0]=arr[i2][0];
                arrt[i2][1]=arr[i2][1];
            }
            int[] arr2=sortarr(arrt);
            String ans="";
            HashSet<Integer> c1=new HashSet<Integer>();
            HashSet<Integer> j1=new HashSet<Integer>();
            for(int i2=0;i2<arr2.length;i2++)
            {
                int i3=arr2[i2];
                int sti=arr[i3][0];
                int endi=arr[i3][1];
                if(c1.contains(sti))
                {
                    if(j1.contains(sti))
                    {
                        ans="IMPOSSIBLE";
                        break;
                    }
                    else
                    {
                        for(int i=sti;i<endi;i++)
                            j1.add(i);
                        ans=ans+"J";
                    }
                }
                else
                {
                    for(int i=sti;i<endi;i++)
                        c1.add(i);
                    ans=ans+"C";
                }
            }
            if(ans.compareTo("IMPOSSIBLE")!=0)
            {
                String ans1="";
                for(int i2=0;i2<n1;i2++)
                {
                    int x=0;
                    for(int i3=0;i3<n1;i3++)
                    {
                        if(arr2[i3]==i2)
                        {
                            x=i3;
                            break;
                        }
                    }
                    ans1=ans1+ans.charAt(x);
                }
                ans=ans1;
            }
            
            System.out.println("Case #"+i1+": "+ans);
        }
    }
    public static int[] sortarr(int[][] arr)
    {
        ArrayList<Integer> arr2=new ArrayList<Integer>();
        int[] arr1=new int[arr.length];
        for(int i=0;i<arr.length;i++)
            arr1[i]=i;
        for(int i=0;i<arr.length;i++)
        {
            int mini=arr[i][0];
            int minj=arr[i][1];
            int minind=i;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[j][0]<mini)
                {
                    mini=arr[j][0];
                    minj=arr[j][1];
                    minind=j;
                }
            }
            int t1=arr1[i];
            arr1[i]=arr1[minind];
            arr1[minind]=t1;
            arr[minind][0]=arr[i][0];
            arr[minind][1]=arr[i][1];
            arr[i][0]=mini;
            arr[i][1]=minj;
            arr2.add(arr1[i]);
        }
        return arr1;
    }
}