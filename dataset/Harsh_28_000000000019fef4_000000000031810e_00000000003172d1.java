
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        //Problem3
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            int T = sc.nextInt();
            for (int i = 0; i < T; i++) {
                System.out.println("Case #" + (i + 1) + ": ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
