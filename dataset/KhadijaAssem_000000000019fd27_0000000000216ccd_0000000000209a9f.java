
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int k = 0; k < t; k++) {
            String output = "";
            String s = input.next();
            int[] arr = new int[s.length()];
//            System.out.println(s);
            Stack<Character> st = new Stack();
            for(int i=0;i<s.length();i++){
//                System.out.println("HERE 1 "+output);
                arr[i] = Integer.parseInt((String.valueOf(s.charAt(i))));
                if(st.size()<arr[i]) {
//                    System.out.println("HERE 2 "+output+" st size "+st.size()+" arr "+arr[i]);
                    for (int j = 0; j < arr[i]; j++) {
                        output+="(";
//                        output.concat("(");
                        st.push(')');
                    }
                }
                else if (st.size()>arr[i]){
//                    System.out.println("HERE 3 "+output);
                    while(st.size()>arr[i]){
//                        System.out.println("HERE 4"+output);
                        st.pop();
                        output+=")";
//                        output.concat(")");
                    }
                }
//                st.push(s.charAt(i));
                output+=String.valueOf(s.charAt(i));
//                System.out.println("HERE 5 "+output);
//                output.concat();
//                System.out.println(arr[i]);
            }
            while (st.size()!=0){
                st.pop();
                output+=")";
            }
            System.out.println("Case #" + (k+1) + ": "+output);
        }
    }
}
