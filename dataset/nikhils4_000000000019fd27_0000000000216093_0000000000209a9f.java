import java.util.*;

class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int test = sc.nextInt();
        sc.nextLine();
        int caseno = 1;
        while(test-->0){
            boolean zero = true;
            int paren = 0;
            String orig = sc.nextLine();
            for(int i = 0; i < orig.length(); i++){
                if(Character.getNumericValue(orig.charAt(i)) - paren > 0){
                    while(Character.getNumericValue(orig.charAt(i)) - paren > 0){
                        sb.append('(');
                        paren++;
                    }
                } else if (Character.getNumericValue(orig.charAt(i)) - paren < 0) {
                    while(Character.getNumericValue(orig.charAt(i)) - paren < 0){
                        sb.append(')');
                        paren--;
                    }
                }
                sb.append(orig.charAt(i));
            }
            if(paren > 0){
                while(paren-->0){
                    sb.append(')');
                }
            }
        
            System.out.println("Case #" + caseno++ + ": " + sb);
            sb = new StringBuilder();
            
        }
    }
}