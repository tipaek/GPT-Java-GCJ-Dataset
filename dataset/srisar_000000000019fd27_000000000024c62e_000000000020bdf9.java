import java.util.*;

class Solution{
    
      public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();

        int t = 0;

        while(t<test){


            int k = scanner.nextInt();

            long[][] arr = new long[k][2];

            for (int i = 0; i < k; i++) {

                for (int j = 0; j < 2; j++) {

                    arr[i][j] = scanner.nextLong();
                }
            }

            char[] character = new char[k*2];


          long[] ar = new long[k*2];

            int e = 0;

            for (int i = 0; i <k ; i++) {

                for (int j = 0; j < 2; j++) {


                       ar[e]  = arr[i][j];

                       e++;

                }
            }

            int u = 1 ;

            character[0] = 'J';

            long temp1 = 0;
            long temp2 = 0;
            long temp3 = 0;
            long temp4 = 0;

            boolean value = false;

          for(int j=0; j<ar.length;j=j+2) {


  if(j==0){

      temp3 = ar[0];
      temp4 = ar[1];
  }

  if(j>0) {

    temp1 = ar[j];
    temp2 = ar[j+1];

    if(temp3<temp1) {

        if(temp1>=temp4) {
                        character[u] = 'J';
                        u++;
        }else {
            character[u] = 'C';
            u++;
        }
    }else{
        if(temp3>temp1){
            if(temp2<=temp3){
                character[u] = 'J';
                u++;
            }else{
                character[u] = 'C';
                u++;
            }
        }
  }
  temp3 = temp1;

    temp4 = temp2;

 }

            }




        String str =  new String(character);

        if(str.indexOf("CCC")==1) {
            str = "IMPOSSIBLE";

        }

            t++;

            System.out.println("Case #"+t+":"+" "+str);



        }


    }
    
}