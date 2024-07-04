import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int q = 1; q <= n; q++){
            String s = sc.next();
            System.out.printf("Case #%d: %s%n", q, doNest(s));
        }
    }

    static String doNest(String s){
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();
        int ac = 0;
        for (char c: chars){
            int val = (int)c - 48;
            int rep = Math.abs(val - ac);
            char compliment = val >= ac? '(': ')';
            for(int i = 0; i < rep; i++){
                str.append(compliment);
            }
            str.append(c);
            ac = val;
        }
        for(int i = 0; i < ac; i++){
            str.append(')');
        }
        return str.toString();
    }
}
