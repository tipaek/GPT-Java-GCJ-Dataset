import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Activity implements Comparable<Activity>
{
    int start;
    int end;
    int no;
    String man;

    Activity(int a,int b,int n)
    {
        start = a;
        end = b;
        no = n;
    }

    public int compareTo(Activity a)
    {
        return start - a.start;
    }

    public String toString()
    {
        return no + ". " + start + " " + end;
    }

}

public class Solution {

    public static void Parenting(int no, int N, Activity [] tasks)
    {
        int C = 0;
        int J = 0;
        String ans = "";

        ArrayList<Activity> ToDo = new ArrayList<>();

        for(int i=0; i<N; i++)
        {
            ToDo.add(tasks[i]);
        }

        Collections.sort(ToDo);

        ArrayList<Activity> Running = new ArrayList<>();

        int time = ToDo.get(0).start;
        int flag = 1;

        while(!ToDo.isEmpty())
        {
            for(int i=0; i<Running.size(); i++)
            {
                Activity act = Running.get(i);

                if(act.end <= time)
                {
                    Running.remove(i);
                    i--;
                    if(act.man.equals("C"))
                    {
                        C = 0;
                    }
                    else J = 0;
                }

            }

            Activity curr = ToDo.remove(0);

            if(C==0 && J==0)
            {
                curr.man = "C";
                C = 1;
            }
            else if(C==1 && J==0)
            {
                curr.man = "J";
                J = 1;
            }
            else if(C==0 && J==1)
            {
                curr.man = "C";
                C = 1;
            }
            else if(C==1 && J==1)
            {
                flag = 0;
                break;
            }

            Running.add(curr);
            if(!ToDo.isEmpty()) time = ToDo.get(0).start;
        }

        if(flag == 0)
        {
            ans = "IMPOSSIBLE";
        }
        else
        {
            for(int i=0; i<N; i++)
            {
                ans = ans + tasks[i].man;
            }
        }

        System.out.println("Case #" + no + ": " + ans);

    }

    public static void main(String[] args) {

        int cases;
        Scanner s = new Scanner(System.in);
        cases = s.nextInt();

        for(int i=1; i<=cases; i++)
        {
            int N;
            N = s.nextInt();
            Activity [] tasks = new Activity[N];

            for(int a=0; a<N; a++)
            {
                int start = s.nextInt();
                int end = s.nextInt();
                Activity act = new Activity(start,end,a);
                tasks[a] = act;
            }

            Parenting(i,N,tasks);
        }

    }

}
