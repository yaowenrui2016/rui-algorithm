package indi.rui.algorithm.十元问题;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author: yaowr
 * @create: 2022-12-11
 */
public class Main {

    private static final int MONEY_TEN = 10;
    private static final int MONEY_FIVE = 5;
    private static final int MONEY_TWO = 2;
    private static final int MONEY_ONE = 1;


    public static void main(String[] args) {
        Set<String> allMethod = new LinkedHashSet<>();
        allMethod.add(MONEY_TEN + "");
        supply(10, new ArrayList<>(), allMethod);
        int count = 1;
        for (String method : allMethod) {
            System.out.println("方式" + count++ + ": " + method);
        }
    }

    private static void supply(int supply, List<Integer> moneyList, Set<String> allMethod) {
        if (supply == 0) {
            Collections.sort(moneyList, Comparator.reverseOrder());
            allMethod.add(StringUtils.join(moneyList, ","));
        }
        if (supply >= MONEY_FIVE) {
            List<Integer> newMoneyList = new ArrayList<Integer>(moneyList);
            newMoneyList.add(MONEY_FIVE);
            supply(supply - MONEY_FIVE, newMoneyList, allMethod);
        }
        if (supply >= MONEY_TWO) {
            List<Integer> newMoneyList = new ArrayList<Integer>(moneyList);
            newMoneyList.add(MONEY_TWO);
            supply(supply - MONEY_TWO, newMoneyList, allMethod);
        }
        if (supply >= MONEY_ONE) {
            List<Integer> newMoneyList = new ArrayList<Integer>(moneyList);
            newMoneyList.add(MONEY_ONE);
            supply(supply - MONEY_ONE, newMoneyList, allMethod);
        }
    }
}
