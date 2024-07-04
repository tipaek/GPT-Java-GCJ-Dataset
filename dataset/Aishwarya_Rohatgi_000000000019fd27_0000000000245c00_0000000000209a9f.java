import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i<n; i++){
            String s = sc.nextLine();
            s = s + "0";
            Stack<Character> st = new Stack<>();
            String str = "";
            for(int j = 0; j<s.length(); j++){
                if(s.charAt(j) == '0'){
                    String str1 = "";
                    while(!st.isEmpty()){
                        char ch = st.pop();
                        str1 = str1 + ch;
                    }
                    if(str1.length() != 0){
                        str1 = "(" + str1 + ")";
                    }
                    str = str + str1 + s.charAt(j);
                } else {
                    st.push(s.charAt(j));
                }
            }
            System.out.println("Case #" + (i+1) + ":" + " " + str.substring(0, str.length() - 1));
        }
    }
}