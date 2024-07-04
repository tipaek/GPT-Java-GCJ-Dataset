import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader((new InputStreamReader(System.in)));

        int t = Integer.parseInt(in.readLine());
        for (int i = 1; i <= t; i++) {
            List<Integer> input = Arrays.stream(in.readLine().split(" ")).map(num -> Integer.parseInt(num)).collect(Collectors.toList());
            int n = input.get(0);
            if(input.get(1)%input.get(0)!=0 || input.get(1)%input.get(0)>input.get(0) || input.get(1)<0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
            else {
                System.out.println("Case #" + i + ": POSSIBLE");

                List<Integer> list = new ArrayList<>();
                list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
                Collections.rotate(list, -((input.get(1) / input.get(0))-1));
                for (int j = 0; j < n; j++) {
                    System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(" ")));
                    Collections.rotate(list, 1);

                }
            }

        }
    }
    static int findSum(int n)
    {
        if (n % 2 == 0)
            return (n / 2) * (n + 1);

        else
            return ((n + 1) / 2) * n;
    }
}
