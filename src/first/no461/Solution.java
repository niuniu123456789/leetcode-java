package first.no461;

/**
 * @author lvy
 * @date 2021/10/2 15:42
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int s = x^y, ret = 0;
        while (s != 0){
            s &= s - 1;
            ret ++;
        }
        return ret;
    }
}


// class Solution {
//     public int hammingDistance(int x, int y) {
//         int n_x =0, n_y=0;
//         while (x/2 != 0){
//             x = x/2;
//             n_x++;
//         }
//         while (y/2 != 0){
//             y = y/2;
//             n_y++;
//         }
//
//         return n_x - n_y >= 0? n_x - n_y: n_y - n_x;
//     }
// }