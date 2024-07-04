//package test;

import java.util.*;
import java.io.*;


public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String S = sc.next();
            StringBuilder tempAnswer = new StringBuilder();
            //creating tempAnswer
            for (int j = 0; j < S.length(); j++) {
                if (S.charAt(j) == '0')
                    tempAnswer.append(S.charAt(j));
                else {
                    for (int k = 0; k < (int) (S.charAt(j) - '0'); k++)
                        tempAnswer.append('(');

                    tempAnswer.append(S.charAt(j));
                    for (int k = 0; k < (int) (S.charAt(j) - '0'); k++)
                        tempAnswer.append(')');
                }

            }
//            System.out.println(tempAnswer.toString());
            //creating s
            StringBuilder s = new StringBuilder();
            s.append(tempAnswer.charAt(0));
            int top  = 1;
            for (int k = 1; k < tempAnswer.length(); k++) {//9
            	 top = s.length()-1;
                if (tempAnswer.charAt(k) == '(' && s.charAt(top) == ')') {
//                	 System.out.println(s.toString());
                	 s.deleteCharAt(top);
                	
                } else
                    s.append(tempAnswer.charAt(k));

            }
//            s.append(tempAnswer.charAt(0));
//            for(int k = 1; k < tempAnswer.length(); k++) {
//            	
//            }
            System.out.println("Case #"+(i+1)+": "+s.toString());
//            0((2(3)))  0(1(2)1)
        }
    }
}