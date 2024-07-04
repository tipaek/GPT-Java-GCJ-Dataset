import java.util.Arrays;
import java.util.Scanner;

class Solution{

    static class Pair implements Comparable<Pair>{
        Integer s;
        Integer e;
        Pair(int s,int e){
            this.s = s;
            this.e = e;
        }
        public int compareTo(Pair s2){
            return e.compareTo(s2.e);
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
            for (int j = 0; j < r; j++) {
                int st = sc.nextInt();
                int end = sc.nextInt();
                time[j] = new Pair(st, end);
            }
            Arrays.sort(time);
            for (int j = 0; j < r; j++) {
                if (endJ <= time[j].s) {
                        endJ = time[j].e;
                        res += "J";
                    } else {
                        if (endC <= time[j].s) {
                            endC = time[j].e;
                            res += "C";
                        } else {
                            res = "IMPOSSIBLE";
                            break;
                        }
                    }
                }
            System.out.println("Case #"+i+": "+res);
        }
    }
}