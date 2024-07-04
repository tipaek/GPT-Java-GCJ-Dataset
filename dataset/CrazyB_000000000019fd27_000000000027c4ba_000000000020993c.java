import java.util.*;
public class Solution{


    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        int  t = in.nextInt();

        for (int i=1;i<=t;i++ ){
            int trace=0,r=0,c=0;
            ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();
            int n = in.nextInt();
            for (int j=1;j<=n;j++) {
                ArrayList<Integer> l = new ArrayList<Integer>();
                for (int k = 1; k <= n; k++) {
                    l.add(in.nextInt());
                }
                mat.add(l);
            }

            for (int j=0;j<n;j++){
                trace+=mat.get(j).get(j);
            }

            for (int j=0;j<n;j++){
                int hash[] = new int[n];
                for (Integer el : mat.get(j)){
                    if(hash[el+-1]!=0){
                        r++;
                        break;
                    }
                    hash[el-1]++;
                }
            }

            for (int k=0;k<n;k++){
                int hash[] = new int[n];
                for (int j=0;j<n;j++){
                    if(hash[mat.get(j).get(k)-1]!=0){
                        c++;
                        break;
                    }
                    hash[mat.get(j).get(k)-1]++;
                }
            }
            System.out.println("Case #"+ i +": "+trace + " " + r + " " + c);


        }



    }
}