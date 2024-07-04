import java.util.*;




class Solution{
    
     public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();

        int t = 0;

        while(t<test){


            int k = scanner.nextInt();

            int[][] arr = new int[k][k];

            for (int i = 0; i < k; i++) {

                for (int j = 0; j < k; j++) {

                    arr[i][j] = scanner.nextInt();
                }
            }
            int sum = 0;
            int r = 0;
            int c = 0;

            for (int i = 0; i <k ; i++) {
                for (int j = 0; j <k ; j++) {

                    if(i==j){
                                sum = sum + arr[i][j];
                    }
                }

            }

            Set<Integer> a = new HashSet<Integer>();

            Set<Integer> b = new HashSet<Integer>();


            for (int i = 0; i <k ; i++) {

                for (int j = 0; j < k; j++) {

                    a.add(arr[i][j]);

                    if (j == k - 1) {
                        if (a.size() != k) {
                            r++;
                        }
                        a.clear();

                    }

                    b.add(arr[j][i]);


                    if (j == k - 1) {

                        if (b.size() != k) {
                            c++;
                        }
                        b.clear();


                    }
                }
            }


            t++;

            System.out.println("Case #"+t+":"+" "+sum+" "+r+" "+c);



        }


    }
}