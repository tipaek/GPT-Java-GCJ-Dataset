import java.util.Scanner;

public class Solution {
    

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++){
            String cadena=s.nextLine();
            int ant,act=0;
            System.out.print("case # "+(i+1)+": ");
            for(int j=0;j<cadena.length();j++){
                ant=act;
                act=cadena.charAt(j)-48;
                if(act-ant<0){
                    for(int l=0;l<ant-act;l++){
                        System.out.print(")");
                    }    
                }
                else{
                    for(int l=0;l<act-ant;l++){
                        System.out.print("(");
                    }
                }
                System.out.print(act);
            }
            for(int l=0;l<act;l++){
                System.out.print(")");
            }
            
            System.out.println("");
        }
    }
    
}
