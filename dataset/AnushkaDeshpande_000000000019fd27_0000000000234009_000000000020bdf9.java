import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String args[])throws IOException
    {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(in.readLine());
        for(int q=0;q<testCases;q++)
        {
            int n = Integer.parseInt(in.readLine());
            int[] s = new int[n];
            int[] e = new int[n];
            char[] assigned = new char[n];
            for(int i=0;i<n;i++)
            {
                String w = in.readLine();
                String[] put = w.split("\\s+");
                s[i] = Integer.parseInt(put[0]);
                e[i] = Integer.parseInt(put[1]);
                assigned[i] = '\0';
            }
            int flag = 0;
            for(int i=0;i<n;i++)
            {
                assigned[i] = 'C';
                for(int j=0;j<i;j++)
                {
                    if(assigned[j] == 'C')
                    {
                        if(s[j] < s[i])//old startign before new
                        {
                            if(e[j] > s[i])
                            {
                                assigned[i] = 'J';
                                break;
                            }
                        }
                        else if(s[i] < s[j])//new is startign before old
                        {
                            if(e[i] > s[j])
                            {
                                assigned[i] = 'J';
                                break;
                            }
                        }
                    }
                }

                if(assigned[i] == 'J')
                {
                    for(int j=0;j<i;j++)
                    {
                        if(assigned[j] == 'J')
                        {
                            if(s[j] < s[i])//old startign before new
                            {
                                if(e[j] > s[i])
                                {
                                    flag = 1;
                                    break;
                                }
                            }
                            else if(s[i] < s[j])//new is startign before old
                            {
                                if(e[i] > s[j])
                                {
                                    flag = 1;
                                    break;
                                }
                            }
                        }
                    }
                }

                if(flag == 1)
                    break;
            }


            if(flag == 1)
                System.out.println("Case #"+(q+1)+": IMPOSSIBLE");
            else
            {
                System.out.print("Case #"+(q+1)+": ");
                for(int i=0;i<n;i++)
                    System.out.print(assigned[i]);
                System.out.println();
            }
        }
    }
}