import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

	    int numTests = Integer.parseInt(sc.nextLine());

	    for(int t = 1; t <= numTests; t++){
	        int u = Integer.parseInt(sc.nextLine());
            HashMap<Character, Integer> maxes = new HashMap<>();

            for(int i = 0; i < 10000; i++){
                String[] cur = sc.nextLine().split(" ");
                int mi = Integer.parseInt(cur[0]);
                String ri = cur[1];

                for(char c : ri.toCharArray()){
                    if(!maxes.containsKey(c)){
                        maxes.put(c, 10);
                    }
                }

                if(mi < 10){
                    char curChar = ri.charAt(0);
                    if(maxes.containsKey(curChar)){
                        if(mi < maxes.get(curChar)){
                            maxes.put(curChar, mi);
                        }
                    } else {
                        maxes.put(curChar, mi);
                    }
                    continue;
                } else {
                    mi = (int) Math.floor(mi / 10.0);
                    if(mi == 0) break;
                }

                for(int j = 1; j < ri.length(); j++){
                    char curChar = ri.charAt(ri.length() - j - 1);
                    int calculatedLimit = mi%10;

                    if(maxes.containsKey(curChar)){
                        if(calculatedLimit < maxes.get(curChar)){
                            maxes.put(curChar, calculatedLimit);
                        }
                    } else {
                        maxes.put(curChar, calculatedLimit);
                    }

                    mi = (int) Math.floor(mi / 10.0);
                    if(mi == 0) break;
                }
            }

            String result = "";

            for(int curTarget = 0; curTarget < 10; curTarget++){
                for(char c : maxes.keySet()){
                    if(maxes.get(c) % 10 == curTarget){
                        result += c;
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}
