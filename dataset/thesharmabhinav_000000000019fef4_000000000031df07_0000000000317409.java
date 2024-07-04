import java.util.*;
import java.io.*;

class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(sc.nextLine());
        for(int i1=0;i1<t;i1++){
            String xy = sc.nextLine();
            String xys[] = xy.split("\\s+");
            int x = Integer.parseInt(xys[0]);
            int y = Integer.parseInt(xys[1]);
            String p = xys[2];
            int l = p.length();
            int tx  = x, ty = y, ans = -1;
            for(int i=0;i<l;i++){
                if(Math.abs(tx) + Math.abs(ty)<=i){ans = i; break;};
                if(p.charAt(i) == 'N') ty++;
                if(p.charAt(i) == 'S') ty--;
                if(p.charAt(i) == 'E') tx++;
                if(p.charAt(i) == 'W') ty--;
            }
            if(Math.abs(tx) + Math.abs(ty)<=l && ans == -1) ans = l;
            System.out.print("Case #"+(i1+1)+": ");
            if(ans == -1) System.out.print("IMPOSSIBLE");
            else System.out.print(ans);
            System.out.println();
        }
    
    }

}