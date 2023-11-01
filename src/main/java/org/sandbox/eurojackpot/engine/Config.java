package org.sandbox.eurojackpot.engine;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Config {

    int mainLoopCounter = 0;

    private int mainLoopBreak = 3;

    private int betsByDraw = 4;

    private int numbersByBetMain = 5;

    private int numbersByBetSecond = 2;

    private int betPrice;
}
