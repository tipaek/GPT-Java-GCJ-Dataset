import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();
        int tcCount = 1;
        StringBuilder output = new StringBuilder();
        while(tc-->0){
            int x = scn.nextInt();
            int y = scn.nextInt();
            String A = scn.next();
            int a = Math.abs(x)+Math.abs(y);
            int c = 0;
            int res = -1;
            int i=0;
            if(a==c){
                res=0;
            }
            else{
                while(i!=A.length()){
                    char ch = A.charAt(i);
                    if(ch=='N'){
                        y++;
                    }
                    else if(ch=='S'){
                        y--;
                    }
                    else if(ch=='E'){
                        x--;
                    }
                    else{
                        x++;
                    }
                    a = Math.abs(x)+Math.abs(y);
                    c=i+1;
                    if(a<=c){
                        res = c;
                        break;
                    }
                    i++;
                }
                output.append("Case #"+tcCount+++": "+((res==-1)?"IMPOSSIBLE":res)).append("\n");
            }
        }
        System.out.println(output);
    }
}