
import java.util.*;

public class Solution {
    
    public static boolean stringFinder (int x, int y, String s){
        if(x == 0 && y == 0){
            System.out.printf(s + "\n");
            return true;
        }
        if((x%2 == 1 || x%2 == -1) && (y%2 == 1 || y%2 == -1)){
            return false;
        }
        if(x%2 == 0 && y%2 == 0){
            return false;
        }
        if(x == 1 && y == 0){
            System.out.println(s + "E");
            return true;
        }
        if(x == -1 && y == 0){
            System.out.println(s + "W");
            return true;
        }
        if(x == 0 && y == 1){
            System.out.println(s + "N");
            return true;
        }
        if(x == 0 && y == -1){
            System.out.println(s + "S");
            return true;
        }
        
        if(x%2 == 1 || x%2 == -1){
            return stringFinder ((x+1)/2, y/2, s+'W') || stringFinder((x-1)/2, y/2, s+'E');
        }
        return stringFinder (x/2, (y+1)/2, s+'S') || stringFinder(x/2, (y-1)/2, s+'N');
        
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        for (int k = 0; k < t; k++) {
            //working code here
            int x = stdin.nextInt();
            int y = stdin.nextInt();
            System.out.printf("Case #%d: ", k+1);
            if(!stringFinder(x, y, "")){
                System.out.printf("IMPOSSIBLE\n");
            }
                
            
            
            
        }

    }
    
}

