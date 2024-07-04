    import java.util.*;
    import java.io.*;
    public class Solution {
        private static String nestingDepth(String input){
        String output ="";
        for(int i=0; i<input.length(); i++){
            int x = Character.getNumericValue(input.charAt(i));
            for(int j=0; j<x; j++){
                output += "(";
            }
            output+= x;
            for(int j=0; j<x; j++){
                output += ")";
            }
        }
        while(output.contains(")(")){
        	output = output.replace(")(", "");
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i=0; i<n; i++){
            String current = scanner.next();
            System.out.println(" Case #"+(i+1)+": " + nestingDepth(current));
        }
    }
    }