import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().read();
    }

    public void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        for (int t = 1; t <= T; t++) {
            this.testCase(t, br);
        }
        br.close();
    }

    public void testCase(int testNumber, BufferedReader br) throws Exception{
        int N=Integer.valueOf(br.readLine());
        StringBuilder sb=new StringBuilder();

        ArrayList<ArrayList<Double>> data=new ArrayList<>();
        data.add(new ArrayList<>());
        data.add(new ArrayList<>());
        data.get(1).add(1.0);
        ArrayList<Double> temp=new ArrayList<>();
        temp.add(1.0);
        temp.add(1.0);
        data.add(temp);
        for(int r=3;r<501;r++){
            temp=new ArrayList<>();
            temp.add(1.0);
            for(int k=1;k<r-1;k++){
                //System.out.println(data.size());
                temp.add(data.get(r-1).get(k-1)+data.get(r-1).get(k));
            }
            temp.add(1.0);
            data.add(temp);
        }
        if(N<=501){
            int val=N;
            if(val>=1){
                sb.append("1 1");
                val--;
            }
            if(val>=1){
                sb.append("\n2 1");
                val--;
            }
            int row=2;
            int col=row;
            if(val>400){
                append(sb, 2,2);
                val--;
                //System.out.print(data.get(2));
                for(int c=3;c>=1;c--) {

                    append(sb, 3, c);
                    val-=data.get(3).get(c-1);
                    //System.out.println("data: "+data.get(3).get(c-1));

                }
                for(int c=1;c<4;c++) {
                    //System.out.print("Val: "+val);
                    append(sb, 4, c);
                    val-=data.get(4).get(c-1);
                }

                row=4;
                col=row;

            }
            while (val > 0) {
                append(sb,row,col);
                val--;
                row++;
                col++;
            }


        }else{


            int val=N;
            val--;
            sb.append(1);
            sb.append(" ");
            sb.append(1);
            int row=2;
            while(val>= 499-row){
                if(row%2==0) {
                    for (int c = 0; c < row; c++) {
                        val -= data.get(row).get(c);
                        append(sb,row,c+1);
                    }
                }else{
                    for (int c = row-1; c >=0; c--) {
                        val -= data.get(row).get(c);
                        append(sb,row,c+1);
                    }
                }
                row++;
            }
            if(row%2==0){
                while(val>0){
                    append(sb,row,1);
                    val--;
                    row++;
                }
            }else{
                while(val>0){
                    append(sb,row,row);
                    val--;
                    row++;
                }
            }


        }
        print(testNumber,sb.toString());
    }
    public void append(StringBuilder sb, int row, int col){
        sb.append("\n"+row);
        sb.append(" "+col);
    }
    public void print(int testCase, String result) {
        System.out.format("Case #%d: \n",testCase);
        System.out.println(result);

    }
}
