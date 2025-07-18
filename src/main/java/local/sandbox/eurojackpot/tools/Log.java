package local.sandbox.eurojackpot.tools;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Log {
    public void log(String message) {
        write(message);
    }

    public void logNumber(String message, int number) {
        write(message + " " + NumberFormat.getNumberInstance().format(number));
    }

    public void logAmount(String message, BigDecimal amount) {
        write(message + " " + NumberFormat.getCurrencyInstance(Locale.GERMANY).format(amount));
    }

    private void write(String message) {
        System.out.println(message);
    }
}
