import java.util.*;
import java.io.*;

public class Solution{

static void printResult(String result, int input){
    System.out.println("Case #" + (input + 1) + ": " + result);
}


public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int total = in.nextInt(); // Number of case tests
    String[] output = new String[total];
    
    in.nextLine(); // Trash the firse line
    for(int i = 0; i < total; i++) {
        String temp = in.nextLine(); // Get the nex string to compute
        int nowOpen = 0; // NUmber of braces currently open
        String result = ""; // Here I save the string to be output
        // Cycle on the string
        for(int j = 0; j < temp.length(); j++){
            char provv = temp.charAt(j);
            switch(provv) {
                case '0':
                    for (int b = 0; b < nowOpen; b++) {
                    result += ')'; // Close all the open braces
                    nowOpen--;
                    }
                    result += provv;
                 break;
                default:
                int value = Character.getNumericValue(provv);
                if(nowOpen == value){ // If number of open braces is already correct
                    result += provv;
                } else { // I have to open or close braces
                    int diff = value - nowOpen; // calculate delta
                    if(diff > 0){ // If delta is positive (i have to add braces)
                    for (int m = 1; m <= diff; m++){
                        result += '('; // Add missing braces
                        nowOpen++; // Increse number of braces open
                    }
                    result += provv; // Add number
                    } else if (diff < 0) { // If i have to close soome braces before appending the number
                        for(int r = diff; r < 0; r++){
                           result += ')'; // Add missing braces 
                           nowOpen--; // Decrease number of open braces
                        }
                        result += provv; // Add number
                    }
                }   
                 break;

}
        }
        // Close all the remaining open braces
        for(int h = 1; h <= nowOpen; h++){
            result += ')';
        }
        output[i] = result;
    }
    for(int u = 0; u < total; u++){
        Solution.printResult(output[u], u);
    }
}
}