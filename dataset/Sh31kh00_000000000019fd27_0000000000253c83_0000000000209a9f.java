import java.io.IOException;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

    public static void fixStack(Stack<String> st) {
        String mainStr = st.pop();
        int left = mainStr.charAt(mainStr.length()-1) - 48;
        while(!st.empty()) {
            String temp = st.pop();
            int two = temp.charAt(temp.length()-1) - 48;
            if(two > left) {
                int diff = two-left;
                for(int j=0; j<diff; j++) {
                    temp = "(" + temp + ")";
                }
            } else if(left > two){
                int diff = left-two;
                left = two;
                for(int j=0; j<diff; j++) {
                    mainStr = "(" + mainStr + ")";
                }
            }
            mainStr = temp + mainStr;
        }
        for(int x=0; x<left; x++) {
            mainStr = "(" + mainStr + ")";
        }
        st.push(mainStr);
    }

    public static String updateStr(String s) {
        Stack<String> st = new Stack<>();
        int currentMax = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int max = c-48;

            if(c == '0') {
                if(st.size() == 0) {
                    st.push("0");
                } else {
                    fixStack(st);
                    st.push(st.pop()+"0");
                }
            }
            else if(max > currentMax) {
                st.push(c+"");
            }else {
                String str = st.pop();
                int diff = currentMax-max;
                for(int j=0; j<diff; j++) {
                    str = "(" + str + ")";
                }
                str += c;
                st.push(str);
            }
            currentMax = max;
        }

        fixStack(st);

        return st.pop();
    }

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.valueOf(bufferedReader.readLine());
        for(int i=0; i<tc; i++) {
            String s = bufferedReader.readLine();
            String finalStr = updateStr(s);
            System.out.println("Case #"+(i+1)+": "+finalStr);
        }
    }

}