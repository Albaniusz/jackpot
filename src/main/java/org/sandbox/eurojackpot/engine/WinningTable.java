package org.sandbox.eurojackpot.engine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WinningTable {

    private List<WinningTableRow> rows;

    public WinningTable() {
        rows = new ArrayList<>();

        int pool = 536_218_800;

        rows.add(WinningTableRow.builder()
                .degree("I")
                .mainWin(true)
                .main(5)
                .second(2)
                .probability("1 : 139 838 159")
//                .amount(calculateAmount(pool, 36.00))
                .amount(19303876800L)
                .build());

        rows.add(WinningTableRow.builder()
                .degree("II")
                .main(5)
                .second(1)
                .probability("1 : 6 991 907")
//                .amount(calculateAmount(pool, 8.6))
                .amount(4611481600L)
                .build());

        rows.add(WinningTableRow.builder()
                .degree("III")
                .main(5)
                .second(0)
                .probability("1 : 3 107 514")
//                .amount(calculateAmount(pool, 4.85))
                .amount(2600661100L)
                .build());

        rows.add(WinningTableRow.builder()
                .degree("IV")
                .main(4)
                .second(2)
                .probability("1 : 621 502")
                .amount(428975000)
                .build());

        rows.add(WinningTableRow.builder()
                .degree("V")
                .main(4)
                .second(1)
                .probability("1 : 31 074")
//                .amount(calculateAmount(pool, 1))
                .amount(3124400)
                .build());

        rows.add(WinningTableRow.builder()
                .degree("VI")
                .main(3)
                .second(2)
                .probability("1 : 14 124")
//                .amount(calculateAmount(pool, 1.1))
                .amount(80200)
                .build());

        rows.add(WinningTableRow.builder()
                .degree("VII")
                .main(4)
                .second(0)
                .probability("1 : 13 810")
//                .amount(calculateAmount(pool, 0.8))
                .amount(68200)
                .build());

        rows.add(WinningTableRow.builder()
                .degree("VIII")
                .main(2)
                .second(2)
                .probability("1 : 984")
//                .amount(calculateAmount(pool, 2.55))
                .amount(10500)
                .build());

        rows.add(WinningTableRow.builder()
                .degree("IX")
                .main(3)
                .second(1)
                .probability("1 : 705")
//                .amount(calculateAmount(pool, 2.85))
                .amount(10500)
                .build());

        rows.add(WinningTableRow.builder()
                .degree("X")
                .main(3)
                .second(0)
                .probability("1 : 313")
//                .amount(calculateAmount(pool, 5.4))
                .amount(9400)
                .build());

        rows.add(WinningTableRow.builder()
                .degree("XI")
                .main(1)
                .second(2)
                .probability("1 : 187")
//                .amount(calculateAmount(pool, 6.75))
                .amount(4700)
                .build());

        rows.add(WinningTableRow.builder()
                .degree("XII")
                .main(2)
                .second(1)
                .probability("1 : 42")
//                .amount(calculateAmount(pool, 20.3))
                .amount(4500)
                .build());
    }

    public WinningTableRow getWin(int main, int second) {
        return rows.stream()
                .filter(item -> item.getMain() == main)
                .filter(item -> item.getSecond() == second)
                .findFirst()
                .orElse(null);
    }

    private int calculateAmount(int initPool, double initPercent) {
        BigDecimal pool = new BigDecimal(initPool);
        BigDecimal percent = new BigDecimal(initPercent).movePointLeft(2);

        BigDecimal result = pool.multiply(percent);

        return result.intValue();
    }
}
