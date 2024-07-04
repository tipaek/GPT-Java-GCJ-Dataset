import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            int N = in.nextInt();
            Shift[] shifts = new Shift[N];
            int[] ints = new int[24*60+1];
            for(int j=0; j<N; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                for(int k=start; k<end; k++) {
                    ints[k]++;
                }
                Shift shift = new Shift(start, end);
                shifts[j] = shift;
            }
            boolean istrue = false;
            for(int j=0; j<24*60; j++) {
                if(ints[j]>2) {
                    istrue = true;
                    break;
                }
            }
            if(istrue==true) {
                System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
            }
            else {
                Arrays.sort(shifts, (x1, x2) -> x1.start < x2.start ? -1 : 1);
                int end = -1;
                char ch = 'J';
                String str = "";
                for(int j=0; j<N; j++) {
                    if(shifts[j].end<end) {
                        if(ch == 'J') {
                            str = str + 'C';
                        }
                        else {
                            str = str + 'J';
                        }
                    }
                    else {
                        if(ch == 'J') {
                            str = str + 'C';
                        }
                        else {
                            str = str + 'J';
                        }
                        if(ch == 'J') {
                            ch = 'C';
                        }
                        else {
                            ch = 'J';
                        }
                    }
                    end = Math.max(end,  shifts[j].end);
                }
                System.out.println("Case #" + (i+1) + ": " + str);
            }
        }
    }
    static class Shift {
        public int start;
        public int end;
        Shift(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
