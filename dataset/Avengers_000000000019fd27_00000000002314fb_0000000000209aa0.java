import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader((new InputStreamReader(System.in)));

        int t = Integer.parseInt(in.readLine());
        for (int i = 1; i <= t; i++) {
            boolean flag = true;
            List<Integer> input = Arrays.stream(in.readLine().split(" ")).map(num -> Integer.parseInt(num)).collect(Collectors.toList());
            int n = input.get(0);
            int m = input.get(1);
            if(input.get(1)%input.get(0)!=0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
            else
                System.out.println("Case #" + i + ": POSSIBLE" );

            List<Integer> list = IntStream.range(-(n), 0).map(p->-p).boxed().collect(Collectors.toList());
            Collections.rotate(list,(m/n));

            for(int j=0;j<n;j++) {
                System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(" ")));
                Collections.rotate(list,1);

            }


        }
    }

}