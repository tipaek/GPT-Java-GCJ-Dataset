import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int d = in.nextInt();
        for(int k = 1; k <= d; k++) {
            int N = in.nextInt();
            ArrayList<time> us = new ArrayList<>();
            ArrayList<time> s = new ArrayList<>();
            ArrayList<String> sa = new ArrayList<>();
            ArrayList<String> a = new ArrayList<>();
            for(int i = 0; i < N; i++){
                us.add(new time(in.nextInt(), in.nextInt()));
                s.add(us.get(i));
            }
            Collections.sort(s);
            int C = 0;
            int J = 0;
            boolean impossible = false;
            for(int i = 0; i < N; i++){
                time t = s.get(i);
                if(C<= t.start){
                    C = t.end;
                    sa.add("C");
                }
                else if(J<=t.start){
                    J = t.end;
                    sa.add("J");
                }
                else{
                    sa.clear();
                    a.add("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }
            for(int i = 0; i < N && !impossible; i++){
                time t = us.get(i);
                a.add(sa.get(s.indexOf(t)));
            }
            System.out.print("Case #"+k+":" + " ");
            for(int i = 0; i < a.size(); i++){
                System.out.print(a.get(i));
            }
            System.out.println();
        }
    }
    public static class time implements Comparable{
        int start;
        int end;
        public time(int s, int e){
            start = s;
            end = e;
        }
        public boolean equals(time t){
            return t.start == start && t.end == end;
        }
        @Override
        public int compareTo(Object o) {
            return start - ((time)o).start;
        }
    }
}