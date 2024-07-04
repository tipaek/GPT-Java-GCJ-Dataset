import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution{
    public static void main( String[] args ) throws IOException {
        class Element implements Comparable<Element> {
            boolean isStart;
            int val;
            int jobId;

            public Element(boolean isStart, int val, int jobId) {
                this.isStart = isStart;
                this.val = val;
                this.jobId = jobId;
            }

            @Override
            public int compareTo(Element o) {
                Element ele = (Element) o;
                if(this.val < ele.val)	return -1;
							 else if(this.val > ele.val)return 1;
							 else{
                    if(ele.isStart) return -1;
                    else	return 1;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        int k = tc;
        while (tc-->0){
            int n = Integer.parseInt(br.readLine());
            List<Element> list = new ArrayList<>();
            for (int i=0; i<n; i++){
                String[] row = (br.readLine()).trim().split("\\s+");
                list.add(new Element(true, Integer.parseInt(row[0]), i+1));
                list.add(new Element(false, Integer.parseInt(row[1]), i+1));
            }
            Collections.sort(list);
            char[] ret = new char[n];
            boolean isAfree = true;
            boolean isBfree = true;
            boolean isPossible = true;
            for(Element ele: list) {
                if(ele.isStart) {
                    if(isAfree) {
                        ret[ele.jobId-1] = 'C';
                        isAfree = false;
                    } else if (isBfree) {
                        ret[ele.jobId-1] = 'J';
                        isBfree = false;
                    } else {
                        System.out.println("Case #" + (k-tc) + ": IMPOSSIBLE");
                        isPossible = false;
                        break;
                    }
                } else {
                    if(ret[ele.jobId-1] == 'A') isAfree = true;
                    else isBfree = true;
                }
            }
            if(isPossible) {
                System.out.println("Case #" + (k-tc) + ": " + String.valueOf(ret));
            }
        }
    }
}
