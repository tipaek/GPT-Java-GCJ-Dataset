import java.util.*;

public class Main{
    public static class Range{
      int low;
      int high;
      int x;
      public Range(int low, int high, int x){
          this.low = low;
          this.high = high;//[low, high)
          this.x = x;
      }

      // public boolean inRange(int begin, int end){
      //     return ((begin >= low && begin <= high) || (end >= low && end <= high));
      // }
    }
    
    public static class RangeComparator implements Comparator<Range> {
    @Override
    public int compare(Range r1, Range r2) {
        if (r1.low != r2.low) {
            return r1.low - r2.low;
        } else if(r1.high != r2.high){
          return r1.high - r2.high;
        } else return r1.x - r2.x;
    }
  }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int tr = sc.nextInt();
        
        for(int i=1;i<=tr;++i){
            int actNum = sc.nextInt();
            Comparator<Range> comparator = new RangeComparator();
            PriorityQueue<Range> time = new PriorityQueue<Range>(actNum, comparator);
            // Queue<Range> time = new LinkedList<>();
            int[] comp = {0,0};
            char[] res = new char[actNum];
            boolean impossible = false;
            for(int j=0;j<actNum;++j){
                int begin = sc.nextInt();
                int end = sc.nextInt();
                time.add(new Range(begin, end, j));
            }
            while(!time.isEmpty()){
               Range r = time.poll();
              //  System.out.println(comp[0]+" "+comp[1]+" "+r.low+" "+r.high+" "+r.x);
               if(r.low>=comp[0]){
                 res[r.x] = 'C';
                 comp[0] = r.high;
               } else if(r.low>=comp[1]){
                 res[r.x] = 'J';
                 comp[1] = r.high;
               } else{
                 impossible = true;
                 break;
               }
            }
            System.out.print("Case #"+i+": ");
            if(!impossible){
              for(char val: res)
                System.out.print(val);
              System.out.println();
            }
            else
              System.out.println("IMPOSSIBLE");  
            }
            
            
            sc.close();
        }   
}