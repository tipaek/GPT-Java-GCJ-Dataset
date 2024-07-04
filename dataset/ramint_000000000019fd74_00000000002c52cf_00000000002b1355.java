import java.util.*;

public class Solution {


    public static void main(String [] args ) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for(int tt=0;tt<t;tt++) {

            int r = scanner.nextInt();
            int c = scanner.nextInt();

            int [][] grid = new int[r][c];
            int ans = 0;
            for(int i=0;i<r;i++) {
                for(int j=0;j<c;j++) {
                    grid[i][j] = scanner.nextInt();
                    //ans+=grid[i][j];
                }
            }

            int [][] used = new int[r][c];
            
            while(true) {
                boolean cont = false;    
                int all = 0;   
                
                List<Pair> list = new ArrayList<>();
                for(int i=0;i<r;i++) {
                    for(int j=0;j<c;j++) {
                        double sum_neigh = 0;
                        int cnt = 0;
                        for(int k=i-1;k>=0;k--) {
                            if(used[k][j]==0) {
                                sum_neigh+=grid[k][j];
                                cnt++;
                                break;
                            }
                            
                        }
                        for(int k=i+1;k<r;k++) {
                            if(used[k][j]==0) {
                                sum_neigh+=grid[k][j];
                                cnt++;
                                break;
                            }
                            
                        }
                        for(int k=j-1;k>=0;k--){
                            if(used[i][k]==0) {
                                sum_neigh+=grid[i][k];
                                cnt++;
                                break;
                            }
                            
                        }
                        for(int k=j+1;k<c;k++){
                            if(used[i][k]==0) {
                                sum_neigh+=grid[i][k];
                                cnt++;
                                break;
                            }
                            
                        }
                        if(cnt>0){
                            double average = sum_neigh/cnt;
                            if(used[i][j]==0 && (grid[i][j] <  average)){
                                list.add(new Pair(i,j));
                                cont = true;
                            }
                            else if(used[i][j]==0 && (grid[i][j] >=average)) {
                                all++;
                            }
                        }
                    }
                }

                for(int i=0;i<r;i++) {
                    for(int j=0;j<c;j++) {
                        if(used[i][j]==0 ) {
                            ans+=grid[i][j];
                        }
                    }
                }

                if(cont) {
                    for(int i=0;i<list.size();i++) {
                        Pair p = list.get(i);
                        used[p.getFirst()][p.getSecond()] = 1;
                    }
                }

                if(!cont){
                    break;
                }


            }

            System.out.println("Case #" + (tt+1) + ": " + ans);
        }

    }
}

class Pair {

    private Integer first;
    private Integer second;

    public Pair(Integer first ,Integer second) {
        this.first = first;
        this.second = second;
    }

    public Integer getFirst() {
        return first;
    }

    public Integer getSecond() {
        return second;
    }


}