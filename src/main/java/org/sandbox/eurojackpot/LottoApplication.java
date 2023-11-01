package org.sandbox.eurojackpot;

import org.sandbox.eurojackpot.engine.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class LottoApplication {

    public static void main(String[] args) {
        LottoApplication lottoApplication = new LottoApplication();
        lottoApplication.doThings();
    }

    public void doThings() {
        Config config = Config.builder()
//                .mainLoopBreak(999_999_999)
                .mainLoopBreak(5)
                .betsByDraw(4)
                .numbersByBetMain(5)
                .numbersByBetSecond(2)
                .betPrice(1250)
                .build();

        Engine engine = new Engine(config);

        boolean breaker = true;
        Boolean mainWin = false;
        int mainLoopCounter = 0;
        int betsCounter = 0;
        int hitCounter = 0;
        long moneySpentCounter = 0;
        long moneyWinCounter = 0;

        while (breaker) {
            mainLoopCounter++;
            log("Draw no: " + mainLoopCounter);

            // my bets
            Draw draw = new Draw();
            draw.setBets(new ArrayList<>());

            for (int i = 0; i < config.getBetsByDraw(); i++) {
                Bet bet = Bet.factory(engine);
                log("             " + bet);
                draw.getBets().add(bet);
                moneySpentCounter += config.getBetPrice();
                betsCounter++;
            }

            // draw
            Bet winningBet = Bet.factory(engine);
            log("Winning bet: " + winningBet);

            // results
            for (Bet bet : draw.getBets()) {
                WinningTableRow row = engine.checkBet(winningBet, bet);

                if (Objects.nonNull(row)) {
                    f
                    log(row.toString());
                    mainWin = row.isMainWin();
                    hitCounter++;
                }
            }

            if (mainLoopCounter >= config.getMainLoopBreak() || mainWin) {
                breaker = false;
            }
            breakLine();
        }

        log("Report:");
        log("Draws           " + mainLoopCounter);
        log("Bets by draw    " + config.getBetsByDraw());
        log("Bets total      " + betsCounter);
        log("Hits            " + hitCounter);

        BigDecimal moneySpent = formatMoney(moneySpentCounter);
        log("Money spent     " + moneySpent);
        BigDecimal moneyWin = formatMoney(moneyWinCounter);
        log("Money won       " + moneyWin);
        log("Money balance   " + moneyWin.subtract(moneySpent));
    }

    private void log(String phrase) {
        System.out.println(phrase);
    }

    private void breakLine() {
        log("------------------------------------------------------------------------------");
    }

    private BigDecimal formatMoney(long amount) {
//        return new BigDecimal(amount).divide(new BigDecimal(100));
        return new BigDecimal(amount);
    }
}
