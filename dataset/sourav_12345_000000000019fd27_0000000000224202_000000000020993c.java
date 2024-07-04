import java.io.*;
import java.util.HashSet;

class Solution{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for(int i=0;i<tc;i++){
            int msize = Integer.parseInt(br.readLine());
            int matrix[][] = new int[msize][msize];
            int ds = 0,dr=0,dc=0;
            HashSet<Integer> hs = new HashSet<>();
            for(int j=0;j<msize;j++){
                String s[] = br.readLine().split(" ");
                boolean isDupfound =false;
                for(int k = 0;k<msize;k++){
                    int current=Integer.parseInt(s[k]);
                    if(k==j){
                        ds+=current;
                    }
                    if(!isDupfound){
                        if(hs.contains(current)){
                            dr++;
                            isDupfound=true;
                        }
                        else
                            hs.add(current);
                    }

                    matrix[j][k] = current;
                }
                isDupfound=false;
                hs.clear();
            }
//            for (int j = 0; j < msize; j++) {
//                for (int k = 0; k < msize; k++) {
//                    System.out.print(matrix[j][k]+" ");
//                }
//                System.out.println();
//            }
            //hs.clear();
            for (int j = 0; j < msize ; j++) {
                for (int k = 0; k < msize; k++) {
                    if(hs.contains(matrix[k][j])){
                        dc++;
                        break;
                    }
                    else
                        hs.add(matrix[k][j]);

                }
                hs.clear();
            }
            bw.write("Case #"+(i+1)+": "+ds+" "+dr+" "+dc+"\n");

        }
        bw.flush();
    }
}