import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        for(int testcase = 1; testcase<=T; testcase++){
            int rx1 = 0;
            int inc = (int) (Math.pow(10,7))*2;
            int a = (int) (-Math.pow(10,9))-inc;
            int b = a+inc;
            boolean komid = false;
            boolean midja = false;
            while(!komid && !midja){
                String lesa = "";
                do{
                    a+=inc;
                    b += inc;
                    System.out.println(b+ " "+0);
                    lesa = sc.next();
                }while(lesa.equals("MISS"));
                if(lesa.equals("CENTER")){
                    midja = true;
                    break;
                }
                else{
                    while(a+1<b){
                        int c = (a+b)/2;
                        System.out.println(c+" "+0);
                        lesa = sc.next();
                        if(lesa.equals("MISS")){
                            a = c;
                        }
                        else if(lesa.equals("HIT")){
                            b= c;
                        }
                        else{
                            midja = true;
                            break;
                        }
                           
                    }
                    rx1 = a;
                    komid = true;
                }
                
            }
            b = (int) (Math.pow(10,9))+inc;
            a = b-inc;
            int rx2 = 0;
            komid = false;
            while(!komid && !midja){
                String lesa = "";
                do{
                    a-=inc;
                    b -= inc;
                    System.out.println(a+ " "+0);
                    lesa = sc.next();
                }while(lesa.equals("MISS"));
                if(lesa.equals("CENTER")){
                    midja = true;
                    break;
                }
                else{
                    while(a+1<b){
                        int c = (a+b)/2;
                        System.out.println(c+" "+0);
                        lesa = sc.next();
                        if(lesa.equals("MISS")){
                            b = c;
                        }
                        else if(lesa.equals("HIT")){
                            a= c;
                        }
                        else{
                            midja = true;
                            break;
                        }
                           
                    }
                    rx2 = a;
                    komid = true;
                }
                
            }
            b = (int) (Math.pow(10,9))+inc;
            a = b-inc;
            int ry1 = 0;
            komid = false;
            while(!komid && !midja){
                String lesa = "";
                do{
                    a-=inc;
                    b -= inc;
                    System.out.println(0+ " "+a);
                    lesa = sc.next();
                }while(lesa.equals("MISS"));
                if(lesa.equals("CENTER")){
                    midja = true;
                    break;
                }
                else{
                    while(a+1<b){
                        int c = (a+b)/2;
                        System.out.println(0+" "+c);
                        lesa = sc.next();
                        if(lesa.equals("MISS")){
                            b = c;
                        }
                        else if(lesa.equals("HIT")){
                            a= c;
                        }
                        else{
                            midja = true;
                            break;
                        }
                           
                    }
                    ry1 = a;
                    komid = true;
                }
                
            }
            int ox = (rx1 + rx2)/2;
            int oy = ry1/2;
            if(!midja){
            for(int i = 0; i<25; i++){
                int giskx = ox-2 +i%5;
                int gisky = oy-2 +i/5;
                
                System.out.println(giskx+" "+gisky);
                if(sc.next().equals("CENTER")) break;
            }
            }
            
            
        }
    }
}