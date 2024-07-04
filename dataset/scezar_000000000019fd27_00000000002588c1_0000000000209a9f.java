import java.util.*;
import java.io.*;

public class Solution {
	
public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt(); 
        for (int idx=1; idx<=N; ++idx) {
            String str = in.next();
            StringBuilder sb = new StringBuilder();
            int opened = 0;
            
            for (char letter: str.toCharArray()) {
				int val = letter -'0';
				while (val > opened) {
					sb.append('(');
					++ opened; 
				}
				
				while (val < opened) {
					sb.append(')');
					--opened;
				}
				sb.append(letter);
			}
			
			while (opened > 0) {
				sb.append(')');
				--opened;
			}
            
            System.out.printf("Case #%d: %s\n", idx, sb.toString());
        }
    }
  
}