// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class ExclusiveTimeFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        int prev = 0;
        for (String log : logs) {
            String[] strArr = log.split(":");
            int currTask = Integer.parseInt(strArr[0]);
            curr = Integer.parseInt(strArr[2]);

            if (strArr[1].equals("start")) {
                // start
                if (!stack.isEmpty()) {
                    result[stack.peek()] += curr - prev;
                }
                stack.push(currTask);
                prev = curr;
            } else {
                // end
                result[stack.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}