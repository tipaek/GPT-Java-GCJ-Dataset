import java.io.*;
import java.util.*;

class Solution{
    public static void main(String args[])throws IOException{
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int c = 0;
        while(c++!=t){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String s = scanner.nextLine();
            int f = -1;
            for(int i=1; i<s.length(); i++){
                char tc = s.charAt(i);
                if(tc=='S')
                y-=1;
                if(tc=='N')
                y+=1;
                if(tc=='E')
                x+=1;
                if(tc=='W')
                x-=1;
                int distance = (x<0?-x:x);
                distance+= (y<0?-y:y);
                if(distance- (i)<=0){
                    f = i;
                    break;
                }
            }
            System.out.print("Case #"+c+": ");
            if(f==-1){
                System.out.println("IMPOSSIBLE");
            }
            else{
                System.out.println(""+f);
            }
        }
    }
}