import java.util.*;
public class Solution{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int z = 1;
        while(t-->0){
            String s = sc.next();
            int c = 0;
            StringBuffer sb = new StringBuffer();
            for(int i = 0;i<s.length();i++){
                char ch = s.charAt(i);
                int a = Integer.parseInt(String.valueOf(ch));
                if(c>a){
                    sb.append(getBrackets(')',c-a));
                    c-=(c-a);
                }else if(c<a){
                    sb.append(getBrackets('(',a-c));
                    c+=(a-c);
                }
                sb.append(a);
            }
            sb.append(getBrackets(')',c));
            System.out.println("Case #"+z+": "+sb);
            z++;
        }
    }
    public static String getBrackets(char ch, int n){
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<n;i++){
            sb.append(ch);
        }
        return sb.toString();
    }
}