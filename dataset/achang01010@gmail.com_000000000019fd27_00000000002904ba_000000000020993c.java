public class Vestigium {
    public static void main(String[] args) {
        InputStream is = new FileInputStream("input.txt");
        FastScanner sc = new FastScanner(is);
    }
    static class FastScanner { 
        public BufferedReader br; 
        public StringTokenizer st; 

        public FastScanner(InputStream is) throws IOException { 
            br = new BufferedReader(new InputStreamReader(is),32768);
            st = null;
        }

        public String next() { 
            while (st == null || !st.hasMoreTokens()) { 
                try { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) { 
                    throw new RuntimeException(e);
                }
            } 
            return st.nextToken(); 
        } 

        public int nextInt() { 
            return Integer.parseInt(next()); 
        } 

        public long nextLong() { 
            return Long.parseLong(next()); 
        } 

        public double nextDouble() { 
            return Double.parseDouble(next()); 
        } 

        public String nextLine() { 
            String str = ""; 
            try { 
                str = br.readLine(); 
            } catch (IOException e) { 
                throw new RuntimeException(e);
            } 
            return str; 
        }
    }
}