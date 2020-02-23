package br.com.rnaufal.summaries;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Rafael Naufal on 09/27/2019.
 */
public class CustomCollectorCharSummarizer implements CharSummarizer {

    @Override
    public CharSummaryStatistics summarize(final String arg) {
        return StringUtils.defaultString(arg)
                .chars()
                .collect(CharSummaryStatistics::new,
                        CharSummaryStatistics::accept,
                        CharSummaryStatistics::combine);
    }
}
