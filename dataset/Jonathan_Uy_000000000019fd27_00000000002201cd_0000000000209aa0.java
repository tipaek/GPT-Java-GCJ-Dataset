import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            System.out.printf("Case #%d: ", t);
            
            if(N == 2){
                if(K == 2){
                    System.out.println("POSSIBLE\n1 2\n2 1");
                } else if(K == 3){
                    System.out.println("IMPOSSIBLE");
                } else if(K == 4){
                    System.out.println("POSSIBLE\n2 1\n1 2");
                }
            } else if(N == 3){
                if(K == 3){
                    System.out.println("POSSIBLE\n1 2 3\n3 1 2\n2 3 1");
                } else if(K == 4){
                    System.out.println("IMPOSSIBLE");
                } else if(K == 5){
                    System.out.println("IMPOSSIBLE");
                } else if(K == 6){
                    System.out.println("POSSIBLE\n2 1 3\n3 2 1\n1 3 2");
                } else if(K == 7){
                    System.out.println("IMPOSSIBLE");
                } else if(K == 8){
                    System.out.println("IMPOSSIBLE");
                } else if(K == 9){
                    System.out.println("POSSIBLE\n3 2 1\n1 3 2\n2 1 3");
                }
            } else if(N == 4){
                if(K == 4){
                    System.out.println("POSSIBLE\n1 2 3 4\n4 1 2 3\n3 4 1 2\n2 3 4 1");
                } else if(K == 5){
                    System.out.println("IMPOSSIBLE");
                } else if(K == 6){
                    System.out.println("POSSIBLE\n1 3 4 2\n4 2 1 3\n3 1 2 4\n2 4 3 1");
                } else if(K == 7){
                    System.out.println("POSSIBLE\n1 3 4 2\n4 2 1 3\n2 1 3 4\n3 4 2 1");
                } else if(K == 8){
                    System.out.println("POSSIBLE\n1 4 3 2\n3 2 1 4\n2 1 4 3\n4 3 2 1");
                } else if(K == 9){
                    System.out.println("POSSIBLE\n1 4 2 3\n2 3 1 4\n3 1 4 2\n4 2 3 1");
                } else if(K == 10){
                    System.out.println("POSSIBLE\n1 4 2 3\n3 2 4 1\n4 1 3 2\n2 3 1 4");
                } else if(K == 11){
                    System.out.println("POSSIBLE\n4 1 3 2\n3 2 4 1\n2 4 1 3\n1 3 2 4");
                } else if(K == 12){
                    System.out.println("POSSIBLE\n4 1 2 3\n2 3 4 1\n3 4 1 2\n1 2 3 4");
                } else if(K == 13){
                    System.out.println("POSSIBLE\n4 2 1 3\n1 3 4 2\n3 4 2 1\n2 1 3 4");
                } else if(K == 14){
                    System.out.println("POSSIBLE\n4 1 2 3\n2 3 4 1\n1 4 3 2\n3 2 1 4");
                } else if(K == 15){
                    System.out.println("IMPOSSIBLE");
                } else if(K == 16){
                    System.out.println("POSSIBLE\n4 3 2 1\n1 4 3 2\n2 1 4 3\n3 2 1 4");
                }
            } else if(N == 5){
                if(K == 5){
                    System.out.println("POSSIBLE\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1");
                } else if(K == 6){
                    System.out.println("IMPOSSIBLE");
                } else if(K == 7){
                    System.out.println("POSSIBLE\n1 4 5 3 2\n3 2 1 4 5\n4 1 2 5 3\n2 5 3 1 4\n5 3 4 2 1");
                } else if(K == 8){
                    System.out.println("POSSIBLE\n1 4 3 5 2\n4 2 1 3 5\n3 5 2 1 4\n5 1 4 2 3\n2 3 5 4 1");
                } else if(K == 9){
                    System.out.println("POSSIBLE\n1 4 5 2 3\n2 3 1 4 5\n4 1 3 5 2\n3 5 2 1 4\n5 2 4 3 1");
                } else if(K == 10){
                    System.out.println("POSSIBLE\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2");
                } else if(K == 11){
                    System.out.println("POSSIBLE\n1 3 5 2 4\n2 4 1 3 5\n3 1 4 5 2\n4 5 2 1 3\n5 2 3 4 1");
                } else if(K == 12){
                    System.out.println("POSSIBLE\n2 4 5 1 3\n1 3 2 4 5\n4 2 3 5 1\n3 5 1 2 4\n5 1 4 3 2");
                } else if(K == 13){
                    System.out.println("POSSIBLE\n1 3 4 2 5\n2 5 1 3 4\n3 1 5 4 2\n5 4 2 1 3\n4 2 3 5 1");
                } else if(K == 14){
                    System.out.println("POSSIBLE\n2 3 5 1 4\n1 4 2 3 5\n3 2 4 5 1\n4 5 1 2 3\n5 1 3 4 2");
                } else if(K == 15){
                    System.out.println("POSSIBLE\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3");
                } else if(K == 16){
                    System.out.println("POSSIBLE\n4 3 1 5 2\n5 2 4 3 1\n3 4 2 1 5\n2 1 5 4 3\n1 5 3 2 4");
                } else if(K == 17){
                    System.out.println("POSSIBLE\n5 3 2 4 1\n4 1 5 3 2\n3 5 1 2 4\n1 2 4 5 3\n2 4 3 1 5");
                } else if(K == 18){
                    System.out.println("POSSIBLE\n4 2 1 5 3\n5 3 4 2 1\n2 4 3 1 5\n3 1 5 4 2\n1 5 2 3 4");
                } else if(K == 19){
                    System.out.println("POSSIBLE\n5 3 1 4 2\n4 2 5 3 1\n3 5 2 1 4\n2 1 4 5 3\n1 4 3 2 5");
                } else if(K == 20){
                    System.out.println("POSSIBLE\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4");
                } else if(K == 21){
                    System.out.println("POSSIBLE\n5 2 1 4 3\n4 3 5 2 1\n2 5 3 1 4\n3 1 4 5 2\n1 4 2 3 5");
                } else if(K == 22){
                    System.out.println("POSSIBLE\n5 2 3 1 4\n2 4 5 3 1\n3 1 4 5 2\n1 5 2 4 3\n4 3 1 2 5");
                } else if(K == 23){
                    System.out.println("POSSIBLE\n5 2 1 3 4\n3 4 5 2 1\n2 5 4 1 3\n4 1 3 5 2\n1 3 2 4 5");
                } else if(K == 24){
                    System.out.println("IMPOSSIBLE");
                } else if(K == 25){
                    System.out.println("POSSIBLE\n5 4 3 2 1\n1 5 4 3 2\n2 1 5 4 3\n3 2 1 5 4\n4 3 2 1 5");
                }
            }
        }
    }
}