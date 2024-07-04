import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author ycagri
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = s.nextInt();
        
        for(int i = 1; i <= testCases; i++){
            String line = s.nextLine();
            StringBuilder sb = new StringBuilder();
            char start = '0';
            
            for(int j = 0; j < line.length(); j++){
                char c = line.charAt(j);
                
                int count = c - start;
                if(count > 0){
                    for(int k = 0; k < count; k++){
                        sb.append('(');
                    }
                }else if(count<0){
                    for(int k = count; k < 0; k++){
                        sb.append(')');
                    }
                }
                sb.append(c);
                start = c;
            }
            
            start -= '0';
            for(int k = 0; k < start; k++){
                sb.append(')');
            }
            
            System.out.println(String.format("Case #%d: %s", i, sb.toString()));
        }
    }
}