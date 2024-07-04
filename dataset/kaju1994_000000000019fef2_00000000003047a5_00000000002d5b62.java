import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t = scanner.nextInt();
        int i = 1;
        int distance = 0;
        while(i<=t){
            int x,y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            distance = Math.abs(x)+Math.abs(y);
            int maxPower = getMaxPower(distance);
            if( isPossibleDistance(distance, maxPower) ){
                System.out.println("Case #" + i + ": " + moves(0,0, x, y, 0, ""));
            }else{
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
            i++;
        }
    }

    public static boolean isPossibleDistance(int number, int pow){
        if(pow <= 0){
            if(number==1 || number==-1)
                return true;
            else
                return false;
        }
        int jump = (int)Math.pow(2,pow);
        return isPossibleDistance(number-jump, pow-1) || isPossibleDistance(number+jump, pow-1);
    }

    private static int getMaxPower(int number) {
        int i=0;
        while((int)Math.pow(2,i) < number){
            i++;
        }
        return i>0 ? i-1 : 0;
    }

    private static String moves(int a, int b, int x, int y, int i, String ans) {
        if(a == x && b == y){
            return ans;
        }
        if(a > Math.abs(x) && b > Math.abs(y) ){
            return "IMPOSSIBLE";
        }
        int jump = (int)Math.pow(2, i);
        String s[]=new String[4];
        if(a + jump <= Math.abs(x))
            s[0] = moves(a+jump, b, x, y, i+1, ans+"E");
        if(a - jump <= 0 && -(a - jump) <= Math.abs(x))
            s[1] = moves(a-jump, b, x, y, i+1, ans+"W");
        if(b + jump <= Math.abs(y))
            s[2] = moves(a, b+jump, x, y, i+1, ans+"N");
        if(b - jump <= 0 && -(b - jump) <= Math.abs(y))
            s[3] = moves(a, b-jump, x, y, i+1, ans+"S");
        return findBest(s);
    }

    private static String findBest(String s[]) {
        String result = "";
        int minLength = Integer.MAX_VALUE;
        for(int i=0;i<s.length;i++){
            if(s[i]!=null && !s[i].equals("IMPOSSIBLE") && s[i].length() < minLength){
                result = s[i];
                minLength = result.length();
            }
        }
        if(result.isEmpty())
            return "IMPOSSIBLE";
        return result;
    }
}