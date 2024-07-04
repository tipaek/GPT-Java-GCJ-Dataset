public class Main {
    public static void main(String[] args) {
        int T = 0; // Initialize T
        int N = 0; // Initialize N
        int M = 0; // Initialize M

        // Constraints
        if (T >= 1 && T <= 100 && N >= 2 && N <= 100 && M >= 1 && M <= N) {
            int S = T + N + M;
            System.out.println("S = " + S);
        } else {
            System.out.println("Input values are out of the specified range.");
        }
    }
}