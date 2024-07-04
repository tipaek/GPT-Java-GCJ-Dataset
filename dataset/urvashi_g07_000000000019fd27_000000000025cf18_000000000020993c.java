import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);
        int T = scrn.nextInt();
        int k=1;
        while (T > 0) {
            int N = scrn.nextInt();
            int[][] A = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    A[i][j] = scrn.nextInt();
                }
            }
            int calcTrace = 0;
            for (int i = 0; i < N; i++) {
                calcTrace += A[i][i];
            }
            int calcrowrepeats = 0;
            int calccolrepeats = 0;
            for (int i = 0; i < N; i++) {
                HashMap<Integer, Boolean> map = new HashMap<>();
                for (int j = 0; j < N; j++) {
                    if (!map.containsKey(A[i][j])) {
                        map.put(A[i][j], true);
                    } else {
                        calcrowrepeats += 1;
                        break;
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                HashMap<Integer, Boolean> map = new HashMap<>();
                for (int i = 0; i < N; i++) {
                    if (!map.containsKey(A[i][j])) {
                        map.put(A[i][j], true);
                    } else {
                        calccolrepeats += 1;
                        break;
                    }
                }
            }
            System.out.println("Case #"+k+": "+calcTrace + " " + calcrowrepeats + " " + calccolrepeats);
            k++;
            T--;
        }

    }
}