import java.util.*;
import java.util.stream.Stream;
import java.io.*;
class Solution {
    public static void main(String[] args)
    {
        int test,size=0,sum,sum1,sum2;
        Scanner sc = new Scanner(System.in);
        test = sc.nextInt();
        int arr[][];
        for(int i=0;i<test;i++)
        {
            sum = 0;
            sum1=0;
            sum2=0;
            size = sc.nextInt();
            arr = new int[size][size];
           for(int j=0;j<size;j++)
            {
                for(int k=0;k<size;k++)
                {
                    arr[j][k] = sc.nextInt();
                    if(j==k)
                    sum+=arr[j][k];
                }
            }
            Set<Integer> set = new HashSet<>(); 
            for(int j=0;j<size;j++)
            {   
                for(int k=0;k<size;k++)
                {
                    set.add(arr[j][k]);    
                }
                if(arr.length != set.size())
                sum1++;
                set.clear();
            }
            for(int j=0;j<size;j++)
            {
                for(int k=0;k<size;k++)
                {
                    if(k<j)
                    {
                        int temp = arr[j][k];
                        arr[j][k] = arr[k][j];
                        arr[k][j] = temp;
                    }
                }
            }
            for(int j=0;j<size;j++)
            {   
                for(int k=0;k<size;k++)
                {
                    set.add(arr[j][k]);    
                }
                if(arr.length != set.size())
                sum2++;
                set.clear();
            }
            int Case = i+1;
            System.out.println("Case #" + Case + ": " + sum + " " + sum1 + " " + sum2);
        }
    }
}