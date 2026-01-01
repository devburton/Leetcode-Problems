import java.util.HashMap;

class App {
    public static void main(String[] args) {
        String str = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(str , k));
    }
        public static int characterReplacement(String s, int k) {
            int res = 0, l = 0, r = 0, maxf = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            for(; r < s.length(); r++) {
                map.put(s.charAt(r),map.getOrDefault(s.charAt(r), 0) + 1);
                maxf = Math.max(maxf, map.get(s.charAt(r)));
                while(r - l + 1 - maxf > k) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                    l++;
                }
                res = Math.max(res, r - l + 1);
            }
            return res;
        }

    /*public static int characterReplacement(String s, int k) {
        int res = 0, l = 0, r = 0, longest = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        boolean rightMoved = true;
        while(r < s.length()) {
            if(rightMoved) {
                char c = s.charAt(rightMoved ? r : l);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for(Integer val : map.values()) {
                longest = Math.max(longest, val);
            }
            if(r - l + 1 - longest <= k) {
                res = Math.max(res, r - l + 1);
                r++;
                rightMoved = true;
            } else {
                char c = s.charAt(l);
                map.put(c, map.get(c) - 1);
                l++;
                rightMoved = false;
            }
        }
        return res;
    }*/
}
