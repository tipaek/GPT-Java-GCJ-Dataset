import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {


    public static void main(String[] args) {

        try{
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            int n =Integer.parseInt(read.readLine());
            int[][] out = new int[n][3];

            for(int i=0;i<n;i++){

                int m = Integer.parseInt(read.readLine());
                int[][] arr = new int[m][m];
                StringTokenizer tk ;

                for(int j=0;j<m;j++){
                    tk = new StringTokenizer(read.readLine().trim()," ");
                    for(int k=0;k<m;k++){
                        arr[j][k] = Integer.parseInt(tk.nextToken());
                    }
                }

                
                int row =0,col=0,sum=0;
                int[] cnt;

                for(int j=0;j<m;j++){
                    cnt = new int[m];
                    for(int k=0;k<m;k++){
                        cnt[(arr[j][k])-1]+=1;
                        if(cnt[(arr[j][k])-1]>1){
                            row++;
                            break;
                        }
                    }
                }

                for(int j=0;j<m;j++){
                    cnt = new int[m];
                    for(int k=0;k<m;k++){
                        cnt[(arr[k][j])-1]++;
                        if(cnt[(arr[k][j])-1]>1){
                            col++;
                            break;
                        }
                    }
                }

                for(int j=0;j<m;j++){
                    for(int k=0;k<m;k++){
                        if(j==k){
                            sum+=arr[j][k];
                            break;
                        }
                    }
                }

                out[i][0] = sum;
                out[i][1] = row;
                out[i][2] = col;

            }

            for(int i = 0;i<n;i++){
                System.out.println("Case #"+(i+1)+": "+out[i][0]+" "+out[i][1]+" "+out[i][2]);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}