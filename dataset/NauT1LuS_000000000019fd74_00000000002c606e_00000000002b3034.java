//import java.io.ByteArrayInputStream;
//import java.nio.charset.StandardCharsets;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String exampleString = "8\n" +
                "5\n" +
                "*CONUTS\n" +
                "*COCONUTS\n" +
                "*OCONUTS\n" +
                "*CONUTS\n" +
                "*S\n" +
                "2\n" +
                "*XZ\n" +
                "*XYZ\n" +
                "4\n" +
                "H*O\n" +
                "HELLO*\n" +
                "*HELLO\n" +
                "HE*\n" +
                "2\n" +
                "CO*DE\n" +
                "J*AM\n" +
                "2\n" +
                "CODE*\n" +
                "*JAM\n" +
                "2\n" +
                "A*C*E\n" +
                "*B*D*\n" +
                "2\n" +
                "A*C*E\n" +
                "*B*D\n" +
                "2\n" +
                "**Q**\n" +
                "*A*";
//        in = new Scanner(new ByteArrayInputStream(exampleString.getBytes(StandardCharsets.UTF_8)));

        int cases = in.nextInt();
        cases: for (int i = 1; i <= cases; i++) {
            int namesCount = in.nextInt();
            List<String> names = new ArrayList<>(namesCount);

            for (int j = 0; j < namesCount; j++) {
                names.add(in.next().replace("**", "*"));
            }

            List<String> prefixes = new ArrayList<>();
            List<String> suffixes = new ArrayList<>();
            List<String> wildcards = new ArrayList<>();


            for (String name : names){
                String[] split = name.split("\\*");
                if(name.charAt(0) == '*' && name.charAt(name.length() -1) == '*'){
                    wildcards.add(name);
                } else if(name.charAt(0) == '*'){
                    String suffix = split[split.length - 1];
                    suffixes.add(suffix);
                    if(split.length > 2){
                        wildcards.add(name.substring(name.length() - suffix.length()));
                    }
                }else if(name.charAt(name.length() -1) == '*'){
                    String prefix = split[0];
                    prefixes.add(prefix);
                    if(split.length > 2){
                        wildcards.add(name.substring(prefix.length()));
                    }
                }else{
                    String prefix = split[0];
                    String suffix = split[split.length - 1];
                    suffixes.add(suffix);
                    prefixes.add(prefix);
                    if(split.length > 2){
                        String wildcard = name.substring(prefix.length(), name.length() - suffix.length());
                        wildcards.add(wildcard);
                    }
                }
            }

            String prefix = mergePrefixes(prefixes);
            String suffix = mergeSuffixes(suffixes);
            if(prefix.equals("*") || suffix.equals("*")){
                System.out.printf("Case #%d: *", i);
                System.out.println();
                continue cases;
            }
            String wilds = mergeWildcards(wildcards);

            String word = prefix + wilds + suffix;
            if(word.length() > 10000){
                  System.out.printf("Case #%d: *", i);
                System.out.println();
                continue cases;
            }
            System.out.printf("Case #%d: %s", i, word);
            System.out.println();

        }

    }

    private static String mergeWildcards(List<String> wildcards) {
        if (wildcards.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(wildcards.get(0));
        for (int i = 1; i < wildcards.size(); i++) {
            sb.append(wildcards.get(i));
        }
        return sb.toString().replace("*", "");
    }

    private static String mergePrefixes(List<String> prefixes) {
        if(prefixes.isEmpty()) return "";
        prefixes.sort(Comparator.comparing(String::length).reversed());

        String prefix = prefixes.get(0);
        for (int i = 1; i < prefixes.size(); i++) {
            if(!prefix.startsWith(prefixes.get(i))) return "*";
        }
        return prefix;
    }

    private static String mergeSuffixes(List<String> suffixes) {
        if(suffixes.isEmpty()) return "";
        suffixes.sort(Comparator.comparing(String::length).reversed());

        String suffix = suffixes.get(0);
        for (int i = 1; i < suffixes.size(); i++) {
            if(!suffix.endsWith(suffixes.get(i))) return "*";
        }
        return suffix;
    }
}
