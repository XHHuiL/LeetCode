package Question.StringQuestion;

public class IsNumeric {
    private static int index = 0;

    private static void testCase_PositiveInteger() {
        char[] str = new char[]{'1', '0', '0'};
        isNumeric(str);
        System.out.println("Pass: testCase_PositiveInteger");
    }

    private static void testCase_PositiveIntegerWithSign() {

    }

    private static void testCase_NegativeInteger() {

    }

    private static void testCase_PositiveFloat() {

    }

    private static void testCase_NegativeFloat() {

    }

    private static void testCase_FloatWithoutIntegralPart() {

    }

    private static void testCase_FloatByENotation() {

    }

    /**
     * @param str the string that may represent a numeric
     * @return whether the input string represents a numeric
     */
    public static boolean isNumeric(char[] str) {
        // attention: a string that represent a numeric follow pattern A[.[B]][e|EC] or .B[e|EC]
        // attention: A and C are integer that may contain '+' or '-', B is integer without sign
        // filter
        if (str == null)
            return false;

        index = 0;
        // step 1: get part A
        boolean isNumeric = getInteger(str);

        // step 2: get part B
        if (index < str.length && str[index] == '.') {
            index++;
            // attention: 123.11  .123 represent 0.123  123. represent 123.0
            // attention: So, need to execute isPartBNumeric || isNumeric
            isNumeric = getUnsignedInteger(str) || isNumeric;
        }

        // step 3: get part C
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            // attention: a number before 'e|E' and a integer after 'e|E'
            // attention: for example, .e12 e36 and 2e1.3 are not numeric. So, need to execute isNumeric || isPartCNumeric
            isNumeric = isNumeric && getInteger(str);
        }

        // attention: if the input string contain other chars like '*', '!', return false
        return isNumeric && index == str.length;
    }

    private static boolean getUnsignedInteger(char[] str) {
        int before = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        return index > before;
    }

    private static boolean getInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            index++;
        return getUnsignedInteger(str);
    }

    public static void main(String[] args) {
        testCase_PositiveInteger();
    }
}