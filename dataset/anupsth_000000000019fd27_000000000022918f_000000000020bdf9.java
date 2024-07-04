import java.util.Scanner;
import java.util.*;

public class Solution {
    public static void main(String args[]) {
         Scanner input = new Scanner(System.in);
         int T = input.nextInt();
         for (int ks = 1; ks <= T; ks++) {
              int N = input.nextInt();
              List<Pair> pairs = new ArrayList<>(N);
              for(int i=0;i<N;i++){
                int start = input.nextInt();
                int end = input.nextInt();
                pairs.add(new Pair(i,start,end));
              }
              Collections.sort(pairs);
              int cEnd = -1;
              int jEnd = -1;
              boolean impossible = false;
              final List<Tasker> taskers = new ArrayList<>();
              for(int i=0;i<N;i++){
                  final Pair currentPair = pairs.get(i);
                  if(cEnd<=currentPair.start){
                    cEnd = currentPair.end;
                    taskers.add(new Tasker(currentPair.index,'C'));
                  }else if(jEnd<=currentPair.start){
                      jEnd = currentPair.end;
                      taskers.add(new Tasker(currentPair.index,'J'));
                  }else{
                      impossible =true;
                      break;
                  }
                  
              }
            
            if(impossible){
                System.out.println("Case #"+ks+": IMPOSSIBLE");
            }else{
             Collections.sort(taskers);
             StringBuffer sb = new StringBuffer(N);
             for(Tasker t:taskers){
                 sb.append(t.who);
             }
            System.out.println("Case #"+ks+": "+sb.toString());
            }
        }
    }
  
}
  class Tasker implements Comparable<Tasker>{
        int index;
        char who;
        public Tasker(int i,char w){
            this.index = i;
            this.who = w;
        }
        public int compareTo(Tasker another){
            return Integer.compare(this.index,another.index);
        }
        
    }
    class Pair implements Comparable<Pair>{
        int index,start,end;
        public Pair(int i,int s,int e){
            this.index = i;
            this.start = s;
            this.end = e;
        }
        
        public int compareTo(Pair another){
            return Integer.compare(this.start,another.start);
        }
        
    }