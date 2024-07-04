import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
public class Solution {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); 
      int num= sc.nextInt();
      int x=1;
      while(x<=num) {
          Person c = new Person();
          Person j = new Person();
          int input = sc.nextInt();
          List<int[]> acts = new ArrayList<>();
          for (int i = 0; i < input; i++) {
              int start = sc.nextInt();
              int end = sc.nextInt();
              acts.add(new int[]{start, end, i});
          }
          Collections.sort(acts, Comparator.comparing(p -> p[0]));
          StringBuilder result = new StringBuilder(acts.size());
          for (int i = 0; i < acts.size(); i++) {
              result.append('C');
          }
          for (int[] act : acts) {
              if (c.free || (!c.free && act[0] >= c.end)) {
                  result.setCharAt(act[2], 'C');
                  c.assign(act[0], act[1]);
              } else if (j.free || (!j.free && act[0] >= j.end)) {
                  result.setCharAt(act[2], 'J');
                  j.assign(act[0], act[1]);
              } else {
                  result = new StringBuilder();
                  result.append("IMPOSSIBLE");
                  break;
              }
          }
          
          System.out.println(" case #"+(x)+": " + result.toString());
          x++;
      }
   }
   public static class Person {
        int start;
        int end;
        boolean free;
        public Person() {
            free();
        }
        public void assign(int start, int end) {
            this.start = start;
            this.end = end;
            free = false;
        }
        public void free() {
            free = true;
            start = -1;
            end = -1;
        }
   }
}