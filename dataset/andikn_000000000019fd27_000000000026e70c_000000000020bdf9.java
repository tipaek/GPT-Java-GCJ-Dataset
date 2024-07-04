import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
   public static boolean overlaps(int[] a, int[] b){
      //System.out.println("\t\t" + Math.max(a[0],b[0]) + "<" + Math.min(a[1],b[1]));
      return Math.max(a[0],b[0]) < Math.min(a[1],b[1]);
   }
   
   public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       int test, n;
       int[] schedule;
       boolean impossible;
       HashSet<Integer> labels = new HashSet<>();
       SortedSet<int[]> intervals = new TreeSet<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                int res = a[0] - b[0];
                if(res == 0){
                    if(b[1] == a[1])
                        return res;
                    return -1;
                }
                return res;
            }
       });
       
       test = in.nextInt();
       int[] interval, prev;
       for(int t = 0; t < test; t++){
           // init
           n = in.nextInt();
           schedule = new int[n];
           impossible = false;
           intervals.clear();
           // getting intervals
           for(int i = 0; i < n; i++){
               interval = new int[3];
               interval[0] = in.nextInt();
               interval[1] = in.nextInt();
               interval[2] = i;
               intervals.add(interval);
           }

           // computing scheduling
           Iterator<int[]> itr = intervals.iterator();
           prev = null;
           int i = 0;
           while(itr.hasNext()){
               labels.clear();
               labels.add(0);
               labels.add(1);
               interval = itr.next();
               System.out.println("curr: [" + interval[0] + "," + interval[1] + "]");
               if(i == 0)
                   schedule[interval[2]] = 0;
               else{
                   // checking previous intervals
                   Iterator<int[]> itr2 = intervals.iterator();
                   int j = 0;
                   while(j < i){
                      prev = itr2.next();
                      System.out.println("\tprev = [" + prev[0] + "," + prev[1] + "]");
                      if(Solution.overlaps(interval,prev)){
                          labels.remove(schedule[prev[2]]);
                          System.out.println("\tOverlap, remove: " + schedule[j]);
                      }
                      j++;
                   }
                   if(labels.isEmpty()){
                       impossible = true;
                       break;
                   }
                   schedule[interval[2]] = labels.contains(0) ? 0 : 1;
                   System.out.println("\tAssigned: " + schedule[interval[2]]);
               }
               i++;
           }
           // OUTPUT
           System.out.print("Case #" + (t+1) + ": ");
           if(impossible)
               System.out.println("IMPOSSIBLE");
           else{
               for(int j = 0; j < n; j++){
                   if(schedule[j] == 0)
                       System.out.print("C");
                   else
                       System.out.print("J");
               }
               System.out.println();
           }
       }
   } 
}