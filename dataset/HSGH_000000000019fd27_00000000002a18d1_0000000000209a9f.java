import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int i= 0; i <t; i++)
        {
            String output = "Case #" + (i+1) + ": ";
            int numofBrac = 0;
            String[] input = sc.nextLine().split("");
            for(int j=0; j< input.length; j++){
                int num = Integer.parseInt(input[j]);
                if(numofBrac < num){
                    int diff = num-numofBrac;
                    for(int k=0; k< diff; k++){
                        output += "(";
                        numofBrac++;
                    }
                    output += input[j];
                }
                else if(numofBrac > num){
                    int diff = numofBrac-num;
                    for(int k=0; k<diff ; k++){
                        output += ")";
                        numofBrac--;
                    }
                    output += input[j];
                }else{
                    output += input[j];
                }
            }
            if(numofBrac > 0){
                for(int k=0; k<numofBrac; k++){
                    output += ")";
                }
            }
            System.out.println(output);
        }
    }
}