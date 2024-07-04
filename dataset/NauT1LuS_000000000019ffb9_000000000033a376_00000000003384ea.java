import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        String exampleString = "9\n" +
                "1 2\n" +
                "2 2\n" +
                "1000000000000000000 1000000000000000000\n"+
                "1000000000000000000 1000000000000000000\n"+
                "1000000000000000000 1000000000000000000\n"+
                "1000000000000000000 1000000000000000000\n"+
                "1000000000000000000 1000000000000000000\n"+
                "1000000000000000000 1000000000000000000\n"+
                "1000000000000000000 1000000000000000000\n";
        Scanner in = new Scanner(System.in);
        //in = new Scanner(new ByteArrayInputStream(exampleString.getBytes(StandardCharsets.UTF_8)));

        int cases = in.nextInt();
        cases:
        for (int i = 1; i <= cases; i++) {
            solve(in, i);
        }

    }

    public static void solve(Scanner in, int caseNumber) {
        long left = in.nextLong();
        long right = in.nextLong();
        for (long i = 1; ; i++) {
            if(right > left){
                if(right >= i){
                    right -=i;
                }else{
                    printResult(caseNumber, i-1, left, right);
                    return;
                }

            }else{
                if(left >= i){
                    left -= i;
                }else{
                    printResult(caseNumber, i-1, left, right);
                    return;
                }
            }
        }
    }

    private static void printResult(int caseNumber, long l, long left, long right) {
        System.out.printf("Case #%d: %d %d %d", caseNumber, l, left, right);
        System.out.println();
    }

    private static void printImpossible(int caseNumber) {
        System.out.printf("Case #%d: %s", caseNumber, "IMPOSSIBLE");
        System.out.println();
    }
}