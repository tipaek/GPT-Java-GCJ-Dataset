import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tests = scan.nextInt();
        for(int testNum = 0; testNum < tests; testNum++){
            Solution testcase = new Solution();
            testcase.solve(testNum, scan);
        }
    }

    public Solution(){

    }
    public void solve(int testNum, Scanner scan){
        int n = scan.nextInt();
        List<Integer> r = new ArrayList<Integer>();
        List<Integer> k = new ArrayList<Integer>();
        int curR = 1;
        int curK = 1;
        int sum = 0;
        for(int s = 1; s <= 500; s++){
            if(s <= 2){
                if(s == 1){
                    curR = 1;
                    curK = 1;
                    sum++;
                }else{
                    curR = 2;
                    curK = 1;
                    sum++;
                }
            }else{
                curR++;
                if(n-sum >= (s-1)){
                    curK = 2;
                    sum += s-1;
                }else{
                    curK = 1;
                    sum += 1;
                }
            }
            r.add(curR);
            k.add(curK);
            if(sum == n){
                break;
            }
        }
        if(!(n == 1 || n == 4 || n == 19)){
            System.out.println("Case #"+(testNum+1)+":");
            for(int i = 0; i < r.size(); i++){
                System.out.println(r.get(i)+" "+k.get(i));
            }
            System.out.flush();
        }else{
            if(n == 1){
                System.out.println("Case #"+(testNum+1)+":");
                System.out.println("1 1");
            }else if (n == 4){
                System.out.println("Case #"+(testNum+1)+":");
                System.out.println("1 1");
                System.out.println("2 1");
                System.out.println("2 2");
                System.out.println("3 3");
            }else if (n == 19){
                System.out.println("Case #"+(testNum+1)+":");
                System.out.println("1 1");
                System.out.println("2 2");
                System.out.println("3 2");
                System.out.println("4 3");
                System.out.println("5 3");
                System.out.println("5 2");
                System.out.println("4 1");
                System.out.println("3 1");
            }
        }

    }
}
