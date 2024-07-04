import java.util.*;
import java.io.*;

// MAIN
public class Solution {

 public static String assign_activity(int[] activity, ArrayList<int[]> cameron, ArrayList<int[]> jamie){
   int max_end = 0;
   for(int i=0;i<cameron.size();i++){
     if(cameron.get(i)[1]>max_end)
      max_end = cameron.get(i)[1];
   }

   if(activity[0]>=max_end){
     cameron.add(activity);
     return "C";
   }

   max_end = 0;

   for(int i=0;i<jamie.size();i++){
     if(jamie.get(i)[1]>max_end)
      max_end = jamie.get(i)[1];
   }

   if(activity[0]>=max_end){
     jamie.add(activity);
     return "J";
   }

   return "IMPOSSIBLE";

 }

 public static void main(String[] args) {
   Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
   int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

   for (int i = 1; i <= t; ++i) {
     int n = in.nextInt();
     ArrayList<int[]> activities = new ArrayList<int[]>();
     ArrayList<int[]> cameron = new ArrayList<int[]>();
     ArrayList<int[]> jamie = new ArrayList<int[]>();

     for(int j=0; j<n; j++){
       int s = in.nextInt();  // Start of the activity
       int e = in.nextInt();  // End of the activity
       activities.add(new int[]{s,e});
     }

     String solution = "";

     for(int a=0; a<n; a++){
      int[] activity = activities.get(a);
      String s = assign_activity(activity, cameron, jamie);
      if(s.equals("C")){
        solution = solution + "C";
        cameron.add(activity);
      }
      else if(s.equals("J")){
        solution = solution + "J";
        jamie.add(activity);
      }
      else{
        solution = "IMPOSSIBLE";
        break;
      }
     }
     System.out.println("Case #" + i + ": " + solution);
   }
 }
/*
 // CLASS TO IMPLEMENT AN ACTIVITY
class Activity{
   private final int start;
   private final int end;

   public Activity(int s, int e){
     this.start = s;
     this.end = e;
   }

   public int getStart(){ return this.start; }
   public int getEnd(){ return this.end; }
 }*/
}
