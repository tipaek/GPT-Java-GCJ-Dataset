public class Solution {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        int t = 1;
        outer:
        while (T-- > 0) {
            String[] coords = reader.readLine().split(" ");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);

            String path = coords[2];
            if (x == 0 && y == 0) {
                System.out.println(String.format("Case #%s: %s", t, 0));
                t++;
                continue;
            }

            for (int i = 0; i < path.length(); i++) {
                if (path.charAt(i) == 'S') {
                    y--;
                } else if (path.charAt(i) == 'N') {
                    y++;
                } else if (path.charAt(i) == 'E') {
                    x++;
                } else {
                    x--;
                }

                int stepsRequired = x + y;
                if (stepsRequired <= i + 1) {
                    System.out.println(String.format("Case #%s: %s", t, i + 1));
                    t++;
                    continue outer;
                }
            }

            System.out.println(String.format("Case #%s: IMPOSSIBLE", t));
            t++;
        }
    }
}