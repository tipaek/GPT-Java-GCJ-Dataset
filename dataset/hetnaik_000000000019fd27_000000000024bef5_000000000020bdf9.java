
import java.util.*;

public class Main {
    private static Scanner sc;
    static int ts = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();

        int[][] het = new int[n][2];
        int[][] mS = het.clone();
        char per = 'J';
        char[] chars = new char[n];
        Stack<int[]> JSt = new Stack<>();
        Stack<int[]> CSt = new Stack<>();
        boolean imp = false;
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < het.length; i++) {
            for (int j = 0; j < het[i].length; j++) {
                het[i][j] = sc.nextInt();
            }

            map.put(het[i], i);
        }
        Arrays.sort(mS, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < mS.length; i++) {
            chars[map.get(mS[i])] = per;
            if (i < mS.length - 1 && overlappingFunc(mS[i], mS[i + 1])) {
                if (per == 'J') {
                    JSt.push(mS[i]);
                    per = getPer(per);

                    if (!CSt.isEmpty() && overlappingFunc(CSt.peek(), mS[i + 1])) {
                        imp = true;
                        break;
                    }
                } else {

                    CSt.push(mS[i]);
                    per = getPer(per);

                    if (!JSt.isEmpty() && overlappingFunc(JSt.peek(), mS[i+1])) {
                        imp = true;
                        break;
                    }

                }
            } else {
                if (per == 'J') {
                    JSt.push((mS[i]));
                } else {
                    CSt.push((mS[i]));
                }
            }
        }
        System.out.println("Case #"+(ts++)+": "+( imp ?"IMPOSSIBLE": new String(chars)));

    }


    private static char getPer(char p) {
        return p == 'J' ? 'C' : 'J';
    }

    private static boolean overlappingFunc(int[] a, int[] b) {
        return a[1] > b[0];
    }
}

