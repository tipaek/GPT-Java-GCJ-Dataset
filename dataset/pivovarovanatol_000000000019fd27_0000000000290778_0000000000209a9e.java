
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
		System.out.println(0);
		int first = input.nextInt();

    	for (int i=0;i<B;i++) {
    		System.out.println(i);
    		arr[i] = input.nextInt();
    	}
    	
    	String result = "";
    	for (int e : arr) {
    		result += e+"";
    	}
        System.out.println(result);
        String answer = input.next();
        if (answer=="Y") return true;
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
        int T = input.nextInt();
        
        // for every case - execute the solution
        for (int ks = 1; ks <= T; ks++) {
        	int B = input.nextInt();
            if (!solve(input, ks, B)) break;
        }
        input.close();
    }
}
