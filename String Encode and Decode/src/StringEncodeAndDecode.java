import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        List<String> inputList = Arrays.asList("neet", "code", "love", "you");
        String encodedList = encode(inputList);
        List<String> decodedList = decode(encodedList);
        System.out.println(decodedList);

    }

    public static String encode(List<String> strs) {
        String returnString = "";
        for(String str : strs) {
            returnString += str.length() + "#" + str;
        }
        return returnString;
    }

    public static List<String> decode(String str) {
        List<String> returnList = new ArrayList<>();
        int stringLength = 0;
        String stringLengthString = "";
        String strToBeAdded = "";
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '#') {
                stringLength = Integer.parseInt(stringLengthString);
                i++;
                for(int j = 0; j < stringLength; i++, j++) {
                    strToBeAdded += str.charAt(i);
                }
                i--;
                if(stringLength == 0) returnList.add("");
                else returnList.add(strToBeAdded); 
                stringLengthString = "";
                stringLength = 0;
                strToBeAdded = "";
                
            } else stringLengthString += Character.toString(c);
        }
        return returnList;
    }
}
