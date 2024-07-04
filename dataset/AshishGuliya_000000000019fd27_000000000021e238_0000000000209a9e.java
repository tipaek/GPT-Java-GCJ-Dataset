import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        esab();
    }

    private static void esab() {
        int N;
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        int i;
        StringBuilder array = new StringBuilder();
        String result;
        for (int t = 1; t <= T; t++) {
            i = 0;
            for (int j = 1; j <= B; j++) {
                System.out.println(j);
                System.out.flush();
                array.append(scanner.nextInt());
            }
            System.out.println(array.toString());
            System.out.flush();
            result = scanner.nextLine();
            if(result == "N")
                break;
        }
    }
}