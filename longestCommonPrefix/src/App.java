import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        String[] strs = {"aacc","aa","aa","aa","aaca"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder res = new StringBuilder();
        String first = strs[0], last = strs[strs.length - 1];
        for(int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if(first.charAt(i) == last.charAt(i)) res.append(first.charAt(i));
            else break;
        }
        return res.toString();
    }
    /*public static String longestCommonPrefix(String[] strs) {
        String longest = "";
        String shortest = strs[0];
        for(String str : strs) {
            if(str.length() == 0) return "";
            if(str.length() > longest.length()) {
                longest = str;
            } 
            if(str.length() < shortest.length()) shortest = str;
        }
        for(int i = 0; i < longest.length(); i++) {
            for(String str : strs) {
                if(str.length() > i && str.charAt(i) != longest.charAt(i) || i >= shortest.length()) {
                    return longest.substring(0, i);
                }
            }
        }
        return shortest;
    }*/
}
