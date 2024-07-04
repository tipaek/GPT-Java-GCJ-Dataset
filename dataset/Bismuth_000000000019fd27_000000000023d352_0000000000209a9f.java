import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String S;
        StringBuilder ans = new StringBuilder();
        StringBuilder text = new StringBuilder();
        for(int i =0; i<T; i++){
            S = sc.next();
            S = S.replace("1", "(1)");
            S = S.replace("2", "((2))");
            S = S.replace("3", "(((3)))");
            S = S.replace("4", "((((4))))");
            S = S.replace("5", "(((((5)))))");
            S = S.replace("6", "((((((6))))))");
            S = S.replace("7", "(((((((7)))))))");
            S = S.replace("8", "((((((((8))))))))");
            S = S.replace("9", "(((((((((9)))))))))");
            while(S.contains(")(")){
                S = S.replace(")(", "");
            }
            ans.append("Case #" + (i + 1) + ": "+ S+"\n");
        }
        System.out.println(ans.toString());
    }
}   