import java.io.*;
class Solution{
    public static void main(String []arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            String s = br.readLine();
            StringBuilder sb = new StringBuilder("");
            int digit = s.charAt(0) - 48;
            for(int j=0;j<digit;j++){
                sb.append("(");
            }
            sb.append(digit);
            int open = digit;
            for(int i=1;i<s.length();i++){
                digit = s.charAt(i)-48;
                if(digit > open){
                    for(int j=0;j<digit-open;j++){
                        sb.append("(");
                    }
                }else if(digit < open){
                    for(int j=0;j<open-digit;j++){
                        sb.append(")");
                    }
                }
                sb.append(digit);
                open = digit;
            }
            for(int i=0;i<open;i++){
                sb.append(")");
            }
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }
}