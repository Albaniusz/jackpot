package local.sandbox.eurojackpot;

import local.sandbox.eurojackpot.structure.Bet;
import local.sandbox.eurojackpot.structure.Draw;
import local.sandbox.eurojackpot.structure.WinningsLevel;
import local.sandbox.eurojackpot.tools.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EuroJackpotApplication {
    public static void main(String[] args) {
        EuroJackpotApplication app = new EuroJackpotApplication();
        app.doThings();
    }

    private void doThings() {
        Log log = new Log();
        Counter counter = new Counter();

        boolean breaker = false;
        int workCounter = 0;

        while (!breaker) {
            counter.draws++;

            // generate bets
            List<Bet> bets = new ArrayList<>();
            for (int i = 0; i < Configuration.betsByDraw; i++) {
                counter.bets++;
                counter.invest = counter.invest.add(Configuration.betCost);
                bets.add(Game.generateBet());
            }

            // draw
            Draw draw = new Draw(Game.generateBet());

            // check is bets in draw
            for (Bet bet : bets) {
                WinningsLevel winningsLevel = Game.checkBet(draw, bet);

                if (Objects.nonNull(winningsLevel)) {
                    breaker = Game.noticeWin(winningsLevel, counter, log);
                    if (breaker) {
                        break;
                    }
                }
            }

            workCounter++;
            if (workCounter >= Configuration.workLimiter) {
//                breaker = true;
            }
        }

        Report report = new Report(log, counter);
        report.generate();
    }
}
