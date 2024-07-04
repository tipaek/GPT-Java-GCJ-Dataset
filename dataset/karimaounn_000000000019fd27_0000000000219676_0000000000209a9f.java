import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        scan.nextLine();
        for(int i = 1; i <= cases; ++i){
            String line = scan.nextLine();
            StringBuilder result = new StringBuilder();
            int halt = 0;
            char c = line.charAt(0);
            int index = 0;
            for(int j = 0; j < line.length(); ++j){
                if(line.charAt(j) != c){
                    result.insert(halt,'(');
                    result.insert(index,line.charAt(j));
                    result.insert(index + 1,')');
                    halt = index+1;
                    c = line.charAt(j);
                }else{
                    result.append(line.charAt(j));
                }
                ++index;
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}