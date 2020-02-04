package leet;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s){
        if (s == null || s.length() == 0)
            return 0;
        int[] positions = new int[128];
        for (int i = 0; i < 128; i++) {
            positions[i] = -1;
        }

        int l = s.length();
        int start = 0;
        int length = 0;
        int maxLength = 0;
        for (int i = 0; i < l; i++) {
            int temp = s.charAt(i);
            if (positions[temp] < start){
                positions[temp] = i;
                length++;
            }
            else if (positions[temp] >= start){
                start = positions[temp] + 1;
                positions[temp] = i;
                length = i - start + 1;
            }
            if (length > maxLength)
                maxLength = length;
        }

        return maxLength;
    }

}
