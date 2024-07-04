import java.util.*;

public class Main {

    public static boolean same(List<Integer> arr, int d) {
        int count = 1;
        int no = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (no == arr.get(i)) {
                count++;
            } else {
                if (count >= d) return true;
                count = 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int u = 1; u <= t; u++) {

            int n = scanner.nextInt();
            int d = scanner.nextInt();
            List<Integer> arr = new ArrayList<>(n);
            for (int i = 0; i < n; i++) arr.add(scanner.nextInt());

            int sum = 0;
            for (int i = 0; i < n; i++) sum += arr.get(i);

            Collections.sort(arr);

            if (same(arr, d)) {
                System.out.println("Case #" + u + ": 0");
                continue;
            }

            int count = 0;
            int start = 0;
            boolean check = false;
            while (!check) {
                float temp = (float) sum / d;
                int big = 0;

                for (int i = start; i < arr.size(); i++) {
                    if (arr.get(i) >= temp) {
                        count += arr.get(i) / temp - 1;
                        big++;
                    }
                }
                if (big > 1) break;
                sum -= arr.get(start);
                start++;
            }

            System.out.println("Case #" + u + ": " + count);
        }

        scanner.close();
    }
}