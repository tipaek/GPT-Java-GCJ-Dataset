import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Solution
{
    public static void main(String args[])throws IOException {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);

        int testCases = Integer.parseInt(in.readLine());

        for (int q = 0; q < testCases; q++) {
            int n = Integer.parseInt(in.readLine());
            int[] s = new int[n];
            int[] e = new int[n];
            int start[] = new int[n];
            int end[] = new int[n];
            char[] assigned = new char[n];
            for (int i = 0; i < n; i++) {
                String w = in.readLine();
                String[] put = w.split("\\s+");
                s[i] = Integer.parseInt(put[0]);
                e[i] = Integer.parseInt(put[1]);
                start[i] = Integer.parseInt(put[0]);
                end[i] = Integer.parseInt(put[1]);
                assigned[i] = '\0';
            }

            int sorted[][] = sort(s, e);
            s = sorted[0];
            e = sorted[1];
            int a[] = new int[n];
            String ans = "";
            int cstarting =-1,jstarting=-1,cending =-1,jending = -1,cbusy=0,jbusy=0, fl=0;

            for (int i=0; i<n; i++)
            {
                if(s[i] >= cending)
                {
                    cending = e[i];
                    for(int j=0;j<n;j++)
                    {
                        if((start[j] == s[i]) && (end[j] == e[i]))
                        {
                            a[j] = 0;
                            break;
                        }
                    }
                }
                else if(s[i] >= jending)
                {
                    jending = e[i];
                    for(int j=0;j<n;j++)
                    {
                        if((start[j] == s[i]) && (end[j] == e[i]))
                        {
                            a[j] = 1;
                            break;
                        }
                    }
                }
                else
                {
                    fl = 1;
                    break;
                }
            }
            for(int i=0;i<n;i++)
                if(a[i]==0)
                    ans += "C";
                else
                    ans += "J";
            if(fl==0)
                System.out.println("Case #" + (q+1) + ": " + ans);
            else
                System.out.println("Case #" + (q+1) + ": IMPOSSIBLE");
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
                    t[j] = t[j-gap];

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
}
