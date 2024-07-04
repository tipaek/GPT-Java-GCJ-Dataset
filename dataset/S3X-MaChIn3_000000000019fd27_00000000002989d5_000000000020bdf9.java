import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;
 
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
        LinkedList<Activity> C = new LinkedList<Activity>();
        LinkedList<Activity> J = new LinkedList<Activity>();
        
        while(L.isEmpty() == false)
        {
            Activity a = null;
            
            do
            {
                a = L.removeFirst();
            }
            while(!L.isEmpty() && a.getStart() > a.getEnd());
            
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

            boolean inserted = false;
            boolean cPossible = true;
            if(C.isEmpty() == false)
            {
                int i = 0;
                while (i < C.size() && cPossible == true) 
                {
                    for(int j = a.getStart(); j < a.getEnd() && cPossible == true; ++j)
                    {
                        if((j > C.get(i).getStart()) && (j < C.get(i).getEnd()))
                        {
                            cPossible = false;
                            break;
                        }
                    }

                    ++i;
                }
            }
            else
            {
                C.addLast(a);
                planning += Partnering.C.toString();
                inserted = true;
                cPossible = false;
            }

            if(cPossible == true)
            {
                C.addLast(a);
                planning += Partnering.C.toString();
                inserted = true;
            }

            boolean jPossible = true;

            if(inserted == false)
            {
                if (J.isEmpty() == false) 
                {
                    int i = 0;
                    
                    while (i < J.size() && jPossible == true) 
                    {
                        for (int j = a.getStart(); j < a.getEnd() && jPossible == true; ++j)
                            if ((j > J.get(i).getStart()) && (j < J.get(i).getEnd())) 
                            {
                                jPossible = false;
                                break;
                            }

                        ++i;
                    }
                } 
                else 
                {
                    J.addLast(a);
                    planning += Partnering.J.toString();
                    inserted = true;
                    jPossible = false;
                }

                if (jPossible == true) 
                {
                    J.addLast(a);
                    planning += Partnering.J.toString();
                    inserted = true;
                }
            }

            if(inserted == false)
            {
                planning = Partnering.IMPOSSIBLE.toString();
                break;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + planning);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int nExec = sc.nextInt(), caseNumber = 1;

        if(nExec >= 1 && nExec <= 100)
        {
            for (int i = 0; i < nExec; ++i) 
            {
                int size = sc.nextInt();
                sc.nextLine();

                if(size >= 2 && size <= 1000)
                {
                    LinkedList<Activity> L = new LinkedList<Activity>();

                    for (int j = 0; j < size; ++j) 
                    {
                        String in = sc.nextLine();
                        String[] formatTask = in.split(" ");

                        int s = Integer.parseInt(formatTask[0]);
                        int e = Integer.parseInt(formatTask[1]);
                        
                        L.addLast(new Activity(s, e));
                    }

                    Scheduling(L, caseNumber);
                    ++caseNumber;
                }
            }
        }

        sc.close();
    }
}