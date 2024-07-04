import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1 ; i <= t ; i++){
            String ans = null;
            int x = sc.nextInt();
            int y = sc.nextInt();
            int sum = Math.abs(x) + Math.abs(y) ;
            int nearest = getNearest2Power(sum);
            if((nearest - sum) % 2 != 0 ){
                ans = "IMPOSSIBLE";
            }
            else{
                if( x <= 0 && y >= 0){
                    ans = getQuadrant1(Math.abs(x),Math.abs(y),sum, nearest);
                }
                else if( x >= 0 && y >= 0){
                    ans = getQuadrant2(Math.abs(x),Math.abs(y),sum,nearest);
                }
                else if(x >= 0 && y <= 0){
                    ans = getQuadrant3(Math.abs(x),Math.abs(y),sum,nearest);
                }
                else if(x <= 0 && y <= 0){
                    ans = getQuadrant4(Math.abs(x),Math.abs(y),sum,nearest);
                }
            }
            System.out.printf("Case #%d: %s\n",i,ans);
        }
    }

    private static String getQuadrant4(int x, int y, int sum, int nearest) {
        StringBuilder ans = new StringBuilder();
        char[] dir = new char[2];
        if(nearest == sum) {
            ans = getWithoutCorrection(x, y, 'S', 'W', 0);
        }
        else{
            int difference = (nearest - sum);
            int correction = difference / 2 ;
            int power = 0;
            dir[0] = 'N';
            dir[1] = 'E';
            int index = x > y ? 1 : 0 ;
            while(correction != 0 ){
                ans.append(dir[index]);
                correction -= Math.pow(2,power);
                power++;
            }
            ans.append(getWithoutCorrection(x, y + (difference / 2), 'S', 'W', power));
        }
        return ans.toString();
    }

    private static String getQuadrant3(int x, int y,int sum, int nearest) {
        StringBuilder ans = new StringBuilder();
        char[] dir = new char[2];
        if(nearest == sum) {
            ans = getWithoutCorrection(x, y, 'S', 'E',0 );
        }
        else{
            int difference = (nearest - sum);
            int correction = difference / 2 ;
            int power = 0;
            dir[0] = 'N';
            dir[1] = 'W';
            int index = x > y ? 1 : 0 ;
            while(correction != 0 ){
                ans.append(dir[index]);
                correction -= Math.pow(2,power);
                power++;
            }
            ans.append(getWithoutCorrection(x, y + (difference / 2), 'S', 'E', power));
        }
        return ans.toString();
    }

    private static String getQuadrant2(int x, int y, int sum, int nearest) {
        StringBuilder ans = new StringBuilder();
        char[] dir = new char[2];
        if(nearest == sum){
            ans = getWithoutCorrection(x, y, 'N', 'E', 0);
        }
        else{
            int difference = (nearest - sum);
            int correction = difference / 2 ;
            int power = 0;
            dir[0] = 'S';
            dir[1] = 'W';
            int index = x > y ? 1 : 0 ;
            while(correction != 0 ){
                ans.append(dir[index]);
                correction -= Math.pow(2,power);
                power++;
            }
            ans.append(getWithoutCorrection(x, y + (difference / 2), 'N', 'E', power));
        }
        return ans.toString();
    }

    private static String getQuadrant1(int x, int y, int sum,  int nearest) {
        StringBuilder ans = new StringBuilder();
        char[] dir = new char[2];
        if(nearest == sum) {
            ans = getWithoutCorrection(x, y, 'N', 'W', 0);
        }
        else{
            int difference = (nearest - sum);
            int correction = difference / 2 ;
            int power = 0;
            dir[0] = 'S';
            dir[1] = 'E';
            int index = x > y ? 1 : 0 ;
            while(correction != 0 ){
                ans.append(dir[index]);
                correction -= Math.pow(2,power);
                power++;
            }
            ans.append(getWithoutCorrection(x, y + (difference / 2), 'N', 'W', power));
        }
        return ans.toString();
    }

    private static StringBuilder getWithoutCorrection(int x, int y, char dir1, char dir2, int power){
        StringBuilder ans = new StringBuilder();
        char[] dir = new char[2];
        dir[0] = dir1;
        dir[1] = dir2;
        int index = y % 2 == 1 ? 0 : 1;
        while(x != 0 || y != 0){
            ans.append(dir[index]);
            if(index == 1){
                x -= Math.pow(2,power);
                if(x == 0){
                    index = 0;
                }
            }
            else{
                y -= Math.pow(2,power);
                if(y == 0){
                    index = 1 ;
                }
            }
            power++;
        }
        return ans;
    }

    private static int getNearest2Power(int num) {
        int sum = 0;
        for(int i = 0 ; i < num ; i++){
            sum += Math.pow(2,i);
            if(sum >= num){
                break;
            }
        }
        return sum;
    }
}
