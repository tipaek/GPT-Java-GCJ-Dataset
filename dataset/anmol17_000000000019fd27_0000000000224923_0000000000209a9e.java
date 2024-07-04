import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int b = in.nextInt();
        for(int i = 0; i < t; i++) {
            try {
                solution.processCase(b, in);
            } catch (Exception ex) {
                return;
            }
        }
    }

    private void processCase(int b, Scanner in) throws Exception {
        char[] arr = new char[b];
        for(int i = 0; i < b; i++) {
            System.out.println(i + 1);
            arr[i] = (char) (in.nextInt() + 48);
        }

        System.out.println(new String(arr));
        String result = in.next();
        if(result.equals("N")) {
            throw new Exception();
        }
    }
}