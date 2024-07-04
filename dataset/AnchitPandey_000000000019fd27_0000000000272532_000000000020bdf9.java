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
            if (max >2 )
                System.out.println("Case #"+test+": IMPOSSIBLE");
            
            else
            {
                 Arrays.sort (ob, new PQClass());
                 ArrayList<Integer> starter = new ArrayList<Integer>();
                 ArrayList<Integer> ender = new ArrayList<Integer>();
                 ArrayList<Integer> indexer = new ArrayList<Integer>();
            
                 for (int i = 0; i < n;i+=1)
                 {
                    starter.add (ob[i].startTime);
                    ender.add (ob[i].endTime);
                    indexer.add (ob[i].index);
                 }
                HashMap<Integer, Character> mapper = new HashMap<Integer, Character>();
                mapper.put (ender.get(0),'C');
                StringBuilder sb = new StringBuilder ();
                HashMap<Integer, Boolean> trueMap = new HashMap<Integer,Boolean>();
            
               // sb.append ('C');
               char[] jj = new char[n];
               jj[indexer.get(0)] = 'C';
               
                for (int i = 1; i< ender.size();i+=1)
                {
                    int index = Collections.binarySearch (ender, starter.get(i));     
                    if (index < 0)
                    {
                       index = -index  -1;
                       if (mapper.containsKey(ender.get(index)))
                        {
                              char getchar = mapper.get(ender.get(index));
                              if (getchar == 'C')
                              {
                                  jj[indexer.get(i)] = 'J';
                                  mapper.put (ender.get(i),'J');
                              }
                              else
                              {
                                    jj[indexer.get(i)] = 'C';
                                    mapper.put (ender.get(i), 'C');
                              }
                        }
                        else
                        {
                              jj[indexer.get(i)] = 'C';
                              mapper.put (ender.get(i), 'C');
                        }
                    }                    
                    else
                    {
                        if (i -index >1)
                        {
                            char getchar = mapper.get(ender.get(i-1));
                            if (getchar =='C')
                            {
                                jj[indexer.get(i)] = 'J';
                                mapper.put (ender.get(i),'J');
                            }
                            else
                            {
                                jj[indexer.get(i)] = 'C';
                                mapper.put (ender.get(i),'C');    
                            }
                        }
                       else
                        {
                                jj[indexer.get(i)] = 'C';
                                mapper.put (ender.get(i),'C');       
                        }
                    }
                }
               for (int i =0; i< n;i+=1)
                   sb.append (jj[i]);
                System.out.println("Case #"+test+": "+ sb.toString());    
            }
        }  
    }
}    
