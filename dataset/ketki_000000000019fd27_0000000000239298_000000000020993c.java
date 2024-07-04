import java.lang.*;
import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        int t,n,s=0,p1=0,p2=0;
                ArrayList<Integer> arr4 = new ArrayList<>();
                ArrayList<Integer> arr5 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<t;i++)
        {
            s=0;p1=0;p2=0;
            n = sc.nextInt();
            int[][] arr = new int [n][n];
            ArrayList<Integer> arr1 =  new ArrayList<>();
            ArrayList<Integer> arr2 = new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                arr1.clear();
                for(int k=0;k<n;k++)
                {
                    arr[j][k] = sc.nextInt();
                    if(!arr1.contains(arr[j][k]))
                    arr1.add(arr[j][k]);
                    if(j==k)
                    {
                        s += arr[j][k];
                    }
                }
                if(arr1.size()==n)
                {
                    arr2.add(0);
                }
                else
                arr2.add(1);
            }
                for(int j1=0;j1<n;j1++)
                {
                    arr4.clear();
                    for(int k1=0;k1<n;k1++)
                    {
                        if(!arr4.contains(arr[k1][j1]))
                        arr4.add(arr[k1][j1]);
                    }
                     if(arr4.size()==n)
                {
                    arr5.add(0);
                }
                else
                arr5.add(1);
                }
               
               for(int p=0;p<arr2.size();p++)
               {
                   if(arr2.get(p)==1)
                   p1++;
               }
               for(int q=0;q<arr5.size();q++)
               {
                   if(arr5.get(q)==1)
                   p2++;
               }
               
            
            System.out.println("Case #"+(i+1)+": "+s+" "+p1+" "+p2);
            System.out.flush();
            arr1.clear();
            arr2.clear();
            arr4.clear();
            arr5.clear();
        }
    }
}