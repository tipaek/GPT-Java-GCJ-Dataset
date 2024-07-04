import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        in.nextLine();
        for (int id = 1; id <= t; id++) {
            solution(in, id);
        }
    }

    private static void solution(Scanner in, int id) {
        String line = in.nextLine();
        BigInteger left = new BigInteger(line.split(" ")[0]);
        BigInteger right = new BigInteger(line.split(" ")[1]);

        BigInteger i = BigInteger.ONE;
        while(left.compareTo(i) >= 0 || right.compareTo(i) >= 0) {
            if(left.compareTo(right) >= 0) {
                left = left.subtract(i);
            }else{
                right = right.subtract(i);
            }
            i = i.add(BigInteger.ONE);
        }
        i = i.subtract(BigInteger.ONE);

        System.out.println("Case #" + id + ": " + i.toString() + " " + left.toString() + " " + right.toString());
    }
}