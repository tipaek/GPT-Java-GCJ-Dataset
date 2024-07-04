
import java.util.*;
import java.io.*;

public class Solution {

    private static final int[][] data = new int[100][100];
    static int N;
    private static Set<Integer> uniq = new HashSet<>(200);

    public static void main(String[] args) {
        main(System.in);
    }

    public static void main(InputStream is) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int t = in.nextInt();
        for (int run = 1; run <= t; ++run) {
            int dutiesN = in.nextInt();
            List<Duty> duties= new ArrayList<>();
            for(int i =1;i<=dutiesN;i++) {
                Duty duty = new Duty();
                duty.start=in.nextInt();
                duty.end=in.nextInt();
                duties.add(duty);
            }
            List<Duty> sorted = new ArrayList<>(duties);
            sorted.sort((d1, d2) -> d1.start.compareTo(d2.start));
            int j=0;
            int c=0;
            boolean fail = false;
            for (Duty duty : sorted) {
                 if (c<=duty.start) {
                    duty.result="C";
                    c=duty.end;
                    continue;
                }
                if (j<=duty.start) {
                    duty.result="J";
                    j=duty.end;
                    continue;
                }
                fail = true;
                break;
            }
            if (fail) {
                System.out.println("Case #" + run + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (Duty duty : duties) {
                    result.append(duty.result);
                }
                System.out.println("Case #" + run + ": " + result.toString());
            }
            //in.nextLine();
        }
    }
    
    static class Duty {
        Integer start;
        Integer end;
        String result;
    }


}
