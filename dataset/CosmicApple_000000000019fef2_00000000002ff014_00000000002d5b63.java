import java.util.Scanner;

public class Solution {
    public static void main (String args[]) {
        Scanner input = new Scanner (System.in);
        
        int numOfTests = input.nextInt ();
        int min = input.nextInt();
        int max = input.nextInt();
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            Solver solver = new Solver(input, min, max);
            solver.solve();
        }
    }
}


class Solver  {
    int min;
    int max;
    Scanner input;
    boolean hitCenter = false;
    int length = 2*Math.Pow(10, 9);
    
    int numOfTries = 0;
    
    public Solver(Scanner input, int min, int max) {
        this.min = min;
        this.max = max;
        this.input = input;
    }
    
    public void solve() {
        //find hit
        //since the smallest radius is 1/4*length, we go in 1/5*length incrememnts
        int[] hit = findHit();
        if (hitCenter) return;
        
        
        foundHit = true;
        
        //find left bound
        int leftBound = findXBound (hit[0], -length/2, hit[1]);
        if (hitCenter) return;
        
        //find right bound
        int rightBound = findXBound (hit[0], length/2, hit[1]);
        if (hitCenter) return;
        
        //find middle
        int middleX = (leftBound + rightBound) / 2;
        
        //find topbound
        int topBound = findYBound (hit[1], length/2, middleX);
        if (hitCenter) return;
        
        //find bottombound
        int bottomBound = findYBound (hit[1], -length/2, middleX);
        if (hitCenter) return;
        
        //calculate centre
        int middleY = (topBound + bottomBound) / 2;
        
        //verify
        int check = checkPosition (middleX, middleY);
        if (hitCenter) return;
        else System.out.println ("Fatal Error");
        
    }
    
    //find extreme value that is a hit
    int findXBound (int hit, int miss, int y) {
        //verify last pos is nonhit
        int check = checkPosition (miss, y);
        
        if (check == 1) return miss;
        if (hitCenter) return -1; //probably unnecessary
        
        while (Math.abs(hit - miss) != 1) {
            int test = (hit+miss)/2;
            check = checkPosition (test, y);
            
            if (check == 1) hit = test;
            else miss = test; //check == 0
            
            if (hitCenter) return -1;
        }
        return hit;
    }
    //find extreme value that is a hit
    int findYBound (int hit, int miss, int x) {
        //verify last pos is nonhit
        int check = checkPosition (x, miss);
        
        if (check == 1) return miss;
        if (hitCenter) return -1; //probably unnecessary
        
        while (Math.abs(hit - miss) != 1) {
            int test = (hit+miss)/2;
            check = checkPosition (x, test);
            
            if (check == 1) hit = test;
            else miss = test; //check == 0
            
            if (hitCenter) return -1;
        }
        return hit;
    }
    
    boolean foundHit = false;
    int[] findHit() {
        for (int i = 1; i < 5; i ++) {
            for (int j = 1; j < 5; j++) {
                int check = checkPosition (length/5*i-length/2, length/5*j-length/2);
                if (check == 1) 
                    return new int[] {length/5*i-length/2, length/5*j-length/2};
            }
        }
        return null;
    }
    
    int checkPosition (int x, int y) {
        numOfTries++;
        if (numOfTries == 300) {
            int[] a = new int[1];
            a[2] = 0;
        }
        
        System.out.println (x + " " + y);
        String s = input.next();
        if (s.equals("CENTER")) {
            hitCenter = true;
            return 1;
        }
        else if (s.equals("HIT")) return 1;
        else if (s.equals("MISS")) return 0;
        else if (s.equals("WRONG")) {
            if (foundHit) {
            if (x > length/2 || x < -length/2 || y > length/2||y<length/2) {
                int[] a = new int[1];
                a[2] = 0;
            }
            }
        } 
        else System.out.println ("Error");
        return -1;
    }
}
