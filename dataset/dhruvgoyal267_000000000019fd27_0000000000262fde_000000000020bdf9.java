import java.util.*;
public class Main{

     public static void main(String []args){
         
         Scanner s = new Scanner(System.in);
         int t,n;
         int time[][];

         HashMap<String,ArrayList<Integer>> map ;
         ArrayList<Integer> arr;
        
         t = s.nextInt();
        int temp = t;
         while(t-->0)
         {
             map = new HashMap<>();
             n = s.nextInt();
            time = new int[n][2];
             int i=0;
             for(;i<n;i++)
                {
                    time[i][0] = s.nextInt();
                    time[i][1] = s.nextInt();
                }
                Arrays.sort(time,new Comparator<int[]>(){
			 @Override
			 public int compare(int[] a,int[] b) {
				 return a[0]-b[0];
			 }
			 
		});
		
                for(i=0;i<n;i++)
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
                        if((time[i][0]<time[arr.get(j)][1]) && (time[i][1]>time[arr.get(j)][0]))
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
                           if((time[i][0]<time[arr.get(j)][1]) && (time[i][1]>time[arr.get(j)][0]))
                                break;
                        }
                        if(j>=arr.size())
                        {
                            arr.add(i);
                            map.put("C",arr);
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                
                String result[] = new String[n];
                String op =  "";
                
                if(i<n)
                {
                        op = "IMPOSSIBLE";
                }
                else{
                    if(map.get("C") != null)
                    {
                        arr = map.get("C");
                        for(i = 0;i<arr.size();i++)
                            result[arr.get(i)] =  "C";
                    }
                    if(map.get("J") !=null)
                    {    arr = map.get("J");
                        for(i = 0;i<arr.size();i++)
                            result[arr.get(i)] =  "J";
                    }
                     for(i =0;i<result.length;i++)
                            {
                            if(result[i] == null)
                               {
                                  op = "IMPOSSIBLE";
                                break;
                               }
                                op+=result[i];
                            }
                }
                
                System.out.println("Case #" +(temp-t) + ": " +op );
         }
     }
}