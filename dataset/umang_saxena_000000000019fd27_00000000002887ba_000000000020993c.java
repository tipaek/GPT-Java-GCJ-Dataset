import java.io.*;
import java.util.*;
class Vestiguin
{
    public static void main(String gg[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int l = 1;
        while(l <= t)
        {
            int sum = 0;
            int rowCount = 0;
            int columnCount = 0;
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            for(int e = 0; e < n; e++)
            {
                for(int f = 0; f < n; f++)
                {
                    int num = sc.nextInt();
                    arr[e][f] = num;                   
                }
                sum += arr[e][e];
            }
            for(int e = 0; e < n; e++)
            {
                Set<Integer> set1 = new HashSet<>();
                for(int f = 0; f < n; f++)
                {
                    if(set1.contains(arr[e][f]))
                    {
                        rowCount++;
                        break;
                    }
                    set1.add(arr[e][f]);
                }
            }
            for(int e = 0; e < n; e++)
            {
                Set<Integer> set1 = new HashSet<>();
                Set<Integer> set2 = new HashSet<>();
                for(int f = 0; f < n; f++)
                {
                    int num = arr[f][e];
                    if(set2.contains(num))
                    {
                        columnCount++;
                        break;
                    }
                    set2.add(num);
                }
            }
            System.out.println("Case #" + l + ": " + sum + " " + rowCount + " " + columnCount);
            l++;
        }
    }
}