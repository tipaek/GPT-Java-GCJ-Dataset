import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      
      int[][] intervals = new int[N][2];
      
      for(int j = 0; j < N; j++) {
          intervals[j][0] = in.nextInt();
          intervals[j][1] = in.nextInt();
      }
      
      Arrays.sort(intervals, (int[] a, int[] b) -> {
         if(a[0] == b[0])  {
             return a[1] - b[1];
         }
         return a[0] - b[0];
      });
      
      PriorityQueue<Person> queue = new PriorityQueue<>(2, (Person a, Person b) -> a.endTime-b.endTime);
      
      queue.add(new Person('C'));
      queue.add(new Person('J'));
      boolean possible = true;
      String answer = "";
      for(int n = 0; n < N; n++) {
          Person p = queue.poll();
          if(p.endTime > intervals[n][0]) {
              possible = false;
              break;
          }
          p.endTime = intervals[n][1];
          answer = answer + p.person;
          queue.add(p);
      }
      
      
      if(!possible) {
          System.out.println("Case #" + i + ": IMPOSSIBLE");
      } else {
          System.out.println("Case #" + i + ": " + answer);
      }
    }
  }
  
}

class Person {
    char person;
    int endTime;
    
    public Person(char person) {
        this.person = person;
    }
}