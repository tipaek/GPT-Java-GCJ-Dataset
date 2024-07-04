import java.util.*;

public  class Solution{

        public static class Interval{
        public int start;
        public int end;
        Interval(int start,int end){
            this.start=start;
            this.end=end;}
         /*   @Override
           public int compareTo(Interval o) {
            return this.start==o.start?(this.end>o.end? 1: -1):(this.start>o.start?1:-1);
            }*/
            @Override
            public String  toString(){
                return start+" "+end;
            }
        }
    
    public static void main(String [] args){
         Scanner s = new Scanner(System.in); 
         int T= s.nextInt();
         Comparator<Interval> comp = new Comparator<Interval>() {
    @Override
    public int compare(Interval o1, Interval o2) {
        return o1.start==o2.start?(o1.end>o2.end? 1: -1):(o1.start>o2.start?1:-1);
    }
};
         for(int t=1;t<=T;t++){
             List<Interval> l= new ArrayList<>();
             int n= s.nextInt();
             for(int i=0;i<n;i++){
                 l.add(new Interval(s.nextInt(),s.nextInt()));
             }
             Collections.sort(l,comp);
             int endJ=0;int endC=0;
             StringBuilder sb= new StringBuilder();
             for(Interval i: l){
                 if(i.start>=endJ){
                     endJ=i.end;
                     sb.append("J");
                 }else if(i.start>=endC){
                     endC=i.end;
                      sb.append("C");
                 }else{
                     sb= new StringBuilder("IMPOSSIBLE");
                     break;
                     
                 }
             }
             System.out.println("Case #"+t+": "+sb.toString());
             
             
         }
    }
}