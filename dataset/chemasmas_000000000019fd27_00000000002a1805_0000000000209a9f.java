import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static Scanner keyboard = new Scanner(System.in);
    private static void solve() {
        //int[] line = Arrays.stream(keyboard.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] line = Arrays.stream(keyboard.nextLine().split("")).mapToInt(Integer::parseInt).toArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <line.length ; i++) {
            for(int j = 0; j< line[i];j++){
                sb.append("(");
            }
            sb.append(line[i]);
            for(int j = 0; j< line[i];j++){
                sb.append(")");
            }
        }

        String r = sb.toString();
        while(r.contains(")(")){
            r = r.replace(")(","");
        }

        System.out.println(
                r
        );
    }


    public static void main(String[] args) {
        int t, i = 1;
        t = keyboard.nextInt();
        keyboard.nextLine();
        while (t-->0){
            System.out.print("Case #");
            System.out.print(i);
            System.out.print(": ");
            solve();
            i++;
        }
    }
}
