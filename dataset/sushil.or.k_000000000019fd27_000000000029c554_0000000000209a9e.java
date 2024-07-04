import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            int numBits = scanner.nextInt();
            
            for (int idx=0;idx<numCases;++idx) {
                char[] output = new char[numBits];
                // Process for 10 Input
                if (numBits == 10) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(i+1);
                        String machineResponse = scanner.next();
                        if (machineResponse.equals("N"))
                            return;
                        output[i] = machineResponse.charAt(0);
                    }

                    System.out.println(new String(output));
                    String result = scanner.next();
                    if (result.equals("N"))
                        return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}