package first.no461;

import java.util.Scanner;

/**
 * @author lvy
 * @date 2021/10/12 11:36
 */
public class ll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pageNum = scanner.nextInt();
        long startTime = System.currentTimeMillis();
        //存储数组
        int[] store = new int[10];
        for (int i = 0; i < pageNum; i++) {
            int temp = i;
            while (temp > 0){
                store[temp % 10]++;
                temp = temp / 10;
            }
        }
        for (int i = 0; i < store.length; i++) {
            System.out.println(store[i]);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间：" + (endTime - startTime));
    }

}
