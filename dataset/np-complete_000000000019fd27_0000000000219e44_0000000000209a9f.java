import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
        public static void main(String[] args) {
                HashMap<Integer, String> openingBraces = new HashMap<Integer, String>();
                for(int i = 0; i <=9; i++) {
                        String str = "";
                        for(int j = 0; j < i; j++) {
                                str = str + "(";
                        }
                        openingBraces.put(i, str);
                }
                
                HashMap<Integer, String> closingBraces = new HashMap<Integer, String>();
                for(int i = 0; i <=9; i++) {
                        String str = "";
                        for(int j = 0; j < i; j++) {
                                str = str + ")";
                        }
                        closingBraces.put(i, str);
                }
                
                Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                String T = in.nextLine();
                int t = Integer.parseInt(T);
                for (int i = 1; i <= t; i++) {
                        String s = in.nextLine();
                        
                        int[] chars = new int[s.length()];
                        
                        int zeroth = Character.getNumericValue(s.charAt(0));
                        String outputString = openingBraces.get(zeroth) + zeroth;
                        chars[0] = zeroth;
                        int openBraces = zeroth;
                        
                        for(int j = 1; j < s.length(); j++) {
                                int n = Character.getNumericValue(s.charAt(j));
                                chars[j] = n;
                                
                                int previous = chars[j-1];
                                if(n > previous) {
                                        outputString = outputString + openingBraces.get(n - previous) + n;
                                        openBraces += n - previous;
                                } else if(n < previous) {
                                        outputString = outputString + closingBraces.get(previous - n) + n;
                                        openBraces += n - previous;
                                } else {
                                        // n == previous
                                        outputString = outputString + n;
                                }
                        }
                        
                        outputString = outputString + closingBraces.get(openBraces);
                        openBraces = 0;
                        
                        System.out.println("Case #" + i + ": " + outputString);
                }
                
                in.close();
        }
}