package validAnagram;
import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        String s = "jar", t = "jam";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            sMap.put( s.charAt(i), sMap.getOrDefault( s.charAt(i), 0 ) + 1 );
            tMap.put( t.charAt(i), tMap.getOrDefault( t.charAt(i), 0 ) + 1 );
        }

        for(Character key : sMap.keySet()) {
            if( ! sMap.get(key).equals( tMap.getOrDefault(key, 0) ) ) return false;
        }
        for(Character key : tMap.keySet()) {
            if( ! tMap.get(key).equals( sMap.getOrDefault(key, 0) ) ) return false;
        }
        return true;
    }
}
