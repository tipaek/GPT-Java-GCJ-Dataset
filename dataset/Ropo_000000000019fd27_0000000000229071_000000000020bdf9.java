// package Qualification_Round;

import java.io.*;
import java.util.*;

public class Solution {  
    public static void main(String[] args) {
        FastReader in = new FastReader();
        
        int numTrials = in.nextInt();
        for(int caseNum = 1; caseNum <= numTrials; caseNum++) {
            int numActivities = in.nextInt();
            ArrayList<Activity> activities = new ArrayList<Activity>();
            
            for(int i = 0; i < numActivities; i++) {
                activities.add(new Activity(in.nextInt(), in.nextInt(), i));
            }
            
            ArrayList<Activity> activitiesSorted = new ArrayList<Activity>();
            activitiesSorted.addAll(activities);
            
            Collections.sort(activitiesSorted);
            
            int cEnd = 0, jEnd = 0;
            boolean works = true;
            
            for(int i = 0; i < activities.size(); i++) {
                Activity act = activitiesSorted.get(i);
                
                if(act.start >= cEnd) {
                    cEnd = act.end;
                    activitiesSorted.get(i).assigned = "C";
                }
                else if(act.start >= jEnd) {
                    jEnd = act.end;
                    activitiesSorted.get(i).assigned = "J";
                }
                else {
                    works = false;
                    break;
                }
            }
            
            StringBuilder s = new StringBuilder();
            
            if(works) {
                Collections.sort(activitiesSorted, new SortIndex());
                
                for(int i = 0; i < activitiesSorted.size(); i++) {
                    s.append(activitiesSorted.get(i).assigned);
                }
            }
            else {
                s.append("IMPOSSIBLE");
            }
            
            System.out.println("Case #" + caseNum + ": " + s.toString().trim());
        }
    }
    
    static class SortIndex implements Comparator<Activity>{

        @Override
        public int compare(Activity arg0, Activity arg1) {
            return arg0.index - arg1.index;
        }
        
    }
    
    static class Activity implements Comparable<Activity>{
        int start, end;
        String assigned;
        int index;
        
        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
        
        @Override
        public int compareTo(Activity o) {
            return this.start - o.start;
        }
    }
    
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        }
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
}
