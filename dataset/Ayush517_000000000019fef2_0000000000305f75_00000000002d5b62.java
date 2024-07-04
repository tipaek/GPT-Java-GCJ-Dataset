import java.math.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);

        int testcases = ob.nextInt();

        for (int test = 1; test<=testcases; test++) {
            long x=ob.nextLong();
            long y=ob.nextLong();
            boolean dirX = (x>=0), dirY =(y>=0);
            x = Math.abs(x);
            y = Math.abs(y);
            boolean possible = true;
            StringBuilder result=new StringBuilder();

            if((x%2==0 && y%2!=0) || (x%2!=0 && y%2==0)){
                // both fill -> easy
                while((x!=0 || y!=0) && possible){
                    if(x+y == 1){
                        if(x==0) {
                            if(dirY){
                                result.append("N");
                            }
                            else{
                                result.append("S");
                            }
                        }else{
                            if(dirX){
                                result.append("E");
                            }
                            else{
                                result.append("W");
                            }
                        }
                        x=0;y=0;
                        break;
                    }
                    if(x%2==0 || x==0){
                        //work on y
                        if(check(x/2,(y+1)/2)){
                            if(!dirY){
                                result.append("N");
                            }
                            else{
                                result.append("S");
                            }
                            x = x/2;
                            y = (y+1)/2;
                        }
                        else if(check(x/2,(y-1)/2)){
                            if(dirY){
                                result.append("N");
                            }
                            else{
                                result.append("S");
                            }
                            x = x/2;
                            y = (y-1)/2;
                        }
                    }
                    else if(y%2==0 || y ==0){

                        if(check(y/2,(x+1)/2)){
                            if(dirX){
                                result.append("W");
                            }
                            else{
                                result.append("E");
                            }
                            y = y/2;
                            x = (x+1)/2;
                        }
                        else if(check(y/2,(x-1)/2)){
                            if(!dirX){
                                result.append("W");
                            }
                            else{
                                result.append("E");
                            }
                            y = y/2;
                            x = (x-1)/2;
                        }
                    }
                    else
                        possible=false;
                    // cout << x << " "<<y << endl;
                }
            }
            else
                possible = false;
            if(!possible)
                result = new StringBuilder("IMPOSSIBLE");

            System.out.println("Case #"+test+": "+result.toString());
        }
    }

    static boolean check(long x,long y){
        if(x+y==0)
            return true;
        return ((x%2==0 && y%2!=0) || (x%2!=0 && y%2==0));
    }
}
