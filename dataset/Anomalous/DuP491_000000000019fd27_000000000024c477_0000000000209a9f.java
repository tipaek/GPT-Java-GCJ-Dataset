import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        StringBuffer[] fb = new StringBuffer[]{
            new StringBuffer(""), new StringBuffer("("), new StringBuffer("(("), 
            new StringBuffer("((("), new StringBuffer("(((("), new StringBuffer("((((("), 
            new StringBuffer("(((((("), new StringBuffer("((((((("), new StringBuffer("(((((((("), 
            new StringBuffer("(((((((((")
        };
        
        StringBuffer[] pb = new StringBuffer[]{
            new StringBuffer(""), new StringBuffer(")"), new StringBuffer("))"), 
            new StringBuffer(")))"), new StringBuffer("))))"), new StringBuffer(")))))"), 
            new StringBuffer("))))))"), new StringBuffer(")))))))"), new StringBuffer("))))))))"), 
            new StringBuffer(")))))))))")
        };

        for (int i = 1; i <= t; i++) {
            int pf = 0, pp = 0;
            String s = br.readLine();
            StringBuffer ans = new StringBuffer();
            
            char ch = s.charAt(0);
            int a = Character.getNumericValue(ch);
            
            ans.append(fb[a]).append(a).append(pb[a]);
            pf = a;
            pp = a;
            
            for (int j = 1; j < s.length(); j++) {
                ch = s.charAt(j);
                a = Character.getNumericValue(ch);
                
                if (a > pf) {
                    StringBuffer temp = new StringBuffer();
                    temp.append(fb[a - pf]).append(ch).append(pb[a - pf]);
                    ans.insert(pp + 1, temp);
                    pp += (a - pf);
                    pf = a;
                } else {
                    ans.insert(pp + (pf - a + 1), ch);
                    pp += (pf - a + 1);
                    pf = a;
                }
            }
            System.out.println(ans);
        }
    }
}