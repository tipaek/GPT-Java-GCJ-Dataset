import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System. in);
        String input = scanner.nextLine();
        int numOfCases = Integer.parseInt(input);
        for(int i=0;i<numOfCases;i++) {
            input = scanner.nextLine();
            int x=Integer.parseInt(input.split(" ")[0]);
            int y=Integer.parseInt(input.split(" ")[1]);
            TestCase tc = new TestCase(x,y);
            String result = tc.getResult();
            System.out.println("Case #"+(i+1)+": "+result);
        }

    }

    public static class TestCase {
        int x;
        int y;
        public TestCase(int x, int y) {
            this.x=x;
            this.y=y;

        }

        private String getResult() {
            StringBuilder sb = new StringBuilder();
            int dist = Math.abs(x)+Math.abs(y);
            int sum=1;
            int index=1;
            while (sum<dist) {
                index*=2;
                sum+=index;
            }
//            System.out.println(String.format("%d %d %d %d", index, sum, x, y));
            while(index>=1) {
                if (Math.abs(x)>Math.abs(y)) {
                    if (x<0) {
                        x+=index;
                        sb.append("W");
                    } else{
                        x-=index;
                        sb.append("E");
                    }
                } else {
                    if (y<0) {
                        y+=index;
                        sb.append("S");
                    } else{
                        y-=index;
                        sb.append("N");
                    }
                }
                index/=2;
//                System.out.println(String.format("%d %d %d %d", index, sum, x, y));
            }
//            System.out.println(String.format("%d %d %d %d", index, sum, x, y));
            if (x!=0 || y!=0) {
                return "IMPOSSIBLE";
            }
            sb.reverse();

            return sb.toString();
        }
    }
}