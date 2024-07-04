
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author qboiler
 */
public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        main(reader);

    }

    public static void main(BufferedReader reader) throws IOException {
        int testCases = Integer.parseInt(reader.readLine());
        for(int i =1;i<=testCases; ++i) {
            processCase(reader, i);
        }

    }


    public static void processCase(BufferedReader reader, int caseN) throws IOException {

        int u = Integer.parseInt(reader.readLine());

        TreeMap<String, AtomicInteger> hist = new TreeMap<>();
        ArrayList<String> data = new ArrayList<>();
        for(int i=0;i<10000;++i){
            String[] line = reader.readLine().split(" ");
            String rand = line[1];
            String s = String.valueOf(rand.charAt(0));
            if(hist.containsKey(s)){
                hist.get(s).incrementAndGet();
            }else{
                hist.put(s, new AtomicInteger(1));
            }
            data.add(rand);
        }

        String Zero = "0";
        for(int i=0;i<data.size();++i){

            String s = data.get(i);
            if(s.length()>1){
                String n = String.valueOf(s.charAt(1));
                if(!hist.containsKey(n)){
                    Zero=n;
                    break;
                }
            }
        }

        hist = new TreeMap<>();
        for(int i=0;i<10000;++i){
            String rand = data.get(i);
            for(int j=0;j<rand.length();++j){
                String s = String.valueOf(rand.charAt(j));
                if(!s.equals(Zero)) {
                    if (hist.containsKey(s)) {
                        hist.get(s).incrementAndGet();
                    } else {
                        hist.put(s, new AtomicInteger(1));
                    }
                }
            }
        }



        String one = getMax(hist);
        hist.remove(one);
        String two = getMax(hist);
        hist.remove(two);
        String three = getMax(hist);
        hist.remove(three);
        String four = getMax(hist);
        hist.remove(four);
        String five = getMax(hist);
        hist.remove(five);
        String six = getMax(hist);
        hist.remove(six);
        String seven = getMax(hist);
        hist.remove(seven);
        String eight = getMax(hist);
        hist.remove(eight);
        String nine = getMax(hist);
        hist.remove(nine);

        System.out.println("Case #"+caseN +": " + Zero+one+two+three+four+five+six+seven+eight+nine);
    }

    private static String getMax(TreeMap<String,AtomicInteger> in){
        int max=-1;
        String maxString = null;
        for(Map.Entry<String,AtomicInteger> entry:in.entrySet()){

            if(entry.getValue().get()>max){
                max=entry.getValue().get();
                maxString=entry.getKey();
            }
        }
        return maxString;

    }
}