import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CodeJam3_Final {


    public static void main(String[] args) {

        
    Scanner sc1 = new Scanner(System.in);
        
    int t = sc1.nextInt();
    int in = 0;
    
    for (int it= 0 ;it<t;it++){

        int n = sc1.nextInt();
        Scanner sc = new Scanner(System.in);
        int[][] a1 = new int[n][2];
        int[][] a  = new int[n][2];
        String sr = new String();
        
        for( in =0;in<n;in++){
            String  lines = sc.nextLine();    
            String[] strs = lines.trim().split("\\s+");
            for (int k = 0; k < strs.length; k++) {
                a[in][k] = Integer.parseInt(strs[k]);
                a1[in][k]=a[in][k];
            }              
        }
                
        Arrays.sort(a, new Comparator<int[]>() { public int compare(final int[] entry1, final int[] entry2) { if (entry1[0] > entry2[0]) return 1; else return -1;}});
        
        int[] b = new int[n];
        int[] b1= new int[n];
        
        int j ,i ,com=-1;

                b[0] = 0;         // b[0]  =  C
                for(i=1 ; i<n ; i++){
                    if(a[i][0] < a[i-1][1]  && a[i][0] > a[i-1][0]){
                        if(com != 0){
                            b[i] = 1 - b[i-1];
                            com = 0;
                        }
                        else{
                            for(j=i-2 ; j>=0 ; j--){
                                if(b[j]==1-b[i-1]){
                                    break;
                                }
                            }
                            if(a[i][0] < a[j][1]  && a[i][0] > a[j][0]){
                                b[i]= -1;
                            }
                            else{
                                b[i] = 1 - b[i-1];
                                com = 0;
                            }
                        }
                    }
                    else{
                        b[i] = b[i-1];
                        com = 1;
                    }
                }
                    for(i = 0;i<n;i++){
                        
                        for(j=0;j<n;j++){
                            
                            if(a1[i][0] == a[j][0] && a1[i][1] == a[j][1]){
                            b1[i] = b[j];
                            break;
                            }
                        }
                    }
                    
                for(i =0;i<n;i++){
                    if(b1[i]==0){
                        sr = sr + 'C';
                    }
                    else if(b1[i]==1){
                        sr = sr + 'J';
                    }
                    else{
                        sr = "IMPOSSIBLE";
                        break;
                    }
                }
                
                System.out.println("Case #"+(it+1)+": "+sr);

    }
    }
}
