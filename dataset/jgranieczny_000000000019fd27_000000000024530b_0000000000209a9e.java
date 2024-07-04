
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();//test cases
        int B = scanner.nextInt();//bytes cases
        for(int i=0;i<T;i++){
            findWhole(B,scanner);
        }
    }

    private static void findWhole(int b,Scanner in) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<b;i++){
            System.out.println((i+1));
            System.out.flush();
            result.add(in.nextInt());
        }
        String s="";
        for(Integer integer:result){
            s+=integer+"";
        }
        System.out.println(s);
        System.out.flush();

    }
}