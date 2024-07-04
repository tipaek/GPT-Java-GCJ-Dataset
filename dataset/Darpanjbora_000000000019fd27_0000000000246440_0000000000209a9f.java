import java.io.*;
import java.util.*;

class NestingDepth{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        char[] s_brac = new char[]{'(','(','(','(','(','(','(','(','('};
        char[] e_brac = new char[]{')',')',')',')',')',')',')',')',')'};
        int t = 0;
        while(t<T)
        {
            String s = sc.nextLine();
            StringBuilder output = new StringBuilder();
            Stack<Integer> st = new Stack<Integer>();
            int i=0;
            int closeCount = 0;
            while(i<s.length())
            {
                int topChar = Integer.parseInt(s.charAt(i)+"");
                if(st.isEmpty()){
                    output.append(s_brac, 0, topChar);
                    closeCount += topChar;
                    output.append(topChar);
                    st.push(topChar);
                }
                else if(!st.isEmpty()){
                    int topElem = st.pop();
                    if(topElem - topChar > 0){
                        output.append(e_brac,0,topElem - topChar);
                        closeCount += topChar-topElem;
                        output.append(topChar);
                        st.push(topChar);
                    }
                    else if(topElem - topChar < 0){
                        output.append(s_brac,0,topChar-topElem);
                        closeCount += topChar-topElem;
                        output.append(topChar);
                        st.push(topChar);
                    }else if(topElem-topChar == 0){
                        output.append(topChar);
                        st.push(topChar);
                    }
                }
                i++;
            }
            output.append(e_brac,0, closeCount);
            System.out.println("Case #"+(t+1)+": "+output);
            t++;
        }
        sc.close();
    }
}