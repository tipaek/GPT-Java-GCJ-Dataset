import javax.swing.*;
import java.io.*;
import java.util.*;
import java.math.*;

import static java.util.Comparator.*;

class Solution {
    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int t=s.nextInt();

        for(int tc=1;tc<=t;tc++)
        {

            int n=s.nextInt();
            List<Task> list=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                int a=s.nextInt();
                int b=s.nextInt();
                list.add(new Task(a,b,i));
            }
            Collections.sort(list, new Comparator<Task>() {
                @Override
                public int compare(Task o1, Task o2) {
                    return o1.start-o2.start;
                }
            });
            int c=0,j=0;
            char[] arr=new char[n];
            int flag=0;
            for(Task task:list)
            {
                if(task.start>=c)
                {
                    c=task.end;
                    arr[task.index]='C';
                    continue;
                }
                if(task.start>=j)
                {
                    j=task.end;
                    arr[task.index]='J';
                    continue;
                }
                flag=1;
                break;
            }
            if(flag==1)
            {
                System.out.println("Case #"+tc+": IMPOSSIBLE");
            }
            else
            {
                StringBuilder ans=new StringBuilder();
                for(char ch:arr)
                {
                    ans.append(ch);
                }
                System.out.println("Case #"+tc+": "+ans.toString());
            }
//            System.out.println("Case #"+tc+": "+ans.toString());
        }

    }

}

class Task
{
    int start,end,index;

    public Task(int start, int end,int index) {
        this.start = start;
        this.end = end;
        this.index=index;
    }
}
class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException  e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt()
    {
        return Integer.parseInt(next());
    }

    long nextLong()
    {
        return Long.parseLong(next());
    }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}