import java.util.*;
public class Solution {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int testcase = 1 ;
        while(t--!=0){
            int r = in.nextInt();
            int c = in.nextInt();
            int [][]visited = new int[r][c];
            int [][]grid = new int[r][c];
            for(int i=0;i<r;++i){
                for(int j=0;j<c;++j){
                    grid[i][j] = in.nextInt();
                }
            }
            long skills = 0;
            while(true) {
                boolean changed = true;
                List<int[]> ret = new ArrayList<>();
                for (int i = 0; i < r; ++i) {
                    for (int j = 0; j < c; ++j) {
                        if (visited[i][j] != -1) skills += (long) grid[i][j];
                        else continue;
                        int count = 0;
                        long temp = 0;
                        int temp_i = i+1;
                        while (temp_i< r&&visited[temp_i][j]==-1) {

                            temp_i+=1;
                        }
                        if(temp_i!=r){
                            temp += grid[temp_i][j];
                            count++;
                        }
                        temp_i = i-1;
                        while(temp_i>= 0&&visited[temp_i][i]==-1) {
                            temp_i-=1;
                        }
                        if(temp_i>=0){
                            temp += grid[temp_i][j];
                            count++;
                        }
                        int temp_j = j-1;
                        while (temp_j>= 0&&visited[i][temp_j]==-1) {
                            temp_j-=1;
                        }
                        if(temp_j>=0){
                            temp += grid[i][temp_j];
                            count++;
                        }
                        temp_j = j+1;
                        while(temp_j< c&&visited[i][temp_j]==-1) {
                            temp_j+=1;
                        }
                        if(temp_j<c){
                            temp += grid[i][temp_j];
                            count++;
                        }
                        if(count==0)continue;
                        double avg = (double) (temp) / (double) count;
                        if (avg > (double) grid[i][j]) {
                            visited[i][j] = -2;
                            ret.add(new int[]{i,j});
                            changed = false;
                        }
                       // System.out.println(" cell : "+i+" : "+j+" sum : "+temp+" count : "+count);
                    }
                }
                for(int []k : ret)visited[k[0]][k[1]] = -1;

                if(changed)break;
            }
            System.out.println("Case #"+testcase+": "+skills);
            testcase++;
        }
    }
}
