package Nov21;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
5933. k 镜像数字的和
一个 k 镜像数字 指的是一个在十进制和 k 进制下从前往后读和从后往前读都一样的 没有前导 0 的 正 整数。

比方说，9 是一个 2 镜像数字。9 在十进制下为 9 ，二进制下为 1001 ，两者从前往后读和从后往前读都一样。
相反地，4 不是一个 2 镜像数字。4 在二进制下为 100 ，从前往后和从后往前读不相同。
给你进制 k 和一个数字 n ，请你返回 k 镜像数字中 最小 的 n 个数 之和 。



示例 1：

输入：k = 2, n = 5
输出：25
解释：
最小的 5 个 2 镜像数字和它们的二进制表示如下：
  十进制       二进制
    1          1
    3          11
    5          101
    7          111
    9          1001
它们的和为 1 + 3 + 5 + 7 + 9 = 25 。
示例 2：

输入：k = 3, n = 7
输出：499
解释：
7 个最小的 3 镜像数字和它们的三进制表示如下：
  十进制       三进制
    1          1
    2          2
    4          11
    8          22
    121        11111
    151        12121
    212        21212
它们的和为 1 + 2 + 4 + 8 + 121 + 151 + 212 = 499 。
示例 3：

输入：k = 7, n = 17
输出：20379000
解释：17 个最小的 7 镜像数字分别为：
1, 2, 3, 4, 5, 6, 8, 121, 171, 242, 292, 16561, 65656, 2137312, 4602064, 6597956, 6958596
 */
public class EX4 {
}
class Solution {
    private int cnt;
    private long ans;

    public long kMirror(int k, int n) {
        int len = 1;
        this.cnt = n;
        this.ans = 0;
        while (this.cnt > 0) {
            int[] nums = new int[len];
            next(0, nums, k);
            len++;
        }
        return ans;
    }

    private void next(int id, int[] nums, int k) {
        if (cnt <= 0) return;
        if (id == (nums.length + 1) / 2) {
            long x = convert(nums);
            // System.out.println(x);
            if (isMirror(x, k)) {
                cnt--;
                ans += x;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (id == 0 && i == 0) continue;
            nums[id] = i;
            nums[nums.length - 1 - id] = i;
            next(id + 1, nums, k);
        }
    }

    private long convert(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res * 10 + nums[i];
        }
        return res;
    }

    private boolean isMirror(long x, int k) {
        List<Integer> list = new ArrayList<>();
        while (x > 0) {
            list.add((int) (x % k));
            x /= k;
        }

        for (int i = 0; i < list.size() / 2; i++) {
            if (!Objects.equals(list.get(i), list.get(list.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }
}


