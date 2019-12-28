package Question.TreeQuestion;

public class VerifySuffixSequenceOfBST {

    public boolean verifySuffixSequence(int[] sequence){
        if (sequence == null || sequence.length == 0)
            return false;
        return helper(sequence, 0, sequence.length - 1);
    }

    private boolean helper(int[] sequence, int start, int end){
        // attention: the structure of the tree can not be determined only according to suffix sequence
        // attention: so you should judge when searching in the right subtree
        if (start >= end)
            return true;
        int root = sequence[end];
        int index = start;
        // the left subtree
        for (int i = start; i < end; i++){
            if (sequence[i] < root)
                index++;
        }
        // the right subtree
        for (int i = index; i < end; i++) {
            if (sequence[i] < root)
                return false;
        }
        return helper(sequence, start, index - 1) && helper(sequence, index, end - 1);
    }

}