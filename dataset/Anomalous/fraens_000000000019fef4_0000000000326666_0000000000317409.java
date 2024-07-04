import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private int east;
    private int north;
    private int[] directions;

    public Solution(int east, int north, int[] directions) {
        this.east = east;
        this.north = north;
        this.directions = directions;
    }

    // Function to remove duplicates from a list of Integer arrays
    private static ArrayList<Integer[]> removeDuplicates(ArrayList<Integer[]> list) {
        Set<Integer[]> set = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(set);
        return list;
    }

    // Function to read input and create a list of Solution objects
    private static ArrayList<Solution> readInput(Scanner scanner) {
        ArrayList<Solution> listOfPeppurrTours = new ArrayList<>();
        int numberOfTestCases = scanner.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            int eastPosition = scanner.nextInt();
            int northPosition = scanner.nextInt();
            String directionsString = scanner.next();
            int[] directions = new int[directionsString.length()];
            for (int j = 0; j < directionsString.length(); j++) {
                directions[j] = (directionsString.charAt(j) == 'S') ? -1 : 1;
            }
            listOfPeppurrTours.add(new Solution(eastPosition, northPosition, directions));
        }
        return listOfPeppurrTours;
    }

    // Function to produce a list of Peppurr's positions over time
    private static ArrayList<Integer[]> produceListOfPeppurrPositions(ArrayList<Solution> listOfPeppurrTours, int tourIndex) {
        ArrayList<Integer[]> peppurrPositions = new ArrayList<>();
        Solution tour = listOfPeppurrTours.get(tourIndex);
        peppurrPositions.add(new Integer[]{0, tour.north, -tour.east});
        for (int i = 1; i <= tour.directions.length; i++) {
            Integer[] lastPosition = peppurrPositions.get(i - 1);
            peppurrPositions.add(new Integer[]{i, lastPosition[1] + tour.directions[i - 1], lastPosition[2]});
        }
        return peppurrPositions;
    }

    // Function to produce a list of possible positions over time
    private static ArrayList<Integer[]> produceListOfMyPositions(ArrayList<Solution> listOfPeppurrTours, int tourIndex) {
        ArrayList<Integer[]> myPossiblePositions = new ArrayList<>();
        myPossiblePositions.add(new Integer[]{0, 0, 0});
        ArrayList<Integer[]> newPositions = new ArrayList<>();

        for (int i = 1; i <= listOfPeppurrTours.get(tourIndex).directions.length; i++) {
            for (Integer[] position : myPossiblePositions) {
                if (position[0] == i - 1) {
                    newPositions.add(new Integer[]{i, position[1], position[2]});
                    newPositions.add(new Integer[]{i, position[1] + 1, position[2]});
                    newPositions.add(new Integer[]{i, position[1] - 1, position[2]});
                    newPositions.add(new Integer[]{i, position[1], position[2] + 1});
                    newPositions.add(new Integer[]{i, position[1], position[2] - 1});
                }
            }
            myPossiblePositions.addAll(newPositions);
            newPositions.clear();
            removeDuplicates(myPossiblePositions);
        }
        return myPossiblePositions;
    }

    // Function to test a specific tour and determine the first meeting point
    private static int testATour(ArrayList<Solution> listOfPeppurrTours, int tourIndex) {
        ArrayList<Integer[]> peppurrPositions = produceListOfPeppurrPositions(listOfPeppurrTours, tourIndex);
        ArrayList<Integer[]> myPositions = produceListOfMyPositions(listOfPeppurrTours, tourIndex);
        for (Integer[] peppurrPosition : peppurrPositions) {
            for (Integer[] myPosition : myPositions) {
                if (Arrays.equals(peppurrPosition, myPosition)) {
                    return peppurrPosition[0];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<Solution> listOfPeppurrTours = readInput(scanner);

        for (int i = 1; i <= listOfPeppurrTours.size(); i++) {
            int result = testATour(listOfPeppurrTours, i - 1);
            if (result == -1) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }
}