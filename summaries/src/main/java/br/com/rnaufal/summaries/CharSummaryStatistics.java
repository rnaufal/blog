package br.com.rnaufal.summaries;

/**
 * Created by Rafael Naufal on 09/26/2019.
 */
public class CharSummaryStatistics {

    private long totalDigits = 0;
    private long totalUppercaseChars = 0;
    private long totalLowercaseChars = 0;
    private long totalInvalidChars = 0;

    public CharSummaryStatistics() {
    }

    public CharSummaryStatistics(final long totalDigits,
                                 final long totalUppercaseChars,
                                 final long totalLowercaseChars,
                                 final long totalInvalidChars) {
        this.totalDigits = totalDigits;
        this.totalUppercaseChars = totalUppercaseChars;
        this.totalLowercaseChars = totalLowercaseChars;
        this.totalInvalidChars = totalInvalidChars;
    }

    public long getTotalDigits() {
        return totalDigits;
    }

    public long getTotalUppercaseChars() {
        return totalUppercaseChars;
    }

    public long getTotalLowercaseChars() {
        return totalLowercaseChars;
    }

    public long getTotalInvalidChars() {
        return totalInvalidChars;
    }

    public void accept(final int currentChar) {
        if (Character.isDigit(currentChar)) {
            totalDigits += 1;
        } else if (Character.isUpperCase(currentChar)) {
            totalUppercaseChars += 1;
        } else if (Character.isLowerCase(currentChar)) {
            totalLowercaseChars += 1;
        } else {
            totalInvalidChars += 1;
        }
    }

    public void combine(final CharSummaryStatistics other) {
        this.totalDigits += other.totalDigits;
        this.totalUppercaseChars += other.totalUppercaseChars;
        this.totalLowercaseChars += other.totalLowercaseChars;
    }
}
