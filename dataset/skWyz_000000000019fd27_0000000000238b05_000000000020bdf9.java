import java.util.*;
import java.io.*;
public class Solution 
{
    
    static class Work
    {
        long s;
        long e;
        char by;
        Work(long a, long b)
        {
            this.s = a;
            this.e = b;
        }
        
        long getStart()
        {return this.s;}
        
        long getEnd()
        {return this.e;}
        
        void setBy(char a)
        {
            this.by = a;
        }
        
        char getBy()
        {return this.by;}
    }
    static int flag = 0;
    static void routine(ArrayList<Work> ob, int n)
    {
        long C = 0;
        long J = 0;
        
        for(int i=0; i < n; ++i)
        {
            if(C<=ob.get(i).getStart())
            {
                ob.get(i).setBy('C');
                C = ob.get(i).getEnd();
                // System.out.println(ob.get(i).getStart()+", "+ob.get(i)+", "+x.getBy()+" : "+C);
            }else if(J<=ob.get(i).getStart())
            {
                ob.get(i).setBy('J');
                J = ob.get(i).getEnd();
                // System.out.println(ob.get(i).getStart()+", "+ob.get(i)+", "+x.getBy()+" : "+C);
            }else{
                flag = 1;
                return;
            }
        }
    }
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) 
        {
            int n = in.nextInt();
            
            ArrayList<Work> ob = new ArrayList<>();
            HashMap<Integer, Work> maps = new HashMap<Integer, Work>();
            
            for(int j = 0; j < n; j++)
            {
                long a = in.nextInt();
                long b = in.nextInt();
                Work tmp = new Work(a,b);
                ob.add(tmp);
                maps.put(j, tmp);
            }
            
            ob.sort((a,b)-> (int)(a.getStart() - b.getStart()));
            
            routine(ob, n);
            
            StringBuffer result = new StringBuffer("");
            if(flag==1)
            {
                result.append("IMPOSSIBLE");
                flag = 0;
            }
            else{
                for (Map.Entry<Integer, Work> entry : maps.entrySet()) 
                {
                    Work x = (Work)entry.getValue();
                   
                    result.append(x.getBy());
                }
            }
            
            System.out.println("Case #" + i + ": " + result);
        }
    }
}