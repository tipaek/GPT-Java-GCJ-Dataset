import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int count;
    static int index;
    static boolean reversed;
    static int revIndex;
    static boolean revParity;
    static int conIndex;
    static int conVal;
    static FastReader reader = new FastReader(); //Reads all the stuff;

    // Gets and flushes and returns the value in the output
    public static int getAndFlush(int val){
        System.out.println(val);
        System.out.flush();
        count++;
        return reader.nextInt();
    }

    // Tells us if we just reversed
    public static boolean reversed(){
        if(revIndex == -1){
            return false;
        }
        int l1 = getAndFlush(revIndex);
        int l2 = getAndFlush(revIndex + 1);

        return (l1 == l2) == revParity;
    }

    public static void main(String[] args) {
        int t = reader.nextInt();             // t trial number


        for(int u=0; u<t; u++){
            count = 0;
            index = -1;
            reversed = false;              // Tells us if we've reversed

            revIndex = -1;
            conIndex = -1;
            int l1, l2, r1, r2;
            String outString = "";

            ArrayList<Integer> divList = new ArrayList<>();
            ArrayList<Boolean> conList = new ArrayList<>();


            int b = reader.nextInt();             // b size of input

            l1 = getAndFlush(0);            // Wastes the first read
            l1 = getAndFlush(0);
            r1 = getAndFlush(b - 1);

            // Getting the index to check if we've flipped and
            // The index to check if we have reversed
            while(revIndex == -1 && index < b/2){
                index++;
                l2 = l1;
                r2 = r1;

                l1 = getAndFlush(index + 1);
                r1 = getAndFlush(b - index - 2);

                if( (l1 == l2) != (r1 == r2) ){
                    revIndex = index;
                    revParity = (l1 == l2);
                }
            }

            divList.add(0);
            conList.add(false);

            // Builds the output string
            while(index < b){
                if(count % 10 == 1){

                    if(index != 0){
                        divList.add(index);
                        conList.add(false);
                    }

                    if(reversed()){
                        reversed = !reversed;
                    }
                }
                if(reversed){
                    outString += Integer.toString(getAndFlush(b - index - 1));
                } else{
                    outString += Integer.toString(getAndFlush(index));
                }
                index++;
            }

            // Gets the conval, and if we have reversed
            conIndex = 0;
            for(int i=0; i<b/2; i++){
                if(outString.charAt(i) == outString.charAt(b - i - 1)){
                    conIndex = i;
                    break;
                }
            }

            conVal = getAndFlush(conIndex);
            if(count % 10 == 1){
                if(reversed()){
                    reversed = !reversed;
                }
                conVal = getAndFlush(conIndex);
            }

            for(int i=0; i<conList.size(); i++){
                Integer getVal;
                int index = divList.get(i);
                char value = outString.charAt(index);

                if(reversed){
                    getVal = getAndFlush( b - index - 1);
                } else{
                    getVal = getAndFlush(index);
                }

                conList.set(i, getVal ==  Character.getNumericValue(value));

                if(count % 10 == 1){
                    if(reversed()){
                        reversed = !reversed;
                    }
                    if(conVal != getAndFlush(conIndex)){
                        conVal = (conVal + 1) % 2;
                        for(int j=0; j<conList.size(); j++){
                            conList.set(j, !conList.get(j));
                        }
                    }
                }
            }
            // Reverses the string
            String secondString = outString;
            if(reversed){
                secondString = "";
                for(int i=0; i<b; i++){
                    secondString = secondString + outString.charAt(b - i - 1);
                }
            }


            outString = secondString;
            Boolean flipBit = conList.get(0);
            int flipIndex = 0;

            char outChar;

            for(int i=0; i<b; i++){
                if(divList.contains(i)){
                    flipBit = conList.get(flipIndex);
                    flipIndex++;
                }

                if(flipBit){
                    outChar = outString.charAt(i);

                    if(outChar == '1'){
                        System.out.print('0');
                    }
                    else{
                        System.out.print('1');
                    }

                }else{
                    System.out.print(outString.charAt(i));
                }

            }
            
            System.out.println();

            if(reader.next() == "N"){
                System.exit(1);
            }
        }

    }



    public static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

        Boolean hasNext(){
            try{
                return br.ready();
            } catch(Exception e){
                return false;
            }
        }
    }
}
