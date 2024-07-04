import java.util.Scanner;

public class Solution {

    private static boolean center = false;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] numbers = scanner.nextLine().split(" ");
        int T = Integer.valueOf(numbers[0]);
        int A = Integer.valueOf(numbers[1]);
        int B = Integer.valueOf(numbers[2]);
        for (int i = 0; i < T; i++) {
            solve(A, B, scanner, i);
        }
    }

    public static void solve (int A, int B, Scanner scanner, int number) {
        boolean hit = false;
        int[] chord1 = new int[2];
        int[] chord2 = new int[2];
        String hitCoords = findhit();
        chord1 = findXChord(hitCoords);
        chord2 = findYChord(hitCoords);
        int x = (chord1[0] + chord1[2]/2);
        int y = (chord2[0] + chord2[2]/2);
        System.out.println("" + x + y);
    }

    public static String findhit() {
        String hitCoords = "";
        String[] possibleCoords = {"1000000000 1000000000", "500000000 500000000", "500000000 1000000000", "1500000000 1500000000", "1500000000 1000000000"};
        for (int i = 0; i < 5; i++) {
            System.out.println(possibleCoords[i]);
            if(hit()) {
                hitCoords = possibleCoords[i];
                break;
            }
        }
        return hitCoords;
    }

    public static boolean hit () {
        String status = scanner.nextLine();
        if (status.equals("WRONG")) {
            System.exit(0); //kills program
            return false;
        } else if (status.equals("CENTER")) {
            center = true;
            return true;
        } else if (status.equals("HIT")) {
            return true;
        }  else if (status.equals("MISS")) {
            return false;
        }
        return false;
    }

    public static int[] findXChord(String hitCoords) {
        int[] xChord = new int[2];
        String[] hitCoordsA = hitCoords.split(" ");
        int[] hitXY = new int[2];
        hitXY[0] = Integer.valueOf(hitCoordsA[0]);
        hitXY[1] = Integer.valueOf(hitCoordsA[1]);
        System.out.println(hitXY[0] + " " + (hitXY[1] + 1));
        if (!hit()) {
            //findYChord("" + hitXY[0] + (hitXY[1] + 1));
            hitXY[0]--; //moves X off of top edge
        } else {
            System.out.println(hitXY[0] + " " + (hitXY[1] - 1));
            if (!hit()) {
                //findYChord("" + hitXY[0] + (hitXY[1] - 1));
                hitXY[0]++; //moves X off of bottom edge
            }
        }
        int factor = 500000000;
        int rightXBound = hitXY[0];
        String direction = "forward";
        while(factor != 0) { //finds right bound x chord, check edge cases
            if (direction.equals("forward")) {
                rightXBound += factor;
            } else {
                rightXBound -= factor;
            }
            System.out.println(rightXBound + " " + hitXY[1]);
            if (hit()) { //could be a problem with center, check
                direction = "forward";
            } else {
                factor = factor / 2;
                direction = "backward";
            }
        }
        factor = 500000000;
        int leftXBound = hitXY[0];
        while(factor != 0) { //finds left bound x chord, check edge cases
            if (direction.equals("forward")) {
                leftXBound += factor;
            } else {
                leftXBound -= factor;
            }
            System.out.println(leftXBound + " " + hitXY[1]);
            if (hit()) { //could be a problem with center, check
                direction = "backward";
            } else {
                factor = factor / 2;
                direction = "forward";
            }
        }
        xChord[0] = leftXBound;
        xChord[1] = rightXBound;
        return xChord;
    }

    //CHECK EDGE CASES
    public static int[] findYChord(String hitCoords) {
        int[] yChord = new int[2];
        String[] hitCoordsA = hitCoords.split(" ");
        int[] hitXY = new int[2];
        hitXY[0] = Integer.valueOf(hitCoordsA[0]);
        hitXY[1] = Integer.valueOf(hitCoordsA[1]);
        System.out.println(hitXY[0] + " " + (hitXY[1] + 1));
        if (!hit()) {
            //findXChord();
            hitXY[1]--; //moves X off of right edge
        } else {
            System.out.println(hitXY[0] + " " + (hitXY[1] - 1));
            if (!hit()) {
                //findXChord();
                hitXY[1]++; //moves X off of left edge
            }
        }
        int factor = 500000000;
        int upperYBound = hitXY[1];
        String direction = "upward";
        while(factor != 0) { //finds right bound x chord, check edge cases
            if (direction.equals("upward")) {
                upperYBound += factor;
            } else {
                upperYBound -= factor;
            }
            System.out.println(hitXY[0] + " " + upperYBound);
            if (hit()) { //could be a problem with center, check
                direction = "upward";
            } else {
                factor = factor / 2;
                direction = "downward";
            }
        }
        factor = 500000000;
        int lowerYBound = hitXY[1];
        while(factor != 0) { //finds left bound x chord, check edge cases
            if (direction.equals("upward")) {
                lowerYBound += factor;
            } else {
                lowerYBound -= factor;
            }
            System.out.println(hitXY[0] + " " + lowerYBound);
            if (hit()) { //could be a problem with center, check
                direction = "downward";
            } else {
                factor = factor / 2;
                direction = "upward";
            }
        }
        yChord[0] = lowerYBound;
        yChord[1] = upperYBound;
        return yChord;
    }


}
	