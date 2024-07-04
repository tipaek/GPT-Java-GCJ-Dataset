import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int ii = 0 ; ii < t; ii ++) {
//            int n = sc.nextInt();
            String s = sc.next();
            int n = s.length();
            s += "0";
            char arr[] = s.toCharArray();
//            int arr[] = new int[n + 1];
            StringBuilder st = new StringBuilder();
//            for(int i = 0; i < n; i ++) {
//                arr[i] = sc.nextInt();
//            }
            int cur = 0;
            for(int i = 0; i < n + 1; i ++) {
                int val = arr[i] - '0';
                if(val > cur) {
                    for(int j = 0; j < val - cur; j ++) {
                        st.append("(");
                    }
                }
                else if(val < cur) {
                    for(int j = 0; j < cur - val; j ++) {
                        st.append(")");
                    }
                }
                cur = val;
                st.append(val);
            }
            System.out.println("Case #" + ii + ": " + st.toString().substring(0, st.length() - 1));
        }
    }
}