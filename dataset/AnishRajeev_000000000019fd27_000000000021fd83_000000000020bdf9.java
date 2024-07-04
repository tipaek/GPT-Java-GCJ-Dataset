import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int testcases = 1; testcases <= T; testcases++) {
            int N = scanner.nextInt();
            ArrayList<time> unsorted = new ArrayList<>();
            ArrayList<time> sorted = new ArrayList<>();
            ArrayList<String> sortedanswer = new ArrayList<>();
            ArrayList<String> answer = new ArrayList<>();
            for(int i = 0; i < N; i++){
                unsorted.add(new time(scanner.nextInt(), scanner.nextInt()));
                sorted.add(unsorted.get(i));
            }
            Collections.sort(sorted);
            int C = 0;
            int J = 0;
            boolean impossible = false;
            for(int i = 0; i < N; i++){
                time t = sorted.get(i);
                if(C<= t.start){
                    C = t.end;
                    sortedanswer.add("C");
                }
                else if(J<=t.start){
                    J = t.end;
                    sortedanswer.add("J");
                }
                else{
                    sortedanswer.clear();
                    answer.add("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }
            for(int i = 0; i < N && !impossible; i++){
                time t = unsorted.get(i);
                answer.add(sortedanswer.get(sorted.indexOf(t)));
            }
            System.out.print("Case #"+testcases+":" + " ");
            for(int i = 0; i < answer.size(); i++){
                System.out.print(answer.get(i));
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
