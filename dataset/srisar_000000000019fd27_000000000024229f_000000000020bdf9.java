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

            int count1 = 0;

            int count2 = 0;

            int count3 = 0;

            int count4 = 0;

            int count5 = 0;

            boolean value = false;

          for(int j=2; j<ar.length;j=j+2) {


            if(ar[0]>ar[j]){
                count3++;
                if(ar[j+1]<=ar[0]){
                    character[u] = 'J';
                    u++;
                }else{
                    character[u] = 'C';
                    u++;
                    count1++;
                }
            }

            if(ar[0]<ar[j]){
                count4++;
                if(ar[1]<=ar[j]) {
                    character[u] = 'J';
                    u++;
                }else{
                    character[u] = 'C';
                    u++;
                    count2++;
                }
            }

            if(ar[0]==ar[j]){

                count5++;
                character[u]= 'C';

                u++;
            }




 if((count1==2&&count3==2)||(count2==2&&count4==2)|| count5==2){



      value = true;

     break;
 }

            }

          String str = "a";

          if(value) {
               str = "IMPOSSIBLE";

          }else {
              str = new String(character);

          }


            t++;

            System.out.print("Case #"+t+":"+" "+str);



        }


    }
    
}