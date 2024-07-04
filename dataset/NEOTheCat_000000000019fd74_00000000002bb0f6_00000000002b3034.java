import java.util.Scanner;

public class Solution {
    private static String PATTEN = "Case #%d: %s";
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int p = 1; p <= t; p++) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] slist = new String[n];
            for (int i =0;i<n;i++){
                slist[i] = sc.nextLine();
            }
            String ans = slist[0];
            boolean flag =  true;
            for (int i =1;i<slist.length;i++){
                ans = connect(ans, slist[i]);
                if (ans == null){
                    System.out.println(String.format(PATTEN, p, "*"));
                    flag = false;
                    break;
                }
            }
            if (flag){
                ans = ans.replace("*","");
                System.out.println(String.format(PATTEN, p, ans));
            }
        }
    }

    private static String connect(String s1, String s2){
        s1= "!"+ s1 +"!";
        s2 = "!"+s2+"!";
        StringBuilder sb = new StringBuilder();
        String[] s1list = s1.split("\\*");
        String[] s2list = s2.split("\\*");
        String x = s1list[0];
        String y  =s2list[0];
        if (x.length()>y.length()){
            if (x.substring(0,y.length()).equals(y)){
                sb.append(x);
            } else {
                return null;
            }
        } else if (x.length()<y.length()){
            if (y.substring(0,x.length()).equals(x)){
                sb.append(y);
            } else {
                return null;
            }
        } else {
            if (x.equals(y)){
                sb.append(x);
            } else {
                return null;
            }
        }
        if ((s1list.length>1) && (s2list.length>1)){
            sb.append("*");
            for (int i=1;i<s1list.length-1;i++){
                sb.append(s1list[i]);
            }
            for (int i=1;i<s2list.length-1;i++){
                sb.append(s2list[i]);
            }
            sb.append('*');
        }
         x = s1list[s1list.length-1];
         y  =s2list[s2list.length-1];
        if (x.length()>y.length()){
            if (x.substring(x.length()-y.length()).equals(y)){
                if (s1list.length!=1){
                    sb.append(x);
                }
            } else {
                return null;
            }
        } else if (x.length()<y.length()){
            if (y.substring(y.length()-x.length()).equals(x)){
                if (s2list.length!=1){
                    sb.append(y);
                }
            } else {
                return null;
            }
        } else {
            if (x.equals(y)){
                sb.append(x);
            } else {
                return null;
            }
        }
        return sb.toString().replace("!","");
    }

}
