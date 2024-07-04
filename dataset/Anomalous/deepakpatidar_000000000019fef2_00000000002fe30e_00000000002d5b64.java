import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int testCase = 0; testCase < t; testCase++) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int[] arr = new int[rows * cols];
            
            int a = rows * (cols - 1);
            int b = rows - 1;
            int count = 0;
            List<Integer> list = new ArrayList<>();
            
            while (b > 0) {
                for (int i = 0; i < (cols - 1); i++) {
                    list.add(a);
                    list.add(b);
                    count++;
                    a--;
                }
                b--;
            }
            
            System.out.println("Case #" + (testCase + 1) + ": " + count);
            for (int i = 0; i < count * 2; i += 2) {
                System.out.println(list.get(i) + " " + list.get(i + 1));
            }
        }
    }
}