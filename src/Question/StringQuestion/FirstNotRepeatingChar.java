package Question.StringQuestion;

public class FirstNotRepeatingChar {

    public int firstNotRepeatingChar(String str){
        if (str == null || str.length() == 0)
            return -1;

        // attention: just use an array with a length of 58(A-Z 65-90, a-z 97-122) to record,
        //  and you don't need to handle case separately.
        //  What's more, if you don't want to perform subtraction, you can use an array with length of 128
        int[] times = new int[58];

        // step 1: record times
        for (int i = 0; i < str.length(); i++) {
            times[str.charAt(i)-65]++;
        }

        // step 2: find the first not repeating char
        for (int i = 0; i < str.length(); i++) {
            if (times[str.charAt(i)-65] == 1)
                return i;
        }
        return -1;
    }

}