import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();

        for(int ti=1;ti<=t;ti++){
            String seq = in.nextLine();
            int len = seq.length();
            String ans = "";
            boolean isOpen = false;

            for(int i=0;i<len;i++){
                if(seq.charAt(i) == '0'){
                    if(isOpen){
                        ans = ans + ")0";
                        isOpen = false;
                    }else{
                        ans+="0";
                    }
                } else {
                    if(isOpen){
                        ans+="1";
                    }else{
                        ans = ans + "(1";
                        isOpen = true;
                    }
                }
            }
            if(isOpen)
                ans+=")";
            System.out.println("Case #"+ti+": "+ans);

        }
    }
}