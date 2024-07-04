import java.util.Scanner;
 class solution {
     public static void main(String []args){
         Scanner in = new Scanner(System.in);
        short t=in.nextShort();
        for(short t1=0;t1<t;t1++){

            int n=in.nextShort();
            short arr[][]=new short[n][n];
            int trace=0;
            for(short i=0;i<n;i++){
                for(short j=0;j<n;j++){
                    arr[i][j]=in.nextShort();
                    if(i==j)
                        trace+=arr[i][j];
                }
            }
            short r=0,c=0;
            for(int i1=0;i1<n;i1++){

                short r1[] = new short[n];
                short c1[] = new short[n];
                for(int j1=0;j1<n;j1++){
                    r1[arr[i1][j1]-1]++;
                    c1[arr[j1][i1]-1]++;
                }
                boolean ro=true;
                boolean co=true;
                for(int k=0;k<n;k++){
                    if(r1[k]!=1&&ro){
                        r++;

                        ro=false;
                    }
                    if(c1[k]!=1&&co){
                        c++;
                        co=false;
                    }
                }
            }
            System.out.println("Case #"+(t1+1)+": "+trace+" "+r+" "+c);

        }
     }
}
