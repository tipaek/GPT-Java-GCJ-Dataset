import java.util.*;

public class Solution {
    Scanner sc = new Scanner(System.in);

    void run(){
        int tests = sc.nextInt();

        for( int t = 0; t < tests; t++){
            solve(t);
        }
    }

    void solve(int y){
        int x = y + 1;
        int N = sc.nextInt();
        char[] out = new char[N];
        boolean possible = true;
        ArrayList<task> tasks = new ArrayList<>();
        int cEnd = 0;
        int jEnd = 0;


        for (int i = 0; i < N; i++) {
            tasks.add(new task(sc.nextInt(), sc.nextInt(), i));
        }

        tasks.sort((o1, o2) -> (o1.start) - (o2.start));

        for (task t : tasks) {
            if (t.start >= cEnd) {
                cEnd = t.end;
                out[t.index] = 'C';
            } else if (t.start >= jEnd) {
                jEnd = t.end;
                out[t.index] = 'J';
            } else {
                possible = false;
                break;
            }
        }



        if (possible) {
            System.out.println("Case #" + x +": " + new String(out));
        } else {
            System.out.println("Case #" + x +": IMPOSSIBLE");
        }
    }

    private class task {
        int start;
        int end;
        int index;

        public task(int s, int e, int i) {
            start = s;
            end = e;
            index = i;
        }
    }

    public static void main(String[] args){
        (new Solution()).run();
    }
}
