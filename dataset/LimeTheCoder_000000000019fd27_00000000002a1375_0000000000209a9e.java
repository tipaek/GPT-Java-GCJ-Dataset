import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            //int n = in.nextInt();

            byte[] arr = new byte[b];

            int left = 1, right = b;
            int knownBits = 0;

            for (int q = 1; q < 150; q++) {
                if (q > 10 && q % 10 == 1) {
                    int diffCand = 1;
                    int sameCand = 1;
                    for (int k = 0; k < knownBits / 2; k++) {
                        if (arr[k] != arr[b - k - 1]) {
                            diffCand = k + 1;
                        } else {
                            sameCand = k + 1;
                        }
                    }

                    System.out.println(diffCand);
                    int diffVal = in.nextByte();
                    q++;

                    System.out.println(sameCand);
                    int sameVal = in.nextByte();
                    boolean sameChanged = arr[sameCand - 1] != sameVal;
                    boolean diffChanged = arr[diffCand - 1] != diffVal;

                    if (sameChanged || diffChanged) {
                        for (int k = 0; k < knownBits / 2; k++) {
                            if (arr[k] == arr[b - k - 1] && sameChanged || arr[k] != arr[b - k - 1] && diffChanged) {
                                arr[k] = (byte) (arr[k] == 1 ? 0 : 1);
                                arr[b - k - 1] = (byte) (arr[b - -k - 1] == 1 ? 0 : 1);
                            }
                        }
                    }

                    continue;
                }

                if ((left + right) % 2 == 1) {
                    System.out.println(left);
                    arr[left - 1] = in.nextByte();
                    left++;
                } else {
                    System.out.println(right);
                    arr[right - 1] = in.nextByte();
                    right--;
                }

                knownBits++;

                if (knownBits == b) {
                    StringBuilder res = new StringBuilder();
                    for (byte m : arr) {
                        res.append(m);
                    }
                    System.out.println(res.toString());
                    if (in.next().equals("Y")) {
                        break;
                    } else {
                        return;
                    }
                }
            }

            //System.out.println("Case #" + i + ": " + order.toString());
        }
    }
}