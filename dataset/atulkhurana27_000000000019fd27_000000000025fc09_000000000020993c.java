import java.util.HashSet;
import java.util.Scanner;

class Vestigium {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int testCases = sc.nextInt();

        for(int i=1;i<=testCases;i++) {


            int len = sc.nextInt();
            int trace=0;

            int arr[][] = new int[len][len];

            int row=0;
            HashSet<Integer> h =null;
            boolean checkReq=false;

            int col=0;

            for(int j=0;j<len;j++) {
                h= new HashSet<>();
                checkReq=true;
                for(int k=0;k<len;k++) {
                    arr[j][k]=Integer.parseInt(sc.next());

                    if(j==k)
                        trace+=arr[j][k];


                    if(!h.add(arr[j][k]) && checkReq) {
                        checkReq=false;
                        row++;
                    }

                }
            }

            for(int j=0;j<len;j++) {
                h= new HashSet<>();
                checkReq=true;
                for(int k=0;k<len;k++) {
                    if(!h.add(arr[k][j]) && checkReq) {
                        checkReq=false;
                        col++;
                    }

                }
            }



System.out.println("Case #"+i+": "+trace+" "+row+" "+col);


        }



    }
}
