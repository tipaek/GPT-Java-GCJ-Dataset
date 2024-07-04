import java.util.*;
class main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Byte p = sc.nextByte();
        Byte n;
        int k ;
        int r;
        int c;
        List<Integer> row = new ArrayList<>();
        List<Integer> coloum = new ArrayList<>();
        for(Byte l =0;l<p;l++){
            n = sc.nextByte();
            k=0;r=0;c=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j) k++;
                    if(row.contains(sc.nextInt())){
                        r++;
                    }
                    else{
                        row.add(sc.nextInt());
                    }
                }
                row.clear();
            }
            System.out.println("Case #"+(l+1)+": "+k+" "+r);
        }
    }
}