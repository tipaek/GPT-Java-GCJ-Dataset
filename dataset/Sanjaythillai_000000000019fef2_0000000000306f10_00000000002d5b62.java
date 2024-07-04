import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.*;



public class Solution {

    public static void main(String[] str1) throws NumberFormatException, IOException {

        String str = "";

        int x = 0, y = 0, step = -1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            String[] inputStr = br.readLine().split(" ");

            int targetX = Integer.parseInt(inputStr[0]);

            int targetY = Integer.parseInt(inputStr[1]);

            Set<String> set = new HashSet<String>();

            findDirection(x, y, targetX, targetY, step, str, set);

            int minlength=Integer.MAX_VALUE; 

            String minString="IMPOSSIBLE";

            for(String sol:set)

            {

                int len= sol.length();

                if(len<minlength)

                {

                    minlength=len;

                    minString=sol;

                }

            }

            System.out.println(minString);

        }

    }



    private static boolean findDirection(int x, int y, int targetX, int targetY, int step, String str, Set<String> set) {

       // System.out.println("x:" + x + " y:" + y + " targetX:" + targetX + " targetY:" + " step:" + step + " srt:" + str);



        if (x == targetX && y == targetY) {

            set.add(str);

            return true;

        } else if (Math.abs(x) > Math.abs(targetX) || Math.abs(y) > Math.abs(targetY)) {

            return false;

        }



        boolean res = false;

        res = findDirection(x + (int) (Math.pow(2, (step + 1))), y, targetX, targetY, step + 1, str + "E", set) || res;



        res = findDirection(x, y + (int) (Math.pow(2, (step + 1))), targetX, targetY, step + 1, str + "N", set) || res;



        res = findDirection(x + (-((int) (Math.pow(2, (step + 1))))), y, targetX, targetY, step + 1, str + "W", set) || res;



        res = findDirection(x, y + (-((int) (Math.pow(2, (step + 1))))), targetX, targetY, step + 1, str + "S", set) || res;



        return res;



    }

}