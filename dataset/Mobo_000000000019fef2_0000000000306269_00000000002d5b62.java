package gcj2020.round1b.problem1;

import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nProblems = in.nextInt();
        for (int problemNumber = 0; problemNumber < nProblems; problemNumber++) {
            //read input for each problem
            int dirX = in.nextInt();
            int dirY = in.nextInt();

            solveProblem(problemNumber + 1, dirX, dirY);
        }
    }

    private static void solveProblem(int problemNumber, int dirX, int dirY) {
        if ((dirX % 2 != 0 && dirY % 2 != 0) || (dirX % 2 == 0 && dirY % 2 == 0)) {
            System.out.println("Case #" + problemNumber + ": IMPOSSIBLE");
            return;
        }
        int distEven = 0;
        int distOdd = 0;

        String evenRight = "";
        String oddRight = "";
        String oddWrong = "";
        if (dirX % 2 == 0) {
            distEven = abs(dirX);
            distOdd = abs(dirY);
            if (dirX >= 0) {
                evenRight = "E";
            } else {
                evenRight = "W";
            }

            if (dirY >= 0) {
                oddRight = "N";
                oddWrong = "S";
            } else {
                oddRight = "S";
                oddWrong = "N";
            }
        } else { //dirY is even
            distEven = abs(dirY);
            distOdd = abs(dirX);
            if (dirY >= 0) {
                evenRight = "N";
            } else {
                evenRight = "S";
            }

            if (dirX >= 0) {
                oddRight = "E";
                oddWrong = "W";
            } else {
                oddRight = "W";
                oddWrong = "E";
            }
        }

        int[] evenArray = new int[32];
        String s = new StringBuilder(Integer.toBinaryString(distEven)).reverse().toString();
        evenArray = s.chars().map(x -> x - '0').toArray();

        int oddStart = 0;
        int oddSum = 0;
        for (int i = 0; i < 32; i++) {
            int leftForOdd = 0;
            if (i >= evenArray.length) {
                leftForOdd = 1;
            } else {
                leftForOdd = (-1) * (evenArray[i] - 1); //1 gdw even is 0
            }
            oddSum = (int) (oddSum + pow(2, i) * leftForOdd);
            if (oddSum >= distOdd) {
                oddStart = i;
                break;
            }
        }

        // sum of leftovers
        // start with even direction

        int[] oddArray = new int[32];
        for (int j = oddStart; j >= 0; j--) {
            if (j < evenArray.length && evenArray[j] == 1) {
                continue;
            }

            if (distOdd >= 0) { //go in right direction
                oddArray[j] = 1;
                distOdd = (int) (distOdd - pow(2, j));
            } else { //go in wrong direction
                oddArray[j] = -1;
                distOdd = (int) (distOdd + pow(2, j));
            }
        }

        if (distOdd != 0) {
            System.out.println("Case #" + problemNumber + ": IMPOSSIBLE");
            return;
        }

        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if (i < evenArray.length && evenArray[i] == 1) {
                resultString.append(evenRight);
            } else if (i < oddArray.length && oddArray[i] == 1) {
                resultString.append(oddRight);
            } else if (i < oddArray.length && oddArray[i] == -1) {
                resultString.append(oddWrong);
            }
        }

        System.out.println("Case #" + problemNumber + ": " + resultString);
    }
}