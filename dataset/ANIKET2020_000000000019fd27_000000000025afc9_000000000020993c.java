import java.util.stream.LongStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class HelloWorld{

    public static void main(String args[]) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          String line = br.readLine();
          int N = Integer.parseInt(line);
          ArrayList<Integer> inputs = new ArrayList<Integer>();
          for (int i = 0; i < N; i++) {
              inputs.add(Integer.valueOf(br.readLine()));
          }
          ArrayList<BigInteger> outputs = new ArrayList<BigInteger>();
          for(Integer input : inputs){
              outputs.add(factorial(input));
          }
          for(BigInteger result: outputs){
              System.out.println(result);
          }
     }

     private static BigInteger factorial(Integer input) {
          if(input == 1) return BigInteger.ONE;
          return factorial(input - 1).multiply(new BigInteger(String.valueOf(input)));
     }
}