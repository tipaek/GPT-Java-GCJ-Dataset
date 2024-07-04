import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class GCJR1b1 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        //log.write() //log.flush()
        int t = scan.nextInt();
        int count = 1;
        while(t-- >0){

            int xs = scan.nextInt();
            int ys = scan.nextInt();
            boolean impossible = false;
            boolean xneg = false;
            boolean yneg = true;

            if(xs<0){
                xneg = true;
                xs = -1*xs;
            }

            if(ys<0){
                yneg = true;
                ys = -1*ys;
            }

            if((xs%2 ==0 && ys%2 ==0)  || (xs%2==1 && ys%2==1) ){
                impossible = true;
            }



            String out = "";


            String binx = Integer.toBinaryString(xs);
            String biny = Integer.toBinaryString(ys);



            //reverse binx and biny

            //also need to handle the first bit

            //String binx = "100010010001";
            //String biny = "10000001010";



            System.out.println(binx);
            System.out.println(biny);

            binx = new StringBuffer(binx).reverse().toString();
            biny = new StringBuffer(biny).reverse().toString();

            while(binx.length() < biny.length() || binx.length() <3 ){
                binx += "0";
            }
            while(biny.length() < binx.length() || biny.length() <3){
                biny += "0";
            }


            if(binx.charAt(1) == '1' && biny.charAt(1) == '1'){
                if(binx.charAt(0) == '1'){
                    char[] xarr = binx.toCharArray();
                    xarr[1] = '0';
                    xarr[2] = '1';
                    binx = xarr.toString();

                }
            }
            if(binx.charAt(1) == '1' && biny.charAt(1) == '1'){
                if(biny.charAt(0) == '1'){
                    char[] yarr = binx.toCharArray();
                    yarr[1] = '0';
                    yarr[2] = '1';
                    biny = yarr.toString();
                }
            }

            System.out.println(binx);
            System.out.println(biny);


            if(binx.charAt(0) == '1'){
                if(binx.charAt(1) == '1' || biny.charAt(1)=='1'){
                    out += "E";
                }
                else{
                    out += "W";
                }
            }
            else if(biny.charAt(0) == '1'){
                if(binx.charAt(1) == '1' || biny.charAt(1)=='1'){
                    out += "N";
                }
                else{
                    out += "S";
                }
            }

            int xcount = 1;
            int ycount = 1;

            while (!impossible && xcount<binx.length() && ycount<biny.length()){
                System.out.println("in");
                boolean x = false;
                boolean y = false;
                if(binx.charAt(xcount) == '1'){
                    x = true;
                }
                else if(biny.charAt(ycount) == '1'){
                    y = true;
                }
                boolean looped = false;
                while(xcount+1<binx.length() && (binx.charAt(xcount+1) == '0' && biny.charAt(ycount+1) == '0')){
                    looped = true;
                    if(x){
                        if(!xneg) {
                            out += "W";
                        }
                        else{
                            out += "E";
                        }
                        System.out.println(out);
                    }
                    if(y){
                        if(!yneg) {
                            out += "S";
                        }
                        else{
                            out += "N";
                        }
                        System.out.println(out);
                    }
                    xcount++;
                    ycount++;
                }
//                if (looped){
//                    xcount--;
//                    ycount--;
//                }
                if(x){
                    if(!xneg) {
                        out += "E";
                    }
                    else{
                        out += "W";
                    }
                    System.out.println(out);
                }
                if(y){
                    if(!yneg) {
                        out += "N";
                    }
                    else{
                        out += "S";
                    }
                    System.out.println(out);
                }
                xcount++;
                ycount++;
            }

            //System.out.println(out);

            if(impossible){
                out = "IMPOSSIBLE";
            }



            log.write("Case #" + (count) + ": " + out + "\n");
            //System.out.println(colRep);
            count++;
        }
        log.flush();





    }
}