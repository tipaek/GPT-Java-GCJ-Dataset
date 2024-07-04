import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());
        for(int time = 0; time < times; time++) {
            String s = br.readLine();
            int opened = 0;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                int val = s.charAt(i) - 48;
                if(val == opened) {
                    sb.append(s.charAt(i));
                }
                else if(val > opened) {
                    int difference = val - opened;
                    sb.append(openBraces(difference));
                    sb.append(s.charAt(i)); 
                    opened += difference;
                }
                else {
                    int difference = opened - val;
                    sb.append(closeBraces(difference));
                    sb.append(s.charAt(i)); 
                    opened -= difference;
                }
            }
            if(opened > 0) {
                sb.append(closeBraces(opened));
            }
            System.out.println("Case#" + (time + 1) + ": " + sb.toString());

        }
    }

    public static String openBraces(int n) {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < n; i++)
    		sb.append("(");
    	return sb.toString(); 
    }
    
    public static String closeBraces(int n) {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < n; i++)
    		sb.append(")");
    	return sb.toString();
    }
}