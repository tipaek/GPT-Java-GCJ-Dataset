import java.util.Scanner;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] results = new String[t];

        if (t >= 1 && t <= 100) {
            for (int ch = 0; ch < t; ch++) {
                int n = sc.nextInt();
                results[ch] = processNumber(n);
            }
            for (int i = 0; i < t; i++) {
                System.out.println("Case #" + (i + 1) + ": " + results[i]);
            }
        }
    }

    private static String processNumber(int n) {
        int x = digits(n);
        StringBuilder s = new StringBuilder();
        StringBuilder lt = new StringBuilder();
        StringBuilder rt = new StringBuilder();

        while (n != 0) {
            int ld = n % 10;
            if (ld != 0) {
                int counter = 0;
                for (int i = 2; i < x; i++) {
                    int q = n % ((int) Math.pow(10, i));
                    if (q == ld) {
                        counter++;
                    } else {
                        break;
                    }
                }
                if (counter > 0) {
                    int a = n % ((int) Math.pow(10, counter + 1));
                    for (int i = 0; i < ld; i++) {
                        lt.insert(0, ")");
                        rt.append("(");
                    }
                    s.insert(0, lt + Integer.toString(a) + rt);
                    n /= ((int) Math.pow(10, counter + 1));
                } else {
                    s.insert(0, "(" + ld + ")");
                    n /= 10;
                }
            } else {
                s.insert(0, ld);
                n /= 10;
            }
        }
        return s.toString();
    }

    private static int digits(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n /= 10;
        }
        return count;
    }
}