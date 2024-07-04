import java.util.*;
import java.io.*;

public class Solution {
    private static final boolean LOCAL_TESTING = false;
    private static final boolean LOCAL_TESTING_SOLUTION = false;
    private static final String OUTPUT_FORMAT = "Case #%d: %s"; //Use with String.format - 1.: number of the test case, 2.: some string
    private static final String SEPARATOR = " ";
    //the directions
    private static final char N = 'N';
    private static final char S = 'S';
    private static final char E = 'E';
    private static final char W = 'W';
    //solution
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = in.nextInt(); //number of test cases
        in.nextLine();
test:   for (int currentTestCase = 1; currentTestCase <= T; currentTestCase++) {
            final int X = in.nextInt(); //x blocks EAST away from my start position
            final int Y = in.nextInt(); //y blocks NORTH away from my start position
            final String CAT_PATH = in.nextLine().trim();
            StringBuilder sb = new StringBuilder();
            int walkCounter = 0; //how many blocks we had to walk. 1 block = 1 minutes
            /*
            //Test set 1:
            boolean testSet1 = 
                    (X <= 10) &&
                    (Y <= 10) &&
                    (CAT_PATH.length() <= 8) &&
                    (!(CAT_PATH.contains(E+"") || CAT_PATH.contains(W+"")))
            ;
            boolean testSet2 = 
                    !testSet1 && 
                    (X <= 1000) &&
                    (Y <= 1000) &&
                    (CAT_PATH.length() <= 1000) &&
                    (!(CAT_PATH.contains(E+"") || CAT_PATH.contains(W+"")))
            ;
            boolean testSet3 = !(testSet1 || testSet2);
            */
            boolean CAT_WALKS_ONLY_VERTICAL = !(CAT_PATH.contains(E+"") || CAT_PATH.contains(W+""));
            //I am starting from 0,0. The cat starts east from me and north from me
            int catX = (-1) * X;
            int catY = (-1) * Y;
            int catEndX = catX;
            int catEndY = catY;
            for(int i=0; i<CAT_PATH.length(); i++) {
                char direction = CAT_PATH.charAt(i);
                switch(direction) {
                    case N: {
                        catEndY -= 1;
                        break;
                    }
                    case S: {
                        catEndY += 1;
                        break;
                    }
                    case E: {
                        catEndX -= 1;
                        break;
                    }
                    case W: {
                        catEndX += 1;
                        break;
                    }
                }
            }
            testPrintln("From (" + X + "," + Y + ") that is (" + catX + "," + catY + ") the path '" + CAT_PATH + "' lead to (" + catEndX + "," + catEndY + ").");
            int CAT_END_AWAY_IN_MINUTES = Math.abs(catEndX) + Math.abs(catEndY);
            final int CAT_TOUR_LENGTH_IN_MINUTES = CAT_PATH.length();
            testPrintln("End of tour is in " + CAT_END_AWAY_IN_MINUTES + " blocks/minutes away from me.");
            if(CAT_TOUR_LENGTH_IN_MINUTES < CAT_END_AWAY_IN_MINUTES) {
                sb.append(IMPOSSIBLE);
            }
            else { 
                int catMoveX = 0;
                int catMoveY = 0;
                int catMoveNextX = 0;
                int catMoveNextY = 0;
                int myX = 0;
                int myY = 0;
steps:          for(int i=0; i<CAT_PATH.length(); i++) {
                    char direction = CAT_PATH.charAt(i);
                    Character nextDirection = (i+1 < CAT_PATH.length()) ? CAT_PATH.charAt(i+1) : null;
                    switch(direction) {
                        case N: {
                            catMoveX = 0;
                            catMoveY = -1;
                            break;
                        }
                        case S: {
                            catMoveX = 0;
                            catMoveY = 1;
                            break;
                        }
                        case E: {
                            catMoveX = -1;
                            catMoveY = 0;
                            break;
                        }
                        case W: {
                            catMoveX = 1;
                            catMoveY = 0;
                            break;
                        }
                    }
                    if(nextDirection == null) {
                        catMoveNextX = 0;
                        catMoveNextY = 0;
                    }
                    else {
                        switch(nextDirection) {
                            case N: {
                                catMoveNextY = -1;
                                break;
                            }
                            case S: {
                                catMoveNextY = 1;
                                break;
                            }
                            case E: {
                                catMoveNextX = -1;
                                break;
                            }
                            case W: {
                                catMoveNextX = 1;
                                break;
                            }
                        }
                    }
                    //move myself ()neither me, nor the cat has moved in this step yet. Should I wait or should I go?
                    int diffDirectionX = myX - catX;
                    int diffDirectionY = myY - catY;
                    int diffX = Math.abs(diffDirectionX);
                    int diffY = Math.abs(diffDirectionY);
                    if(myX != catX) { //if are X did not meet yet, we go this way and only after in Y direction
                        if(2 <= diffX) { //I can move towards the cat, we wont cross within 1 step
                            if(0 < diffDirectionX) { //to the EAST from me: 0--4 || -1--4 || 3--4
                                myX += -1;
                            }
                            else if(diffDirectionX == 0) { //stay: -4--4 || 3-3
                                myX += 0;
                                throw new RuntimeException("Can't happen, or it means bug in my logical solution");
                            }
                            else {
                                myX += 1;
                            }
                        }
                        else if(1 == diffX) { //I need to check if its next step comes back to me and I should rather not move or move differently
                            String catsPathReminder = CAT_PATH.substring(i, CAT_PATH.length());
                            boolean willstillComeTowardsMe = false;
                            if(0 < diffDirectionX && catsPathReminder.contains(W+"")) { //if cat is to the east from me, but will still come to the west some time
                                willstillComeTowardsMe = true;
                            }
                            else if(diffDirectionX < 0 && catsPathReminder.contains(E+"")) { //if cat is to the west from me, but will still come to the east some time
                                willstillComeTowardsMe = true;
                            }
                            if(willstillComeTowardsMe) { //it will come towards me, lets move rather vertically with it
                                myY += catMoveY; //I move with the cat
                            }
                            else { //wont come towards me
                                int catPozNewX = catX + catMoveX;
                                if(catPozNewX == myX) { //I should not move, cat comes back
                                    myX += 0;
                                }
                                else {
                                    if(0 < diffDirectionX) { //to the EAST from me: 0--4 || -1--4 || 3--4
                                        myX += -1;
                                    }
                                    else if(diffDirectionX == 0) { //stay: -4--4 || 3-3
                                        myX += 0;
                                        throw new RuntimeException("Can't happen, or it means bug in my logical solution");
                                    }
                                    else {
                                        myX += 1;
                                    }
                                }
                            }
                        }
                        else {
                            //myX == catX, can't come here, because we go vertical instead
                        }
                    }
                    else { //our X is the same, move towards Y
                        if(2 <= diffY) { //I can move towards the cat, we wont cross within 1 step
                            if(0 < diffDirectionY) { //to the NORTH from me: 0--4 || -1--4 || 3--4
                                myY += -1;
                            }
                            else if(diffDirectionY == 0) { //stay: -4--4 || 3-3
                                myY += 0;
                                //we reached the cat's position
                            }
                            else {
                                myY += 1;
                            }
                        }
                        else if(1 == diffY) { //I need to check if its next step comes back to me and I should rather not move
                            int catPozNewY = catY + catMoveY;
                            if(catPozNewY == myY) { //I should not move, cat comes back
                                myY += 0;
                            }
                            else {
                                if(0 < diffDirectionY) { //to the NORTH from me: 0--4 || -1--4 || 3--4
                                    myY += -1;
                                }
                                else if(diffDirectionY == 0) { //stay: -4--4 || 3-3
                                    myY += 0;
                                    //we reached the cat's position
                                }
                                else {
                                    myY += 1;
                                }
                            }
                        }
                    }
                    
                    //move the cat according to its path
                    catX += catMoveX;
                    catY += catMoveY;
                    
                    testPrintln("Cat moved to (" + catX + "," + catY + ") and I moved to (" + myX + "," + myY + ").");
                    walkCounter++;
                    if(catX == myX && catY == myY) { //after moving, if at any step we meet, I am done
                        sb.append(walkCounter);
                        printSolution((X+SEPARATOR+Y+SEPARATOR+CAT_PATH), currentTestCase, sb.toString());
                        continue test;
                    }
                } //end of cat tour cyclus
                sb.append(IMPOSSIBLE);
            }
            //System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, "TEST"));
            printSolution((X+SEPARATOR+Y+SEPARATOR+CAT_PATH), currentTestCase, sb.toString());
        } //end of test cases
    } //end of main
    
    /**
     * Helper method to print the solution and locally to test the expected values.
     * 
     * @param input the whole input under the testcase concatenated or passed over in any format
     * @param currentTestCase
     * @param solution 
     */
    protected static void printSolution(String input, int currentTestCase, String solution) {
        if(!LOCAL_TESTING_SOLUTION) { //solution for the contest
            System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, solution));
        }
        else {
            System.out.print(String.format(OUTPUT_FORMAT, currentTestCase, solution));
            //TODO feel free to extend the solution with checking expected values
            String expected;
            if("4 4 SSSS".equals(input)) {
                expected = "4";
                testPrint(" <-- " + (expected.equals(solution) ? "OK" : "NOT OK") + " | '" + expected + "' was expected for input: " + input);
            }
            else if("3 0 SNSS".equals(input)) {
                expected = "IMPOSSIBLE";
                testPrint(" <-- " + (expected.equals(solution) ? "OK" : "NOT OK") + " | '" + expected + "' was expected for input: " + input);
            }
            else if("2 10 NSNNSN".equals(input)) {
                expected = "IMPOSSIBLE";
                testPrint(" <-- " + (expected.equals(solution) ? "OK" : "NOT OK") + " | '" + expected + "' was expected for input: " + input);
            }
            else if("0 1 S".equals(input)) {
                expected = "1";
                testPrint(" <-- " + (expected.equals(solution) ? "OK" : "NOT OK") + " | '" + expected + "' was expected for input: " + input);
            }
            else if("2 7 SSSSSSSS".equals(input)) {
                expected = "5";
                testPrint(" <-- " + (expected.equals(solution) ? "OK" : "NOT OK") + " | '" + expected + "' was expected for input: " + input);
            }
            else if("3 2 SSSW".equals(input)) {
                expected = "4";
                testPrint(" <-- " + (expected.equals(solution) ? "OK" : "NOT OK") + " | '" + expected + "' was expected for input: " + input);
            }
            else if("4 0 NESW".equals(input)) {
                expected = "4";
                testPrint(" <-- " + (expected.equals(solution) ? "OK" : "NOT OK") + " | '" + expected + "' was expected for input: " + input);
            }
            testPrintln("");
        }
    }
    
    /**
     * Helper method to print text while locally testing but easily switching it off in the Code Jam submission
     * @param s 
     */
    protected static void testPrintln(String s) {
        if(LOCAL_TESTING) {
            System.err.println(s);
            System.err.flush();
        }
    }
    /**
     * Helper method to print text while locally testing but easily switching it off in the Code Jam submission
     * @param s 
     */
    protected static void testPrint(String s) {
        if(LOCAL_TESTING) {
            System.err.print(s); 
            System.err.flush();
        }
    }
}