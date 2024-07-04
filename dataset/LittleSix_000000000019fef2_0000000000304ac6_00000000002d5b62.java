import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int targetX = in.nextInt();
            int targetY = in.nextInt();
            if ((targetX % 2 == 0 && targetY % 2 == 0)
                    || (targetX % 2 == 1 && targetY % 2 == 1)) {
                System.out.println("Case #" + caseNum +": " + "IMPOSSIBLE");
                continue;
            }
            Queue<String> currentQueue = new LinkedList<String>();
            currentQueue.offer("0_0_");
            String result = "IMPOSSIBLE";
            int nextStep = 1;
            boolean found = false;
            while(!found && currentQueue.size() > 0) {
                Queue<String> nextQueue = new LinkedList<String>();
                for(String current : currentQueue) {
                    String[] currentValues = current.split("_", -1);
                    int currentX = Integer.valueOf(currentValues[0]);
                    int currentY = Integer.valueOf(currentValues[1]);
                    String currentResult = currentValues[2];
                    if (currentX == targetX && currentY == targetY) {
                        result = currentResult;
                        found = true;
                        break;
                    } else if (currentX == targetX) {
                        if (!(Math.abs(currentY - targetY) < nextStep)) {
                            if (targetY > currentY) {
                                nextQueue.offer(currentX + "_" + (currentY + nextStep) + "_" + currentResult + "N");
                            } else {
                                nextQueue.offer(currentX + "_" + (currentY - nextStep) + "_" + currentResult + "S");
                            }
                        }
                    } else if (currentY == targetY) {
                        if (!(Math.abs(currentX - targetX) < nextStep)) {
                            if (targetX > currentX) {
                                nextQueue.offer((currentX + nextStep) + "_" + currentY + "_" + currentResult + "E");
                            } else {
                                nextQueue.offer((currentX - nextStep) + "_" + currentY + "_" + currentResult + "W");
                            }
                        }
                    } else if (Math.abs(currentX - targetX) >= nextStep 
                            && Math.abs(currentY - targetY) >= nextStep) {
                        nextQueue.offer(currentX + "_" + (currentY + nextStep) + "_" + currentResult + "N");
                        
                        nextQueue.offer(currentX + "_" + (currentY - nextStep) + "_" + currentResult + "S");
                        
                        nextQueue.offer((currentX + nextStep) + "_" + currentY + "_" + currentResult + "E");
                        
                        nextQueue.offer((currentX - nextStep) + "_" + currentY + "_" + currentResult + "W");
                    }
                }
                currentQueue = nextQueue;
                nextStep = nextStep * 2;
            }
            System.out.println("Case #" + caseNum +": " + result);
        }
    }
}