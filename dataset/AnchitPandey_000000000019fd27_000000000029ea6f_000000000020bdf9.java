import java.io.*;
import java.util.*;

class time 
{
    int startTime,endTime, index;
       time (int startTime, int endTime, int index)
       {
           this.startTime = startTime;
           this.endTime = endTime;
           this.index = index;
       }
}

class PQClass implements Comparator <time>
{
    public int compare (time t1, time t2)
    {
        if (t1.endTime < t2.endTime)
            return -1;
        else if (t1.endTime > t2.endTime)
            return 1;
        else
        {
            if (t1.startTime <= t2.startTime)
                return -1;
            else
                return 1;           
        }
    }    
}

class Solution
{
    public static int maxOverlapIntervalCount(int[] start, int[] end){
	int maxOverlap = 0;
	int currentOverlap = 0;
	Arrays.sort(start);
	Arrays.sort(end);
	
        int i = 0;
	int j = 0;
	int m=start.length,n=end.length;
	
        while(i< m && j < n){
		if(start[i] < end[j]){
			currentOverlap++;
			maxOverlap = Math.max(maxOverlap, currentOverlap);
			i++;
		}
		else{
			currentOverlap--;
			j++;
		}
	}	
	return maxOverlap;
}
 
    public static void main(String[] args)throws Exception
    {      
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(buff.readLine());
        for (int test = 1; test <= testcase;test+=1)
        {
            int n = Integer.parseInt (buff.readLine());
            time[] ob = new time[n];
            int[] s = new int[n];
            int[] e = new int[n];
            
            for (int j =0; j< n;j+=1)
            {
                String[] input = buff.readLine().split("\\s+");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                s[j] = start;
                e[j] = end;
                ob[j] = new time(start, end,j);
            }
            
            int max = maxOverlapIntervalCount(s, e);     
            // Assuming this is working properly
            if (max >2 )
                System.out.println("Case #"+test+": IMPOSSIBLE");
            
            else
            {
                HashMap<Integer, Integer> indiceVisited = new HashMap<Integer, Integer>();
                 Arrays.sort (ob, new PQClass());        
                 char[] jj = new char[n];
                 int[] present = new int[n];
                 ArrayList<Integer> startTimes = new ArrayList<Integer>();
                 ArrayList<Integer> endTimes = new ArrayList<Integer>();
                 ArrayList<Integer> indices = new ArrayList<Integer>();
                 for (int i =0 ; i< n;i+=1)
                 {
                     startTimes.add (ob[i].startTime);
                     endTimes.add (ob[i].endTime);
                     indices.add (ob[i].index);      
                 }
                 Arrays.fill(present, 0);
                 jj[indices.get(0)]=  'C';
                 for (int i = 1; i< n;i+=1)
                 {
                    int start = startTimes.get(i);
                    int index = Collections.binarySearch (endTimes, start);
                    if (index < 0 && (-index-1) != i)
                    {
                        index = -index-1;
                        jj[indices.get(i)] = jj[indices.get(index)] == 'C' ? 'J':'C';
                    } 
                    else
                    {
                        if (index < 0)
                            index = -index -2;
                        if (present[index] ==1)
                        {
                           
                          jj[indices.get(i)] = jj[indices.get(index)] == 'C' ? 'J':'C';
                                           
                        }
                        else
                        {
                            jj[indices.get(i)] = jj[indices.get(index)];
                            present[index] = 1;
                        }
                    }                     
                 }
                 StringBuilder sb = new StringBuilder();
                 for (int j =0; j< n;j+=1)
                     sb.append (jj[j]);
                  String str = sb.toString();
                  System.out.println("Case #"+test+": "+str);
            }
        }  
    }
}    