package kukulam.module.advancedtesting.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TimeFormatterTest {

    @Mock
    private SimpleClock mockedClock;
    private TimeFormatter timeFormatter;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        timeFormatter = new TimeFormatter(mockedClock);
    }

    @Test
    void shouldGenerateTimeAsStringForPolishZone() {
        // given
        ZoneId polishZone = ZoneId.of("Europe/Warsaw");
        Instant now = Instant.ofEpochMilli(1577870100000L);
        String expectedPolishTime = "2020-01-01T10:15";

        when(mockedClock.nowPlusDays(any())).thenReturn(now);

        // when
        String polishTime = timeFormatter.now(polishZone);

        // then
        assertThat(polishTime).isEqualTo(expectedPolishTime);
    }

    // manual creating mock
    @Test
    void shouldGenerateTimeAsStringForPolishZone2() {
        // given
        ZoneId polishZone = ZoneId.of("Europe/Warsaw");
        Instant now = Instant.ofEpochMilli(1577870100000L);
        String expectedPolishTime = "2020-01-01T10:15";

        SimpleClock mockedClock = Mockito.mock(SimpleClock.class);
        TimeFormatter timeFormatter = new TimeFormatter(mockedClock);

        when(mockedClock.nowPlusDays(any())).thenReturn(now);

        // when
        String polishTime = timeFormatter.now(polishZone);

        // then
        assertThat(polishTime).isEqualTo(expectedPolishTime);
    }

    @Test
    void shouldGenerateTimeAsStringForUTCZone() {
        // given
        ZoneId utc = ZoneId.of("UTC");
        Instant now = Instant.ofEpochMilli(1577870100000L);
        String expectedUTCTime = "2020-01-01T09:15";

        when(mockedClock.nowPlusDays(any())).thenReturn(now);

        // when
        String polishTime = timeFormatter.now(utc);

        // then
        assertThat(polishTime).isEqualTo(expectedUTCTime);
    }

    @Test
    void shouldGenerateTimeForTomorrowAsStringForPolishZone() {
        // given
        ZoneId polishZone = ZoneId.of("Europe/Warsaw");
        Instant now = Instant.ofEpochMilli(1577870100000L);
        String expectedPolishTime = "2020-01-01T10:15";

        when(mockedClock.nowPlusDays(1)).thenReturn(now);

        // when
        String polishTime = timeFormatter.tomorrow(polishZone);

        // then
        assertThat(polishTime).isEqualTo(expectedPolishTime);
    }

}