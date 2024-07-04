import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static boolean correct;

    static void neg(int[] arr, int s, int n) {
        for(int i = s; i < n; i++) arr[i] = 1 - arr[i];
    }

    static void rev(int[] arr, int s, int n) {
        for(int i = s; i < n/2; i++) {
            int save = arr[i];
            arr[i] = arr[n-s-i-1];
            arr[n-s-i-1] = save;
        }
    }

    static void both(int[] arr, int s, int n) {
        rev(arr, s, n);
        neg(arr, s, n);
    }

    static void solve(int[] guess, int part, int b, BufferedReader input) throws IOException {
        if(correct) return;
        for (int v : guess) System.out.print(v);
        System.out.println();
        String ver = input.readLine();
        if(ver.equals("Y")) {
            correct = true;
            return;
        }

        if(part + 20 >= b) return;
        solve(guess, part + 10, b, input);
        neg(guess, part + 10,  part + 20);
        solve(guess, part + 10, b, input);
        neg(guess, part + 10,  part + 20);
        rev(guess, part + 10,  part + 20);
        solve(guess, part + 10, b, input);
        rev(guess, part + 10,  part + 20);
        both(guess, part + 10,  part + 20);
        solve(guess, part + 10, b, input);
        both(guess, part + 10,  part + 20);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer data = new StringTokenizer(input.readLine());
        int t = Integer.parseInt(data.nextToken()),
            b = Integer.parseInt(data.nextToken());

        for(int i = 0; i < t; i++) {
            correct = false;
            int[] guess = new int[b];
            for(int j = 1; j <= b; j++) {
                System.out.println(j);
                int resp = Integer.parseInt(input.readLine());
                guess[j-1] = resp;
            }

            solve(guess, 0, b, input);
            neg(guess, 0, 10);
            solve(guess, 0, b, input);
            neg(guess, 0, 10);
            rev(guess, 0, 10);
            solve(guess, 0, b, input);
            rev(guess, 0, 10);
            both(guess, 0, 10);
            solve(guess, 0, b, input);
            both(guess, 0, 10);
        }

    }

}
