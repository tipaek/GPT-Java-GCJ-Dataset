import java.util.*;
public class CodeJamQualifiers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int [] fvals = new int[test*3];
        int fcount = 0;
        for(int h =0;h<test;h++){
            int nn = sc.nextInt();
            int[][]arr = new int[nn][nn];
            for(int i =0;i<nn;i++){
                for(int k = 0;k<nn;k++){
                    arr[i][k] = sc.nextInt();
                }
            }
            int trace = 0;
            int inx = 0;
            int iny = 0;
            while(inx!=nn-1&&iny!=nn-1){
                trace+=arr[inx][iny];
                inx++;
                iny++;
            }
            trace += arr[nn-1][nn-1];
            int rows = 0;
            int[]el = new int[nn];
            for(int i =0;i<nn;i++){
                el[i] = i+1;
            }
            int[]row = new int[nn];
            for(int i =0;i<nn;i++){
                for(int j = 0;j<nn;j++){
                    row[j] = arr[i][j];
                }
                boolean add = false;
                for(int k = 0;k<nn;k++){
                    if(search(row,el[k])==-1){
                        add = true;
                        break;
                    }
                }
                if(add){
                    rows++;
                }
            }
            int columns = 0;
            int[]col = new int[nn];
            for(int i =0;i<nn;i++){
                for(int j = 0;j<nn;j++){
                    col[j] = arr[j][i];
                }
                boolean add = false;
                for(int k =0;k<nn;k++){
                    if(search(col,k+1)==-1){
                        add = true;
                        break;
                    }
                }
                if(add){
                    columns++;
                }
            }
            fvals[fcount] = trace;
            fcount++;
            fvals[fcount] = rows;
            fcount++;
            fvals[fcount] = columns;
            fcount++;
        }
        int num = 1;
        for(int i =0;i<test*3;i+=3){
            System.out.println("Case #"+(num)+": "+fvals[i]+" "+fvals[i+1]+" "+fvals[i+2]);
            num++;
        }
    }
    public static int search(int[]a,int x){
        for(int i =0;i<a.length;i++){
            if(a[i]==x){
                return i;
            }
        }
        return -1;
    }
}
