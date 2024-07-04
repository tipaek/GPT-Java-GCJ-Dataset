import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int z = in.nextInt();
        in.nextLine();
        for (int i = 0; i < z; i++) {
            String[] inp = in.nextLine().trim().split(" ");
            int left = Integer.parseInt(inp[0]);
            int right = Integer.parseInt(inp[1]);
            for (int j = 1; ; j++) {
                if (left >= right) {
                    if (left >= j)
                    left -= j;
                    else {
                        System.out.println("Case #" + (i+1) + ": " + (j-1) + " " + left + " " + right);
                        break;
                    }
                }
                else {
                    if (right >= j) {
                        right -= j;
                    }
                    else {
                        System.out.println("Case #" + (i+1) + ": " + (j-1) + " " + left + " " + right);
                        break;
                    }
                }
            }
        }
        in.close();
    }
}