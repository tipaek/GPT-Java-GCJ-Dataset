import java.util.Scanner;
public class Solution {
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int T = s.nextInt();
            for(int a=1; a<=T; a++){
                String s2 = s.next();
                StringBuilder sb = new StringBuilder();
                int p=0;
                for(int i=0; i<s2.length(); i++){
                    int c=s2.charAt(i)-48;
                    if(c > p){
                        for(int j=0; j<c-p; j++){
                            sb.append("(");
                        }
                            p=c;
                        sb.append(s2.charAt(i));
                    }else{
                        for(int j=0; j<p-c; j++){
                            sb.append(")");
                        }                        
                            p=c;
                        sb.append(s2.charAt(i));
                    }
                }
                for(int j=0; j<s2.charAt(s2.length()-1)-48; j++){
                    sb.append(")");
                }
                System.out.println("Case #"+a+": "+sb);
            }
        }
}
