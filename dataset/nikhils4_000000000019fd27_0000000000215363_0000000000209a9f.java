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
            int val = Integer.parseInt(orig);
            while(val > 0){
                zero = false;
                int num = val%10;
                if(num - paren > 0){
                    while(num - paren > 0){
                        sb.append(')');
                        paren++;
                    }
                } else if (num - paren < 0) {
                    while(num - paren < 0){
                        sb.append('(');
                        paren--;
                    }
                }
                sb.append(val%10);
                val = val/10;
            }
            if(paren > 0){
                while(paren-->0){
                    sb.append('(');
                }
            }
            
            if(zero == true){
                System.out.println("Case #" + caseno++ + ": " + orig);
            } else {
                System.out.println("Case #" + caseno++ + ": " + sb.reverse());
                sb = new StringBuilder();
            }
        }
    }
}