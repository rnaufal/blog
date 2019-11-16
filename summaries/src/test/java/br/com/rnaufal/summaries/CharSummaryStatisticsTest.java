package br.com.rnaufal.summaries;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Rafael Naufal on 11/15/2019.
 */
class CharSummaryStatisticsTest {

    @Test
    void shouldAcceptDifferentTypesOfChars() {
        final CharSummaryStatistics charSummaryStatistics = buildCharSummaryStatistics();

        assertThat(charSummaryStatistics.getTotalDigits()).isEqualTo(1);
        assertThat(charSummaryStatistics.getTotalUppercaseChars()).isEqualTo(1);
        assertThat(charSummaryStatistics.getTotalLowercaseChars()).isEqualTo(2);
        assertThat(charSummaryStatistics.getTotalInvalidChars()).isEqualTo(0);
    }

    @Test
    void shouldCombineCharSummaryStatistics() {
        final CharSummaryStatistics charSummaryStatistics = buildCharSummaryStatistics();
        final CharSummaryStatistics other = buildCharSummaryStatistics();

        charSummaryStatistics.combine(other);

        assertThat(charSummaryStatistics.getTotalDigits()).isEqualTo(2);
        assertThat(charSummaryStatistics.getTotalUppercaseChars()).isEqualTo(2);
        assertThat(charSummaryStatistics.getTotalLowercaseChars()).isEqualTo(4);
        assertThat(charSummaryStatistics.getTotalInvalidChars()).isEqualTo(0);
    }

    private CharSummaryStatistics buildCharSummaryStatistics() {
        final CharSummaryStatistics charSummaryStatistics = new CharSummaryStatistics();
        charSummaryStatistics.accept('A');
        charSummaryStatistics.accept('a');
        charSummaryStatistics.accept('b');
        charSummaryStatistics.accept('1');
        return charSummaryStatistics;
    }
}