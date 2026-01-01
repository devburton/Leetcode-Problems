import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
    public static String minWindow(String s, String t) {
        String minSubstring = s;
        int left = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        boolean hasCommon = false;
        for(int i = 0; !hasCommon; i++) {
            char c = s.charAt(i);
            if(tMap.containsKey(c)) {
                hasCommon = true;
                left = i;
                break;
            }            
        }

        for(int i = left; i < s.length(); i++) {
            char c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            boolean matches = true;
            if(tMap.containsKey(c)) {
                for(char compare : tMap.keySet()) {
                    if(sMap.getOrDefault(compare, 0) != tMap.getOrDefault(compare,0)) {
                        matches = false;
                        break;
                    }
                }
                if(matches) {
                    minSubstring = minSubstring.length() > s.substring(left, i + 1).length() ? s.substring(left, i + 1) : minSubstring;
                    do {
                        if(sMap.get(s.charAt(left)) == 1) {
                            sMap.remove(s.charAt(left));
                        } else {
                            sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                        }
                        left += 1;
                    } while(left < s.length() && !tMap.containsKey(s.charAt(left)));
                }
            }
        }
        return minSubstring;

    }
}
