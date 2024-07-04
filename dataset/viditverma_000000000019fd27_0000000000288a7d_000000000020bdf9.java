import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int cases = 1; cases <= test; ++cases) {
            int n = in.nextInt();
            StringBuilder sb =new StringBuilder();
            int start[]=new int[n];
            int end[] = new int[n];
            int pos[]= new int[n];
            for(int i = 0;i<n;i++)
            {
                start[i] = in.nextInt();
                end[i] = in.nextInt();
                pos[i] = i;
            }

            //Sorting
            for(int i =0;i<n;i++)
            {
                for(int j=0;j<n-1;j++)
                {
                    if(start[j]>start[j+1])
                    {
                        int temp = start[j];
                        start[j] = start[j+1];
                        start[j+1] = temp;

                        temp = end[j];
                        end[j] = end[j+1];
                        end[j+1] = temp;

                        temp = pos[j];
                        pos[j] = pos[j+1];
                        pos[j+1] = temp;
                    }
                }
            }

            boolean impossible = false;
            char ans[] = new char[n];
            int cstart=0,cend=0,jstart=0,jend=0;
            for(int i =0;i<n;i++)
            {
                if(start[i]>=cend)
                {
                    ans[i] = 'C';
                    cend = end[i];
                    cstart = start[i];
                }
                else if(start[i]>=jend)
                {
                    ans[i] = 'J';
                    jend = end[i];
                    jstart = start[i];
                }
                else
                {
                    impossible = true;
                    break;
                }
            }
            if(impossible)
            {
                System.out.println("Case #"+cases+": IMPOSSIBLE");
            }
            else
            {
                for(int i =0;i<n;i++)
                {
                    for(int j=0;j<n-1;j++)
                    {
                        if(pos[j]>pos[j+1])
                        {
                            int temp = pos[j];
                            pos[j] = pos[j+1];
                            pos[j+1] = temp;
                            char tem = ans[j];
                            ans[j] = ans[j+1];
                            ans[j+1] = tem;
                        }
                    }
                }
                System.out.println("Case #"+cases+": "+String.valueOf(ans));
            }
        }
    }
}