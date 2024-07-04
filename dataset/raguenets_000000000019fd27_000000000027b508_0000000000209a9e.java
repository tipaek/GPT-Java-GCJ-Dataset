import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        for (int t=1; t <= T; t++) {
            boolean finished = false;
            BitSet bitset = new BitSet(B+1);
            while (!finished) {
                String answer;
                for (int i=1; i <=10; i++) {
                    System.out.println(i);
                    answer = scanner.next();
                    if (answer.equals("N")) System.exit(-1);
                    if (answer.equals("1")) {
                        bitset.set(i);
                    } else {
                        bitset.clear(i);
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int i=1; i <= B; i++) {
                    if (bitset.get(i)) {
                        sb.append('1');
                    } else {
                        sb.append('0');
                    }
                }
                System.out.println(sb.toString());
                answer = scanner.next();
                if (answer.equals("Y")) {
                    finished = true;
                } else {
                    System.exit(-1);
                }
            }
        }
    }
}