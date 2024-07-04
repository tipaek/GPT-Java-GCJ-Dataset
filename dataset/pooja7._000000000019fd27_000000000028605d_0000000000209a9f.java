import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for(int t=0; t<test; t++) {
            String str = sc.next();
            Stack<Character> st = new Stack<>();
            System.out.print("Case #"+(t+1)+": ");
            for(int i=0; i<str.length(); i++) {
                int num = Integer.parseInt(str.charAt(i)+"");
                int size = st.size();
                if(size < num) {
                    for(int j=1; j<=(num-size); j++) {
                        System.out.print("(");
                        st.push('(');
                    }
                    System.out.print(num);
                } else if(size > num){
                    for(int j=1; j<=(size-num); j++) {
                        System.out.print(")");
                        st.pop();
                    }
                    System.out.print(num);
                } else {
                    System.out.print(num);
                }
            }
            for(int i=0; i<st.size(); i++) {
                System.out.print(")");
            }

            System.out.println();
        }
    }
}
