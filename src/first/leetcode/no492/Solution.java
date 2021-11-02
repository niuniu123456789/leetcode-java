package first.leetcode.no492;

/**
 * @author lvy
 * @date 2021/10/23 20:37
 */
class Solution {
    public int[] constructRectangle(int area) {
        int width = 1;
        int length = area;
        for (int i = 1; i <= Math.sqrt(area) ; i++) {
            if (area % i == 0){
                width = i;
                length = area / width;
            }
        }
        return new int[]{length,width};
    }
}
