import java.util.*;

class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int T=1; T<=tc; T++){
            int n = sc.nextInt();
            char[] assign = new char[n];
            ArrayList<Task> t = new ArrayList<>();
            for(int i=0; i<n; i++) 
                t.add(new Task(sc.nextInt(), sc.nextInt(), i));
            Collections.sort(t);
            int cAvail = -1, jAvail = -1;
            boolean fail = false;
            for(Task cur : t){
                if(cur.start>=cAvail){
                    cAvail = cur.end;
                    assign[cur.idx] = 'C';
                } else if(cur.start>=jAvail){
                    jAvail = cur.end;
                    assign[cur.idx] = 'J';
                } else {
                    fail = true;
                    break;
                }
            }
            System.out.print("Case #"+T+": ");
            if(fail) System.out.println("IMPOSSIBLE");
            else System.out.println(assign);
        }
    }
    
    static class Task implements Comparable<Task>{
        int start, end, idx;
        
        Task(int a, int b, int c){
            start = a;
            end = b;
            idx = c;
        }
        
        public int compareTo(Task o){
            if(start==o.start) return end-o.end;
            return start-o.start;
        }
    }
}