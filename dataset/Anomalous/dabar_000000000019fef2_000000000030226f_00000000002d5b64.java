import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < numOfCases; i++) {
            String[] inputs = scanner.nextLine().split(" ");
            int r = Integer.parseInt(inputs[0]);
            int s = Integer.parseInt(inputs[1]);
            TestCase testCase = new TestCase(r, s);
            List<String> results = testCase.getResult();
            
            System.out.println("Case #" + (i + 1) + ": " + results.size());
            for (String result : results) {
                System.out.println(result);
            }
        }
    }

    public static class TestCase {
        private final int r;
        private final int s;

        public TestCase(int r, int s) {
            this.r = r;
            this.s = s;
        }

        public List<String> getResult() {
            List<String> results = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            
            for (int ss = 0; ss < s; ss++) {
                for (int rr = 0; rr < r; rr++) {
                    values.add(rr + 1);
                }
            }

            for (int rr = 0; rr < r - 1; rr++) {
                int current = r - rr;
                int count = s - 1;
                int idx = current * s - 2;
                int start = idx;
                
                while (count > 0) {
                    while (true) {
                        if (values.get(idx) == current) {
                            count--;
                            int size = start - idx;
                            results.add(String.format("%d %d", idx + 1, size));
                            
                            List<Integer> temp = new ArrayList<>();
                            for (int i = 0; i < size; i++) {
                                temp.add(values.remove(idx + 1));
                            }
                            temp.addAll(values);
                            values = temp;
                            
                            idx = start;
                            start--;
                            break;
                        }
                        idx--;
                    }
                }
            }
            return results;
        }
    }
}