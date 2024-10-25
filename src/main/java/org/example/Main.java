package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\reeze\\IdeaProjects\\jsonTest\\src\\main\\resources\\file.json");
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(file, Person.class);
        System.out.println("Что-то работает");
        System.out.println(person);
        globalCheck(person);


    }

    public static boolean checkForAge(Person person) {
        Date birthday = person.getBirthDate();
        LocalDateTime birthDate = birthday.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        LocalDateTime currentDate = LocalDateTime.now();
        if (birthDate.plusYears(20).isBefore(currentDate)) {
            System.out.println("Ура, проверка на возраст пройдена");
            return true;
        } else {
            System.out.println("Клиент моложе 20 лет");
            return false;
        }
    }

    public static boolean checkForPassport(Person person) {
        Date birthday = person.getBirthDate();
        Date issuedAt = person.getPassport().getIssuedAt();
        LocalDateTime birthDate = birthday.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        LocalDateTime dateOfIssue = issuedAt.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        if ((birthDate.plusYears(20).isAfter(dateOfIssue)) || (birthDate.plusYears(45).isAfter(dateOfIssue))){
            System.out.println("Проверка действительности паспорта не пройдена");
            return false;
        } else {
            System.out.println("Проверка действительности паспорта пройдена");
            return true;
        }
    }

    public static boolean checkCreditHistory(Person person) {
        List<creditHistory> histories = person.getCreditHistory();
        String creditType = "Кредитная карта";
        int overdueCount = 0;
        for (creditHistory history : histories) {
            if (!history.getType().equals(creditType)) {                // если тип кредита - не кредитная карта
                System.out.println("Это не кредитная карта");
                boolean firstCheckNotCard = checkForRepaid(history);           // проверка на непогашенную задолженность
                boolean secondCheckNotCard = checkForOverdue(history);         // проверка на количество просроченных дней
                if (firstCheckNotCard && secondCheckNotCard) {                 //первые две проверки пройдены
                     if (history.getNumberOfDaysOnOverdue() > 15 && overdueCount < 3) {      //проверка на наличие >2 просроченных задолженнностей
                         overdueCount++;
                         if (overdueCount > 2) {
                             System.out.println("Есть больше двух кредитов с просроченной задолженностью\n" +
                                     " протяженностью более 15 дней");
                             return false;
                         }
                     }
                } else {
                    return false;
                }
            }
            else {
                System.out.println("Это кредитная карта");
                boolean firstCheckCard = checkForRepaid(history);
                boolean secondCheckCard = checkForOverdue(history);
                if (!(firstCheckCard && secondCheckCard)){
                    System.out.println("Проверка кредитной истории не пройдена");
                    return false;
                }
            }
        }
        System.out.println("Проверка кредитной истории пройдена");
        return true;
    }

    public static boolean checkForRepaid(creditHistory history) {
        Date repaidAt = history.getRepaidAt();
        if (repaidAt == null) {
            System.out.println("Имеется непогашенная задолженность");
            return false;
        } else {
            System.out.println("Нет непогашенных задолженностей");
            return true;
        }
    }

    public static boolean checkForOverdue(creditHistory history){
        String creditType = "Кредитная карта";
        if (!history.getType().equals(creditType)) {                // если тип кредита - не кредитная карта
            if (history.getNumberOfDaysOnOverdue() > 60) {
                System.out.println("Возникала просроченная задолженность протяженностью более 60 дней");
                return false;
            } else {
                System.out.println("Не возникало просроченной задолженности протяженностью более 60 дней");
                return true;
            }
    }   else if (history.getNumberOfDaysOnOverdue() > 30) {        // проверка для кредитной карты
            System.out.println("Возникала просроченная задолженность протяженностью более 30 дней");
            return false;
        } else {
            System.out.println("Не возникало просроченной задолженности протяженностью более 30 дней");
            return true;
        }
    }

    public static boolean globalCheck (Person person) {
        if (checkForAge(person) && checkForPassport(person) && checkCreditHistory(person)) {
            System.out.println("Все проверки пройдены успешно");
            return true;
        }
            else {
                System.out.println("Проверки не пройдены");
                return false;
            }
        }

}