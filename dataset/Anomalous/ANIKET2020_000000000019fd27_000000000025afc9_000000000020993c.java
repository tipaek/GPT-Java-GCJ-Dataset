import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> inputs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            inputs.add(Integer.parseInt(br.readLine()));
        }

        List<BigInteger> outputs = new ArrayList<>();
        for (Integer input : inputs) {
            outputs.add(factorial(input));
        }

        for (BigInteger result : outputs) {
            System.out.println(result);
        }
    }

    private static BigInteger factorial(int input) {
        if (input == 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(input).multiply(factorial(input - 1));
    }
}