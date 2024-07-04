import java.util.*;

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
    int r;
    int c;
    int elimCount = 0;
    int interest = 0;
    public void solve(int testNum, Scanner scan){
        r = scan.nextInt();
        c = scan.nextInt();
        int[][] skills = read(scan);
        elimCount = -1;
        while(elimCount != 0){
            interest+=calcInterest(skills);
            int[][][] cover = findCover(skills);
            int[][] avgcover = average(cover);
            elimCount = 0;
            skills = eliminate(skills, avgcover);
        }
        System.out.println("Case #"+(testNum+1)+": "+interest);
        System.out.flush();
    }
    public int calcInterest(int[][] skills){
        int sum = 0;
        for(int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum += skills[i][j];
            }
        }
        return sum;
    }
    public int[][] eliminate(int[][] skills, int [][] avgcover){
        for(int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(avgcover[i][j] > skills[i][j]){
                    skills[i][j] = 0;
                    elimCount++;
                }
            }
        }
        return skills;
    }
    public int[][] average(int[][][] cover){
        int[][] avgcover = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++) {
                int count = 0;
                int sum = 0;
                for(int k = 0; k < 4; k++){
                    if(cover[r][c][k] != 0){
                        sum+=cover[r][c][k];
                        count++;
                    }
                }
                int avg = count/sum;
                avg++;
                avgcover[i][j] = avg;
            }
        }
        return avgcover;
    }
    public int[][][] findCover(int[][] skills){
        int[][][] cover = new int[r][c][4];
        for(int i = 0; i < skills.length; i++){
            for(int j = 0; j < skills[0].length; j++){
                if(skills[i][j] != 0){
                    for(int k = 0; k < 4; k++){
                        int newr = i;
                        int newc = j;
                        boolean stop = false;
                        while(!stop){
                            switch(k){
                                case 0:
                                    newr--;
                                    break;
                                case 1:
                                    newc--;
                                    break;
                                case 2:
                                    newr++;
                                    break;
                                case 3:
                                    newc--;
                                    break;
                                default:
                                    break;
                            }
                            cover[newr][newc][(k+2)%4] = skills[i][j];
                            if(skills[newr][newc] != 0){
                                stop = true;
                            }
                        }
                    }
                }
            }
        }
        return cover;
    }
    public int[][] read(Scanner scan){
        int[][] skills = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                skills[i][j] = scan.nextInt();
            }
        }
        return skills;
    }
}
