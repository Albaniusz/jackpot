package local.sandbox.eurojackpot.tools;

import local.sandbox.eurojackpot.structure.WinningsLevel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Counter {
    public int bets = 0;

    public int draws = 0;

    public BigDecimal invest = BigDecimal.ZERO;

    public BigDecimal result = BigDecimal.ZERO;

    public Map<WinningsLevel, Integer> winningsByLevel = new HashMap<>();
}
