import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
        public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int cases = read.nextInt();
        int act = 1;
        while (act <= cases) {
            int N = read.nextInt();
            List<Values> arr = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                arr.add(new Values(read.nextInt(), read.nextInt(),i));
            }
            System.out.println("Case #" + (act) + ": " + solve(arr,N));
            act++;
        }
        read.close();
    }

    public static String solve(List<Values> arr,  int N) {
        arr.sort((Values v1, Values v2)->v1.getStart()-v2.getStart());
        String sol[] = new String[N];
        List<Values> c = new LinkedList<>();
        List<Values> j = new LinkedList<>();
        for (int i = 0; i < arr.size(); i++) {
            if(c.size() == 0){
                c.add(arr.get(i));
                sol[arr.get(i).getPos()] = "C";
            }else if(j.size() == 0){
                j.add(arr.get(i));
                sol[arr.get(i).getPos()] = "J";
            }else{
                int actStart = arr.get(i).getStart();
                if(c.size() != 0 && actStart >= c.get(c.size()-1).getEnd()){
                    c.add(arr.get(i));
                    sol[arr.get(i).getPos()] = "C";
                }else if(j.size() != 0 && actStart >= j.get(c.size()-1).getEnd()){
                    j.add(arr.get(i));
                    sol[arr.get(i).getPos()] = "J";
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
        int start;
        int end;
        int pos;
        Values(int start, int end,int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
        public int getStart(){
            return this.start;
        }
        public int getEnd(){
            return this.end;
        }
        public int getPos(){
            return this.pos;
        }
    }
}