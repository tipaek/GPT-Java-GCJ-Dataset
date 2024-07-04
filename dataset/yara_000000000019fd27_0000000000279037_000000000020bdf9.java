import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static class Time2{
        int start;
        int end;
        int p;
        char out;

        public Time2(int start, int end, int p) {
            this.start = start;
            this.end = end;
            this.p = p;
//            this.out = out;
        }


        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getP() {
            return p;
        }

        public void setP(int p) {
            this.p = p;
        }

        public char getOut() {
            return out;
        }

        public void setOut(char out) {
            this.out = out;
        }
        
    }
    static class SortbyEnd implements Comparator<Time2> { 
        public int compare(Time2 a, Time2 b) { 
            return a.start - b.start; 
        } 
    } 
    static class SortbyPri implements Comparator<Time2> { 
        public int compare(Time2 a, Time2 b) { 
            return a.p - b.p; 
        } 
    } 
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int a=1; a<=T; a++){
            int N = s.nextInt();
            List<Time2> l = new ArrayList<>();
            for(int i=0; i<N; i++){
                int st = s.nextInt();
                int en = s.nextInt();
                Time2 t = new Time2(st,en,i);
                l.add(t);
            }
            System.out.println("Case #"+a+": "+assignAct(l));
        }
    }
    
    public static String assignAct(List<Time2> l){
            Collections.sort(l, new SortbyEnd());
//            char[] out = new char[N];
            l.get(0).out='C';
//            int cs=l.get(0).start;
            int ce=l.get(0).end;
  //          int js=0;
            int je=0;
            for(int i=1; i<l.size(); i++){
                if(l.get(i).start >= ce){
                    l.get(i).out='C';
                    ce=l.get(i).end;
                }else if(l.get(i).start < ce && l.get(i).start >= je){
                    l.get(i).out='J';
                    je=l.get(i).end;
                }else{
                    return "IMPOSSIBLE";
                }
            }
            Collections.sort(l, new SortbyPri());
            StringBuilder sb = new StringBuilder();
            for(Time2 t8 : l){
                sb.append(t8.out);
            }        
            return sb.toString();
    }

}
