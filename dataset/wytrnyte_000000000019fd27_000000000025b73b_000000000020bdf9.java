import java.util.*;



public class Solution{
    public static class Range{
      int low;
      int high;
      char who;
      public Range(int low, int high, char who){
          this.low = low;
          this.high = high-1;//[low, high)
          this.who = who;
          }

      public boolean inRange(int begin, int end){
          return ((begin >= low && begin <= high) || (end >= low && end <= high));
      }

      // public String toString(){
      //   return low+" "+high+" "+who;
      // }
    }
     
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int tr = sc.nextInt();
        for(int i=1;i<=tr;++i){
            int actNum = sc.nextInt();
            List<Range> time = new ArrayList<Range>();
            // List<Character> time = new ArrayList<Character>(1440);
            // char[] time = new char[1440];
            // char[] actRes = new char[actNum];
            // for(int j=1440;j!=0;--j)
            //   time.add('N');
            // Arrays.fill(time,'N');
            boolean impossible = false;
            for(int j=0;j<actNum;++j){
                int begin = sc.nextInt();
                int end = sc.nextInt();
                boolean canCameron = true;
                boolean canJamie = true;
                int k=0;
                while(k<time.size()){
                    Range r = time.get(k);
                    // System.out.println(r);
                    if(r.inRange(begin, end) == true){
                      if(r.who == 'C') canCameron = false;
                      else if(r.who == 'J') canJamie = false;
                    }
                    if(!canCameron && !canJamie) break;
                    ++k;
                }//findout who can be resposible

                if(canCameron)
                  time.add(new Range(begin, end, 'C'));
                else{
                  if(canJamie) time.add(new Range(begin, end, 'J'));
                  else impossible = true;
                }
                // for(int k=begin;k<end;++k){
                //     if(canCameron) time.set(k, 'C');
                //     else{
                //       if(canJamie) time.set(k, 'J');
                //       else impossible = true;
                //     }
                // }//update time array

                if(impossible){
                  System.out.println("Case #"+i+": "+"IMPOSSIBLE");
                  break;
                }
                // for(int x=0;x<time.size();++x)
                //   System.out.print(time.get(x).who);

                // if(canCameron) actRes[j] = 'C';
                // else actRes[j] = 'J';
            }//end of j loop: for each activity
            if(impossible) continue;
            System.out.print("Case #"+i+": ");
            for(int j=0;j<time.size();++j)
                System.out.print(time.get(j).who);
            System.out.println();
        }   
    
        sc.close();
    }
}