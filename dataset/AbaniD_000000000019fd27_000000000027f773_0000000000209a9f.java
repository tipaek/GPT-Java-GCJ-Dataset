import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            String input = sc.next();
            StringBuilder sb = new StringBuilder();
            int n = input.length();
            boolean started = false;
            int countBraces = 0;
            
            for(int i = 0; i < n; i++){
                if(started){
                    while(i < n && input.charAt(i) != '0' && input.charAt(i) != input.charAt(i - 1)){
                        sb.append("(" + input.charAt(i));
                        countBraces++;
                        i++;
                    }
                    while(i < n && input.charAt(i) != '0' && input.charAt(i) == input.charAt(i - 1)){
                        sb.append(Character.toString(input.charAt(i)));
                        i++;
                    }
                    while(countBraces > 0){
                        sb.append(")");
                        countBraces--;
                    }
                    started = false;
                }
                if(i < n){
                    if(input.charAt(i) != '0'){
                        countBraces = 1;
                        sb.append("(" + input.charAt(i));
                        started = true;
                    }
                    else {
                        sb.append(Character.toString(input.charAt(i)));
                    }
                }
            }
            if(started){
                sb.append(")");
            }
            System.out.println("Case #" + t + ": " + sb);
        }
    }
}