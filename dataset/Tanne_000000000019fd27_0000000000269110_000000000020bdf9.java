import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // initiating the base variables
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            String y = "";
            int jam = 0;
            int cam = 0;
            int n = scan.nextInt();
            boolean poss = true;
            int[][] sced = new int[n][4];
            for (int j = 0; j < n; j++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                sced[j][0] = start;
                sced[j][1] = end;
                sced[j][3] = j;
            }
            //int[][] cop = Arrays.copyOf(sced,n);
            Arrays.sort(sced, (a,b) -> Double.compare(a[0], b[0]));

            for (int j = 0; j < n; j++) {
                int start = sced[j][0];
                int end = sced[j][1];
                if (start >= cam) {
                    cam = end;
                    sced[j][2]=1;
                } else if (start >= jam) {
                    jam = end;
                    sced[j][2]=2;
                } else {
                    poss = false;
                }
            }
            if (!poss){
                y = "IMPOSSIBLE";
            } else {
                Arrays.sort(sced, (a,b) -> Double.compare(a[3], b[3]));
                for (int j = 0; j < n; j++){
                    if(sced[j][2]==1){
                        y+="C";
                    } else {
                        y+="J";
                    }
                }
            }
            System.out.println("Case #" + i + ": " + y);
        }
    }
}
