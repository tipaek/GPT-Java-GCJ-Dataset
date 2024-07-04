import java.util.*;
class main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int n;
        int k ;
        int r;
        int c;
        int k1[] = new int[p];
        int r1[] = new int[p];
        int c1[] = new int[p];
        List<Integer> row = new ArrayList<>();
        List<Integer> coloum = new ArrayList<>();
        for(int l =0;l<p;l++){
            n = sc.nextInt();
            k=0;r=0;c=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int temp = sc.nextInt();
                    if(i==j) k++;
                    if(row.contains(temp)){
                        r++;
                    }
                    else{
                        row.add(temp);
                    }
                }
                row.clear();
            }
            k1[l] = k;
            r1[l] = r;
            c1[l] = c;
        }
    }
}