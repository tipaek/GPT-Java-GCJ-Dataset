import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0;i<t;i++){
            String str = s.next();
            char prev = ' ';
            StringBuffer sb = new StringBuffer("");
            for(int j=0;j<str.length();j++){
                char curr = str.charAt(j);
                if(curr == '1' && (prev == ' ' || prev == '0')) sb.append("(1");
                else if(curr == '1' && prev == '1') sb.append("1");
                if(curr == '1' && j != str.length()-1 && str.charAt(j+1) == '0') sb.append(")");
                if(curr == '0') sb.append("0");
                prev = curr;
            }
            if(str.charAt(str.length()-1) == '1') sb.append(")");
            System.out.println("Case #"+(i+1)+": "+sb);
        }
    }
}