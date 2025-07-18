package local.sandbox.eurojackpot.structure;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Bet {
    private List<Integer> main;

    private List<Integer> secondary;
}
