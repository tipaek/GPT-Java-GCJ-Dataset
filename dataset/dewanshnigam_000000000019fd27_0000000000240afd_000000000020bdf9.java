import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String args[])throws IOException
    {
        Scanner ob=new Scanner(System.in);
        int t=ob.nextInt();
        StringBuilder sb=new StringBuilder();
        int cases=1;
        while(t-->0)
        {
            int n=ob.nextInt();
            Activity a[]=new Activity[n];
            Activity uns[]=new Activity[n];            
            for(int i=0;i<n;i++)
            {
                a[i]=new Activity(ob.nextInt(),ob.nextInt(),i);
                uns[i]=new Activity(a[i].st,a[i].end,i);
            }
            
            Arrays.sort(a,new Sort());
            int ans[]=new int[n]; // ans[i] = 1 Cameron , 2 Jamie
            ans[0] = 1; // Cameron takes up the first activity always.
            boolean free[]=new boolean[3];
            free[1] = false; // Cameron is not Free as it is assigned Acitivity 1.
            free[2] = true; // Jamie is Free.
            
            int finishTime[]=new int[3];
            finishTime[1] = a[0].end; // Cameron 1 activity
            boolean isImpossible = false;
            for(int i=1;i<n;i++)
            {
                if(a[i].st >= finishTime[1])
                {
                    finishTime[1] = 0;
                    free[1] = true;
                }
                if(a[i].st >= finishTime[2])
                {
                    finishTime[2] = 0;
                    free[2] = true;
                }                
                if(a[i].st >= a[i-1].end)
                {
                    ans[i] = ans[i-1]; // let cameron continue the job.
                    free[ans[i]] = false;
                    finishTime[ans[i]] = a[i].end;
                    continue;
                }
                // Overlap.
                if(free[1])
                {
                    free[1] = false;
                    finishTime[1] = a[i].end; 
                    ans[i] = 1;
                    continue;
                }
                else if(free[2])
                {
                    free[2] = false;
                    ans[i] = 2;
                    finishTime[2] = a[i].end; 
                    continue;
                }
                else
                {
                    isImpossible = true;
                    break;
                }
            }
            if(isImpossible)
            sb.append("Case #"+cases+": "+"IMPOSSIBLE\n");
            else
            {
                HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
                for(int i=0;i<n;i++)
                map.put(a[i].index,i);
                sb.append("Case #"+cases+": ");
                for(int i=0;i<n;i++)
                {
                    int ind = (int)map.get(uns[i].index);
                    int x = ans[ind];
                    if(x==1)
                    sb.append("C");
                    else 
                    sb.append("J");
                }
                sb.append("\n");
            }
            cases++;
        }
        System.out.println(sb);
    }
    static class Activity
    {
        int st;
        int end;
        int index;
        public Activity(int st,int end,int index)
        {
            this.st=st;
            this.end=end;
            this.index=index;
        }
    }
    static class Sort implements Comparator<Activity>
    {
        public int compare(Activity a,Activity b)
        {
            if(a.st == b.st)
            return a.end - b.end;
            
            return a.st - b.st;
        }
    }
}