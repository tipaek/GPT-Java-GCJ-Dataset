import java.util.*;

class Solution {

    static String display(String s){
        int[] numarr = new int[s.length()];
        Stack<Integer> high = new Stack<>();
        Stack<Integer> last = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            numarr[i] = Character.getNumericValue(s.charAt(i));
        }

        String ans = "";
        for(int i = 0; i < numarr.length; i++){
            if(high.isEmpty() && last.isEmpty()){
                high.push(numarr[i]);
                last.push(numarr[i]);
                for(int j = 0; j < numarr[i]; j++){
                    ans += "(";
                }
                ans += Integer.toString(numarr[i]);
                continue;
            }

            if(numarr[i] == 0){
                for(int a = 0; a < last.peek(); a++){
                    ans += ")";

                }
                ans += numarr[i];
                last.push(numarr[i]);
            }

            else if(last.peek() == numarr[i]){
                ans += Integer.toString(numarr[i]);
                continue;
            }

            else if(last.peek() > numarr[i]){

                for(int k = 0; k < (last.peek() - numarr[i]); k++){
                    ans += ")";
                }
                ans += numarr[i];
                last.push(numarr[i]);
            }

            else{
                //ans = balance(ans);
                for(int j = 0; j < (numarr[i] - last.peek()); j++){
                    ans += "(";
                }
                ans += numarr[i];
                last.push(numarr[i]);
            }

        }
        return ans;
    }

    static String balance(String s){

        int index = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                index++;
            }
        }

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                index--;
            }
        }
        if(index > 0){
            for(int i = 0; i < index; i++){
                s += ")";
            }
        }

        return s;
    }


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for(int k = 1; k <= t; k++){
            String str = scan.next();
            //System.out.println(display(str));
            String strr = display(str);
            System.out.println("Case #" + k + ": " + balance(strr));
        }
    }

}
