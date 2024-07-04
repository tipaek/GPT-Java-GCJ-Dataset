import java.util.*;
public class Solution {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int tt=1;tt<=t;tt++)
        {
            int n = s.nextInt();
            Integer[] start = new Integer[n];
            Integer[] end = new Integer[n];
            Integer[] index = new Integer[n];
            char[] ans = new char[n];
            for(int i = 0;i<n;i++)
            {
                start[i] = s.nextInt();
                end[i] = s.nextInt();
                index[i] = i;
            }
            Arrays.sort(index,new Comparator<Integer>(){
                public int compare(Integer a,Integer b)
                {
                    return end[a]-end[b];
                }
            });
            Arrays.sort(end);
            Integer[] tempStart = new Integer[n];
            for(int i=0;i<n;i++)
            tempStart[i] = start[index[i]];
            start = tempStart;
            int pankajEnd = 0;
            int pankajWifeEnd = 0;
            boolean flag = false;
            for(int i=0;i<n;i++)
            {
                if(start[i]>=pankajEnd && start[i]>=pankajWifeEnd )
                {
                    if(pankajEnd<pankajWifeEnd)
                    {
                        ans[index[i]] = 'J';
                        pankajWifeEnd = end[i];
                    }
                    else
                    {
                        ans[index[i]] = 'C';
                        pankajEnd = end[i];
                    }
                }
                else if(start[i]>=pankajEnd || start[i]>=pankajWifeEnd)
                {
                    if(start[i]>=pankajEnd)
                    {
                        ans[index[i]] = 'C';
                        pankajEnd = end[i];
                    }
                    else
                    {
                        ans[index[i]] = 'J';
                        pankajWifeEnd = end[i];
                    }
                }
                else
                {
                    flag = true;
                    break;
                }
            }
            System.out.print("Case #" + tt + ": ");
            if(flag == true)
            {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            String str = "";
            for(int i=0;i<n;i++)
            str = str + ans[i];
            System.out.println(str);
        }
    }
}