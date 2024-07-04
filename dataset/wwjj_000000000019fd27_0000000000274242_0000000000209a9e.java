import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedInputStream in = new BufferedInputStream(System.in);
             PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out))) {

            Scanner sc = new Scanner(in);

            int T = sc.nextInt();
            int b = sc.nextInt();

            for (int t = 0; t < T; t++) {

                List<Integer> bits = new ArrayList<>();
                for (int i = 0; i < b; i++) {
                    out.println(i + 1);
                    bits.add(sc.nextInt());
                }
                out.println(bits.stream().map(String::valueOf).collect(Collectors.joining("")));
                String reply = sc.next();
                if (!reply.equals("Y")) return;
            }
        }
    }

}
