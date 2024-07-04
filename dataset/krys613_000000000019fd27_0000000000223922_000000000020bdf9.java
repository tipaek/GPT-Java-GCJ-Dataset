import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int x = 1; x <= T; x++){
            //init
            ArrayList<task> C = new ArrayList<task>();
            ArrayList<task> J = new ArrayList<task>();
            ArrayList<task> tasks = new ArrayList<task>();
            StringBuilder sb = new StringBuilder();
            boolean ans = true;
            //input 
            int N = sc.nextInt();
            for(int i = 0; i < N; i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                task t = new task(i, start, end, "C");
                tasks.add(t);
            }
            //process
            Collections.sort(tasks);
            for(int i = 0; i < N; i++){
                task cur = tasks.get(i);
                if(C.size() == 0 || cur.start >= C.get(C.size() - 1).end){
                    cur.point = "C";
                    C.add(cur);
                }else if(J.size() == 0 || cur.start >= J.get(J.size() - 1).end){
                    cur.point = "J";
                    J.add(cur);
                }else{
                    ans = false;
                    break;
                }
            }
            //output
            if(!ans) System.out.println("case #" + x + ": IMPOSSIBLE");
            else{
                for(int i = 0; i < N; i++){
                    sb.append(tasks.get(i).point);
                }
                System.out.println("case #" + x + ": " + sb.toString());
            }
        }
    }
}

class task implements Comparable{
    int id;
    int start;
    int end;
    String point;
    public task(int id, int start, int end, String point){
        this.id = id;
        this.start = start;
        this.end = end;
        this.point = point;
    }

    @Override
    public int compareTo(Object o) {
        task cmp = (task) o;
        return this.start != cmp.start ? this.start - cmp.start : this.end - cmp.end;
    }
}