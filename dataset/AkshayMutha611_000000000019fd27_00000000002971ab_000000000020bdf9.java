import java.util.*;
import java.lang.*;

public class Solution
{
    int t,n,start_time,end_time,xyz;
    
    // This map stores unsorted values 
    Map<Integer, String> map = new HashMap<>();

    public static void main(String args[])
    {
        Solution sol = new Solution();
        sol.takeInputAndSolve();
    }

    void takeInputAndSolve()
    {
        Scanner s = new Scanner(System.in);
        t = s.nextInt();
        
        for (xyz=0;xyz<t;xyz++)
        {
            String outputString = "";
            n = s.nextInt();
            
            ArrayList<Integer> start_times = new ArrayList<Integer>();
            ArrayList<Integer> end_times = new ArrayList<Integer>();
            
            for (int b=0;b<n;b++)
            {
            start_time = s.nextInt();
            end_time = s.nextInt();
            
            start_times.add(start_time);
            end_times.add(end_time);
            }
            
            // 1st for to check if impossible if not then go below
        
            int count = 0;
            for (int i=0;i<n-1;i++)
            {
                
                if(start_times.get(i+1) > start_times.get(i) && end_times.get(i+1) < Collections.max(end_times))
                {
                    count++;
                }
                if (count == 2)
                {
                    outputString = "Case #"+(xyz+1)+": IMPOSSIBLE";
                    
                    break;
                }
            }

            // make n-1 time comparisons here below to check for overlap
            if (count < 2)
            {

              // putting values in the Map 
              for (int l=0;l<n;l++)
              {
                    map.put(start_times.get(l),end_times.get(l).toString()); 
              }
              sortbykey();
              System.out.println(outputString);
            }
            
        }
        
    }
            void sortbykey()
            {
                // TreeMap to store values of HashMap 
                TreeMap<Integer, String> sorted = new TreeMap<>(); 
          
                // Copy all data from hashMap into TreeMap 
                sorted.putAll(map);
                    
                    String w = sorted.get(sorted.keySet().toArray()[0]);
                    w = "C";
                for(int m=0;m<n-1;m++)
                  {
                    int a = (Integer) sorted.keySet().toArray()[m+1];
                    int b = (Integer) sorted.keySet().toArray()[m];
                    int c = Integer.parseInt(sorted.get(sorted.keySet().toArray()[m+1]));
                    int d = Integer.parseInt(sorted.get(sorted.keySet().toArray()[m]));
                    int e = (Integer) sorted.keySet().toArray()[m+1];
                    int f = Integer.parseInt(sorted.get(sorted.keySet().toArray()[m]));

                      if (a > b && (c < d || e < f ))
                        {
                            if(w.substring(w.length() - 1) == "C")
                               { 
                                    w = w + "J";
                               }
                            else
                                w = w + "C";
                        }
                        else
                          {
                              w = w + w.substring(w.length() - 1);
                          }
                  }
                  System.out.println("Case #"+(xyz+1)+": "+w);
            }
}