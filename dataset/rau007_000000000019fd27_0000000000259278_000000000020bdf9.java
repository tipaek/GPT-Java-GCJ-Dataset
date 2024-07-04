import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int z = 1; z <= t; z++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] d = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                d[i] = sc.nextInt();
            }
            int person = findPerson(a, d, n);
            if (person > 2) {
                System.out.println("Case #" + z + ": IMPOSSIBLE");
            } else {
                int[][] arr = new int[n][2];
                for (int i = 0; i < n; i++) {
                    arr[i][0] = a[i];
                    arr[i][1] = d[i];
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

                int c = 0;
                int j = 0;
                Map<Integer, Character> map = new HashMap<>();

                for (int i = 0; i < n; i++) {
                    if (c <= arr[i][0]) {
                        map.put(arr[i][0], 'C');
                        c = arr[i][1];
                    } else if (j <= arr[i][0]) {
                        map.put(arr[i][0], 'J');
                        j = arr[i][1];
                    }
                }
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < n; i++) {
                    sb.append((char) map.get(a[i]));
                }
                System.out.println("Case #" + z + ": " + sb);
            }
        }
    }

    static int findPerson(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int personNeeded = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                personNeeded++;
                i++;

                if (personNeeded > result)
                    result = personNeeded;
            } else {
                personNeeded--;
                j++;
            }
        }
        return result;
    }
}