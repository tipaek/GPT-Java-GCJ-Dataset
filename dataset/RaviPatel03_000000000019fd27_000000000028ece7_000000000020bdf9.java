import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int startC = 0, endC = 0, startJ = 0, endJ = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test; i++) {
            startC = endC = startJ = endJ = 0;
            int n = sc.nextInt();
            // sc.nextLine();
            for (int j = 0; j < n; j++) {
                // String str=sc.nextLine();
                int start = sc.nextInt();
                int end =  sc.nextInt();
                if ((startC < start && endC > start) || (end > startC && endC > end)) {
                    if (!(startJ < start && endJ > start) || (end > startJ && endJ > end)) {
                        startJ = start;
                        endJ = end;
                        sb.append("J");
                    }else{
                        sb.setLength(0);
                        sb.append("IMPOSSIBLE");
                        j=n;
                    }
                } else {
                    startC = start;
                    endC = end;
                    sb.append("C");
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + sb.toString());
            sb.setLength(0);
        }
        scanner.close();
    }
}
