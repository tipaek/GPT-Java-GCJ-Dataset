import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.println("Case #"+(i+1)+": "+solve(in));
        }
    }
    public static String solve(Scanner in){
        int N = in.nextInt();
        String[]data = new String[N];
        StringBuilder ans1 = new StringBuilder();
        for (int j = 0; j < N; j++) {
            data[j]=in.next();

        }
        while(true){
            HashSet<Character>stuff = new HashSet<>();
            for (int i = 0; i < N; i++) {
                if(data[i].charAt(0)=='*'){
                    continue;
                }
                stuff.add(data[i].charAt(0));
                data[i]=data[i].substring(1);
            }
            if(stuff.size()==0){
                break;
            }
            if(stuff.size()==1){
                for(char x:stuff){
                    ans1.append(x);
                }
            }
            else{
                return "*";
            }
        }
        for (int i = 0; i < N; i++) {
            String temp = data[i];
            int j = temp.length()-1;
            for(;j>=0;j--){
                if(temp.charAt(j)=='*'){
                    break;
                }
            }
            temp = temp.substring(0,j);
            for (int k = 0; k < temp.length()-1; k++) {
                if(temp.charAt(k)!='*'){
                    ans1.append(temp.charAt(k));
                }
            }
            data[i]=data[i].substring(j);
        }
        //solves from asterick to end
        StringBuilder ans2 = new StringBuilder();
        int dist = 1;
        while(true){
            HashSet<Character>stuff = new HashSet<>();
            for (int i = 0; i < N; i++) {
                if(data[i].length()-dist>=0){
                    char e = data[i].charAt(data[i].length() - dist);
                    if(e !='*')
                        stuff.add(e);
                }
            }
            if(stuff.size()==0){
                return ans1.toString()+ans2.toString();
            }
            else if(stuff.size()!=1){
                return "*";
            }
            Iterator<Character>temp = stuff.iterator();
            ans2.insert(0, temp.next());
            dist++;
        }
    }
}
