
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author qboiler
 */
public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] caseSize = reader.readLine().split(" ");
        int testCases = Integer.parseInt(caseSize[0]);
        int size = Integer.parseInt(caseSize[1]);
        for(int i =1;i<=testCases; ++i) {
            processCase(reader, i, size);
        }
    }

    public static void main2(String s) throws IOException {

        StringReader ir = new StringReader(s);
        BufferedReader reader = new BufferedReader(ir);
        String[] caseSize = reader.readLine().split(" ");
        int testCases = Integer.parseInt(caseSize[0]);
        int size = Integer.parseInt(caseSize[1]);

        for(int i =1;i<=testCases; ++i) {
            processCase(reader, i, size);
        }
    }
    static int[] result = new int[1];
    static int[] resultCompliment = new int[1];
    static int[] resultReversal = new int[1];
    static int[] complimentReversal = new int[1];
    static int SIZE =0;

    public static void processCase(BufferedReader reader, int caseN, int Size) throws IOException {

        SIZE = Size;
        result = new int[Size];
        resultCompliment = new int[Size];
        resultReversal = new int[Size];
        complimentReversal = new int[Size];

        for(int i=0;i<result.length;++i){
            result[i]=2;
        }
        System.arraycopy(result, 0, resultCompliment, 0, Size);
        System.arraycopy(result, 0, resultReversal, 0, Size);
        System.arraycopy(result, 0, complimentReversal, 0, Size);

        System.out.println(1);
        int item = Integer.parseInt(reader.readLine());
        result[0]=item;
        resultCompliment[0]=item;
        resultReversal[0]=item;
        complimentReversal[0]=item;

        int request = 2;

        while(request<=150) {
            if (isReady()) {
                // submit result...
                break;
            }


            if (request % 10 == 1) {
                // brazen assumption that result is the same as the others...
                // after the request somthing bad will happen to the data...
                resultReversal = reverse(result);
                resultCompliment = compliment(result);
                complimentReversal = compliment(resultReversal);
                display(result,              "result           -> ");
                display(resultReversal,      "resultReversal   -> ");
                display(resultCompliment,    "resultCompliment -> ");
                display(complimentReversal,  "complimentRvrsal -> ");
            }


            if(didReduce(reader)){
                ++request;
                continue;

            }else{
                explore(reader);
            }
            ++request;
        }

        String results = "";
        for(int i: result){
            results+=i;
        }
        System.out.println(results);
        if(reader.readLine().equals("N")){
            System.exit(0);
        }
    }

    public static void display(int[] a, String mm){
        String r = "";
        for(int i: a){
            r+=i;
        }
        //System.out.println(mm+r);

    }

    private static int[] reverse(int[] ia){
        int[] res = new int[ia.length];
        for(int i=ia.length; i>0;--i){
            res[i-1]=ia[ia.length -i];
        }
        return res;
    }

    private static int[] compliment(int[] ia){
        int[] res = new int[ia.length];
        for(int i=0; i<ia.length;++i){
            if(ia[i]==2){
                res[i]=2;
            }else{
                res[i] = (ia[i]==1)?0:1;
            }
       }
       return res;
    }

    private static boolean isReady(){
        for(int i=0;i<SIZE;++i){
            if(result[i]!=resultCompliment[i]
                    || result[i]!=resultReversal[i]
                    || result[i]!=complimentReversal[i]
                    || result[i]==2
            ){
                return false;
            }
        }
        return true;
    }

    private static boolean didReduce( BufferedReader reader) throws IOException {

        boolean didreduce=false;
        display(result,              "br result           -> ");
        display(resultReversal,      "br resultReversal   -> ");
        display(resultCompliment,    "br resultCompliment -> ");
        display(complimentReversal,  "br complimentRvrsal -> ");

        int index =-1;
        if(!Arrays.equals(result, resultReversal)){
            index = findDif(result,resultReversal);

        }else if(!Arrays.equals(result, resultCompliment)){
            index = findDif(result,resultCompliment);

        }else if(!Arrays.equals(result, complimentReversal)){
            index = findDif(result,complimentReversal);

        }

        ArrayList<int[]> bads = new ArrayList<int[]>();
        int[] good = null ;
        if(index!=-1){
            System.out.println(index+1);
            int value = Integer.parseInt(reader.readLine());
            if(result[index]==2){
                result[index] = value;
                good = result;
            }else if(result[index]!=value){
                bads.add(result);
            }else{
                good=result;
            }
            if(resultReversal[index]==2){
                resultReversal[index] = value;
            }else if(resultReversal[index]!=value){
                bads.add(resultReversal);
            }else{
                if(good==null){
                    good=resultReversal;
                }
            }
            if(resultCompliment[index]==2){
                resultCompliment[index]=value;
            }else if(resultCompliment[index]!=value){
                bads.add(resultCompliment);
            }else{
                if(good==null){
                    good=resultCompliment;
                }
            }
            if(complimentReversal[index]==2){
                complimentReversal[index]=value;
            }else if(complimentReversal[index]!=value){
                bads.add(complimentReversal);
            }else{
                if(good==null){
                    good=complimentReversal;
                }
            }

            for(int[] a : bads){
                System.arraycopy(good, 0, a, 0, good.length);
            }
            display(result,              "ar result           -> ");
            display(resultReversal,      "ar resultReversal   -> ");
            display(resultCompliment,    "ar resultCompliment -> ");
            display(complimentReversal,  "ar complimentRvrsal -> ");

            didreduce=true;
        }

        return didreduce;
    }

    static void explore(BufferedReader reader) throws IOException {
        for(int i=0;i<result.length;++i){
            if(result[i]==2){
                System.out.println(i+1);
                int value = Integer.parseInt(reader.readLine());
                result[i]=value;
                resultReversal[i]=value;
                resultCompliment[i]=value;
                complimentReversal[i]=value;
                break;
            }else if(result[result.length-1-i]==2){
                int index = result.length-1-i;
                System.out.println(index+1);
                int value = Integer.parseInt(reader.readLine());
                result[index]=value;
                resultReversal[index]=value;
                resultCompliment[index]=value;
                complimentReversal[index]=value;
                break;
            }
        }
    }

    private static int findDif(int[] a, int[] b){
        for(int i=0;i<a.length;++i){
            if(a[i]!=b[i] && a[i]!=2){
                return i;
            }
        }
        return -1;
    }
}


