package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate = new Date();
    private String citizenship;
    passport passport = new passport();
    List<creditHistory> creditHistory = new ArrayList<>();


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", citizenship='" + citizenship + '\'' +
                ", passport=" + passport +
                ", creditHistory=" + creditHistory +
                '}';
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public class passport {
        private String series;
        private String number;
        private Date issuedAt;
        private String issuer;
        private String issuerСode;

        @Override
        public String toString() {
            return "passport{" +
                    "series='" + series + '\'' +
                    ", number='" + number + '\'' +
                    ", issuedAt=" + issuedAt +
                    ", issuer='" + issuer + '\'' +
                    ", issuerCode='" + issuerСode + '\'' +
                    '}';
        }
    }

}
