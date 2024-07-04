import java.util.Scanner;
public class Solution {
    static Scanner scan = new Scanner(System.in);
    static class Person{
        int[] schedule = new int[1441];
        boolean check(int S, int E){
            for(S++; S<=E; S++)
                if(schedule[S] > 0)return false;
            return true;
        }
        void push(int S, int E){
            for(S++; S<=E; S++)
                schedule[S]++;
        }
    }
    static String sol(Person p1, Person p2, int N){
        if(N == 0)
            return "";
        int S = scan.nextInt(), E = scan.nextInt();
        String ans;
        if(p1.check(S, E)){
            p1.push(S, E);
            ans = sol(p1, p2, --N);
            if(ans.equals("IMPOSSIBLE"))return ans;
            return 'C'+ans;
        }
        if(p2.check(S, E)){
            p2.push(S, E);
            ans = sol(p1, p2, --N);
            if(ans.equals("IMPOSSIBLE"))return ans;
            return 'J'+ans;
        }
        return "IMPOSSIBLE";
    }
    public static void main(String args[]){
        int N, tc = scan.nextInt();
        for(int t = 1; t<=tc; t++){
            N = scan.nextInt();
            System.out.println("Case #"+t+": "+sol(new Person(), new Person(), N));
        }
        scan.close();
    }
}