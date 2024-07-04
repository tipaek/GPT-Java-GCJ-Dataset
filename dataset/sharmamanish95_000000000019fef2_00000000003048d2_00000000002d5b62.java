import java.util.Scanner;
import java.util.Stack;

class Solution {
    static Stack<String> stack;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i<=t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            stack = new Stack<>();
            boolean res = jumpRec(0,0,x,y,1);
            if(res) {
                StringBuilder sb = new StringBuilder();
                for(String s : stack)
                    sb.append(s);
                System.out.println("Case #"+ i +": " + sb.toString());
            }else {
                System.out.println("Case #"+ i +": IMPOSSIBLE");
            }
        }
    }
    
    static boolean jumpRec(int srcX, int srcY, int destX, int destY, int jump) {
        if(srcX==destX && srcY==destY)
            return true;
        if(!valid(srcX,srcY, destX, destY))
        	return false;
        
        boolean b1, b2, b3, b4;
        
        stack.push("N");
        b1 = jumpRec(srcX, (srcY+(int)Math.pow(2, jump-1)), destX, destY, jump+1);
        if(b1==true)
        	return true;
        else
        	stack.pop();
        
        stack.push("E");
        b2 = jumpRec(srcX+(int)Math.pow(2, jump-1), srcY, destX, destY, jump+1);
        if(b2==true)
        	return true;
        else
        	stack.pop();
        
        stack.push("W");
        b3 = jumpRec(srcX-(int)Math.pow(2, jump-1), srcY, destX, destY, jump+1);
        if(b3==true)
        	return true;
        else
        	stack.pop();
        
        stack.push("S");
        b4 = jumpRec(srcX, srcY-(int)Math.pow(2, jump-1), destX, destY, jump+1);
        if(b4==true)
        	return true;
        else
        	stack.pop();
        return false;
    }
    
    static boolean valid(int srcX, int srcY, int destX, int destY) {
    	return (srcX>=(0-Math.abs(destX)) && srcX<=(Math.abs(destX)) && 
    			srcY>=(0-Math.abs(destY)) && srcY<=(Math.abs(destY)));
    }
    
}