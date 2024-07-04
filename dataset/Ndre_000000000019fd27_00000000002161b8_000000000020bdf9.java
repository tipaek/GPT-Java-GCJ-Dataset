import java.util.Arrays;
import java.util.Scanner;

class Solution{

    static class Pair implements Comparable<Pair>{
        Integer s;
        Integer e;
        int p;
        Pair(int s,int e, int p){
            this.s = s;
            this.e = e;
            this.p = p;
        }
        public int compareTo(Pair s2){
            return s.compareTo(s2.s);
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1;i<=t;i++) {
            int r = sc.nextInt();
            int endJ = 0;
            int endC = 0;
            String res = "";
            Pair[] time = new Pair[r];
            String[] ress = new String[r];
            for (int j = 0; j < r; j++) {
                int st = sc.nextInt();
                int end = sc.nextInt();
                time[j] = new Pair(st, end,j);
            }
            Arrays.sort(time);
            for (int j = 0; j < r; j++) {
                System.out.println(time[j].s + " " + time[j].e);
            }
            for (int j = 0; j < r; j++) {
                if (endJ <= time[j].s) {
                        endJ = time[j].e;
                        ress[time[j].p] = "J";
                    } else {
                        if (endC <= time[j].s) {
                            endC = time[j].e;
                            ress[time[j].p] = "C";
                        } else {
                            res = "IMPOSSIBLE";
                            break;
                        }
                    }
                }
            if(!res.equals("IMPOSSIBLE")){
                for(int h=0;h<r;h++) res+=ress[h];
            }
            System.out.println("Case #"+i+": "+res);
        }
    }
}