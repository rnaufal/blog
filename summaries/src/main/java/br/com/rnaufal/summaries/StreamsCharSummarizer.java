package br.com.rnaufal.summaries;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Rafael Naufal on 09/26/2019.
 */
public class StreamsCharSummarizer implements CharSummarizer {

    @Override
    public CharSummaryStatistics summarize(final String arg) {
        var inputArg = StringUtils.defaultString(arg);

        var totalDigits = inputArg.chars()
                                  .filter(Character::isDigit)
                                  .count();

        var totalUppercaseChars = inputArg.chars()
                                          .filter(Character::isUpperCase)
                                          .count();

        var totalLowercaseChars = inputArg.chars()
                                          .filter(Character::isLowerCase)
                                          .count();

        var totalInvalidChars = inputArg.chars()
                                        .filter(character -> !Character.isLetterOrDigit(character))
                                        .count();

        return new CharSummaryStatistics(totalDigits, totalUppercaseChars, totalLowercaseChars, totalInvalidChars);
    }
}
