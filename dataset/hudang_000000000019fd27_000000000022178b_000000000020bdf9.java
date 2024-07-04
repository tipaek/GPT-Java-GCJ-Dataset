import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        int n, s, e;
        int[] chk = new int [2];
        StringBuffer rtn;
        Act now;
        PriorityQueue<Act> que = new PriorityQueue<>();

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            rtn = new StringBuffer();
            que.clear();
            chk[0] = chk[1] = 0;

            n = in.nextInt();
            for(int j = 0 ; j < n ; j++){
                s = in.nextInt();
                e = in.nextInt();
                que.add(new Act(s, e));
            }

            while(!que.isEmpty()){
                now = que.poll();
                if(chk[0] <= chk[1]){
                    if(chk[0] <= now.start){
                        chk[0] = now.end;
                        rtn.append('C');
                    }else break;
                }else{
                    if(chk[1] <= now.start){
                        chk[1] = now.end;
                        rtn.append('J');
                    }else break;
                }
            }
            String result;
            if(rtn.length() == n) result = rtn.toString();
            else result = "IMPOSSIBLE";

            System.out.println("Case #" + i + ": " + result);
        }
    }
}

class Act implements Comparable{
    int start, end;

    public Act(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Object o) {
        return this.start - ((Act) o).start;
    }
}