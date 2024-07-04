import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            Pair[][] events = new Pair[N][2];
            System.out.print("Case #" + (i + 1) + ": ");
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                events[j][0] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                events[j][1] = new Pair(j, 0);
            }
            Arrays.sort(events, new Comparator<Pair[]>() {
                @Override
                public int compare(Pair[] pair1, Pair[] pair2) {
                    return Integer.compare(pair1[0].start, pair2[0].start);
                }
            });
            int CameronEnd = 0;
            int JamieEnd = 0;
            char[] answer = new char[N];
            boolean flag = true;
            for (int j = 0; j < N; j++) {
                if(events[j][0].start >= CameronEnd) {
                    answer[events[j][1].start] = 'C';
                    CameronEnd = events[j][0].end;
                }
                else if(events[j][0].start >= JamieEnd) {
                    answer[events[j][1].start] = 'J';
                    JamieEnd = events[j][0].end;
                }
                else {
                    flag = false;
                    System.out.println("IMPOSSIBLE");
                    break;
                }
            }
            if(flag)
                System.out.println(new String(answer));
        }

    }
}
class Pair {

    int start;
    int end;

    public Pair(Integer s, Integer e) {
        this.start = s;
        this.end = e;
    }
}
