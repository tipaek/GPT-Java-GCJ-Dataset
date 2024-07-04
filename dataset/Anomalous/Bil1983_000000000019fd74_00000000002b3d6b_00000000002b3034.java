import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner sc;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();
        sc.nextLine();
        for (int test = 1; test <= t; test++) {
            List<String> list = new ArrayList<>();
            int a = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < a; i++) {
                list.add(sc.nextLine());
            }

            for (int i = 0; i < a; i++) {
                list.set(i, list.get(i).replaceAll("[*]", "[AZ]"));
            }

            System.out.println("Case #" + test + ": ");
        }
    }
}