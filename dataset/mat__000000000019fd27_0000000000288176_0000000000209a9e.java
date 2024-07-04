import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {

        System.out.flush();

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {

            int b = in.nextInt();

            process(b, in);

            System.out.flush();

        }
    }

    private static void process(int b, Scanner in) {

        int[] array = new int[b];
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            array[i] = in.nextInt();
        }

        String result = IntStream.of(array).
                mapToObj(String::valueOf).
                collect(Collectors.joining(""));

        System.out.println(result);
        in.next();
    }

}
