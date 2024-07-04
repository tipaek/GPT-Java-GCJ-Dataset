import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
        public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int cases = read.nextInt();
        int act = 1;
        while (act <= cases) {
            int N = read.nextInt();
            List<Values> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(new Values(read.nextInt(), read.nextInt(),i));
            }
            System.out.println("Case #" + (act) + ": " + solve(arr,N));
            act++;
        }
        read.close();
    }

    public static String solve(  List<Values> arr,  int N) {
        Collections.sort(arr);
        String sol[] = new String[N];
        Arrays.fill(sol, "");
        List<Values> c = new ArrayList<>();
        List<Values> j = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if(c.size() == 0){
                c.add(arr.get(i));
                sol[arr.get(i).pos] = "C";
            }else if(j.size() == 0){
                j.add(arr.get(i));
                sol[arr.get(i).pos] = "J";
            }else{
                int actStart = arr.get(i).start;
                if(actStart >= c.get(c.size()-1).end){
                    c.add(arr.get(i));
                    sol[arr.get(i).pos] = "C";
                }else if(actStart >= j.get(c.size()-1).end){
                    j.add(arr.get(i));
                    sol[arr.get(i).pos] = "J";
                }else{
                    return "IMPOSSIBLE";
                }
            }
        }
        String s = "";
        for(int i = 0; i < N; i++){
            s+= sol[i];
        }
        return s;
    }

    static class Values implements Comparable<Values> {
        Integer start;
        Integer end;
        Integer pos;
        Values(Integer start, Integer end,Integer pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }

        @Override
        public int compareTo(Values v) {
            return this.start.compareTo(v.start);
        }
    }
}