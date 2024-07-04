 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= t; ++testCase) {
          int numAct = in.nextInt();
          boolean[][] actOverlap = new boolean[numAct][numAct];
          Activity[] activities = new Activity[numAct];
          for(int i=0;i<numAct;i++)
          {
        	  activities[i] = new Activity(in.nextInt(),in.nextInt());
        	  for(int j=0;j<i;j++)
        	  {
        		  boolean overlap = activities[i].overlap(activities[j]);
        		  actOverlap[i][j] = actOverlap[j][i] = overlap;
        	  }
          }
          
          boolean impossible = false;
          for(int i=0;i<numAct;i++)
          {
        	  if(!activities[i].visited)
        	  {
        		  activities[i].responsible = 'C';
        		  if(visit(i,actOverlap,activities))
        		  {
        			  impossible = true;
        			  break;
        		  }
        	  }
          }
          
          if(impossible)System.out.println("Case #"+testCase+": IMPOSSIBLE");
          else System.out.println("Case #"+testCase+": "+getString(activities));
          
        }
      }
      
      public static boolean visit(int act, boolean[][] actOverlap, Activity[] acts)
      {
    	  acts[act].visited = true;
    	  for(int i=0;i<acts.length;i++)
    	  {
    		  if(!actOverlap[act][i])continue;
    		  if(acts[i].visited)
    		  {
    			  if(acts[i].responsible == acts[act].responsible)return true;
    		  }
    		  else
    	      {
    			  acts[i].responsible = (acts[act].responsible=='C'?'J':'C');
    			  if(visit(i,actOverlap,acts))return true;
    	      }
    	  }
    	  return false;
      }
      
      public static String getString(Activity[] acts)
      {
    	  StringBuilder sb = new StringBuilder();
    	  for(Activity a:acts)sb.append(a.responsible);
    	  return sb.toString();
      }
      
     static class Activity
     {
    	 int begin,end;
    	 char responsible;
    	 boolean visited;
    	 Activity(int b,int e)
    	 {
    		 begin = b;
    		 end = e;
    	 }
    	 
    	 boolean overlap(Activity s)
    	 {
    		 Activity min = (begin<s.begin?this:s);
    		 Activity aux = (min==this?s:this);
    		 if(aux.begin < min.end)return true;
    		 return false;
    	 }
    	 
     }
      
    }
    
    