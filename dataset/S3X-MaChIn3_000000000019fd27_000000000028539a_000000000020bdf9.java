import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;
 
enum Partnering {C, J, IMPOSSIBLE};

class Activity implements Comparable<Activity>
{
    private int start, end;

    public Activity(int s, int e)
    {
        start = s;
        end = e;
    }

    public int getStart()
    {
        return start;
    }

    public int getEnd()
    {
        return end;
    }

    @Override
    public int compareTo(Activity a)
    {
        return start - a.getStart();
    }

    @Override
    public String toString()
    {
        return "[" + start + " " + end + "] ";
    }
}

public class Solution 
{
    public static void Scheduling(LinkedList<Activity> L, int caseNumber)
    {
        String planning = "";
        int endCameron = 0, endJamie = 0;
        Collections.sort(L);

        System.out.println(L.toString());

        while(!L.isEmpty())
        {
            Activity a = L.removeFirst();
            
            if(a.getStart() < 0)
            {
                planning = Partnering.IMPOSSIBLE.toString();
                break;
            }

            if(a.getEnd() > 1440)
            {
                planning = Partnering.IMPOSSIBLE.toString();
                break;
            }

            if(a.getStart() > a.getEnd())
            {
                planning = Partnering.IMPOSSIBLE.toString();
                break;
            }

            if((endCameron > a.getStart()) && (endJamie > a.getStart()))
            {
                planning = Partnering.IMPOSSIBLE.toString();
                break;
            }
            else if((endCameron > a.getStart()) && (endJamie <= a.getStart()))
            {
                
                planning += Partnering.J.toString();
                endJamie = a.getEnd();
            }
            else if(endCameron <= a.getStart())
            {
                planning += Partnering.C.toString();
                endCameron = a.getEnd();
            }
        }

        System.out.println("Case #" + caseNumber + ": " + planning);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int nExec = sc.nextInt(), caseNumber = 1;

        for (int i = 0; i < nExec; ++i) 
        {
            int size = sc.nextInt();
            LinkedList<Activity> L = new LinkedList<Activity>();

            for(int j = 0; j < size; ++j)
            {
                int s = sc.nextInt(), e = sc.nextInt();
                L.addLast(new Activity(s, e));
            }

            Scheduling(L, caseNumber);
            ++caseNumber;
        }

        sc.close();
    }
}