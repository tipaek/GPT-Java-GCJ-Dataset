

import java.util.*;
class Time implements Comparable{
    public int start, end, pos;
    public Time(int start, int end, int pos) {
        this.end = end;
        this.start = start;
        this.pos = pos;
    }

    @Override
    public int compareTo(Object o) {
        return this.start - ((Time)o).start;
    }

    @Override
    public String toString() {
        return this.start + " " + this.end;
    }


};
public class Solution {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int test  = scn.nextInt(), n, x, y, free_J, free_C, end1, end2, ok;
        List<Time> vl = new ArrayList<Time>();
        char ans[] = new char[1001];
        String fin;
        for(int k = 0; k < test; k++) {
            n = scn.nextInt();
            vl.clear();
            ok = 0;
            for(int j = 0; j < n; j++) {
                x = scn.nextInt();
                y = scn.nextInt();
                vl.add(new Time(x, y, j));
            }
            Collections.sort(vl);
            free_C = 1;
            free_J = 1;
            end1 = 0;
            end2 = 0;

            for(int j = 0; j < n; j++) {
                if(vl.get(j).start >= end1) {
                    free_C = 1;
                }
                if(vl.get(j).start >= end2) {
                    free_J = 1;
                }
                if(free_C == 1) {
                    free_C = 0;
                    end1 = vl.get(j).end;
                    ans[vl.get(j).pos] = 'C';
                } else if(free_J == 1) {
                    free_J = 0;
                    end2 = vl.get(j).end;
                    ans[vl.get(j).pos] = 'J';
                } else {
                    ok = 1;
                    break;
                }
            }
            if(ok == 1) {
                System.out.println("CASE #" + (k + 1) + ": " + "IMPOSSIBLE");
            } else {
                fin = "";
                for(int j = 0; j < n; j++) {
                    fin += ans[j];
                }
                System.out.println("CASE #" + (k + 1) + ": " + fin);
            }




        }
    }
}