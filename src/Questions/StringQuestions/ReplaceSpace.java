package Questions.StringQuestions;


public class ReplaceSpace {


    /*
     * test case 1: input null reference
     * expect: return null
     * */
    private static void testCase_NullReference() {
        assert replaceSpace(null) == null;
        System.out.println("Pass: testCase_NullReference");
    }

    /*
     * test case 2: no space
     * expect: return the same string
     * */
    private static void testCase_NoSpace() {
        assert replaceSpace(new StringBuffer("NoSpace")).equals("NoSpace");
        System.out.println("Pass: testCase_NoSpace");
    }

    /*
     * test case 3: one space
     * expect: return the string after replaced
     * */
    private static void testCase_OneSpace() {
        StringBuffer str = new StringBuffer("One Space");
        assert replaceSpace(str).equals("One%20Space");
        System.out.println("Pass: testCase_OneSpace");
    }

    /*
     * test case 4: multi space
     * expect: return the string after replaced
     * */
    private static void testCase_MultiSpace() {
        StringBuffer str = new StringBuffer("Multi Space ");
        assert replaceSpace(str).equals("Multi%20Space%20");
        System.out.println("Pass: testCase_MultiSpace");
    }

    /*
     * test case 5: multi consecutive space
     * expect: return thr string after replaced
     * */
    private static void testCase_MultiConsSpace() {
        StringBuffer str = new StringBuffer("Multi  Cons Space");
        assert replaceSpace(str).equals("Multi%20%20Cons%20Space");
        System.out.println("Pass: testCase_MultiConsSpace");
    }

    /**
     * Replace all spaces in the input StringBuffer by "%20"
     *
     * @param str string contains space that need replaced by "%20"
     * @return the string after replaced
     */
    public static String replaceSpace(StringBuffer str) {
        // step 1: filter input
        if (str == null)
            return null;

        // step 2: get the number of space
        int len = str.length();
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ')
                num++;
        }

        // step 3: copy chars from str to a new string and insert "%20" into this string
        // attention: StringBuilder is more efficient than StringBuffer in  non-thread application
        // should use StringBuilder.setCharAt(), can't use StringBuilder.insert() or StringBuilder.replace()
        // attention: can't set char out of count belong to StringBuilder
        // attention: but in this case, you can use primary char array , because only need set option
        int newLen = len + num * 2;
        char[] result = new char[newLen];
        int p2 = newLen - 1;
        for (int p1 = len - 1; p1 >= 0; p1--) {
            if (str.charAt(p1) != ' ') {
                result[p2--] = str.charAt(p1);
            } else {
                result[p2--] = '0';
                result[p2--] = '2';
                result[p2--] = '%';
            }
        }

        // construct a string from char array
        return new String(result);
    }

    public static void main(String[] args) {
        testCase_NullReference();
        testCase_NoSpace();
        testCase_OneSpace();
        testCase_MultiSpace();
        testCase_MultiConsSpace();
    }
}