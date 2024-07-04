import java.util.*;
import java.io.*;
public class Solution {
    

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int K = in.nextInt();
            int mat[][] = new int[N][N];
            if(K%N==0){
                int sumt=0;

                System.out.println("Case #"+i+": POSSIBLE");
                for(int j=0; j<N; j++){
                    for(int y=0; y<N; y++){
                        int o = N - j;
                        mat[j][y] = (o+y)%N + 1;
                        if(j==y)
                            sumt+=mat[j][y];

                    }
                }

                if(sumt==K){
                    for(int j=0; j<N; j++){
                        for(int y=0; y<N; y++){
                            System.out.print(mat[j][y]+" ");
                        }
                        System.out.println();
                    }
                }
                else{
                    final int temp[][] = mat;
                    int n = 0;

                    int b = 0;
                    List<Integer> c = new ArrayList<>();
                    for(int y=0; y<N; y++){

                        for(int s=0; s<temp.length; s++){
                            b=0;
                            for(int l=0; l<temp.length; l++)
                            {
                                if(temp[s][l]==(K/N) && s==n){
                                   c.add(l);
                                   
                                   b=1;
                                   break;
                                   }
                            }
                            if(b==1)
                            {
                                break;
                            }
                        }
                        n++;
                    }
                    
                        
                        for(int j=0; j<N; j++){
                            for(int co : c){
                            System.out.print(temp[j][co]+" ");
                        }
                        System.out.println();
                    }
                    
                    
                }
            }
            else{
                System.out.println("Case #"+i+": IMPOSSIBLE");
            }

        }
    }

}