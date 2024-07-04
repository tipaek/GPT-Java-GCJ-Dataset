import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // Scanner has functions to read ints, longs, strings, chars, etc.
        String line = in.nextLine();
        String[] inpLine = line.split(" ");
        int test = Integer.parseInt(inpLine[0]);
        for (int t = 1; t <= test; ++t) {
            String S = new String();
            S = "MISS";
            boolean done = false;
            long lowC = -1000000000;
            long highC = 1000000000;
            long indX = 0;
            long indY = 0;
            for (int i = 0; i < 4; i++) {
                if (done || (S.equals("HIT"))) {
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    indX = lowC + (highC / 4) + i * (highC / 2);
                    indY = lowC + (highC / 4) + j * (highC / 2);
                    System.out.println(indX + " " + indY);
                    System.out.flush();
                    S = in.nextLine();
                    if (S.equals("WRONG")){
                        return;
                    }
                    if (S.equals("CENTER")) {
                        done = true;
                        break;
                    } else if (S.equals("HIT")) {
                        break;
                    }
                }
            }

            long low = -1000000000;
            long high = indX;
            long mid = 0;
            long leftX, rightX, leftY, rightY;
            leftX = 0;
            rightX = 0;
            leftY = 0;
            rightY = 0;
            if (!done) {
                while (low < high-1) {
                    mid = (low + high) / 2;
                    System.out.println(mid + " " + indY);
                    System.out.flush();
                    S = in.nextLine();
                    if (S.equals("WRONG")){
                        return;
                    }
                    if (S.equals("CENTER")) {
                        done = true;
                        break;
                    } else if (S.equals("HIT")) {
                        high = mid;

                    } else {
                        low = mid;
                    }
                }
                if (!done) {
                   System.out.println(low + " " + indY);
                   System.out.flush();
                   S = in.nextLine();
                   if (S.equals("WRONG")){
                        return;
                    }
                   if (S.equals("CENTER")) {
                        done = true;
                        
                   } else if (S.equals("HIT")) {
                        leftX = low;

                   } else {
                        leftX = high;
                   }
                }
            }
            
            low  = indX;
            high = highC;
            mid = 0;
            if (!done) {
                while (low < high-1) {
                    mid = (low + high) / 2;
                    System.out.println(mid + " " + indY);
                    System.out.flush();
                    S = in.nextLine();
                    if (S.equals("WRONG")){
                        return;
                    }
                    if (S.equals("CENTER")) {
                        done = true;
                        break;
                    } else if (S.equals("HIT")) {
                        low = mid;

                    } else {
                        high = mid;
                    }
                }
                if (!done) {
                   System.out.println(high + " " + indY);
                   System.out.flush();
                   S = in.nextLine();
                   if (S.equals("WRONG")){
                        return;
                    }
                   if (S.equals("CENTER")) {
                        done = true;
                        
                   } else if (S.equals("HIT")) {
                        rightX = low;

                   } else {
                        rightX = high;
                   }
                }
            }
            
            
            
            low  = -highC;
            high = indY;
            mid = 0;
            if (!done) {
                while (low < high-1) {
                    mid = (low + high) / 2;
                    System.out.println(indX + " " + mid);
                    System.out.flush();
                    S = in.nextLine();
                    if (S.equals("WRONG")){
                        return;
                    }
                    if (S.equals("CENTER")) {
                        done = true;
                        break;
                    } else if (S.equals("HIT")) {
                        high = mid;

                    } else {
                        low = mid;
                    }
                }
                if (!done) {
                   System.out.println(indX + " " + low);
                   System.out.flush();
                   S = in.nextLine();
                   if (S.equals("WRONG")){
                        return;
                    }
                   if (S.equals("CENTER")) {
                        done = true;
                       
                   } else if (S.equals("HIT")) {
                        leftY = low;

                   } else {
                        leftY = high;
                   }
                }
            }
            
            low  = indY;
            high = highC;
            mid = 0;
            if (!done) {
                while (low < high-1) {
                    mid = (low + high) / 2;
                    System.out.println(indX + " " + mid);
                    System.out.flush();
                    S = in.nextLine();
                    if (S.equals("WRONG")){
                        return;
                    }
                    if (S.equals("CENTER")) {
                        done = true;
                        break;
                    } else if (S.equals("HIT")) {
                        low = mid;

                    } else {
                        high = mid;
                    }
                }
                if (!done) {
                   System.out.println(indX + " " + high);
                   System.out.flush();
                   S = in.nextLine();
                   if (S.equals("WRONG")){
                        return;
                    }
                   if (S.equals("CENTER")) {
                        done = true;
                        
                   } else if (S.equals("HIT")) {
                        rightY = high;

                   } else {
                        rightY = low;
                   }
                }
            }
            
            if (!done) {
                indX = (leftX+rightX)/2;
                indY = (leftY+rightY)/2;
                for (int i = -2; i<2; i++){
                    for (int j=-2; j<2; j++){
                        if (!done){
                            System.out.println((indX+i) + " " + (indY+j));
                            System.out.flush();
                            S = in.nextLine();
                            if (S.equals("CENTER")){
                                done = true;
                            }
                        }
                    }
                }
                
                if (!S.equals("CENTER")){
                        System.out.println("Wrong:"+indX+ " "+indY);
                        return;
                }
            }

            
        }
    }
}
