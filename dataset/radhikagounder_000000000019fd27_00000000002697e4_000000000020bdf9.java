import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int T=s.nextInt();
        for(int t=0;t<T;t++)
        {
            int n=s.nextInt();
            HashMap<Integer,Integer> h=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int start=s.nextInt();
                int end=s.nextInt();
                h.put(start,end);
                
            }
            TreeMap<Integer,Integer> sorted=new TreeMap<>();
            sorted.putAll(h);
            int j=0,c=0;
            String str="";
            for (Map.Entry<Integer, Integer> entry : sorted.entrySet())
            {
                   int start=entry.getKey();
                   int end=entry.getValue();
                   if(start>=c)
                   {
                       c=end;
                       str=str+"C";
                       continue;
                   }
                   if(start>=j)
                   {
                       j=end;
                       str=str+"J";
                       continue;
                   }
                   
                   if(start<j && start<c)
                   {
                       str="IMPOSSIBLE";
                       break;
                   }
            }
        System.out.println("Case #"+(t+1)+":"+" "+str);
            
        }
    }
}