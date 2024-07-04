import java.util.*;

public class Main {
    static final Random rng = new Random();
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = scanner.nextInt();
            int D = scanner.nextInt();
            List<Long> a = new ArrayList<>(Collections.nCopies(n + 5, 0L));

            for (int i = 1; i <= n; i++) {
                a.set(i, scanner.nextLong());
            }

            Collections.sort(a.subList(1, n + 1));

            long cuts = D - 1;

            for (int i = 1; i <= n; i++) {
                long x = 0;
                long d = 1;

                for (int j = i + 1; j <= n; j++) {
                    if (a.get(j) % a.get(i) == 0) {
                        x += Math.min(a.get(j) / a.get(i) - 1, D - d);
                        d += a.get(j) / a.get(i);
                        if (d >= D) {
                            break;
                        }
                    }
                }

                if (d >= D) {
                    cuts = Math.min(cuts, x);
                } else {
                    for (int j = i + 1; j <= n; j++) {
                        if (a.get(j) % a.get(i) > 0) {
                            x += Math.min(a.get(j) / a.get(i), D - d);
                            d += a.get(j) / a.get(i);
                            if (d >= D) {
                                break;
                            }
                        }
                    }

                    if (d >= D) {
                        cuts = Math.min(cuts, x);
                    }
                }
            }

            System.out.println("Case #" + t + ": " + cuts);
        }
    }
}