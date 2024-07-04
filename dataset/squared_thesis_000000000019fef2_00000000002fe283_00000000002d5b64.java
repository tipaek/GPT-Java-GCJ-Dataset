package com.neo.dolphin.CodeJam.roundoneb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static List<String> outputList = new ArrayList<>();
    private static List<Integer> r_list = new ArrayList<>();
    private static List<Integer> s_list = new ArrayList<>();


    public static void main(String[] args){
        setDataFromUserInput();
        solve();
        printOutput();
    }

    private static void solve(){

        for(int i=0; i < r_list.size(); i++){
            List<String> output = getOutput(r_list.get(i), s_list.get(i));
            int size = output.size();
            String outputString = size + "\n";
            for(String s : output){
                outputString = outputString + s + "\n";
            }
            outputList.add(outputString);
        }

    }

    private static List<String> getOutput(int R, int S){
        List<String> outputData = new ArrayList<>();

        int icount = 0;
        for(int i=1; i<R; i++){
            for(int j=1; i<S; j++){
                int a = (R*S) - R - icount;
                int b = S - j;
                icount --;
                outputData.add(a + " " + b);
            }
        }

        return outputData;
    }



    private static void setDataFromUserInput(){
        Scanner scan = new Scanner(System.in);
        int numberOfTestCases = scan.nextInt();
        scan.nextLine();
        for(int i=0; i<numberOfTestCases; i++){
            String numbers = scan.nextLine();
            String[] tokens = numbers.split(" ");
            r_list.add(Integer.parseInt(tokens[0]));
            s_list.add(Integer.parseInt(tokens[1]));
        }
    }

    private static void printOutput(){
        for(int i=0; i<outputList.size(); i++){
            System.out.print("Case #"+(i+1)+": "+ outputList.get(i));
        }
    }


}
