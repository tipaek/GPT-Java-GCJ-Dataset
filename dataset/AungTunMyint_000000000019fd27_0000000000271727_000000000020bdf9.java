

import java.util.*;
import java.io.*;


class Interval {
    int start;
    int end;

    Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }
}
public class Solution {


    static boolean isValid(Interval[] table) {

        for ( int i = 1; i < table.length; ++i) {

            int curStart = table[i].start;
            int curEnd = table[i].end;

            int overlap = 0;
            for ( int j = i - 1; j >= 0; --j) {

                int start = table[j].start;
                int end = table[j].end;

                if ( curStart == start ) {
                    overlap++;
                    //System.out.println("CurStart == start " + start);
                }
                if ( end == curStart ) {
                    
                    //System.out.println("CurStart == end " + end);
                    continue;
                }
                if ( curEnd == start) {
                    
                    //System.out.println("curend == start " + start);
                    continue;
                }

                if ( curStart > start && curStart < end) {
                    //System.out.println("curstart in range " + curStart);
                    overlap++;
                }
                else if ( curEnd < end && curEnd > start) {
                  //  System.out.println("Curend in range " + curEnd);
                    overlap++;
                }
            }

            if ( overlap >= 2 ) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tc = Integer.parseInt(sc.nextLine());

        for (int t = 1; t <= tc; ++t) {

            int N = Integer.parseInt(sc.nextLine());

            Interval[] table = new Interval[N];
            for ( int i = 0; i < N; ++i ) {    
                int start = Integer.parseInt(sc.next());
                int end = Integer.parseInt(sc.next());
                
                Interval obj = new Interval(start, end);
                table[i] = obj;
            }
            sc.nextLine();

            if ( ! isValid(table) ) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            }else {

                StringBuilder sb = new StringBuilder();

                sb.append("J");
                char cur = 'J';
                int preEnd = table[0].end;
                
                for ( int i = 1; i < table.length; ++i) {

                    int curStart = table[i].start;
                    
                    if ( curStart < preEnd ) {
                        cur = cur == 'C' ? 'J' : 'C';
                    }
                    sb.append(cur);
                     
                    preEnd = table[i].end;
                }
                System.out.printf("Case #%d: %s\n", t,sb.toString());
            }
        }


        sc.close();
    }
}