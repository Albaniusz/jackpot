package org.sandbox.eurojackpot.engine;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@RequiredArgsConstructor
public class Engine {

    private static Random random;

    private static WinningTable winningTable;

    @Getter
    private final Config config;

    public void generateNumberMain(List<Integer> list) {
        generateUniqueNumber(list, 50);
    }

    public void generateNumberSecond(List<Integer> list) {
        generateUniqueNumber(list, 10);
    }

    private void generateUniqueNumber(List<Integer> list, int upperbound) {
        int number = generateNumber(upperbound);

        while (checkNumberIsUnique(list, number)) {
            number = generateNumber(upperbound);
        }

        list.add(number);
    }

    private int generateNumber(int upperbound) {
        if (Objects.isNull(random)) {
            random = new Random();
        }

        return random.nextInt(upperbound) + 1;
    }

    public boolean checkNumberIsUnique(List<Integer> list, int number) {
        return list.contains(number);
    }

    public WinningTableRow checkBet(Bet winningBet, Bet bet) {
        int mainCounter = checkLists(winningBet.getNumbersMain(), bet.getNumbersMain());
        int secondCounter = checkLists(winningBet.getNumbersSecond(), bet.getNumbersSecond());

        if (Objects.isNull(winningTable)) {
            winningTable = new WinningTable();
        }

        return winningTable.getWin(mainCounter, secondCounter);
    }

    private int checkLists(List<Integer> winningList, List<Integer> list) {
        int counter = 0;

        for (Integer number : winningList) {
            if (list.contains(number)) {
                counter++;
            }
        }

        return counter;
    }
}
