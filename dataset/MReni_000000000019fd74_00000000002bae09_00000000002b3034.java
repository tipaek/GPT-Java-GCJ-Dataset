public class PatternMatching {
    public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
      in.nextLine();
      for (int i = 1; i <= t; ++i) {
        int lineCount = in.nextInt();
        in.nextLine();

        String[] lines = new String[lineCount];
        for (int j = 0; j < lineCount; j++) {
            lines[j] = in.nextLine();
        }
        String output = getOutput(lines);
        System.out.println("Case #" + i + ": " + output);
      }
    }

    public static String getOutput(String[] lines) {
        List<String> output = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            List<String> input = new ArrayList<>(Arrays.asList(lines[i].split("\\*")));
            if (output.size() == 0) {
                output = input;
            } else {
                int outIdx = 0;
                int inIdx = 0;
                boolean isStar = false;
                while (outIdx < output.size() && inIdx < input.size()){
                    String out = output.get(outIdx);
                    String in = input.get(inIdx);
                    // out is *, input is *
                    // advance input and do nothing to output
                    if (out.length() == 0 && in.length() == 0) {
                        inIdx++;
                        continue;
                    }
                    // out is *, input is not
                    // advance out, keep input as is
                    if (out.length() == 0 && in.length() > 0) {
                        outIdx++;
                    }

                    // out is not *, input is *
                    // advance input, keep out as is
                    if (out.length() > 0 && in.length() == 0) {
                        inIdx++;
                    }

                    // out is not *, input is not *
                    // does input.startWith(out)? 
                    // yes -> remove matching part from out, insert non-matching part to input next to scan
                    // no -> test if can be inserted? if previous character was *
                    if (out.length() > 0 && in.length() > 0) {
                        if (in.equals(out)) {
                            inIdx++;
                            outIdx++;
                        }
                        else if (in.startsWith(out)) {
                            String newIn = in.substring(out.length());
                            input.add(inIdx + 1, newIn);
                            inIdx++;
                            outIdx++;
                        } else if (isStar){
                            if (in.endsWith(out)) {
                                output.set(outIdx, in.substring(0, in.length() - out.length()) + out);
                            } else {
                                output.set(outIdx, in + out);
                            }
                        } else {
                            return "*";
                        }
                    }
                    isStar = (out.length() == 0);
                }
                // check remaining for both input and output
                if (outIdx == output.size() && inIdx == input.size()) {
                    return String.join("", output);
                }
                if (outIdx == output.size()) {
                    // output consumed, input remains...
                    // check if output last char is "" then append rest of input
                    // check if input last char is ""?
                    if (output.get(output.size() - 1).length() == 0) {
                        output.addAll(input.subList(inIdx + 1, input.size()));
                        return String.join("", output);
                    }
                    if (allEmpty(input, inIdx)) {
                        return String.join("", output);
                    }
                } else if (inIdx == input.size()) {
                    // input consumed, output remains...
                    // if input last char is *, return output as is
                    // else if output only has "*" left, return output as is
                    if (input.get(input.size() - 1).length() == 0 || allEmpty(output, outIdx)) {
                        return String.join("", output);
                    }
                }
            }
        }
        return "*";
    }

    private static boolean allEmpty(List<String> s, int idx) {
        for (int i = idx; i < s.size(); i++) {
            if (s.get(i).length() > 0) return false;
        }
        return true;
    }
}