import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t =0; t<T; t++){
            String s = in.next();
            String result = find_nesting(s);
            System.out.println(String.format("Case #%d: %s", t+1, result));
        }
    }

    public static String find_nesting(String str){
        int depth = 0;
        String result = "";
        for(char c : str.toCharArray()){
            int n = c - '0';
            if(n>depth){
                while(n>depth){
                    result += ("(");
                    depth++;
                }
            }
            if(n<depth){
                while(n<depth){
                    result += (")");
                    depth--;
                }
            }
            result += (c);
        }
        while(depth>0){
            result += (")");
            depth--;
        }
        return result;
    }
}
