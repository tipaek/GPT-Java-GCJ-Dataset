import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static boolean md(int a){
        return ((((a%2)+2)%2)!=0);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int tt = 1; tt<= t; tt++){
            int x = in.nextInt();
            int y = in.nextInt();
            boolean impossible = false;
            ArrayList<Character> result = new ArrayList<>();
            while(true){
                //System.out.println(" dup "+ x + y + String.valueOf(result));
                if(x==1 && y == 0){
                    result.add('E');
                    break;
                }
                if(x==-1 && y == 0){
                    result.add('W');
                    break;
                }
                if(x==0 && y == 1){
                    result.add('N');
                    break;
                }
                if(x==0 && y == -1){
                    result.add('S');
                    break;
                }
                if((md(x)&&md(y)) || (!md(x) && !md(y))){
                    impossible = true; //check nested loops later
                    break;
                }
                int px = 0, nx = 0;
                char pc= '0', nc = '0';
                //System.out.println(" dup "+ x + y + String.valueOf(result));
                if(md(x)){
                    y = y/2;
                    int x1 = (x+1)/2;
                    int x2 = (x-1)/2;
                    if(!md(x1)){
                        px = x1;
                        pc = 'W';
                        nx = x2;
                        nc = 'E';

                    }else{
                        px = x2;
                        pc = 'E';
                        nx = x1;
                        nc = 'W';
                    }
                    if(md(y)){
                        x = px;
                        result.add(pc);
                    }else{
                        x = nx;
                        result.add(nc);
                    }
                }else{
                    x = x/2;
                    int y1 = (y+1)/2;
                    int y2 = (y-1)/2;
                    if(!md(y1)){
                        px = y1;
                        pc = 'S';
                        nx = y2;
                        nc = 'N';
                    }else{
                        px = y2;
                        pc = 'N';
                        nx = y1;
                        nc = 'S';
                    }
                    if(md(x)){
                        y = px;
                        result.add(pc);
                    }else{
                        y = nx;
                        result.add(nc);
                    }
                }

            }
            if(impossible){
                System.out.println("Case #" + tt + ": IMPOSSIBLE");
            }else{
                System.out.print("Case #" + tt + ": ");
                for(char c : result){
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }

}
