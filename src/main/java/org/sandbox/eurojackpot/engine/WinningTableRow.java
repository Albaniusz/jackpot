package org.sandbox.eurojackpot.engine;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WinningTableRow {

    private boolean mainWin;

    private String degree;

    private int main;

    private int second;

    private String probability;

    private long amount;
}
