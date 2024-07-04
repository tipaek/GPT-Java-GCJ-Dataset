import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];

            for (int j = 0; j < n; j++) {
                arr[j][0] = sc.nextInt();
                arr[j][1] = sc.nextInt();
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] entry1, int[] entry2) {
                    return Integer.compare(entry1[0], entry2[0]);
                }
            });

            StringBuilder result = new StringBuilder("JC");
            boolean isImpossible = false;
            int lastJ = 0, lastC = 1;

            for (int k = 2; k < n; k++) {
                if (arr[k - 1][1] > arr[k][0]) { // finish > start
                    if (result.charAt(result.length() - 1) == 'C') {
                        if (arr[lastJ][1] <= arr[k][0]) {
                            result.append("J");
                            lastJ = k;
                        } else {
                            isImpossible = true;
                            break;
                        }
                    } else {
                        if (arr[lastC][1] <= arr[k][0]) {
                            result.append("C");
                            lastC = k;
                        } else {
                            isImpossible = true;
                            break;
                        }
                    }
                } else { // finish <= start
                    if (result.charAt(result.length() - 1) == 'C') {
                        if (arr[lastJ][1] <= arr[k][0]) {
                            result.append("J");
                            lastJ = k;
                        } else {
                            result.append("C");
                            lastC = k;
                        }
                    } else {
                        if (arr[lastC][1] <= arr[k][0]) {
                            result.append("C");
                            lastC = k;
                        } else {
                            result.append("J");
                            lastJ = k;
                        }
                    }
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + result.toString());
            }
        }
    }
}