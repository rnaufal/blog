package br.com.rnaufal.summaries;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Rafael Naufal on 09/26/2019.
 */
public class ImperativeCharSummarizer implements CharSummarizer {

    @Override
    public CharSummaryStatistics summarize(final String arg) {
        final var inputArg = StringUtils.defaultString(arg);
        var totalDigits = 0;
        var totalUppercaseChars = 0;
        var totalLowercaseChars = 0;
        var totalInvalidChars = 0;
        for (final char current : inputArg.toCharArray()) {
            if (Character.isDigit(current)) {
                totalDigits += 1;
            } else if (Character.isUpperCase(current)) {
                totalUppercaseChars += 1;
            } else if (Character.isLowerCase(current)) {
                totalLowercaseChars += 1;
            } else {
                totalInvalidChars += 1;
            }
        }
        return new CharSummaryStatistics(totalDigits, totalUppercaseChars, totalLowercaseChars, totalInvalidChars);
    }
}
