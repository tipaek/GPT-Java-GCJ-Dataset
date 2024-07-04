package com.yonav.round1B.q1;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final boolean DEBUG = false;

    private static List<Integer> power = new ArrayList<>();


    public static String solve(int goalX, int goalY){



         boolean changed_xy = false;
         boolean negative_x = false;
         boolean negative_y = false;



        if(goalX < 0) {
            goalX *= -1;
            negative_x = true;
        }

        if(goalY < 0) {
            goalY *= -1;
            negative_y =true;
        }
        if(goalY %2 ==1) {
            int temp = goalY;
            goalY = goalX;
            goalX = temp;
            changed_xy = true;
        }

        if(goalX %2 ==1 && goalY %2 == 1) {
            return "IMPOSSIBLE";
        }
        if(goalX %2 ==0 && goalY %2 == 0) {
            return "IMPOSSIBLE";
        }

        power.clear();
        power.add(1);
        addPowerToList(goalX, goalY);

        double[] coord = new double[2];
        coord[0] = goalX;
        coord[1] = goalY;
        int nextIndex = power.size() -1;
        StringBuilder sb = new StringBuilder();
        char start = 'A';


        boolean whileLoop = true;
        while(whileLoop) {

            if (coord[0] >= coord[1]) {

                coord[0] -= power.get(nextIndex);
                sb.append('E');
            } else {
                coord[1] -= power.get(nextIndex);
                sb.append('N');
            }


            if(coord[0] == -1 ) {
                start = 'W';
                coord[0] = 0;
            } else if(coord[0] == 1) {
                start = 'E';
                coord[0] = 0;
            }

            if(nextIndex == 0 || coord[0] <0 || coord[1] < 0) {
                return "IMPOSSIBLE";
            }

            if(coord[0] == 0 && coord[1] == 0) {
                whileLoop = false;
            }
            nextIndex --;
        }
        sb.append(start);

        sb.reverse();
        String resultTemp  = sb.toString();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < resultTemp.length(); i++) {

            char c = resultTemp.charAt(i);

            if(changed_xy) {
                if(c == 'N') {
                    c = 'E';
                } else if(c == 'E') {
                    c = 'N';
                } else if(c == 'W') {
                    c = 'S';
                } else if(c == 'S') {
                    c = 'W';
                }
            }

            if(negative_x) {
                if(c == 'N') {
                    c = 'S';
                } else if(c == 'S') {
                    c = 'N';
                }
            }

            if(negative_y) {
                if(c == 'W') {
                    c = 'E';
                } else if(c == 'E') {
                    c = 'W';
                }
            }

            result.append(c);
        }
        return result.toString();
    }

/*    public static double doSomething(double zahl) {
        int index = power.size() -1;
        while(true){
            if(index == -1) {
                return -1;
            } else if(zahl > power.get(index)) {
                return power.get(index);

            } else {
                index --;
            }
        }
    }*/

    public static void addPowerToList(int x, int y){
        while(x > power.get(power.size()-1) || y > power.get(power.size()-1) ) {
            power.add(power.get(power.size()-1)*2);
        }
        if(x +1== power.get(power.size()-1) && y != 0) {
            return;
        }

        power.remove(power.size() -1);
    }

    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = DEBUG ? new FileInputStream("resources/round1B/q1/input.txt") : System.in;
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)))) {

            int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= testCases; ++i) {



                String result = solve(in.nextInt(), in.nextInt());
                System.out.println("Case #" + i + ": " + result);
            }
        } catch( Exception e) {
            e.printStackTrace();
        }
    }
}


