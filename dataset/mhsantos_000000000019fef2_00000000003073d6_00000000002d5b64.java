import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int R = in.nextInt();
            int S = in.nextInt();
            int cards = R * S;
            int bottom = 1;
            List<String> steps = new ArrayList<>();
            for (int rank = R - 1; rank > 0; rank--) {
                for (int suite = S - 1; suite > 0; suite--) {
                    int a = cards - bottom - rank;
                    int b = rank;
                    bottom++;
                    steps.add(a + " " + b);
                }
                bottom++;
            }
            System.out.println("Case #" + i + ": " + steps.size());
            for (String step : steps) {
                System.out.println(step);
            }
        }
    }
}
