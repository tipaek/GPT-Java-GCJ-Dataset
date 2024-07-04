import java.util.*;
import java.io.*;

public class Solution {
    private static final boolean LOCAL_TESTING = false;
    private static final boolean LOCAL_TESTING_SOLUTION = false;
    private static final String OUTPUT_FORMAT = "Case #%d: %s";
    private static final String SEPARATOR = " ";
    private static final char N = 'N';
    private static final char S = 'S';
    private static final char E = 'E';
    private static final char W = 'W';
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = in.nextInt();
        in.nextLine();
        
        for (int currentTestCase = 1; currentTestCase <= T; currentTestCase++) {
            final int X = in.nextInt();
            final int Y = in.nextInt();
            final String CAT_PATH = in.nextLine().trim();
            StringBuilder sb = new StringBuilder();
            int walkCounter = 0;
            
            boolean CAT_WALKS_ONLY_VERTICAL = !(CAT_PATH.contains(E + "") || CAT_PATH.contains(W + ""));
            int catX = -X;
            int catY = -Y;
            int catEndX = catX;
            int catEndY = catY;
            
            for (int i = 0; i < CAT_PATH.length(); i++) {
                char direction = CAT_PATH.charAt(i);
                switch (direction) {
                    case N: catEndY--; break;
                    case S: catEndY++; break;
                    case E: catEndX--; break;
                    case W: catEndX++; break;
                }
            }
            
            testPrintln("From (" + X + "," + Y + ") that is (" + catX + "," + catY + ") the path '" + CAT_PATH + "' lead to (" + catEndX + "," + catEndY + ").");
            int CAT_END_AWAY_IN_MINUTES = Math.abs(catEndX) + Math.abs(catEndY);
            final int CAT_TOUR_LENGTH_IN_MINUTES = CAT_PATH.length();
            testPrintln("End of tour is in " + CAT_END_AWAY_IN_MINUTES + " blocks/minutes away from me.");
            
            if (CAT_TOUR_LENGTH_IN_MINUTES < CAT_END_AWAY_IN_MINUTES) {
                sb.append(IMPOSSIBLE);
            } else {
                int catMoveX = 0;
                int catMoveY = 0;
                int myX = 0;
                int myY = 0;
                
                for (int i = 0; i < CAT_PATH.length(); i++) {
                    char direction = CAT_PATH.charAt(i);
                    switch (direction) {
                        case N: catMoveX = 0; catMoveY = -1; break;
                        case S: catMoveX = 0; catMoveY = 1; break;
                        case E: catMoveX = -1; catMoveY = 0; break;
                        case W: catMoveX = 1; catMoveY = 0; break;
                    }
                    
                    int diffDirectionX = myX - catX;
                    int diffDirectionY = myY - catY;
                    int diffX = Math.abs(diffDirectionX);
                    int diffY = Math.abs(diffDirectionY);
                    
                    if (myX != catX) {
                        if (diffX >= 2) {
                            myX += (diffDirectionX > 0) ? -1 : 1;
                        } else if (diffX == 1) {
                            String catsPathReminder = CAT_PATH.substring(i);
                            boolean willstillComeTowardsMe = (diffDirectionX > 0 && catsPathReminder.contains(W + "")) ||
                                                             (diffDirectionX < 0 && catsPathReminder.contains(E + ""));
                            if (willstillComeTowardsMe) {
                                myY += catMoveY;
                            } else {
                                myX += (diffDirectionX > 0) ? -1 : 1;
                            }
                        }
                    } else {
                        if (diffY >= 2) {
                            myY += (diffDirectionY > 0) ? -1 : 1;
                        } else if (diffY == 1) {
                            String catsPathReminder = CAT_PATH.substring(i);
                            boolean willstillComeTowardsMe = (diffDirectionY > 0 && catsPathReminder.contains(S + "")) ||
                                                             (diffDirectionY < 0 && catsPathReminder.contains(N + ""));
                            if (willstillComeTowardsMe) {
                                myX += catMoveX;
                            } else {
                                myY += (diffDirectionY > 0) ? -1 : 1;
                            }
                        }
                    }
                    
                    catX += catMoveX;
                    catY += catMoveY;
                    
                    testPrintln("Cat moved to (" + catX + "," + catY + ") and I moved to (" + myX + "," + myY + ").");
                    walkCounter++;
                    
                    if (catX == myX && catY == myY) {
                        sb.append(walkCounter);
                        printSolution((X + SEPARATOR + Y + SEPARATOR + CAT_PATH), currentTestCase, sb.toString());
                        break;
                    }
                }
                
                if (sb.length() == 0) {
                    sb.append(IMPOSSIBLE);
                }
            }
            
            printSolution((X + SEPARATOR + Y + SEPARATOR + CAT_PATH), currentTestCase, sb.toString());
        }
    }
    
    protected static void printSolution(String input, int currentTestCase, String solution) {
        if (!LOCAL_TESTING_SOLUTION) {
            System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, solution));
        } else {
            System.out.print(String.format(OUTPUT_FORMAT, currentTestCase, solution));
            String expected = getExpectedOutput(input);
            testPrint(" <-- " + (expected.equals(solution) ? "OK" : "NOT OK") + " | '" + expected + "' was expected for input: " + input);
            testPrintln("");
        }
    }
    
    private static String getExpectedOutput(String input) {
        switch (input) {
            case "4 4 SSSS": return "4";
            case "3 0 SNSS": return "IMPOSSIBLE";
            case "2 10 NSNNSN": return "IMPOSSIBLE";
            case "0 1 S": return "1";
            case "2 7 SSSSSSSS": return "5";
            case "3 2 SSSW": return "4";
            case "4 0 NESW": return "4";
            default: return "";
        }
    }
    
    protected static void testPrintln(String s) {
        if (LOCAL_TESTING) {
            System.err.println(s);
            System.err.flush();
        }
    }
    
    protected static void testPrint(String s) {
        if (LOCAL_TESTING) {
            System.err.print(s);
            System.err.flush();
        }
    }
}