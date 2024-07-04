import java.util.*;

public class Solution 
{
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        for(int ii=0; ii<t; ii++)
        {
            int n = in.nextInt();
            //Task jt[] = new Task[n];
            ArrayList<Task> jt = new ArrayList<Task>(); 
            //Task ct[] = new Task[n];
            ArrayList<Task> ct = new ArrayList<Task>(); 
            char ss[] = new char[n];
            int jj=0;
            int cc=0;
            for(int j=0; j<n; j++)
            {
                int s = in.nextInt();
                int e = in.nextInt();
                if(jj==0)
                {
                    jj++;
                    Task task = new Task();
                    task.s = s;
                    task.e = e;
                    jt.add(task);
                    ss[j]='J';
                    continue;
                }
                else if(IsPossible(jt, s, e, jj))
                {
                    Task task = new Task();
                    task.s = s;
                    task.e = e;
                    jt.add(task);
                    ss[j]='J';
                    jj++;
                    continue;
                }
                else if(IsPossible(ct, s, e, cc))
                {
                    Task task = new Task();
                    task.s = s;
                    task.e = e;
                    ct.add(task);
                    ss[j]='C';
                    cc++;
                    continue;
                }
                jj=0;
                System.out.println("Case #"+(ii+1)+": IMPOSSIBLE");
                break;
            }
            if(jj!=0)
            {
                System.out.println("Case #"+(ii+1)+": " + Cs(ss));
            }
        }
    }
    static class Task
    {
        int s=0;
        int e=0;
    }
    public static boolean IsPossible(ArrayList<Task> a, int s, int e, int size)
    {
       for(int i=0; i<a.size(); i++)
       {
           if(s<a.get(i).s && e<=a.get(i).s)
            {
                continue;
            }
            else if(s>=a.get(i).e)
            {
                continue;
            }
            return false;
       }
       return true; 
    }
    public static String Cs(char a[])
    {
        String s="";
        for(int i=0; i<a.length; i++)
        {
            s+=a[i];
        }
        return s;
    }
}