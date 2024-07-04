import java.io.*;
import java.util.*;

class Event{
    int time;
    char e;
    Event(int t,char x){
        time=t;
        e=x;
    }
    public String toString()
    {
        return "("+time+","+e+")";
    }
}
class EventComp implements Comparator<Event>{
    public int compare(Event e1,Event e2)
    {
        if(e1.time!=e2.time)
        {
            return e1.time-e2.time;
        }
        int a=e1.e-97,b=e2.e-97;
        return a-b;
    }
}
class Codechef{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            int n = Integer.parseInt(br.readLine());
            int[] a=new int[1442];
            //Details[] det=new Details[1442];
            ArrayList<Integer> startList=new ArrayList<>();
            ArrayList<Event> eventList = new ArrayList<>();
            HashMap<Integer, ArrayList<Integer>> eventMap=new HashMap<>();
            for(int j=0;j<n;j++)
            {
                String[] inp=br.readLine().split(" ");
                int start=Integer.parseInt(inp[0]);
                eventList.add(new Event(start,'s'));
                startList.add(start);
                int end=Integer.parseInt(inp[1]);
                eventList.add(new Event(end,'e'));
                if(eventMap.containsKey(end))
                {
                    eventMap.get(end).add(start);
                }
                else{
                    ArrayList<Integer> al=new ArrayList<>();
                    al.add(start);
                    eventMap.put(end,al);
                }
                
                a[start]++;
                a[end]--;
            }
            //System.out.println(eventMap);
            //System.out.println(eventList);
            Collections.sort(eventList, new EventComp());
            //System.out.println(eventList);
            int flag=0;
            ArrayList<Character> ans=new ArrayList<>();
            ArrayList<ArrayList<Character>> who=new ArrayList<>();            
            for(int j=1;j<1442;j++)
            {
                a[j]+=a[j-1];
                if(a[j]>2)
                {
                    flag=1;
                }
                who.add(new ArrayList<Character>());
            }
            if(flag==1)
            {
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                continue;
            }
            int c_working=0,j_working=0;
            for(int j=0;j<eventList.size();j++)
            {
                Event e=eventList.get(j);
                if(e.e=='s')
                {
                    if(c_working==0 || c_working==-1)
                    {
                        ans.add('C');
                        who.get(e.time).add('C');
                        c_working++;
                    }
                    else{
                        ans.add('J');
                        who.get(e.time).add('J');
                        j_working++;
                    }
                }
                else{
                    int endTime=e.time;
                    ArrayList<Integer> corresponding_start=eventMap.get(endTime);
                    if(corresponding_start.size()==1)
                    {
                        if(corresponding_start.get(0)==endTime)
                        {
                            if(c_working==0)
                            {
                                c_working=-1;
                            }
                            else{
                                j_working=-1;
                            }
                        }
                        else if(who.get(corresponding_start.get(0)).get(0)=='C')
                        {
                            c_working=0;
                        }
                        else{
                            j_working=0;
                        }
                    }
                    else{
                        if(corresponding_start.get(0)==endTime)
                        {
                            if(c_working==0)
                            {
                                c_working=-1;
                            }
                            else{
                                j_working=-1;
                            }
                        }
                        else if(who.get(corresponding_start.get(0)).get(0)=='C')
                        {
                            c_working=0;
                        }
                        else{
                            j_working=0;
                        }
                        eventMap.get(endTime).remove(0);
                    }
                }
            }
            System.out.print("Case #"+(i+1)+": ");
            for(int j=0;j<startList.size();j++)
            {
                System.out.print(who.get(startList.get(j)).get(0));
                // for(int k=0;k<temp.size();k++)
                // {
                //     System.out.print(temp.get(k));
                // }
                who.get(startList.get(0)).remove(0);
            }
            System.out.println();
        }
    }
}