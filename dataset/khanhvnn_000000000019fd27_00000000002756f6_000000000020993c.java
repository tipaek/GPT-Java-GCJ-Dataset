import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set; 

public class Vestigium { 

	public static void vestigium(Scanner in) 
	{ 
		int n, i, j; 
        n = in.nextInt(); 

        // Declare the matrix 
        int matrix[][] = new int[n][n]; 

        // Read the matrix values
        int k = 0;
        int r = 0;
        for (i = 0; i < n; i++) {
            boolean mark = false;
            Set<Integer> setRow = new HashSet<>();
            for (j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt(); 
                if (i==j) k += matrix[i][j];
                if (setRow.contains(matrix[i][j])) mark = true; else setRow.add(matrix[i][j]);
            }
            if (mark) r += 1;
        }

        int c = 0;
        for (j = 0; j < n; j++) {
            boolean mark = false;
            Set<Integer> setRow = new HashSet<>();
            for (i = 0; i < n; i++) {
                if (setRow.contains(matrix[i][j])) mark = true; else setRow.add(matrix[i][j]);
            }
            if (mark) c += 1;
        }
        
        System.out.print(" " + k + " " + r + " " + c);

        // Display the elements of the matrix 
        // System.out.println("Elements of the matrix are"); 
        // for (i = 0; i < n; i++) { 
        // 	for (j = 0; j < n; j++) 
        // 		System.out.print(matrix[i][j] + " "); 
        // 	System.out.println(); 
        // }  
    } 
    
	public static void main(String[] args) 
	{ 
        try {
            Scanner scanner = new Scanner(System.in);
            // Scanner scanner = new Scanner(new File("Vestigium.in"));
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                System.out.print("Case #" + (i + 1) + ":");
                vestigium(scanner); 
                System.out.println(); 
            }
            scanner.close();
        } catch (Exception e) {
        }
	} 
} 
