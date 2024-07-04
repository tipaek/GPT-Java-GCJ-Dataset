import java.util.*;
import java.util.stream.Stream;
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
                }
            }
            for(int j=0;j<size;j++)
            {
                Long distinctCount = Stream.of(arr[j]).distinct().count();
	            if(arr[j].length != distinctCount)
	            sum1++;
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
                Long distinctCount = Stream.of(arr[j]).distinct().count();
	            if(arr[j].length != distinctCount)
	            sum2++;
            }
            int Case = i+1;
            System.out.println("Case #" + Case + ": " + sum + " " + sum1 + " " + sum2);
        }
    }
}