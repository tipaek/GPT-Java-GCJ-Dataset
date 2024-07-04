import java.util.*;

public class Solution{
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i<=t; i++){
            int n = sc.nextInt(), k = sc.nextInt();
            System.out.print("Case #" + i + ": ");
            validate(n, k);    
            System.out.println();
        }
        
        
    }
    
    public static void validate(int n, int k){
        if(n==2){
            if(k==3)
                System.out.print("IMPOSSIBLE");
            else if(k==2){
                System.out.println("POSSIBLE");
                method22();
            }
            else if(k==4){
                System.out.println("POSSIBLE");
                method24();
            }
        }
        else if(n==3){
            if(k==3){
                System.out.println("POSSIBLE");
                method33();
            }   
            else if(k==6){
                System.out.println("POSSIBLE");
                method36();
            }
            else if(k==9){
                System.out.println("POSSIBLE");
                method39();
            }
            else{
                System.out.print("IMPOSSIBLE");
            }
        }
        else if(n==4){
            if(k==5 || k==15)
                System.out.print("IMPOSSIBLE");
            else if(k==4){
                System.out.println("POSSIBLE");
                method44();
            }
            else if(k==6){
                System.out.println("POSSIBLE");
                method46();
            }
            else if(k==7){
                System.out.println("POSSIBLE");
                method47();
            }
            else if(k==8){
                System.out.println("POSSIBLE");
                method48();
            }
            else if(k==9){
                System.out.println("POSSIBLE");
                method49();
            }
            else if(k==10){
                System.out.println("POSSIBLE");
                method410();
            }
            else if(k==11){
                System.out.println("POSSIBLE");
                method411();
            }
            else if(k==12){
                System.out.println("POSSIBLE");
                method412();
            }
            else if(k==13){
                System.out.println("POSSIBLE");
                method413();
            }
            else if(k==14){
                System.out.println("POSSIBLE");
                method414();
            }
            else if(k==16){
                System.out.println("POSSIBLE");
                method416();
            }
        }
        else if(n==5){
            if(k==6 || k==24)
                System.out.print("IMPOSSIBLE");
            else if(k==5){
                System.out.println("POSSIBLE");
                method55();
            }
            else if(k==7){
                System.out.println("POSSIBLE");
                method57();
            }
            else if(k==8){
                System.out.println("POSSIBLE");
                method58();
            }
            else if(k==9){
                System.out.println("POSSIBLE");
                method59();
            }
            else if(k==10){
                System.out.println("POSSIBLE");
                method510();
            }
            else if(k==11){
                System.out.println("POSSIBLE");
                method511();
            }
            else if(k==12){
                System.out.println("POSSIBLE");
                method512();
            }
            else if(k==13){
                System.out.println("POSSIBLE");
                method513();
            }
            else if(k==14){
                System.out.println("POSSIBLE");
                method514();
            }
            else if(k==15){
                System.out.println("POSSIBLE");
                method515();
            }
            else if(k==16){
                System.out.println("POSSIBLE");
                method516();
            }
            else if(k==17){
                System.out.println("POSSIBLE");
                method517();
            }
            else if(k==18){
                System.out.println("POSSIBLE");
                method518();
            }
            else if(k==19){
                System.out.println("POSSIBLE");
                method519();
            }
            else if(k==20){
                System.out.println("POSSIBLE");
                method520();
            }
            else if(k==21){
                System.out.println("POSSIBLE");
                method521();
            }
            else if(k==22){
                System.out.println("POSSIBLE");
                method522();
            }
            else if(k==23){
                System.out.println("POSSIBLE");
                method523();
            }
            else if(k==25){
                System.out.println("POSSIBLE");
                method525();
            }
        }
        else{
            System.out.print("IMPOSSIBLE");
        }
    }
    
    public static void method525(){
        System.out.println("5 1 2 3 4");
        System.out.println("4 5 1 2 3");
        System.out.println("3 4 5 1 2");
        System.out.println("2 3 4 5 1");
        System.out.print("1  2 3 4 5");
    }
    
    public static void method523(){
        System.out.println("5 1 4 2 3");
        System.out.println("4 5 2 3 1");
        System.out.println("3 4 5 1 2");
        System.out.println("2 3 1 4 5");
        System.out.print("1 2 3 5 4");
    }
    
    public static void method522(){
        System.out.println("4 1 5 3 2");
        System.out.println("5 4 3 2 1");
        System.out.println("2 5 4 1 3");
        System.out.println("3 2 1 5 4");
        System.out.print("1 3 2 4 5");
    }
    
    public static void method521(){
        System.out.println("5 1 3 2 4");
        System.out.println("3 5 2 4 1");
        System.out.println("4 3 5 1 2");
        System.out.println("2 4 1 3 5");
        System.out.print("1 2 4 5 3");
    }
    
    public static void method520(){
        System.out.println("4 1 2 3 5");
        System.out.println("5 4 1 2 3");
        System.out.println("3 5 4 1 2");
        System.out.println("2 3 5 4 1");
        System.out.print("1 2 3 5 4");
    }
    
    public static void method519(){
        System.out.println("3 1 5 2 4");
        System.out.println("5 3 2 4 1");
        System.out.println("4 5 3 1 2");
        System.out.println("2 4 1 5 3");
        System.out.print("1 2 4 3 5");
    }
    
    public static void method518(){
        System.out.println("4 1 3 2 5");
        System.out.println("3 4 2 5 1");
        System.out.println("5 3 4 1 2");
        System.out.println("2 5 1 3 4");
        System.out.print("1 2 5 4 3");
    }
    
    public static void method517(){
        System.out.println("3 1 4 2 5");
        System.out.println("4 3 2 5 1");
        System.out.println("5 4 3 1 2");
        System.out.println("2 5 1 4 3");
        System.out.print("1 2 5 2 3");
    }
    
    public static void method516(){
        System.out.println("4 1 2 3 5");
        System.out.println("2 4 3 5 1");
        System.out.println("5 2 4 1 3");
        System.out.println("3 5 1 2 4");
        System.out.print("1 3 5 4 2");
    }
    
    public static void method515(){
        System.out.println("3 1 2 4 5");
        System.out.println("5 3 1 2 4");
        System.out.println("4 5 3 1 2");
        System.out.println("2 4 5 3 1");
        System.out.print("1 2 4 5 3");
    }
    
    public static void method514(){
        System.out.println("2 4 3 5 1");
        System.out.println("1 2 4 3 5");
        System.out.println("4 5 2 1 3");
        System.out.println("5 3 1 4 2");
        System.out.print("3 1 5 2 4");
    }
    
    public static void method513(){
        System.out.println("3 1 2 4 5");
        System.out.println("2 3 4 5 1");
        System.out.println("5 2 3 1 4");
        System.out.println("4 5 1 2 3");
        System.out.print("1 4 5 3 2");
    }
    
    public static void method511(){
        System.out.println("3 2 1 4 5");
        System.out.println("1 3 4 5 2");
        System.out.println("5 1 3 2 4");
        System.out.println("4 5 2 1 3");
        System.out.print("2 4 5 3 1");
    }
    
    public static void method512(){
        System.out.println("2 1 3 4 5");
        System.out.println("3 2 4 5 1");
        System.out.println("5 3 2 1 4");
        System.out.println("4 5 1 3 2");
        System.out.print("1 4 5 2 3");
    }
    
    public static void method510(){
        System.out.println("2 1 3 4 5");
        System.out.println("5 2 1 3 4");
        System.out.println("4 5 2 1 3");
        System.out.println("3 4 5 2 1");
        System.out.print("1 3 4 5 2");
    }
    
    public static void method59(){
        System.out.println("1 2 3 4 5");
        System.out.println("3 1 4 5 2");
        System.out.println("5 3 1 2 4");
        System.out.println("4 5 2 3 1");
        System.out.print("2 4 5 1 3");
    }
    
    public static void method58(){
        System.out.println("2 3 1 4 5");
        System.out.println("1 2 4 5 3");
        System.out.println("5 1 2 3 4");
        System.out.println("4 5 3 1 2");
        System.out.print("3 4 5 2 1");
    }
    
    public static void method57(){
        System.out.println("1 3 2 4 5");
        System.out.println("2 1 4 5 3");
        System.out.println("5 2 1 3 4");
        System.out.println("4 5 3 2 1");
        System.out.print("3 4 5 1 2");
    }
    
    public static void method55(){
        System.out.println("1 2 3 4 5");
        System.out.println("5 1 2 3 4");
        System.out.println("4 5 1 2 3");
        System.out.println("3 4 5 1 2");
        System.out.print("2 3 4 5 1");
    }
    
    public static void method416(){
        System.out.println("4 1 2 3");
        System.out.println("3 4 1 2");
        System.out.println("2 3 4 1");
        System.out.print("1 2 3 4");
    }
    
    public static void method414(){
        System.out.println("3 4 2 1");
        System.out.println("4 3 1 2");
        System.out.println("2 1 4 3");
        System.out.print("1 2 3 4");
    }
    
    public static void method413(){
        System.out.println("4 2 3 1");
        System.out.println("3 4 1 2");
        System.out.println("1 3 2 4");
        System.out.print("2 1 4 3");
    }
    
    public static void method412(){
        System.out.println("3 1 2 4");
        System.out.println("4 3 1 2");
        System.out.println("2 4 3 1");
        System.out.print("1 2 4 3");
    }
    
    public static void method411(){
        System.out.println("3 1 4 2");
        System.out.println("4 3 2 1");
        System.out.println("2 4 1 3");
        System.out.print("1 2 3 4");
    }
    
    public static void method410(){
        System.out.println("3 2 1 4");
        System.out.println("2 3 4 1");
        System.out.println("1 4 2 3");
        System.out.print("4 1 3 2");
    }
    
    public static void method49(){
        System.out.println("3 1 2 4");
        System.out.println("2 3 4 1");
        System.out.println("4 2 1 3");
        System.out.print("1 4 3 2");
    }
    
    public static void method48(){
        System.out.println("2 1 3 4");
        System.out.println("4 2 1 3");
        System.out.println("3 4 2 1");
        System.out.print("1 3 4 2");
    }
    
    public static void method47(){
        System.out.println("1 2 3 4");
        System.out.println("3 1 4 2");
        System.out.println("4 3 2 1");
        System.out.print("2 4 1 3");
    }
    
    public static void method46(){
        System.out.println("1 2 3 4");
        System.out.println("2 1 4 3");
        System.out.println("3 4 2 1");
        System.out.print("4 3 1 2");
    }
    
    public static void method44(){
        System.out.println("1 2 3 4");
        System.out.println("4 1 2 3");
        System.out.println("3 4 1 2");
        System.out.print("2 3 4 1");
    }
    
    public static void method39(){
        System.out.println("3 1 2");
        System.out.println("2 3 1");
        System.out.print("1 2 3");
    }
    
    public static void method33(){
        System.out.println("1 2 3");
        System.out.println("3 1 2");
        System.out.print("2 3 1");
    }
    
    public static void method36(){
        System.out.println("2 1 3");
        System.out.println("3 2 1");
        System.out.print("1 3 2");
    }
    
    public static void method22(){
        System.out.println("1 2");
        System.out.print("2 1");
    }
    
    public static void method24(){
        System.out.println("2 1");
        System.out.print("1 2");
    }
    
}