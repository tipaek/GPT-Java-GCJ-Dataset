// Java program to print Latin Square
public class LatinSquare {

    // Function to print n x n Latin Square
    static void printLatinSquare(int n) {
        // Variable to control the rotation point
        int rotationPoint = n + 1;

        // Loop to print rows
        for (int row = 1; row <= n; row++) {
            int temp = rotationPoint;

            // Print numbers from rotationPoint to n
            while (temp <= n) {
                System.out.print(temp + " ");
                temp++;
            }

            // Print numbers from 1 to rotationPoint - 1
            for (int col = 1; col < rotationPoint; col++) {
                System.out.print(col + " ");
            }

            rotationPoint--;
            System.out.println();
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        int n = 5;

        // Invoking printLatinSquare function
        printLatinSquare(n);
    }
}

// This code is contributed by Anant Agarwal.