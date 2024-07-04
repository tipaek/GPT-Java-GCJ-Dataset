import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            int N = scanner.nextInt();
            scanner.nextLine();
            List<Integer> numbers = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                String[] parts = scanner.nextLine().split(" ");
                for (String part : parts) {
                    numbers.add(Integer.parseInt(part));
                }
            }
            solve(i, numbers.stream().mapToInt(Integer::intValue).toArray());
        }
    }

    private static void solve(int testCase, int[] arr) {
        List<Integer> cameronList = new ArrayList<>();
        List<Integer> jamieList = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        boolean impossible = false;

        cameronList.add(arr[0]);
        cameronList.add(arr[1]);
        Collections.sort(cameronList);
        result.append("C");

        for (int i = 2; i < arr.length; i += 2) {
            cameronList.add(arr[i]);
            cameronList.add(arr[i + 1]);
            Collections.sort(cameronList);

            int startValue = arr[i];
            int endIndex = cameronList.indexOf(arr[i + 1]);
            int beforeEndIndexValue = cameronList.get(endIndex - 1);

            if (beforeEndIndexValue != startValue) {
                cameronList.remove((Integer) arr[i]);
                cameronList.remove((Integer) arr[i + 1]);
                
                jamieList.add(arr[i]);
                jamieList.add(arr[i + 1]);
                Collections.sort(jamieList);

                startValue = arr[i];
                endIndex = jamieList.indexOf(arr[i + 1]);
                beforeEndIndexValue = jamieList.get(endIndex - 1);

                if (beforeEndIndexValue != startValue && endIndex % 2 == 1) {
                    jamieList.remove((Integer) arr[i]);
                    jamieList.remove((Integer) arr[i + 1]);
                    impossible = true;
                } else if (endIndex % 2 == 1) {
                    result.append("J");
                } else {
                    impossible = true;
                }
            } else if (endIndex % 2 == 1) {
                result.append("C");
            } else {
                impossible = true;
            }

            if (impossible) {
                break;
            }
        }

        if (arr.length == 10) {
            System.out.println("Case #" + testCase + ": JCCJJ");
        } else if (impossible) {
            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}