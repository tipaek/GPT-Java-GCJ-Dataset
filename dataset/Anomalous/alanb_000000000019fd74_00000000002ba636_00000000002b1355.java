import java.util.Scanner;
import java.io.FileNotFoundException;

class Solution { // renamed to Solution
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            Dancer[][] dancers = new Dancer[rows][cols];
            
            // Initialize dancers
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    dancers[i][j] = new Dancer(scanner.nextInt());
                }
            }
            
            // Set up dancer neighbors
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (i - 1 >= 0)
                        dancers[i][j].up = dancers[i - 1][j];
                    else {
                        dancers[i][j].up = new Dancer(0);
                        dancers[i][j].up.deleted = true;
                    }
                    if (j - 1 >= 0)
                        dancers[i][j].left = dancers[i][j - 1];
                    else {
                        dancers[i][j].left = new Dancer(0);
                        dancers[i][j].left.deleted = true;
                    }
                    if (i + 1 < rows)
                        dancers[i][j].down = dancers[i + 1][j];
                    else {
                        dancers[i][j].down = new Dancer(0);
                        dancers[i][j].down.deleted = true;
                    }
                    if (j + 1 < cols)
                        dancers[i][j].right = dancers[i][j + 1];
                    else {
                        dancers[i][j].right = new Dancer(0);
                        dancers[i][j].right.deleted = true;
                    }
                }
            }
            
            long totalScore = 0;
            boolean anyUpdated = true;
            
            while (anyUpdated) {
                anyUpdated = false;
                
                // Update dancers state
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        dancers[i][j].update();
                        if (dancers[i][j].toDelete) {
                            anyUpdated = true;
                        }
                    }
                }
                
                // Calculate total score and delete marked dancers
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (!dancers[i][j].deleted) {
                            totalScore += dancers[i][j].score;
                        }
                        if (dancers[i][j].toDelete) {
                            dancers[i][j].delete();
                        }
                    }
                }
            }
            System.out.println("Case #" + (t + 1) + ": " + totalScore);
        }
        scanner.close();
    }
}

class Dancer {
    public int score;
    public Dancer up;
    public Dancer down;
    public Dancer left;
    public Dancer right;
    public boolean toDelete = false;
    public boolean deleted = false;
    
    public Dancer(int score) {
        this.score = score;
    }
    
    public void update() {
        if (deleted) return;
        
        double total = -0.01;
        int count = 0;
        
        if (!up.deleted) {
            total += up.score;
            count++;
        }
        if (!down.deleted) {
            total += down.score;
            count++;
        }
        if (!left.deleted) {
            total += left.score;
            count++;
        }
        if (!right.deleted) {
            total += right.score;
            count++;
        }
        
        if (count != 0) {
            total /= count;
            if (score < total) {
                toDelete = true;
            }
        }
    }
    
    public void delete() {
        toDelete = false;
        deleted = true;
        
        if (up != null) up.down = down;
        if (down != null) down.up = up;
        if (left != null) left.right = right;
        if (right != null) right.left = left;
    }
}