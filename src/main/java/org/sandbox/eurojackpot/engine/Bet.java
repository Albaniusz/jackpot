package org.sandbox.eurojackpot.engine;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Bet {
    private List<Integer> numbersMain;

    private List<Integer> numbersSecond;

    public static Bet factory(Engine engine) {
        Bet bet = new Bet();

        bet.setNumbersMain(new ArrayList<>());
        for (int i = 0; i < engine.getConfig().getNumbersByBetMain(); i++) {
            engine.generateNumberMain(bet.getNumbersMain());
        }

        bet.setNumbersSecond(new ArrayList<>());
        for (int i = 0; i < engine.getConfig().getNumbersByBetSecond(); i++) {
            engine.generateNumberSecond(bet.getNumbersSecond());
        }

        bet.sort();

        return bet;
    }

    public void sort() {
        numbersMain = sort(numbersMain);
        numbersSecond = sort(numbersSecond);
    }

    private List<Integer> sort(List<Integer> list) {
        return list.stream()
            .sorted()
            .collect(Collectors.toList());
    }
}
