import java.util.*;
import java.lang.*; 
import java.io.*;
    class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          Activity[] a = new Activity[n];
          for (int j = 0; j < n; j++) {
            a[j] = new Activity(j, in.nextInt(), in.nextInt());
          }
          
          Arrays.sort(a, (a1, a2) -> {
            return a1.startTime - a2.startTime;
          });

          boolean selectedWorker = false;
          boolean impossible = false;
          a[0].assign(selectedWorker);
          Activity prev = a[0];
          for (int j = 1; j < n; j++) {
            Activity decision = overlapWithCurrent(a, j);
            if (decision == null) {
              // No Overlap
              a[j].assign(selectedWorker);
            } else if (decision instanceof Anomaly) {
              impossible = true;
              break;
            } else {
              if (decision.assigned == (selectedWorker ? 1 : 0)) {
                selectedWorker = !selectedWorker;
              }
              a[j].assign(selectedWorker);
            }
          }
          if (impossible) {
            System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            continue;
          }
          Arrays.sort(a, (a1, a2) -> {
            return a1.jobId - a2.jobId;
          });
          StringBuilder n2 = new StringBuilder("Case #" + i + ": "); 
          for (int j = 0; j < n; j++) {
            n2.append(a[j].assigned == 1 ? "J": "C");  
          }
          System.out.println(n2);
        }
      }

      static Activity overlapWithCurrent(Activity[] a, int index) {
        int overlapCount = 0;
        Activity ref = null;
        for (int i = index-1; i >= 0; i-- ) {
          if (a[i].isOverlap(a[index])) {
            overlapCount++;
            if (overlapCount > 1) {
              return new Anomaly();
            }
            ref = a[i];
            overlapCount++;            
          }
        }
        if (overlapCount == 0) {
          return null;
        } 
        return ref;
      }
    }

    class Activity {
      int startTime;
      int endTime;
      int jobId;
      int assigned = -1;

      Activity(int jobId, int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.jobId = jobId;
      }

      void assign(boolean worker) {
        this.assigned = worker ? 1 : 0;
      }

      void unassign() {
        this.assigned = -1;
      }

      boolean isOverlap(Activity a1) {
        return (
          (a1.startTime > this.startTime && a1.startTime < this.endTime)
          //||
          //(a1.endTime > this.startTime && a1.endTime < this.endTime)
        ) ? true : false;
      }
    }

    class Anomaly extends Activity {
      Anomaly() {
        super(-1, -1, -1);
      }
    }