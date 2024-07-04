import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner scj=new Scanner(System.in);
        int tj=scj.nextInt();
        for(int i1j=1;i1j<=tj;i1j++)
        {
            int n1j=scj.nextInt();
            int[][] arrj=new int[n1j][2];
            int[][] arrtj=new int[n1j][2];
            for(int i2j=0;i2j<n1j;i2j++)
            {
                arrj[i2j][0]=scj.nextInt();
                arrj[i2j][1]=scj.nextInt();
                arrtj[i2j][0]=arrj[i2j][0];
                arrtj[i2j][1]=arrj[i2j][1];
            }
            int[] arr2j=sortarr(arrtj);
            String ansj="";
            HashSet<Integer> c1j=new HashSet<Integer>();
            HashSet<Integer> j1j=new HashSet<Integer>();
            for(int i2j=0;i2j<arr2j.length;i2j++)
            {
                int i3j=arr2j[i2j];
                int stij=arrj[i3j][0];
                int endij=arrj[i3j][1];
                if(c1j.contains(stij))
                {
                    if(j1j.contains(stij))
                    {
                        ansj="IMPOSSIBLE";
                        break;
                    }
                    else
                    {
                        for(int ij=stij;ij<endij;ij++)
                            j1j.add(ij);
                        ansj=ansj+"J";
                    }
                }
                else
                {
                    for(int ij=stij;ij<endij;ij++)
                        c1j.add(ij);
                    ansj=ansj+"C";
                }
            }
            if(ansj.compareTo("IMPOSSIBLE")!=0)
            {
                String ans1j="";
                for(int i2j=0;i2j<n1j;i2j++)
                {
                    int xj=0;
                    for(int i3j=0;i3j<n1j;i3j++)
                    {
                        if(arr2j[i3j]==i2j)
                        {
                            xj=i3j;
                            break;
                        }
                    }
                    ans1j=ans1j+ansj.charAt(xj);
                }
                ansj=ans1j;
            }
            
            System.out.println("Case #"+i1j+": "+ansj);
        }
    }
    public static int[] sortarr(int[][] arrj)
    {
        ArrayList<Integer> arr2j=new ArrayList<Integer>();
        int[] arr1j=new int[arrj.length];
        for(int ij=0;ij<arrj.length;ij++)
            arr1j[ij]=ij;
        for(int ij=0;ij<arrj.length;ij++)
        {
            int minij=arrj[ij][0];
            int minjj=arrj[ij][1];
            int minindj=ij;
            for(int jj=ij+1;jj<arrj.length;jj++)
            {
                if(arrj[jj][0]<minij)
                {
                    minij=arrj[jj][0];
                    minjj=arrj[jj][1];
                    minindj=jj;
                }
            }
            int t1j=arr1j[ij];
            arr1j[ij]=arr1j[minindj];
            arr1j[minindj]=t1j;
            arrj[minindj][0]=arrj[ij][0];
            arrj[minindj][1]=arrj[ij][1];
            arrj[ij][0]=minij;
            arrj[ij][1]=minjj;
            arr2j.add(arr1j[ij]);
        }
        return arr1j;
    }
}