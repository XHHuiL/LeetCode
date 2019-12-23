package Question.StringQuestion;


public class StringToInteger {

    /**
     * @param str the input string
     * @return if this string represent a integer, return it, otherwise return 0
     */
    public static int stringToInteger(String str) {
        // filter
        if (str == null || str.equals(""))
            return 0;

        boolean isPositive = true;
        int index = 0;

        // step 1: get the sign
        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            if (str.charAt(index) == '-')
                isPositive = false;
            index++;
        }

        // step 2: get integer
        int length = str.length();
        int result = 0;
        while (index < length) {
            char c = str.charAt(index);
            if (c <= '9' && c >= '0') {
                index++;
                int value = isPositive ? c - '0' : '0' - c;
                try {
                    // attention: the operations here may overflow, so you should check it
                    // attention: you can use '<<' or '>>' to accelerate calculation
                    // attention: the priority of '+' operation is higher than '<<' operation
                    result = Math.addExact(result << 3, (result << 1) + value);
                } catch (ArithmeticException e) {
                    return 0;
                }
            } else
                return 0;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}