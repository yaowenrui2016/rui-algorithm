package indi.rui.algorithm.十元问题;

import indi.rui.algorithm.TimeUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author: yaowr
 * @create: 2022-12-11
 */
public class Main {

    private static final int[] rewards = new int[]{100, 50, 20, 10, 5, 2, 1};


    public static void main(String[] args) {
        Set<String> allMethod = new LinkedHashSet<>();
        long begin = System.currentTimeMillis();
        supply(40, new ArrayList<>(), allMethod);
        long calcEnd = System.currentTimeMillis();
        int count = 1;
        for (String method : allMethod) {
            System.out.println("方式" + count++ + ": " + method);
        }
        long printEnd = System.currentTimeMillis();
        System.out.println("计算耗时：" + TimeUtil.getDuration(calcEnd - begin));
        System.out.println("打印耗时：" + TimeUtil.getDuration(printEnd - calcEnd));
    }

    private static void supply(int supply, List<Integer> moneyList, Set<String> allMethod) {
        if (supply == 0) {
            Collections.sort(moneyList, Comparator.reverseOrder());
            allMethod.add(StringUtils.join(moneyList, ","));
        }
        for (int i = 0; i < rewards.length; i++) {
            if (supply >= rewards[i]) {
                List<Integer> newMoneyList = new ArrayList<Integer>(moneyList);
                newMoneyList.add(rewards[i]);
                supply(supply - rewards[i], newMoneyList, allMethod);
            }
        }
    }
}
