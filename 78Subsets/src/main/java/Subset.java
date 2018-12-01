import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        LinkedList<Integer> current = new LinkedList<>();
        Arrays.sort(nums);
        backTracing(nums, result, current, 0);
        return result;
    }

    private void backTracing(int[] sortedNums, List<List<Integer>> result, LinkedList<Integer> current, int start) {
        if (start == sortedNums.length) {
            return;
        }
        for (int i = start; i < sortedNums.length; i++) {
            current.add(sortedNums[i]);
            result.add(new ArrayList<>(current));
            backTracing(sortedNums, result, current, i+1);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        for (List<Integer> ret : new Subset().subsets(new int[]{1,2,3})) {
            System.out.println(ret);
        }
    }
}
