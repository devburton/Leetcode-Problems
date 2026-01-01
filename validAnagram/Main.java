package validAnagram;

class Main {
    public static void main(String[] args) {
        String s = "jam", t = "jar";
        System.out.println(isAnagram(s, t));
    }

    // a = 97
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] count = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 97]++;
            count[t.charAt(i) - 97]--;
        }

        for(int i = 0; i < 26; i++) {
            if(count[i] != 0) return false;
        }
        return true;
    }
}
