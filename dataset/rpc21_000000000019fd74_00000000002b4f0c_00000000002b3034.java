import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int test = 1; test<=t; test++){
            int n = in.nextInt();
            PriorityQueue<String> pq = new PriorityQueue<String>(Comparator.comparing(String::length).reversed());
            pq.add(in.next());
            boolean possible = true;
            for(int i = 1; i<n; i++){
                String next = in.next();
                String head = pq.peek();
                for(int j=0; j<Math.min(next.length(), head.length())-1;j++){
                    if(next.charAt(next.length()-1-j) != head.charAt(head.length()-1-j)){
                        possible = false;
                    }
                }
                pq.add(next);
            }
            if(possible){
                String answer = pq.poll().substring(1);
                System.out.println(String.format("Case #%d: %s", test, answer));
            }
            else {
                System.out.println(String.format("Case #%d: *", test));
            }
        }
    }
}
