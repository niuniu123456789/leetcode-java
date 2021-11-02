// package first.leetcode.no496;
//
// import java.util.Deque;
// import java.util.LinkedHashMap;
// import java.util.LinkedList;
// import java.util.Map;
//
// /**
//  * @author lvy
//  * @date 2021/10/5 12:09
//  */
// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         int[] res = new int[nums1.length - 1];
//         //接收nums2 排列身高的栈
//         Deque<Integer> stack = new LinkedList<>();
//         //把nums2 转换成 一个哈希表
//         Map<Integer, Integer> num2Map = new LinkedHashMap<>();
//
//         //逐个寻找nums1的元素
//         for (int j = 0; j < nums1.length; j++){
//
//             //将nums2 的元素 倒着入栈, 并在之前 判断与nums1的大小关系
//             for (int i = nums2.length -1; i>=0; i--){
//                 if (stack.isEmpty()){
//                     stack.push(nums2[i]);
//                     continue;
//                 }
//                 if (nums2[i] == nums1[j]){
//                     while (!stack.isEmpty() && stack.peek() <= nums1[lenNums1]){
//                         stack.pop();
//                     }
//                     res[lenNums1] = stack.isEmpty() ? -1 : stack.pop();
//                 }
//                 lenNums1--;
//                 stack.push(nums2[i]);
//             }
//         }
//
//
//     }
// }