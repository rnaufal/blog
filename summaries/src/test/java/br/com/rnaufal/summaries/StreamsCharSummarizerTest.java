package br.com.rnaufal.summaries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Rafael Naufal on 10/06/2019.
 */
class StreamsCharSummarizerTest {

    private CharSummarizer streamsCharSummarizer;

    @BeforeEach
    void setUp() {
        streamsCharSummarizer = new StreamsCharSummarizer();
    }

    @ParameterizedTest
    @CsvSource({
            "abcde, 0, 0, 5, 0",
            "ABCDE, 0, 5, 0, 0",
            "f, 0, 0, 1, 0",
            "123fm, 3, 0, 2, 0",
            "7AfY90Kn48J6, 6, 4, 2, 0",
            " , 0, 0, 0, 0",
            "&A@1b, 1, 1, 1, 2"
    })
    void shouldSummarizeCharsSuccessfully(final ArgumentsAccessor arguments) {
        var charSummaryStatistics = streamsCharSummarizer.summarize(arguments.getString(0));

        assertThat(charSummaryStatistics.getTotalDigits()).isEqualTo(arguments.getLong(1));
        assertThat(charSummaryStatistics.getTotalUppercaseChars()).isEqualTo(arguments.getLong(2));
        assertThat(charSummaryStatistics.getTotalLowercaseChars()).isEqualTo(arguments.getLong(3));
        assertThat(charSummaryStatistics.getTotalInvalidChars()).isEqualTo(arguments.getLong(4));
    }
}