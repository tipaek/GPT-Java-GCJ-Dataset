package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class Nesting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> answer = new ArrayList<>();
        for(int i=0;i<n;i++){
            String input = sc.next();
            answer.add(new Solver().solve(input));
        }

        int temp = 0;
        for (String s: answer ) {
            temp+=1;
            System.out.println("Case #"+temp+": " +s);
        }
    }
}

class Solver {
    public static String solve(String s){
        String output = "";
        int len = s.length();
        for(int i=0;i<len;i++){
            int temp =Integer.parseInt(String.valueOf(s.charAt(i)));
            for(int j=0;j<temp;j++){
                output += "(";
            }
            output += String.valueOf(s.charAt(i));
            for(int j=0;j<temp;j++){
                output += ")";
            }
        }
        ArrayList<String> string = new ArrayList<>();
        for(int i=0;i<output.length();i++){
            string.add(String.valueOf(output.charAt(i)));
        }
        for(int i=0;i<string.size()-1;i++){
            if(string.get(i).equals(")") && string.get(i+1).equals("(")){
                string.remove(i);
                string.remove(i);
                i=-1;
            }
        }
        output="";
        for (String str:string) {
            output+=str;
        }
        return output;
    }
}
