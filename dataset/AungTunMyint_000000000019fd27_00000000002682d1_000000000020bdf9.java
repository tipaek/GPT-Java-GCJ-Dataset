

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

        int count = 0;
        for ( int i = 0; i < table.length; ++i) {

            int s1 = table[i].start;
            int e1 = table[i].end;

            count = 0;
            HashSet<Integer> set = new HashSet<>();

            set.add(e1);
            for ( int j = i + 1; j < table.length; ++j) {

                int s2 = table[j].start;
                int e2 = table[j].end;

                if ( e2 >= s1 && e2 < e1 && ! set.contains(s2) ) ++count;

                if ( set.contains(s2) ) {
                    set.remove(s2);
                }

                set.add(e2);
            }
            if ( count >= 2 ) return false;
            set.clear();
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