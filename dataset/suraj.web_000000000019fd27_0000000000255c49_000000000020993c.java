import java.util.Scanner;

class q1soln {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T= in.nextInt();

        for (int j=0; j<T; j++)  {
            int N=in.nextInt();
            int noe=N*N;
            
            int a[] = new int[110];

            for (int i=0; i<noe; i++)  {
                a[i]=in.nextInt();
            }

            int trace=0;
            for (int i=0; i<noe; i=i+N+1)  {
                trace=trace+a[i];
            }

            int rmax=0, cmax=0;
            int rflag=0, cflag=0;

            int num=0, rcount=0;
            for (int mr=0; mr<noe; mr+=N)  {
                for (int i=mr; i<mr+N; i++) {
                    int r=i+1;
                    while (num<N-1)  {
                        if (a[i]==a[r]) {
                            rflag=1;
                            rcount++;
                        }
                        num++;                                                
                        r++;
                    }
                    
                }
                if (rcount>rmax)
                    rmax=rcount;
            }

            int ccount=0;
            for (int mc=0; mc<noe; mc+=4)  {
                for (int i=mc; i<mc+4; i++) {
                    for (int c=4; c>0; c--)  {

                    }
                }
            }
            

            int notimes=j+1;
            
            if (rflag==1)
                rcount++;
            if (cflag==1)
                ccount++;

            System.out.println("Case #" + notimes +": " + trace + " " + rcount + " " + ccount );
            


        }

        in.close();
    }

}