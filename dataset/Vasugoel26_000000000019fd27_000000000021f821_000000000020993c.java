import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solutions {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int notc = in.nextInt();
        //loop to pass all test cases
        for (int i =0;i<notc;i++){
            in.nextLine();

            int ms = in.nextInt();
            int case_no =i+1;
            int trace=0;
            int norr=0;
            int norc=0;


            int temp_matrix [][] = new int[ms][ms];
            //loop to read all rows
            for (int j=0; j<ms;j++){
                 in.nextLine();
                 //to read all elements in a row
                for(int k =0;k< ms;k++){
                    temp_matrix[j][k]=in.nextInt();
                    if(j==k){
                        trace=trace+temp_matrix[j][k];
                    }
                }

            }


            for(int y =0;y<ms;y++){
                int tempa[]=new int[ms];
                int a =0;
                boolean exists = false;
                boolean repeated =false;

                for(int l=0;l<ms;l++){
                    int temp = temp_matrix[l][y];
                     for(int element : tempa){
                         if(element == temp){
                             exists = true;
                             break;
                         }


                     }
                     if(exists != true){

                         tempa[a]=temp;
                         a++;

                         //loop to check repeated columns
                         for(int m =l;m<ms;m++){

                             if(temp_matrix[m][y]==temp){
                                 if(m!=l){

                                     norc=norc+1;
                                     repeated=true;
                                     break;
                                 }
                             }
                         }
                         if(repeated==true){
                             break;
                         }
                     }

                }

            }

            for(int z =0; z<ms;z++){
                int tempb[]= new int[ms];
                int b=0;
                boolean exists = false;
                boolean repeated = false;

                for(int x =0;x<ms;x++){
                    int temp2 = temp_matrix[z][x];
                    for(int element : tempb){
                        if(element == temp2){
                            exists=true;
                            break;
                        }
                    }
                    if(exists!=true){
                        tempb[b]=temp2;
                        b++;
                        //loop to check re[eated rows
                        for(int n =x;n<ms;n++){
                            if(temp_matrix[z][n]==temp2){
                                if(n!=x){
                                    norr = norr +1;
                                    repeated=true;
                                    break;
                                }
                            }
                        }
                        if(repeated==true){
                            break;
                        }
                    }

                }

            }

            System.out.println("Case #"+case_no+": "+ trace+" "+ norr+" "+ norc);
        }
    }
}
