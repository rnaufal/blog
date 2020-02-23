package br.com.rnaufal.summaries;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Rafael Naufal on 09/26/2019.
 */
public class StreamsCharSummarizer implements CharSummarizer {

    @Override
    public CharSummaryStatistics summarize(final String arg) {
        final var inputArg = StringUtils.defaultString(arg);

        final var totalDigits = inputArg.chars()
                .filter(Character::isDigit)
                .count();

        final var totalUppercaseChars = inputArg.chars()
                .filter(Character::isUpperCase)
                .count();

        final var totalLowercaseChars = inputArg.chars()
                .filter(Character::isLowerCase)
                .count();

        final var totalInvalidChars = inputArg.chars()
                .filter(character -> !Character.isLetterOrDigit(character))
                .count();

        return new CharSummaryStatistics(totalDigits, totalUppercaseChars, totalLowercaseChars, totalInvalidChars);
    }
}
