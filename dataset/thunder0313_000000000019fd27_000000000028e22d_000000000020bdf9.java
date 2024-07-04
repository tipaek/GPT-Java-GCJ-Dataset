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
         Activity[] activities = new Activity[N];
         for(int i = 0; i < N; i++) {
            star = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(star.nextToken());
            int e = Integer.parseInt(star.nextToken());
            activities[i] = new Activity(s, e, i + 1);
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
         
         Arrays.sort(activities, 
            new Comparator<Activity>() {
               public int compare(Activity a1, Activity a2) {
                  if(a1.getPosition() < a2.getPosition())
                     return -1;
                  else if(a1.getPosition() > a2.getPosition())
                     return 1;
                  return 0;
               }});
               
         if(!order.equals("IMPOSSIBLE")) {
            for(int i = 0; i < activities.length; i++) {
               order += activities[i].getPerson();
            }
         }
      
      
         System.out.println("Case #" + case_num + ": " + order);
      }    
   }
}

class Activity implements Comparable<Activity>
{
   public int start, end, position;
   public String person;
      
   public Activity(int s, int e, int pos)
   {
      start = s;
      end = e;
      position = pos;
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
   public int getPosition()
   {
      return position;
   }
   public String getPerson()
   {
      return person;
   }
   public void setPerson(String p)
   {
      person = p;
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