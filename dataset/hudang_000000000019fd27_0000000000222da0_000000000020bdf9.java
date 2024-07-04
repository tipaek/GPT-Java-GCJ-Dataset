import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        int n, s, e;
        int[] chk = new int [2];
        char[] rtn;
        Act now;
        PriorityQueue<Act> que = new PriorityQueue<>();

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            que.clear();
            chk[0] = chk[1] = 0;
            n = in.nextInt();
            rtn = new char[n];

            for(int j = 0 ; j < n ; j++){
                s = in.nextInt();
                e = in.nextInt();
                que.add(new Act(j, s, e));
            }

            while(!que.isEmpty()){
                now = que.poll();
                if(chk[0] >= chk[1]){
                    if(chk[0] <= now.start){
                        chk[0] = now.end;
                        rtn[now.index] = 'C';
                    }else{
                        if(chk[1] <= now.start){
                            chk[1] = now.end;
                            rtn[now.index] = 'J';
                        }
                    }
                }else{
                    if(chk[1] <= now.start){
                        chk[1] = now.end;
                        rtn[now.index] = 'J';
                    }else{
                        if(chk[0] <= now.start){
                            chk[0] = now.end;
                            rtn[now.index] = 'C';
                        }
                    }
                }
            }
            StringBuffer result = new StringBuffer();
            for(int x = 0 ; x < n ; x++){
                if(rtn[x] != 'C' && rtn[x] != 'J'){
                    result = new StringBuffer("IMPOSSIBLE");
                    break;
                }else{
                    result.append(rtn[x]);
                }
            }


            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}

class Act implements Comparable{
    int index, start, end;

    public Act(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Object o) {
        return this.start - ((Act) o).start;
    }
}