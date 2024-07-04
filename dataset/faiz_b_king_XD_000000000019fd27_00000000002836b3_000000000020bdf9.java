import java.util.*;
class Solution
{
    static int pivot(int a[][],int low, int high)
    {
        int j;
        int temp[]=new int[2];
        int temp1[]=new int[2];
        int p=a[high][0];
        int i=low-1;
        for(j=low;j<high;j++)
        {
           if(a[j][0]<p)
           {
               i++;
               temp[0]=a[i][0];
               temp[1]=a[i][1];
               a[i][0]=a[j][0];
               a[i][1]=a[j][1];
               a[j][0]=temp[0];
               a[j][1]=temp[1];
            }
        }
        temp1[0]=a[i+1][0];
        temp1[1]=a[i+1][1];
        a[i+1][0]=a[high][0];
        a[i+1][1]=a[high][1];
        a[high][0]=temp1[0];
        a[high][1]=temp1[1];
        return i+1;
    }
    static void sort(int a[][],int low,int high)
    {
        if(low<high)
        {
            int pi=pivot(a,low,high);
            sort(a,low,pi-1);
            sort(a,pi+1,high);
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int w=1;
        int t=sc.nextInt();
        while(t>0)
        {
            t--;
            int n=sc.nextInt();
            int arr[][]=new int[n][2];
            for(int i=0;i<n;i++)
            {
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
            }
            sort(arr,0,n-1);
            String temp="C";
            int k=1;
            int f=0;
            int i=1;
            int curr=0;
            int count=0;
            while(k<n)
            {
                if(arr[i][0]<arr[curr][1])
                {
                    temp=temp+"J";
                    count++;
                    if(count>=2)
                    {
                        if(arr[i][0]<arr[i-1][1])
                        {
                            temp="IMPOSSIBLE";
                            break;
                        }
                    }
                }
                else
                {
                    temp=temp+"C";
                    curr=i;
                    count=0;
                    if((arr[i-1][1]<=arr[i][1])&&(arr[i-1][1]>=arr[i][0]))
                    {
                        count++;
                    }
                }
                i++;
                k++;
            }
            System.out.println("Case #"+w+": "+temp);
            w++;
        }
    }
}