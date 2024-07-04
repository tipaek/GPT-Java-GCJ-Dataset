import java.util.Scanner;

class Main {
    public static String balance(String str) {
        StringBuilder st = new StringBuilder();
        int have = 0;
        
        for (int i = 0; i < str.length(); i++) {
            int want = str.charAt(i) - '0';
            
            if (have < want) {
                for (int j = 0; j < want - have; j++) {
                    st.append("(");
                }
            } else if (have > want) {
                for (int j = 0; j < have - want; j++) {
                    st.append(")");
                }
            }
            
            st.append(str.charAt(i));
            have = want;
        }
        
        for (int i = 0; i < have; i++) {
            st.append(")");
        }
        
        return st.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        
        for (int i = 1; i <= t; i++) {
            String str = scn.next();
            String balancedStr = balance(str);
            System.out.println("Case #" + i + ": " + balancedStr);
        }
        
        scn.close();
    }
}