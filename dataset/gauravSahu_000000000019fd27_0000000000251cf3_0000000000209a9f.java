import java.util.*;

class Solution {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String [] args) {
        int t = scn.nextInt();
        for(int i = 1; i <= t; i++){        
            String s = scn.next();
            solve(s, i);
        }
    }
    static void solve(String s, int t) {
        System.out.print("Case #" + t + ": ");
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            int val = s.charAt(i) - '0';
            if(i == 0){
                for(int j = 0;  j < val; j++){
                    arr.add("(");
                }
            }

            if(i + 1 < s.length()){
                String ch = ""+val;
                arr.add(ch);
                int dif = val - (s.charAt(i + 1) - '0');
                if(dif >= 0){
                    for(int k = 0; k < dif; k++){
                        arr.add(")");
                    }
                }
                else{
                    dif = Math.abs(dif);
                    for(int k =0; k < dif; k++){
                        arr.add("(");
                    }
                }
            }
            
            if(i == s.length() - 1){
                String ch = ""+val;
                arr.add(ch);
                for(int j = 0; j < val; j++){
                    arr.add(")");
                }
            }
        }
        for(int i =0; i < arr.size(); i++){
            System.out.print(arr.get(i));
        }
        System.out.println();
    }
}