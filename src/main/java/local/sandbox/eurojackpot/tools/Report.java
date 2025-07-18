package local.sandbox.eurojackpot.tools;

import local.sandbox.eurojackpot.structure.WinningsLevel;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class Report {
    private final Log log;

    private final Counter counter;

    public void generate() {
        log.log("");
        log.log("------------------------------------------------------------------------------------------------------------------------");
        log.log("");

        log.logNumber("bets", counter.bets);
        log.logNumber("draws", counter.draws);
        log.logAmount("invest", counter.invest);
        log.logAmount("result", counter.result);

        for (Map.Entry<WinningsLevel, Integer> entry : counter.winningsByLevel.entrySet()) {
            log.logNumber(entry.getKey().name(), entry.getValue());
        }
    }
}
