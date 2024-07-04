import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(new File("a.in")))));
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            if (B == 10) {
                int[] a = new int[B];
                for (int i = 0; i < B; i++) {
                    System.out.println(i + 1);
                    a[i] = scanner.nextInt();
                }
                System.out.println(IntStream.of(a).mapToObj(String::valueOf).collect(Collectors.joining()));
                String ans = scanner.next();
                if (ans.equals("N")) {
                    return;
                }
            }
        }
    }
}
