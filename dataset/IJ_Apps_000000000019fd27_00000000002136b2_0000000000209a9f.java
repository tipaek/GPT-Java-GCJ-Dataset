import java.util.Scanner;

public class Solution {
    static String out;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nam = sc.nextInt();
        sc.nextLine();
        for (int tr = 0; tr < nam; tr++) {
            String S = sc.nextLine();
            out = "";
            int o = 0, c = 0, counter = 0;
            for (char ch : S.toCharArray()) {
                int n = Integer.parseInt("" + ch);
                if(counter == 0){
                    o = n;
                    c = 0;
                    addOpenFirst(o,n, c);
                }else{
                    int prev = Integer.parseInt("" + S.charAt(counter - 1));
                    if(n == prev){
                        //addLast(n, n, n);
                        //o=n;
                        out+=n;
                    }else if(n > prev){
                        o += n - prev;
                        addOpenFirst(n-prev, n, 0);
                    }else{
                        o-=  prev-n;
                        //System.out.println("Out: " + out);
                        String temp = addCloseFirst(0, n, prev-n);
                        //System.out.println("New: " + temp);
                    }
                }

                counter++;
            }
            for(int i = 0; i < o; i++) out+=")";
            System.out.println("Case #" + (tr+1) + ": " +out);
        }
    }
    public static String addLast(int o, int n, int c){
        for(int i = 0; i < c; i++) out += ")";
        for(int i = 0; i < o; i++) out += "(";
        out+= n;
        return out;
    }
    public static String addCloseFirst(int o, int n, int c){
        for(int i = 0; i < c; i++) out += ")";
        out+= n;
        for(int i = 0; i < o; i++) out += "(";
        return out;
    }

    public static String addOpenFirst(int o, int n, int c){
        for(int i = 0; i < o; i++) out += "(";
        out+= n;
        for(int i = 0; i < c; i++) out += ")";
        return out;
    }
}
