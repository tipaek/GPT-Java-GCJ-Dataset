import java.util.*;
import java.io.*;

public class Solution{
    
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i=0; i<t; i++){
            System.out.print("Case #" + (i + 1) + ": ");
            solve(in);
        }
        in.close();
    }
    
    public static void solve(Scanner in){
        System.out.println("");
        int n = in.nextInt();
        if(n < 40){
            int t = (n + 1)/2;
            for(int i=1; i<=t; i++){
                System.out.println(i + " " + 1);
            }
            if(n%2 == 0){
                t++;
            }
            if(n > 3){
                System.out.println(t + " " + 2);
            }else if(n == 3){
                System.out.println("3 " + 1);
            }else if(n == 2){
                System.out.println("2 " + 1);
            }
        }else{
            List<Integer> list = new ArrayList<>();
            int x = n - 31;
            for(int i=0 ; i<31; i++){
                if(x%2 == 1){
                    list.add(i);
                }
                x/=2;
            }
            boolean start = true;
            int pointer = 0;
            for(int i=0; i<31 + list.size(); i++){
                if(pointer < list.size() && list.get(pointer) == i){
                    pointer ++;
                    for(int j=0; j <= i; j++){
                        if(start){
                            System.out.println((i + 1) + " " + (j + 1));
                        }else{
                            System.out.println((i + 1) + " " + (i + 1 - j));
                        }
                    }
                    start = !start;
                }else{
                    if(start){
                        System.out.println((i + 1) + " " + (1));
                    }else{
                        System.out.println((i + 1) + " " + (i + 1));
                    }
                }
            }
        }
    }
    
}