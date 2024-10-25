package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class creditHistory {
    private String type;
    private String currency;
    private Date issuedAt = new Date();
    private Double rate;
    private Long loanSum;
    private Integer term;
    private Date repaidAt = new Date();
    private Long currentOverdueDebt;
    private Integer numberOfDaysOnOverdue;
    private Long remainingDebt;
    private String creditId;

    @Override
    public String toString() {
        return "creditHistory{" +
                "type='" + type + '\'' +
                ", currency='" + currency + '\'' +
                ", issuedAt=" + issuedAt +
                ", rate=" + rate +
                ", loanSum=" + loanSum +
                ", term=" + term +
                ", repaidAt=" + repaidAt +
                ", currentOverdueDebt=" + currentOverdueDebt +
                ", numberOfDaysOnOverdue=" + numberOfDaysOnOverdue +
                ", remainingDebt=" + remainingDebt +
                ", creditId='" + creditId + '\'' +
                '}';
    }

}