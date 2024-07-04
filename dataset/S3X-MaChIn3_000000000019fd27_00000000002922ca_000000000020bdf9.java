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

        while(!L.isEmpty())
        {
            Activity a = null;

            do
            {
                a = L.removeFirst();
            }
            while(!L.isEmpty() );//&& a.getStart() > a.getEnd());
            
            if(a.getStart() > a.getEnd())
            {
                planning = Partnering.IMPOSSIBLE.toString();
                break;
            }

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
            if(!C.isEmpty())
            {
                boolean cPossible = false;
                int i = 0;
                while (i < C.size()) 
                {
                    if (!(a.getStart() < C.get(i).getStart() && C.get(i).getStart() < a.getEnd()) && !cPossible && !inserted) 
                        cPossible = true;

                    if (cPossible && !(a.getStart() < C.get(i).getEnd() && C.get(i).getStart() < a.getEnd()) && !inserted) 
                    {
                        C.addLast(a);
                        Collections.sort(C);
                        planning += Partnering.C.toString();
                        inserted = true;
                    }
                    ++i;
                    cPossible = false;
                }
            }
            else
            {
                C.addLast(a);
                planning += Partnering.C.toString();
                inserted = true;
            }

            if(!inserted)
            {
                if (!J.isEmpty()) 
                {
                    boolean jPossible = false;
                    int i = 0;
                    while (i < J.size()) 
                    {
                        if (!(a.getStart() < J.get(i).getStart() && J.get(i).getStart() < a.getEnd()) && !jPossible && !inserted) 
                            jPossible = true;
                        

                        if (jPossible && !(a.getStart() < J.get(i).getEnd() && J.get(i).getStart() < a.getEnd()) && !inserted) 
                        {
                            J.addLast(a);
                            Collections.sort(J);
                            planning += Partnering.J.toString();
                            inserted = true;
                        }

                        ++i;
                        jPossible = false;
                    }
                } else 
                {
                    J.addLast(a);
                    planning += Partnering.J.toString();
                    inserted = true;
                }
            }

            if(!inserted)
            {
                planning = Partnering.IMPOSSIBLE.toString();
                break;
            }
            

            /*if ((endCameron > a.getStart()) && (endJamie > a.getStart())) 
            {
                planning = Partnering.IMPOSSIBLE.toString();
                break;
            } 
            else if ((endCameron > a.getStart()) && (endJamie <= a.getStart())) 
            {

                planning += Partnering.J.toString();
                endJamie = a.getEnd();
            } 
            else if (endCameron <= a.getStart()) 
            {   
                planning += Partnering.C.toString();
                endCameron = a.getEnd();
            }else if(endCameron >= a.getStart())
            {   
                planning += Partnering.J.toString();
                endJamie = a.getEnd();
            }else if(remainingC == 0)
            {
                planning += Partnering.C.toString();
                remainingC += (a.getEnd() - a.getStart());
                remainingJ -= (a.getEnd() - a.getStart());
                if(remainingJ < 0)
                    remainingJ = 0;
            }else if(remainingJ == 0)
            {
                planning += Partnering.J.toString();
                remainingJ += (a.getEnd() - a.getStart());
                remainingC -= (a.getEnd() - a.getStart());
                if (remainingC < 0)
                    remainingC = 0;
            }*/
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