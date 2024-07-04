import java.util.Scanner;
import java.lang.*; 
class a{  
    static Scanner scan = new Scanner(System.in);
    public static void main(final String args[]) {
        int all = scan.nextInt();
        String[] line = new String[all];
        
        for(int x=0; x<all; x++){
            line[x] = scan.next();
        }

        boolean open=false,close=false;
        for(int x=0; x<all; x++){
            open=false;close=false;
            System.out.print("Case #"+x+": "); 
            for(int i=0; i<line[x].length(); i++){
                char z=line[x].charAt(i);
                if(open==false && z=='1'){
                    if(i!=0 && line[x].charAt(i-1)=='0')
                    System.out.print(" ");

                    open=true;
                    System.out.print("("+line[x].charAt(i));

                    if(i==line[x].length()-1)
                    System.out.print(") ");
                }else if(open==true && line[x].charAt(i)=='0' ){
                    open=false;
                    close=true;
                    System.out.print(") "+line[x].charAt(i));
                }else if( open==true && i==line[x].length()-1){
                    open=false;
                    close=true;
                    System.out.print(line[x].charAt(i)+") ");
                }
                // else if(close==true){

                // }
                else System.out.print(line[x].charAt(i));
            }
            System.out.print("\n");
        }
    }
}