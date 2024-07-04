import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NestingDepth {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader((new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.readLine());
        for (int i = 1; i <= t; i++) {


            String res = calculate(in.readLine());
            System.out.println("Case #" + i + ": "+ res);
        }

    }
    public static String calculate(String s) {
        String result = "";
        int prev =0;
        for(int i=0;i<s.length();i++) {
            int num = Character.getNumericValue(s.charAt(i));
            int diff = num-prev;
            if(diff==0)
                result = result+s.charAt(i);
            else if(diff > 0)
                result = result + IntStream.range(0, diff).mapToObj(j -> "(").collect(Collectors.joining(""))  + s.charAt(i);
            else
                result = result + IntStream.range(0, -diff).mapToObj(j -> ")").collect(Collectors.joining("")) + s.charAt(i);
            prev = num;

        }
        if(prev >0)
            result = result+IntStream.range(0, prev).mapToObj(j -> ")").collect(Collectors.joining(""));
        return result;
    }

}
