package AppServices;

import java.time.LocalDate;

public abstract class AppService {

    public static LocalDate ConverteData(String d) {
        if (d == null) {
            return null;
        }
        String[] ds = d.split("-");

        LocalDate date = LocalDate.of(Integer.parseInt(ds[0]), Integer.parseInt(ds[1]), Integer.parseInt(ds[2]));
        return date;
    }
}
