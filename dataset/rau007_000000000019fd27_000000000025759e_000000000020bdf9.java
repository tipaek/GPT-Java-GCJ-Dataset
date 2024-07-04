import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int z=1;z<=t;z++) {
            int n = sc.nextInt();
            int[][] a = new int[n][2];
            int[][] arr = new int[n][2];

            for(int i=0;i<n;i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
                arr[i][0] = a[i][0];
                arr[i][1] = a[i][1];
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    if (ints[0] >= t1[0])
                        return 1;
                    else
                        return -1;
                }
            });

            int c =0;
            int j =0;
            boolean flag = false;
            Map<Integer, Character> map = new HashMap<>();

            for(int i=0;i<n;i++) {
                if(c <= arr[i][0]) {
                    map.put(arr[i][0], 'C');
                    c = arr[i][1];
                } else if(j <= arr[i][0]) {
                    map.put(arr[i][0], 'J');
                    j = arr[i][1];
                } else {
                    flag = true;
                    break;
                }
            }

            if(flag) {
                System.out.println("Case #" + z + ": IMPOSSIBLE");
            } else {
                StringBuffer sb = new StringBuffer();
                for(int i=0;i<n;i++) {
                    sb.append((char)map.get(a[i][0]));
                }
                System.out.println("Case #" + z + ": " + sb);
            }
        }
    }
}
