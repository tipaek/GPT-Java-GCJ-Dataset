public class Solution {

    public static double series(double x, int n) {
        double evenTermSum = 0;
        double oddTermSum = 0;
        
        for (int i = 0; i < n; i++) {
            if (n % 2 == 0) {
                evenTermSum -= 2;
                if (n > 1) {
                    evenTermSum *= x;
                }
            } else {
                oddTermSum += 1;
                if (n > 2) {
                    oddTermSum = n * x * x;
                }
            }
            n--;
        }
        return evenTermSum + oddTermSum;
    }

    public static void main(String[] args) {
        System.out.print("series(0.5, 4) should be 1.0");
        System.out.println(": " + series(0.5, 4));
    }
}