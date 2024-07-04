import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Solution
{
    public static void main(String args[])throws IOException
    {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(in.readLine());
        String output[] = new String[testCases];
        for(int q=0;q<testCases;q++)
        {
            int n = Integer.parseInt(in.readLine());
            int[] start = new int[n];
            int[] end = new int[n];
            char[] assigned = new char[n];
            char finass[] = new char[n];
            for(int i=0;i<n;i++)
            {
                String w = in.readLine();
                String[] put = w.split("\\s+");
                start[i] = Integer.parseInt(put[0]);
                end[i] = Integer.parseInt(put[1]);
                assigned[i] = '\0';
            }
            int flag = 0;
            int sorted[][] = sort(start, end);
            int s[] = sorted[0];
            int e[] = sorted[1];
            for(int i=0;i<n;i++)
            {
                assigned[i] = 'C';
                for(int j=0;j<i;j++)
                {
                    if(assigned[j] == 'C')
                    {
                        if((s[j] < s[i]) && (e[j] > s[i]))
                        {
                            assigned[i] = 'J';
                            break;
                        }
                        else if((s[i] < s[j]) && (e[i] > s[j]))
                        {
                            assigned[i] = 'J';
                            break;
                        }
                    }
                }

                if(assigned[i] == 'J')
                {
                    for(int j=0;j<i;j++)
                    {
                        if(assigned[j] == 'J')
                        {
                            if((s[j] < s[i]) && (e[j] > s[i]))
                            {
                                flag = 1;
                                break;
                            }
                            else if((s[i] < s[j]) && (e[i] > s[j]))
                            {
                                flag = 1;
                                break;
                            }
                        }
                    }
                }

                if(flag == 1)
                    break;
            }


            if(flag == 1)
                output[q] = "IMPOSSIBLE";
            else
            {
                String ans = "";
                for(int i=0;i<n;i++)
                {
                    finass[i] = assigned[findIndex(s,start[i])];
                    ans = ans + finass[i];
                }
                output[q] = ans;
            }
        }

        for(int i=0;i<testCases;i++)
        {
            System.out.println("Case #"+(i+1)+": "+output[i]);
        }
    }

    public static int[][] sort(int arr[], int t[])
    {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {
                int temp = arr[i];
                int t2 = t[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                {
                    arr[j] = arr[j - gap];
                    t[j] = arr[j-gap];

                }
                arr[j] = temp;
                t[j] = t2;
            }
        }
        int ret[][] = new int[2][arr.length];
        ret[0] = arr;
        ret[1] = t;
        return ret;
    }

    public static int findIndex(int arr[], int t)
    {
        int len = arr.length;
        return IntStream.range(0, len)
                .filter(i -> t == arr[i])
                .findFirst() // first occurrence
                .orElse(-1); // No element found
    }
}