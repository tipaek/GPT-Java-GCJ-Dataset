import java.util.*;

public class Solution {

    static class Customer {
        int start;
        int end;

        Customer(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private void processCase(Scanner scanner, Comparator<Customer> comparator, int caseNumber) {
        boolean isPossible = true;
        PriorityQueue<Customer> queue = new PriorityQueue<>(comparator);
        Map<Customer, Integer> customerIndexMap = new HashMap<>();
        int N = scanner.nextInt();
        int cameronEnd = 0, jamieEnd = 0;

        for (int i = 0; i < N; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            Customer customer = new Customer(start, end);
            customerIndexMap.put(customer, i);
            queue.add(customer);
        }

        StringBuilder schedule = new StringBuilder("C".repeat(N));

        while (!queue.isEmpty()) {
            Customer currentCustomer = queue.poll();
            int index = customerIndexMap.get(currentCustomer);

            if (currentCustomer.start >= cameronEnd) {
                cameronEnd = currentCustomer.end;
                schedule.setCharAt(index, 'C');
            } else if (currentCustomer.start >= jamieEnd) {
                jamieEnd = currentCustomer.end;
                schedule.setCharAt(index, 'J');
            } else {
                isPossible = false;
                break;
            }
        }

        if (!isPossible) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + caseNumber + ": " + schedule.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<Customer> comparator = Comparator.comparingInt(c -> c.start);
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            new Solution().processCase(scanner, comparator, i);
        }
    }
}