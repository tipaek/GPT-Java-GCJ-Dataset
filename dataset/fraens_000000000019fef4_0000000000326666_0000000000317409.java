import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    int east;
    int north;
    int[] directions;

    public Solution(int east, int north, int[] directions) {
        this.east = east;
        this.north = north;
        this.directions = directions;
    }


    // Function to remove duplicates from an ArrayList
    public static ArrayList<Integer[]> removeDuplicates(ArrayList<Integer[]> list) {
        Set<Integer[]> set = new LinkedHashSet<>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        return list;
    }

    public static ArrayList<Solution> readInput(Scanner in) {
        ArrayList<Solution> listOfPeppurrTours = new ArrayList<>();
        int numberOfTestCases = in.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            int eastPosition = in.nextInt();
            int northPosition = in.nextInt();
            String directionsString = in.next();
            int[] directions = new int[directionsString.length()];
            for (int j = 0; j < directionsString.length(); j++) {
                if (directionsString.charAt(j) == 'S') {
                    directions[j] = -1;
                } else {
                    directions[j] = 1;
                }
            }
            Solution tour = new Solution(eastPosition, northPosition, directions);
            listOfPeppurrTours.add(tour);
        }
        return listOfPeppurrTours;
    }

    /**
     * Takes a list of peppers tours and the number of the tour, for which you want the directions.
     * Returns an ArrayList of Integer[], which have 3 ints:
     * Point in time --- North/South position --- EastWest position
     *
     * @param listOfPeppurrTours
     * @param numberOfTourInTestCaseList
     * @return
     */
    public static ArrayList<Integer[]> produceListOfPeppurrPositions(ArrayList<Solution> listOfPeppurrTours, int numberOfTourInTestCaseList) {
        ArrayList<Integer[]> peppurrPositions = new ArrayList<>();
        Integer[] positionZero = {0, listOfPeppurrTours.get(numberOfTourInTestCaseList).north, listOfPeppurrTours.get(numberOfTourInTestCaseList).east * (-1)};
        peppurrPositions.add(positionZero);
        for (int i = 1; i <= listOfPeppurrTours.get(numberOfTourInTestCaseList).directions.length; i++) {
            Integer[] position = {i, peppurrPositions.get(i - 1)[1] + listOfPeppurrTours.get(numberOfTourInTestCaseList).directions[i - 1], peppurrPositions.get(i - 1)[2]};
            peppurrPositions.add(position);
        }
        return peppurrPositions;
    }

    public static ArrayList<Integer[]> produceListOfMyPositions(ArrayList<Solution> listOfPeppurrTours, int numberOfTourInTestCaseList) {
        ArrayList<Integer[]> myPossiblePositions = new ArrayList<>();
        Integer[] positionZero = {0, 0, 0};
        myPossiblePositions.add(positionZero);
        ArrayList<Integer[]> myPossiblePositionsCopy = new ArrayList<>();

        for (int i = 1; i <= listOfPeppurrTours.get(numberOfTourInTestCaseList).directions.length; i++) {

            //i represents time points
            for (Integer[] position : myPossiblePositions) {
                if (position[0] == i - 1) {
                    myPossiblePositionsCopy.add(new Integer[]{i, position[1], position[2]});
                    myPossiblePositionsCopy.add(new Integer[]{i, position[1] + 1, position[2]});
                    myPossiblePositionsCopy.add(new Integer[]{i, position[1] - 1, position[2]});
                    myPossiblePositionsCopy.add(new Integer[]{i, position[1], position[2] + 1});
                    myPossiblePositionsCopy.add(new Integer[]{i, position[1], position[2] - 1});
                }
            }

            myPossiblePositions.addAll(myPossiblePositionsCopy);
            myPossiblePositionsCopy.clear();
            removeDuplicates(myPossiblePositions);
        }
        return myPossiblePositions;
    }

    public static int testATour(ArrayList<Solution> listOfPeppurrTours, int numberOfTour) {
        ArrayList<Integer[]> peppurrPositions = produceListOfPeppurrPositions(listOfPeppurrTours, numberOfTour);
        ArrayList<Integer[]> myPositions = produceListOfMyPositions(listOfPeppurrTours, numberOfTour);
        int firstMeeting = -1;
        for (Integer[] position : peppurrPositions) {
            for (Integer[] myPosition : myPositions
            ) {
                if (position[0] == myPosition[0] && position[1] == myPosition[1] && position[2] == myPosition[2]) {
                    firstMeeting = position[0];
                    break;
                }
            }
        }
        return firstMeeting;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<Solution> listOfPeppurrTours = readInput(in);

        for (int i = 1; i <= listOfPeppurrTours.size(); i++) {
            int result = testATour(listOfPeppurrTours, i-1);

            if (result == -1) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }

}
