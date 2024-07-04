package javaTest;
import java.util.*;

class Act1 implements Comparable<Act1>
{
    int start;
    int end;
    int index;
    
    public int compareTo(Act1 compareAct)
    {
        int compareEnd = ((Act1) compareAct).end;
        return this.end - compareEnd;
    }
    
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int t=0;t<T;t++)
        {
            int N = s.nextInt();
            ArrayList<Act1> arr = new ArrayList<Act1>();
            for(int i=0;i<N;i++)
            {
                Act1 a = new Act1();
                a.start = s.nextInt();
                a.end =s.nextInt();
                a.index = i;
                arr.add(a);
            }
            Collections.sort(arr);
            char[] sol = new char[N];
            sol[arr.get(0).index] = 'C';
            arr.get(0).index = -1;
            int j = 0;
            for(int i=1;i<N;i++)
            {
            	if(arr.get(i).start>=arr.get(j).end)
            	{
            		sol[arr.get(i).index] = 'C';
            		arr.get(i).index = -1;
            		j=i;
            	}
            }
            
            arr.removeIf(n->(n.index)==-1);
            System.out.println(arr.size());
            int k=0;
            if(arr.size()!=0)
            {
	            sol[arr.get(0).index] = 'J';
	            arr.get(0).index = -1;
	            for(int i=1;i<arr.size();i++)
	            {
	            	if(arr.get(i).start>=arr.get(k).end)
	            	{
	            		sol[arr.get(i).index] = 'J';
	            		arr.get(i).index=-1;
	            		k=i;
	            	}
	            }
	            arr.removeIf(n->(n.index)==-1);
            }
            if(arr.size()!=0)
            	System.out.println("Case #" + (t+1) + ": IMPOSSIBLE");
            else
            {
                String a = "";
            	
            	for(char d : sol)
            	{
            		a+=d;
            	}
            	System.out.print("Case #" + (t+1) + ": "+a);
            }
            
        }
    }
}
