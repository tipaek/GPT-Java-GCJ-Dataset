import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
       forloop: for (int ii = 1; ii <= t; ii++) {
              int N = Integer.parseInt(s.nextLine());
              Interval[] in = new Interval[N];
              for(int i=0; i < N; i++){
                  String[] d = s.nextLine().split(" ");
                  in[i] = new Interval();
                  in[i].pos = i+1;
                  in[i].start = Integer.parseInt(d[0]);
                  in[i].end = Integer.parseInt(d[1]);
              }

              Arrays.sort(in);
              char[] res = new char[N];
              res[in[0].pos-1] = 'J';
              int prevJ = in[0].end;
              int prevC = 0;
              for(int i=1; i < N; i++){
                  if (in[i-1].end > in[i].start && res[in[i-1].pos - 1] == 'J'){
                      if (prevC > in[i].start){
                          System.out.println("Case #" +  ii + ": " + "IMPOSSIBLE");
                          continue forloop;
                      }
                      else {
                          res[in[i].pos - 1] = 'C';
                          prevC = in[i].end;
                      }
                  }
                  if (in[i-1].end > in[i].start && res[in[i-1].pos - 1] == 'C'){
                      if (prevJ > in[i].start){
                          System.out.println("Case #" +  ii + ": " + "IMPOSSIBLE");
                          continue forloop;
                      }
                      else {
                          res[in[i].pos - 1] = 'J';
                          prevJ = in[i].end;
                      }
                  }
                  if (in[i-1].end <= in[i].start && res[in[i-1].pos - 1] == 'J'){
                      res[in[i].pos - 1] = 'J';
                      prevJ = in[i].end;
                  }
                  if (in[i-1].end <= in[i].start && res[in[i-1].pos - 1] == 'C'){
                      res[in[i].pos - 1] = 'C';
                      prevC = in[i].end;
                  }
              }
              String res1 = new String(res);
            System.out.println("Case #" +  ii + ": " + res1);
        }
    }
    static class Interval implements Comparable<Interval>{
        int pos;
        int start;
        int end;

        public int compareTo(Interval in){
            return this.start - in.start;
        }
    }
}
