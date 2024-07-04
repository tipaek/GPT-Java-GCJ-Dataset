
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
 
public class Solution {
    public static boolean solve(Scanner input, int caseNum, int B) {
    	int[] arr = new int[B];
		//System.out.println("1");
		//int first = Integer.parseInt(input.next());

    	for (int i=0;i<B;i++) {
    		System.out.println(i+1);
    		arr[i] = input.nextInt();
            System.err.println("Requested bit # " + (i+1) + " = " + arr[i]);
    	}
    	
    	String result = "";
    	for (int e : arr) {
    		result += e+"";
    	}
        System.out.println(result);
        System.err.println("Proposed answer = " + result);
        String answer = input.next();
        System.err.println("Response = " + answer);
        if (answer.equals("Y")) return true;
        else return false;
        	
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
//         try {
// 			input = new Scanner(new FileInputStream(new File("C:\\Users\\i855719\\git\\kickstart\\KickStart\\CodeJam2020\\qalificationRound\\PArentingPartneringReturns\\ESAbATAd.txt")));
// 		} catch (FileNotFoundException e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}
        // number of cases
        int T = Integer.parseInt(input.next());
        System.err.println("Number of test cases: " + T);
    	int B = Integer.parseInt(input.next());
        System.err.println("Number of bits: " + B);
        // for every case - execute the solution
        for (int ks = 1; ks <= T; ks++) {
            boolean solved = solve(input, ks, B);
            System.err.println("Case #" + ks + " solved? " + solved);
            if (!solved) break;
        }
        input.close();
    }
}
