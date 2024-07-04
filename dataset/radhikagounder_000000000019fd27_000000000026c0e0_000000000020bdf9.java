import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int T=s.nextInt();
        for(int t=0;t<T;t++)
        {
            int n=s.nextInt();
            int[] st= new int[n];
            HashMap<Integer,Integer> h=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int start=s.nextInt();
                st[i]=start;
                int end=s.nextInt();
                h.put(start,end);
                
            }
            HashMap<Integer,String> ans=new HashMap<>();
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
                       ans.put(start,"C");
                       continue;
                   }
                   if(start>=j)
                   {
                       j=end;
                       ans.put(start,"J");
                       continue;
                   }
                   
                   if(start<j && start<c)
                   {
                       str="IMPOSSIBLE";
                       break;
                   }
            }
            if(!(str.equals("IMPOSSIBLE")))
            {
                for(int i=0;i<n;i++)
                str=str+ans.get(st[i]);
            }
        System.out.println("Case #"+(t+1)+":"+" "+str);
            
        }
    }
}