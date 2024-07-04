import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Ranks().read();
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
        String temp[]=br.readLine().split(" ");
        int r=Integer.valueOf(temp[0]);
        int s=Integer.valueOf(temp[1]);
        int arr[]=new int [r*s];

        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<s;i++){
            for(int j=0;j<r;j++)
                list.add(j+1);
        }
        //System.out.println(list);

        int i=0;
        int val1=0;
        int val2=0;
        StringBuilder sb=new StringBuilder();
        int count=0;
        while(i<list.size()) {
            i=1;
            ArrayList<Integer> A=new ArrayList<>();
            ArrayList<Integer> B=new ArrayList<>();
            A.add(list.get(i-1));
            while (i<list.size()-1 && list.get(i) >= list.get(i - 1)) {
                A.add(list.get(i));
                i++;
            }
            //System.out.println(A);
            if(A.isEmpty()) break;
            if(i>list.size()-1) break;
            int high = A.get(A.size() - 1);
            while (high > list.get(i)) {
                B.add(list.get(i));
                i++;
            }
            if(B.isEmpty()) break;
            //System.out.println(B);
            i = 0;
            while (i < B.size()) {
                list.set(i, B.get(i));
                i++;
            }
            for (int j = 0; j < A.size(); j++) {
                list.set(i++, A.get(j));
            }
            //break;
            sb.append(A.size()+" "+B.size()+"\n");
            count++;

        }
        print(testNumber,count,sb.toString());

        //System.out.println(list);
    }

    public void print(int testNumber, int count, String result) {
        System.out.format("Case #%d: %d\n%s",testNumber,count,result);
    }
}
