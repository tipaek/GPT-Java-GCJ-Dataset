import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int numOfTests = input.nextInt();
        int min = input.nextInt();
        int max = input.nextInt();
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            Solver solver = new Solver(input, min, max);
            solver.solve();
        }
    }
}

class Solver {
    private int min;
    private int max;
    private Scanner input;
    private boolean hitCenter = false;
    private static final int LENGTH = (int) Math.pow(10, 9) * 2;
    
    public Solver(Scanner input, int min, int max) {
        this.min = min;
        this.max = max;
        this.input = input;
    }
    
    public void solve() {
        int[] hit = findHit();
        if (hitCenter) return;
        
        int leftBound = findXBound(hit[0], -LENGTH / 2, hit[1]);
        if (hitCenter) return;
        
        int rightBound = findXBound(hit[0], LENGTH / 2, hit[1]);
        if (hitCenter) return;
        
        int middleX = (leftBound + rightBound) / 2;
        
        int topBound = findYBound(hit[1], LENGTH / 2, middleX);
        if (hitCenter) return;
        
        int bottomBound = findYBound(hit[1], -LENGTH / 2, middleX);
        if (hitCenter) return;
        
        int middleY = (topBound + bottomBound) / 2;
        
        int check = checkPosition(middleX, middleY);
        if (!hitCenter) {
            System.out.println("Fatal Error");
        }
    }
    
    private int findXBound(int hit, int miss, int y) {
        if (checkPosition(miss, y) == 1) return miss;
        if (hitCenter) return -1;
        
        while (Math.abs(hit - miss) != 1) {
            int test = (hit + miss) / 2;
            int check = checkPosition(test, y);
            
            if (check == 1) hit = test;
            else miss = test;
            
            if (hitCenter) return -1;
        }
        return hit;
    }
    
    private int findYBound(int hit, int miss, int x) {
        if (checkPosition(x, miss) == 1) return miss;
        if (hitCenter) return -1;
        
        while (Math.abs(hit - miss) != 1) {
            int test = (hit + miss) / 2;
            int check = checkPosition(x, test);
            
            if (check == 1) hit = test;
            else miss = test;
            
            if (hitCenter) return -1;
        }
        return hit;
    }
    
    private int[] findHit() {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int check = checkPosition(LENGTH / 5 * i - LENGTH / 2, LENGTH / 5 * j - LENGTH / 2);
                if (check == 1) 
                    return new int[] {LENGTH / 5 * i - LENGTH / 2, LENGTH / 5 * j - LENGTH / 2};
            }
        }
        return null;
    }
    
    private int checkPosition(int x, int y) {
        System.out.println(x + " " + y);
        String response = input.next();
        if (response.equals("CENTER")) {
            hitCenter = true;
            return 1;
        } else if (response.equals("HIT")) {
            return 1;
        } else if (response.equals("MISS")) {
            return 0;
        } else {
            System.out.println("Error");
            return -1;
        }
    }
}