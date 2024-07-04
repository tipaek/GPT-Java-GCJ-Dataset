import java.util.ArrayDeque;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ntc = sc.nextInt();
        sc.nextLine();
        int currTest = 1;
        while(currTest<=ntc) {
            String s = sc.nextLine();
            StringBuilder ansStr = new StringBuilder();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            int prev = 0;
            int diff = 0;
            int n=0;
            for(int i=0;i<s.length();i++){
                n = Integer.parseInt(Character.toString(s.charAt(i)));
                diff = n-prev;
                if(diff>=0){
                    while(diff-- > 0){
                        ansStr.append('(');
                        stack.push(')');
                    }
                }else{
                    diff = Math.abs(diff);
                    while(diff-->0){
                        ansStr.append(stack.pop());
                    }
                }
                ansStr.append(n);
                prev= n;
            }
            while(!stack.isEmpty()){
                ansStr.append(stack.pop());
            }
            System.out.println("Case #"+currTest+": "+ansStr);
            currTest++;
        }
    }
}
