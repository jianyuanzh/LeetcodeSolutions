import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */
class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0 || k == 0) {
            return result;
        }
        LinkedList<Integer> current = new LinkedList<>();
        dfs(result, current, n,  k, 1);
        return result;
    }

    private void dfs(List<List<Integer>> result, LinkedList<Integer> current, int n, int k, int level) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (current.size() > n) {
            return;
        }

        for (int i = level; i <= n; i++) {
            current.add(i);
            dfs(result, current, n, k, i+1);
            current.removeLast();
        }
    }


    public static void main(String[] args) {
        for (List<Integer> res : new Combination().combine(4, 2)) {
            System.out.println(res);
        }
    }
}