import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.print("Case #"+i+": ");
            solve(in);
        }

    }
    public static void solve(Scanner in){
        int U = in.nextInt();
        HashSet<Character>[]impossible = new HashSet[10];
        for (int i = 0; i < 10; i++) {
            impossible[i]=new HashSet<>();
        }
        HashSet<Character>vals = new HashSet<>();
        //10^U-1 is includisve upperbound
        for(int i = 0;i<10000;i++){
            long M = in.nextLong();
            if(M==-1){
                M = (long)Math.pow(10,U)-1;
            }
            String R = in.next();
            long min = (long)Math.pow(10,R.length()-1);
            long max = Math.min(M,(long)Math.pow(10,R.length())-1);
            for(int j = R.length()-1;j>=0;j--){
                for(int k = 0;k<min%10;k++){
                    impossible[k].add(R.charAt(j));
                }
                if(max<10)
                for(int k = (int)max%10+1;k<10;k++){
                    impossible[k].add(R.charAt(j));
                }
                vals.add(R.charAt(j));
                min/=10;
                max/=10;
            }
        }
        //System.out.println(Arrays.toString(impossible));
        HashSet<Character>[] possible = new HashSet[10];
        for (int i = 0; i < 10; i++) {
            possible[i]=new HashSet<>();
        }
        for(int i = 0;i<10;i++){
            HashSet<Character> temp = new HashSet<>(vals);
            for(char x:impossible[i]){
                temp.remove(x);
            }
            for(char x:temp) {
                possible[i].add(x);
            }
        }
        //System.out.println(Arrays.toString(possible));
        int rem = 10;
        char ans[]=new char[10];
        while(rem>0){
            for (int i = 0; i < 10; i++) {
                if(possible[i].size()==1){
                    rem--;
                    for(char x:possible[i]){
                        ans[i]=x;
                    }
                    for (int j = 0; j < 10; j++) {
                        possible[j].remove(ans[i]);
                    }
                }
            }
        }
        for(int i = 0;i<10;i++){
            System.out.println(ans[i]);
        }

    }
}
