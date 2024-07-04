import java.util.*;

public class Google6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] arr = new long[n];
            Map<Long, Integer> frequencyMap = new HashMap<>();
            boolean resultPrinted = false;

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextLong();
                frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);

                if (frequencyMap.get(arr[i]) >= d) {
                    System.out.println("Case #" + testCase + ": 0");
                    resultPrinted = true;
                    break;
                }
            }

            if (!resultPrinted) {
                if (d == 2) {
                    System.out.println("Case #" + testCase + ": 1");
                } else {
                    Arrays.sort(arr);
                    boolean found = false;

                    for (int i = 0; i < n && !found; i++) {
                        if (frequencyMap.get(arr[i]) == 2 && i != n - 1 && arr[i] != arr[n - 1]) {
                            System.out.println("Case #" + testCase + ": 1");
                            found = true;
                        } else {
                            for (int j = 0; j < n; j++) {
                                if (arr[j] == arr[i] * 2) {
                                    System.out.println("Case #" + testCase + ": 1");
                                    found = true;
                                    break;
                                }
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Case #" + testCase + ": 2");
                    }
                }
            }
        }
    }
}