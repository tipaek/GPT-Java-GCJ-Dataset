import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Solution {
    
    static String TestC(int J, Scanner scan){
        String[] end = new String[J];  //schedule to be returned
        ArrayList<Integer> tempC = new ArrayList<>();     //holds all the schedules for Cameron
        ArrayList<Integer> tempJ = new ArrayList<>();     //holds all the schedules for Jamie
        int[] chores = new int[2 * J];                    //holds all schedules
        int check = 0;  //added as a switch, to make sure that the for loop doesnt keep going when I want it to stop

        for (int i = 0; i < 2 * J; i++) {
            chores[i] = scan.nextInt();
        }

        for (int i = 0; i < J; i++) { //checking to see if chores overlap before putting them into either tempC or tempJ. If it fits into neither, then IMPOSSIBLE is returned.

            for (int K = 0; K < tempC.size(); K += 2) {
                
                if ( ((tempC.get(K) < chores[2 * i]) && (tempC.get(K + 1) > chores[2 * i])) || ((tempC.get(K) < chores[2 * i + 1]) && (tempC.get(K + 1) > chores[2 * i + 1])) || ((tempC.get(K) > chores[2 * i]) && (tempC.get(K + 1) < chores[2 * i + 1]))){
                    for (int K2 = 0; K2 < tempJ.size(); K2 += 2) {
                        if ( ((tempJ.get(K2) < chores[2 * i]) && (tempJ.get(K2 + 1) > chores[2 * i])) || ((tempJ.get(K2) < chores[2 * i + 1]) && (tempJ.get(K2 + 1) > chores[2 * i + 1])) || ((tempJ.get(K) > chores[2 * i]) && (tempJ.get(K + 1) < chores[2 * i + 1]))){
                            return "IMPOSSIBLE";
                        }
                    }
                    tempJ.add(chores[2*i]);
                    tempJ.add(chores[2*i + 1]);

                    end[i] = "J";
                    check++;
                    break;
                }
            }
            if(check > 0){
                check = 0;
                continue;
            }

            tempC.add(chores[2*i]);
            tempC.add(chores[2*i + 1]);
            end[i] = "C";
        }

        StringBuffer sb = new StringBuffer();  //converting string array into a single string
        for (int i = 0; i < end.length; i++) {
            sb.append(end[i]);
        }
        String str = sb.toString();

        return str;
    }


    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int X = 1; //counter to keep track of test number

        for (int i = 0; i < N; i++) {
            int J = scan.nextInt();


            System.out.println("Case #" + X + ": " + TestC(J, scan));  
            X++;
        }

        scan.close();

        }

}
