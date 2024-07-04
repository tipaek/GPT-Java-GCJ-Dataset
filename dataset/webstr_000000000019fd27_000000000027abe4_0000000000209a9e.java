import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t1 = in.nextInt();
        int b = in.nextInt();
        for (int t = 1; t <= t1; t++) {
            int l = b / 2 - 1;
            int k1 = -1;
            int k2 = -1;

            int[] res = new int[b];
            int q = 0;
            int z = -1;
            int c = 0;
            while (l + q * z >= 0) {
                if (c % 10 == 0) {
                    if (k1 > 0 && k2 > 0) {
                        System.out.println(k1 + 1);
                        int w1 = in.nextInt();
                        System.out.println(k2 + 1);
                        int w2 = in.nextInt();
                        if (res[k1] != w1 && res[k2] != w2) {
                            swap(res);
                        } else if (res[k1] != w1) {
                            reverseAndSwap(res);
                        } else if (res[k2] != w2) {
                            reverse(res);
                        }
                        c += 2;
                        continue;
                    } else if (k1 > 0) {
                        System.out.println(k1 + 1);
                        int w1 = in.nextInt();
                        System.out.println(k1 + 1);
                        in.nextInt();
                        if (res[k1] != w1) {
                            swap(res);
                        }
                        c += 2;
                        continue;
                    } else if (k2 > 0) {
                        System.out.println(k2 + 1);
                        int w1 = in.nextInt();
                        System.out.println(k2 + 1);
                        in.nextInt();
                        if (res[k2] != w1) {
                            swap(res);
                        }
                        c += 2;
                        continue;
                    }
                }
                System.out.println(l + q * z + 1);
                res[l + q * z] = in.nextInt();

                if (k1 < 0 && z > 0) {
                    if (res[l + q * z] == res[l + (q - 1) * (-z)]) {
                        k1 = l + (q - 1) * (-z);
                    }
                }
                if (k2 < 0 && z > 0) {
                    if (res[l + q * z] != res[l + (q - 1) * (-z)]) {
                        k2 = l + (q - 1) * (-z);
                    }
                }

                z = -z;
                if (z > 0) {
                    q++;
                }

                c++;
            }

            System.out.println(toString(res));
            String resp = in.next();
            if (resp.equals("N")) {
                break;
            }
        }
    }

    public static String toString(int[] res) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            stringBuilder.append(res[i]);
        }
        return stringBuilder.toString();
    }

    public static void reverseAndSwap(int[] res) {
        swap(res);
        reverse(res);
    }

    public static void swap(int[] res) {
        for (int i = 0; i < res.length; i++) {
            res[i] = (res[i] + 1) % 2;
        }
    }

    public static void reverse(int[] res) {
        for (int i = 0; i < res.length / 2; i++) {
            int x = res[i];
            res[i] = res[res.length - i - 1];
            res[res.length - i - 1] = x;
        }
    }
}