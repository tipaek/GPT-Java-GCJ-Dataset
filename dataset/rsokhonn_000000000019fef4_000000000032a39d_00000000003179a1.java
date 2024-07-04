import java.util.*;

public class Solution {
    public static HashMap<Character, Integer> map;
    public static HashMap<Integer, Character> mapResult;
    public static int numOfLines = 10000;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTC = sc.nextInt();

        for(int tc=1; tc<=numTC; tc++) {
            int u = sc.nextInt();
            
            map = new HashMap<Character, Integer>();
            
            String result = solve(u, sc);
            
            System.out.println("Case #" + tc + ": " + result);
        }
    }
    
    public static String solve (int u, Scanner sc) {
        for (int line=0; line<numOfLines; line++) {
            int randomVal = sc.nextInt();
            String str = sc.next();
            
            int lengthVal = getNumOfDigits(randomVal);
            int lengthStr = str.length();
            
            // System.out.println("lengthVal: " + lengthVal + ", lengthStr: " + lengthStr);
            
            int base = 1;
            
            for (int i=0; i<lengthStr; i++) {
                char currentDigit = str.charAt(str.length() - 1 - i);
                
                int currentVal = randomVal / base;
                
                // System.out.println("digit: " + currentDigit + ", val: " + currentVal);
                
                if (!map.containsKey(currentDigit) || currentVal < map.get(currentDigit))
                    map.put(currentDigit, currentVal);
                base *= 10;
            }
            
            // if (line >= numOfLines - 10)
            //     printMap();
            
            if (map.size() == 10 && checkMap())
                return buildString();
        }
        
        return "";
    }
    
    public static boolean checkMap() {
        // System.out.println("size: " + map.size());
        // printMap();
        
        if (map.size() != 10)
            return false;
        else {
            // printMap();
            for (char key : map.keySet()) {
                if (map.get(key) > 10) 
                    return false;
            }
        }
        
        return true;
    }
    
    public static void printMap() {
        System.out.println("size: " + map.size());
        
        for(char key : map.keySet())
            System.out.print("(" + key + ", " + map.get(key) + ") ");
        System.out.println();
    }
    
    // public static void printMapResult() {
    //     System.out.println("size: " + mapResult.size());
        
    //     for(int key : mapResult.keySet())
    //         System.out.print("(" + key + ", " + mapResult.get(key) + ") ");
    //     System.out.println();
    // }
    
    public static String buildString() {
        char[] result = new char[10];
        
        int i=0;
        for (char key : map.keySet()) {
            result[map.get(key) % 10] = key;
        }
        
        return new String(result);
    }
    
    public static int getNumOfDigits(int num) {
        return (int) (Math.log10(num) + 1);
    }
}
