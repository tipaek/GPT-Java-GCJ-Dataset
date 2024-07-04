import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {


    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int test;

        for(test=1;test<=t;test++){
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][n];

            int i,j;
            String[] s;
            int[] checker = new int[n+1];
            for(i=0;i<n;i++){
                s = br.readLine().trim().split(" ");
                for(j=0;j<n;j++){
                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }

            int r=0,c=0;
            for(i=0;i<n;i++){
                Arrays.fill(checker,0);
                for(j=0;j<n;j++){
                    checker[arr[i][j]]++;
                }
                for(int k=1;k<n;k++){
                    if(checker[k]==0 || checker[k]>1){
                        r++;
                        break;
                    }
                }
            }
            for(i=0;i<n;i++){
                Arrays.fill(checker,0);
                for(j=0;j<n;j++){
                    checker[arr[j][i]]++;
                }
                for(int k=1;k<n;k++){
                    if(checker[k]==0 || checker[k]>1){
                        c++;
                        break;
                    }
                }
            }
            int trace=0;
            for(i=0;i<n;i++){
                trace += arr[i][i];
            }

            System.out.println("Case #"+test+": "+trace+" "+r+" "+c);

        }


    }


}
