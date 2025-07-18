package local.sandbox.eurojackpot.structure;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum WinningsLevel {
    I(5, 2, new BigDecimal("40000000")),
    II(5, 1, new BigDecimal("1000000")),
    III(5, 0, new BigDecimal("200000")),
    IV(4, 2, new BigDecimal("5000")),
    V(4, 1, new BigDecimal("300")),
    VI(4, 0, new BigDecimal("150")),
    VII(3, 2, new BigDecimal("125")),
    VIII(2, 2, new BigDecimal("25")),
    IX(3, 1, new BigDecimal("17")),
    X(3, 0, new BigDecimal("13")),
    XI(1, 2, new BigDecimal("11")),
    XII(2, 1, new BigDecimal("9"));

    private final int main;

    private final int second;

    private final BigDecimal average;

    WinningsLevel(int main, int second, BigDecimal average) {
        this.main = main;
        this.second = second;
        this.average = average;
    }
}
