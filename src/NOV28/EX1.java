package NOV28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*

给你一个下标从 0 开始的整数数组 nums 以及一个目标元素 target 。

目标下标 是一个满足 nums[i] == target 的下标 i 。

将 nums 按 非递减 顺序排序后，返回由 nums 中目标下标组成的列表。如果不存在目标下标，返回一个 空 列表。返回的列表必须按 递增 顺序排列。
 */
public class EX1 {
    public List<Integer> targetIndices(int[] nums, int target) {
        ArrayList<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]==target){
                list.add(i);
            }
        }
        return list;
    }
}
