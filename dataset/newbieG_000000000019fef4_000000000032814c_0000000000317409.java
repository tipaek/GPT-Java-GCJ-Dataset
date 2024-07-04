

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int testCase;
        String[] result;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        testCase = Integer.parseInt(in.nextLine().trim());
        result = new String[testCase];
        for (int i = 0; i < testCase; i++) {
            String inputString = in.nextLine().trim();
            StringTokenizer tmp = new StringTokenizer(inputString.trim(), " ");
            if (tmp.hasMoreElements()) {
                int xAxis = Integer.parseInt(tmp.nextToken());
                int yAxis = Integer.parseInt(tmp.nextToken());
                String path = tmp.nextToken();
                result[i] = timeTakenToReach(xAxis, yAxis, path);
            }
        }
        for (int i = 0; i < testCase; i++) {
            if (result[i] == null)
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            else
                System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static String timeTakenToReach(int x, int y, String path) {
        int currentXPosition = 0;
        boolean isPossible = false;
        int currentYPosition = 0;
        int i = 0;
        /*if (path.length() < x)
            return null;
        else {*/
            for (i = 0; i < path.length(); i++) {
                char c = path.charAt(0);
                if (c == 'N') {
                    y = y + 1;
                    if (x != currentXPosition) {
                        currentXPosition = currentXPosition + 1;
                        if (currentYPosition == y) {
                            isPossible =true;
                            break;
                        }
                    }
                    else {
                        if (currentYPosition == y) {
                            isPossible =true;
                            break;
                        }

                            else {
                                if (y < 0) {
                                    currentYPosition = currentYPosition - 1;
                                    if (currentYPosition == y) {
                                        isPossible =true;
                                        break;
                                    }
                                } else {
                                    currentYPosition = currentYPosition + 1;
                                    if (currentYPosition == y) {
                                        isPossible =true;
                                        break;
                                    }
                                }
                            }

                    }
                } else {
                    y = y + -1;
                    if (x != currentXPosition) {
                        currentXPosition = currentXPosition + 1;
                        if (currentYPosition == y) {
                            isPossible =true;
                            break;
                        }
                    }
                    else {
                        if (currentYPosition == y) {
                            isPossible =true;
                            break;
                        }
                        else {
                            if (y < 0) {
                                currentYPosition = currentYPosition - 1;
                                if (currentYPosition == y) {
                                    isPossible =true;
                                    break;
                                }
                            } else {
                                currentYPosition = currentYPosition + 1;
                                if (currentYPosition == y) {
                                    isPossible =true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        //}
        if(isPossible)
            return String.valueOf(i + 1);
        else return null;
    }
}