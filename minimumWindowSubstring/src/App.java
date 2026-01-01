import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        String s = "A";
        String t = "AA";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int minL = 0, minR = -1;
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        
        for(char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = tMap.size();
        for(int L = 0, R = 0; R < s.length(); R++) {
            char c = s.charAt(R);
            if(tMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                if(sMap.get(c).intValue() == tMap.get(c).intValue()) have++;
            }
            while(have == need) {
                if (minR == -1 || R - L < minR - minL) {
                    minR = R;
                    minL = L;
                }
                c = s.charAt(L);
                if(sMap.containsKey(c)) {
                    sMap.put(c, sMap.get(c) - 1);
                    if(sMap.get(c).intValue() < tMap.get(c).intValue()) {
                        have--;
                    }
                }
                L++;
            }
        }
        return (minR == -1) ? "" : s.substring(minL, minR + 1);
    }

    // public static String minWindow(String s, String t) {
    //     int l = 0, r = 0, res = 0;
    //     HashMap<Character, Integer> sMap = new HashMap<>();
    //     HashMap<Character, Integer> tMap = new HashMap<>();
    //     for(int i = 0; i < t.length(); i++) {
    //         tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0) + 1);
    //     }
    //     for(; r <s.length(); r++) {
    //         sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r),0) + 1);
    //         boolean matches = true;
    //         for(Character c : tMap.keySet()) {
    //             if(tMap.get(c) != sMap.get(c)) matches = false;
    //         }
    //         while(matches) {
    //             while(sMap.get(s.charAt(r)) - tMap.get(s.charAt(r)) > 1) {
    //                 r--;
    //                 sMap.put(s.charAt(r), sMap.get(s.charAt(r)) - 1);
    //             }
    //             sMap.put(s.charAt(l), sMap.get(s.charAt(l)) - 1);
    //             for(Character c : tMap.keySet()) {
    //                 if(tMap.get(c) != sMap.get(c)) matches = false;
    //             }
    //         }
    //     }
    //     return "";
    // }
}
