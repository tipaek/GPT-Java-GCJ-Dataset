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


