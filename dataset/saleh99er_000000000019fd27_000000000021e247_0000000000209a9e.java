import java.util.*;
import java.io.*;
import java.util.Random;
import java.lang.StringBuilder;

public class Solution {

    public static boolean[][] binData;
    public static int queryCount = 0;

    public static final int NO_CHANGE = 0;
    public static final int INVERT_BITS = 1;
    public static final int MIRROR_BITS = 2;
    public static final int BOTH = 3;



    public static void change(int i, int j, int B, Scanner in){
        System.err.println("change("+i+","+j+","+B+")");
        System.err.println(buildOutput(B));
        boolean[] isPossible = {true, true, true, true};

        for(int iPrime = 1; iPrime < i; iPrime++){
            binData[iPrime][INVERT_BITS] = !binData[iPrime][NO_CHANGE];
            binData[B-iPrime+1][MIRROR_BITS] = binData[iPrime][NO_CHANGE];
            binData[B-iPrime+1][BOTH] = !binData[iPrime][NO_CHANGE];
        }
        for(int jPrime = B; jPrime > j; jPrime--){
            binData[jPrime][INVERT_BITS] = !binData[jPrime][NO_CHANGE];
            binData[B-jPrime+1][MIRROR_BITS] = binData[jPrime][NO_CHANGE];
            binData[B-jPrime+1][BOTH] = !binData[jPrime][NO_CHANGE];
        }

        int bitIndex = 1;
        int possibleChanges = 4;
        while(bitIndex <= B && possibleChanges != 1){

            // compare all 4 possibilities at this bit, if there is at least 1
            // difference then we can poll here and find out which are possible
            boolean difference = false;
            int numTrue = 0;
            int numFalse = 0;
            for(int p = 0; p < 4; p++){
                if(isPossible[p]){
                    if(binData[bitIndex][p]){
                        numTrue++;
                    }
                    else {
                        numFalse++;
                    }
                }
            }
            if(numTrue != possibleChanges && numFalse != possibleChanges){
                //at least 1 difference, lets poll at this index to find out which is possible
                queryCount++;
                System.out.println(bitIndex+"");
                boolean queriedBit = in.nextInt() == 1 ? true : false;
                for(int p = 0; p < 4; p++){
                    if(isPossible[p]){
                        if(queriedBit != binData[bitIndex][p]) isPossible[p] = false;
                    }
                }
            }

            // prepare for next iteration
            bitIndex++;
            if(bitIndex == i) bitIndex = j+1;
            possibleChanges = 0;
            for(int p = 0; p < 4; p++){
                if(isPossible[p]) possibleChanges++;
            }
        }

        // only 1 change is possible or there is ambiguity, regardless, use the lowest p that's marked true as the change
        // update array state to reflect this
        int changeDetected = 0;
        for(int p = 0; p < 4; p++){
            if(isPossible[p]){
                changeDetected = p;
                if(changeDetected == 0) System.err.println("NO_CHANGE");
                if(changeDetected == 1) System.err.println("INV");
                if(changeDetected == 2) System.err.println("SWAP");
                if(changeDetected == 3) System.err.println("BOTH");
                break;
            }
        }

        bitIndex = 1;
        while(bitIndex <= B){ // copy over data from bin matrix from one where we detected the change
            binData[bitIndex][NO_CHANGE] = binData[bitIndex][changeDetected]; 
            bitIndex++;
        }

        //jank fix, if swap occurred and there was a middle index unknown, poll that point
        if(i==j){
            System.out.println(""+(i-1));
            boolean queriedBit = in.nextInt() == 1 ? true : false;
            binData[i-1][NO_CHANGE] = queriedBit;
            queryCount++;
        }
    }


    public static void esab(Scanner x, int B) throws Exception{
        int i = 1; // where we're at reading leftward
        int j = B;
        int amtRead = 0;
        boolean iTurn = true;
        int request;
        queryCount = 0;
        System.err.println("NEW CASE");
        while( amtRead < B){
            request = iTurn ? i : j;
            System.err.println("request="+request);
            System.out.println(request);
            boolean queriedBit = x.nextInt() == 1 ? true : false;
            queryCount++;
            if(queryCount % 10 == 1 && amtRead != 0){ //random flux will occur, need to acct for this in data processing
                //detect  if inversion/backwards occurred
                change(i, j, B, x);
            }

            binData[request][NO_CHANGE] = queriedBit;
            if(iTurn) i++;
            else j--;
            iTurn = !iTurn;
            amtRead++;
            System.err.println("java-soln :" + buildOutput(B));
        } // binData is full of info we want now provide it to user
    }

    public static String buildOutput(int B){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= B; i++){
            sb.append( binData[i][NO_CHANGE] ? '1' : '0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        int b;
        b = in.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            binData = new boolean[b+1][4];
            try {
                esab(in, b);
            }
            catch( Exception e){
                e.printStackTrace();
                return;
            }
            //System.out.println("Finished reading input");
            System.out.println(buildOutput(b));
            in.nextLine();
            String feedback = in.nextLine();
            if(feedback.equals("N")){
                System.err.println("failed test case " + i);
                return;
            }
        }
    }
}