import java.util.*;
import java.io.*;

public class Solution
{
   public static void main(String[] args) throws IOException
   {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));                                         
      StringTokenizer star = new StringTokenizer(bf.readLine());
      int cases = Integer.parseInt(star.nextToken());
      for(int case_num = 1; case_num <= cases; case_num++) {
         star = new StringTokenizer(bf.readLine());
         int N = Integer.parseInt(star.nextToken());
         Activity[] original = new Activity[N];
         Activity[] activities = new Activity[N];
         for(int i = 0; i < N; i++) {
            star = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(star.nextToken());
            int e = Integer.parseInt(star.nextToken());
            original[i] = new Activity(s, e);
            activities[i] = new Activity(s, e);
         }
      
         String order = "";
         int cameron = 0;
         int jamie = 0;
         Arrays.sort(activities);
         for(int i = 0; i < activities.length; i++) {
            if(cameron <= activities[i].getStart()) {
               cameron = activities[i].getEnd();
               activities[i].setPerson("C");
            } else if(jamie <= activities[i].getStart()) {
               jamie = activities[i].getEnd();
               activities[i].setPerson("J");
            } else {
               order = "IMPOSSIBLE";
               break;
            }
         }
         
         if(!order.equals("IMPOSSIBLE")) {
            for(int i = 0; i < original.length; i++) {
               for(int j = 0; j < activities.length; j++) {
                  if(original[i].equals(activities[j])) {
                     order += activities[i].getPerson();
                     break;
                  }
               }
            }
         }
      
         System.out.println("Case #" + case_num + ": " + order);
      }    
   }
}

class Activity implements Comparable<Activity>
{
   public int start, end;
   public String person;
      
   public Activity(int s, int e)
   {
      start = s;
      end = e;
      person = "";
   }
   public int getStart()
   {
      return start;
   }
   public int getEnd()
   {
      return end;
   }
   public String getPerson()
   {
      return person;
   }
   public void setPerson(String p)
   {
      person = p;
   }
   public boolean equals(Activity other)
   {
      if((start == other.getStart()) && (end == other.getEnd())) {
         return true;
      }
      return false;
   }
   public int compareTo(Activity other)
   {
      if(start < other.getStart())
         return -1;
      else if(start > other.getStart())
         return 1;
      return 0;
   }
}