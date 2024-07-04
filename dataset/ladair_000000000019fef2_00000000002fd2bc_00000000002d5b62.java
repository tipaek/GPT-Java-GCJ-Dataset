import java.io.*;
import java.util.*;
public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt(); // num test cases
        int testCaseCounter = 0;
        while (testCaseCounter < testCases) {
            int inputSize = 2;
            testCaseCounter++;
            String[] input = new String[2];
            for (int i = 0; i < inputSize; ++i) {
               String str = in.next();
               input[i] = str;
            }
            String result = func(input );
            System.out.println("Case #" + testCaseCounter + ": " + result);

        }
    }

    public static String func(String[] point){
        StringBuilder sb = new StringBuilder();

        int pointX = Integer.parseInt(point[0]);
        int pointY = Integer.parseInt(point[1]);
        boolean isXNegative = pointX < 0;
        boolean isYNegative = pointY < 0;
        pointX = Math.abs(pointX);
        pointY = Math.abs(pointY);
        double movedX = Math.abs(pointX) == Integer.highestOneBit(Math.abs(pointX)) ? pointX : Math.pow(Integer.highestOneBit(Math.abs(pointX)), 2);
        double movedY = Math.abs(pointY) == Integer.highestOneBit(Math.abs(pointY)) ? pointY : Math.pow(Integer.highestOneBit(Math.abs(pointY)), 2);
        if(movedX == movedY){
            return "IMPOSSIBLE";
        }
        int disX =   pointX - (int)movedX ;
        int distY =  pointY - (int) movedY;
        int currX = 0;
        int currY = 0;
        double expAmt = 0;
        while(currX != pointX || currY != pointY ){
            int distCanMove = (int) Math.pow(2.0, expAmt);
            expAmt++;
            if(Math.abs(disX) == distCanMove){
                currX += disX;
                if(disX < 0){
                    if(isXNegative){
                        sb.append("E");
                    }else{

                        sb.append("W");
                    }
                }else{
                    if(isXNegative){
                        sb.append("W");
                    }else{

                        sb.append("E");
                    }
                }
            }else if(Math.abs(distY) == distCanMove){
                currY += distY;
                if(distY < 0){
                    if(isYNegative){
                        sb.append("N");
                    }else{

                        sb.append("S");
                    }
                }else{
                    if(isXNegative){
                        sb.append("S");
                    }else{
                        sb.append("N");
                    }
                }
            } else{
                int moveThisTurnX = pointX- currX;
                if(Math.abs(moveThisTurnX) == distCanMove){
                    if(moveThisTurnX < 0 ){
                        if(isXNegative){
                            sb.append("E");
                        }else{
                            sb.append("W");

                        }
                    }else{
                        if(isXNegative){
                            sb.append("W");
                        }else{
                            sb.append("E");
                        }
                    }
                    currX += moveThisTurnX;
                }else{
                    int moveThisTurnY = pointY- currY;
                    if(Math.abs(moveThisTurnY) == distCanMove){
                        if(moveThisTurnY < 0 ){

                            if(isYNegative){
                                sb.append("N");
                            }else{
                                sb.append("S");
                            }
                        }else{
                            if(isXNegative){
                                sb.append("S");
                            }else{
                                sb.append("N");
                            }
                        }
                        currY += moveThisTurnY;
                    }
                }
            }



        }
        return sb.toString();
    }
}