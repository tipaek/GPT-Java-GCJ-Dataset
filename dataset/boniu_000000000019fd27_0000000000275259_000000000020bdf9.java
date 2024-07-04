import java.util.Scanner;
import java.util.Vector;

public class Solution {
    public static int[][] activities;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            String s = "";
            int N = scanner.nextInt();
            activities = new int[N][2];
            for (int n = 0; n < N; n++) {
                activities[n][0] = scanner.nextInt();
                activities[n][1] = scanner.nextInt();
            }
            Vector<Integer> idxC = new Vector(), idxJ = new Vector();
            for (int i = 0; i < activities.length; i++) {
                if (!checkOverlap(idxC, activities[i][0], activities[i][1])) {
                    idxC.add(i);
                    s += "C";
                }else if(!checkOverlap(idxJ, activities[i][0], activities[i][1])){
                    idxJ.add(i);
                    s += "J";
                }else {
                    s = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println(String.format("Case #%d: %s", t, s));
        }
    }
    public static boolean checkOverlap(Vector<Integer> idxs, int start, int end){
        for (int i = 0; i < idxs.size(); i++) {
            if (start < activities[idxs.get(i)][1] && end > activities[idxs.get(i)][0]) {
                return true;
            }
        }
        return false;
    }
}
