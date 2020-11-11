package kukulam.module.advancedtesting.task3;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

// Use in tests: @Mock, Mockito.mock(), any()
// Talk about repeatable, any(), @Mock params
// Available zones: ZoneId.getAvailableZoneIds().forEach(System.out::println);
// timestamp: https://currentmillis.com/
public class TimeFormatter {

    private final SimpleClock clock;

    public TimeFormatter(SimpleClock clock) {
        this.clock = clock;
    }

    public String now(ZoneId zoneId) {
        Instant now = clock.nowPlusDays(0);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, zoneId);
        return localDateTime.toString();
    }

    public String tomorrow(ZoneId zoneId) {
        Instant now = clock.nowPlusDays(1);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, zoneId);
        return localDateTime.toString();
    }

}
