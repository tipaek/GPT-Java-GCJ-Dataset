class LatinSquareGenerator {

    // Function to print n x n Latin Square
    static void printLatinSquare(int n) {
        // A variable to control the rotation point.
        int rotationPoint = n + 1;

        // Loop to print rows
        for (int i = 1; i <= n; i++) {
            // This loop runs only after the first iteration of the outer loop.
            // It prints numbers from n to rotationPoint
            for (int num = rotationPoint; num <= n; num++) {
                System.out.print(num + " ");
            }

            // This loop prints numbers from 1 to rotationPoint - 1.
            for (int num = 1; num < rotationPoint; num++) {
                System.out.print(num + " ");
            }

            rotationPoint--;
            System.out.println();
        }
    }

    // Driver code
    public static void main(String[] args) {
        int n = 5;

        // Invoking printLatinSquare function
        printLatinSquare(n);
    }
}