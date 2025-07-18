package local.sandbox.eurojackpot.tools;

import local.sandbox.eurojackpot.structure.Bet;
import local.sandbox.eurojackpot.structure.Draw;
import local.sandbox.eurojackpot.structure.WinningsLevel;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Game {

    private Game() {
    }

    public static int random(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static Bet generateBet() {
        Bet bet = new Bet();

        bet.setMain(new ArrayList<>());
        for (int i = 0; i < 5; i++) {
            bet.getMain().add(random(1, 50));
        }
        bet.getMain().sort(Integer::compareTo);

        bet.setSecondary(new ArrayList<>());
        for (int i = 0; i < 2; i++) {
            bet.getSecondary().add(random(1, 12));
        }
        bet.getSecondary().sort(Integer::compareTo);

        return bet;
    }

    public static WinningsLevel checkBet(Draw draw, Bet bet) {
        int mainCounter = 0;
        int secondCounter = 0;

        for (int i : bet.getMain()) {
            if (draw.getWinner().getMain().contains(i)) {
                mainCounter++;
            }
        }

        for (int i : bet.getSecondary()) {
            if (draw.getWinner().getSecondary().contains(i)) {
                secondCounter++;
            }
        }

        if (mainCounter > 2
                || (mainCounter == 2 && secondCounter >= 1)
                || (mainCounter == 1 && secondCounter == 2)) {
            for (WinningsLevel level : WinningsLevel.values()) {
                if (level.getMain() == mainCounter && level.getSecond() == secondCounter) {
                    return level;
                }
            }
        }

        return null;
    }

    public static boolean noticeWin(WinningsLevel winningsLevel, Counter counter, Log log) {
        boolean breaker = false;

        BigDecimal win = winningsLevel.getAverage();

        if (counter.winningsByLevel.containsKey(winningsLevel)) {
            counter.winningsByLevel.put(winningsLevel, counter.winningsByLevel.get(winningsLevel) + 1);
        } else {
            counter.winningsByLevel.put(winningsLevel, 1);
        }

        counter.result = counter.result.add(win);
        if (WinningsLevel.I == winningsLevel) {
            log.logAmount("MAIN WIN", win);
            breaker = true;
        } else {
            log.logAmount("Win " + winningsLevel.name() + " level", win);
        }

        return breaker;
    }
}
