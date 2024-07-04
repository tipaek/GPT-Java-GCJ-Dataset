import java.util.*;
public class Solution{

     public static void main(String []args){
         
         Scanner s = new Scanner(System.in);
         int t,n;
         int st[],et[];

         HashMap<String,ArrayList<Integer>> map ;
         ArrayList<Integer> arr;
        
         t = s.nextInt();
        int temp = t;
         while(t-->0)
         {
             map = new HashMap<>();
             n = s.nextInt();
             st = new int[n];
             et = new int[n];
             
             for(int i=0;i<n;i++)
                {
                    st[i] = s.nextInt();
                    et[i] = s.nextInt();
                }
                
                for(int i=0;i<n;i++)
                {
                    
                    if(map.get("J") == null)
                        {
                            arr = new ArrayList();
                            arr.add(i);
                            map.put("J",arr);
                            continue;
                        }
                    else{
                    int j = 0;
                    arr = map.get("J");
                    for(;j<arr.size();j++)
                    {
                        if((st[i]<et[arr.get(j)]) && (et[i]>st[arr.get(j)]))
                            break;
                    }
                    if(j>=arr.size())
                    {
                        arr.add(i);
                        map.put("J",arr);
                        continue;
                    }
                    }
                    if(map.get("C") == null)
                        {
                            arr = new ArrayList();
                            arr.add(i);
                            map.put("C",arr);
                        }
                    else{
                        arr = map.get("C");
                        int j = 0;
                        for(;j<arr.size();j++)
                        {
                            if((st[i]<et[arr.get(j)]) && (et[i]>st[arr.get(j)]))
                                break;
                        }
                        if(j>=arr.size())
                        {
                            arr.add(i);
                            map.put("C",arr);
                        }
                    }
                }
                
                String result[] = new String[n];
                String op =  "";
                int cSize ,jSize;
                if(map.get("C") == null)
                    cSize = 0;
                else
                    cSize = map.get("C").size();
                if(map.get("J") == null)
                    jSize = 0;
                else
                    jSize = map.get("J").size();
                
                if((cSize+jSize) !=n)
                {
                        op = "IMPOSSIBLE";
                }
                else{
                    for(String obj : map.keySet())
                    {
                        arr = map.get(obj);
                        for(int i = 0;i<arr.size();i++)
                            result[arr.get(i)] =  obj;
                    }
                     for(int i =0;i<result.length;i++)
                            op+=result[i];   
                }
                System.out.println("Case #" +(temp-t) + ": " +op );
         }
     }
}