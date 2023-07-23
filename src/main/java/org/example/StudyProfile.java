package org.example;

public enum StudyProfile {
    JURISPRUDENCE ("Юриспруденция"),
    MANAGEMENT ("Делопроизводство"),
    FINANCIAL ("Финансы"),
    ADMINISTRATION ("Администрирование"),
    MEDICINE ("Медицина"),
    SURGERY("Хирургия"),
    THERAPY ("Терапия"),
    PSYCHOLOGY ("Психология"),
    CARDIOLOGY("Кардиология"),
    PHLEBOLOGY("Флебология"),
    GASTROENTEROLOGY("Гастроэнтерология"),
    PHYSICS("Физика"),
    LINGUISTICS("Лингвистика"),
    MATHEMATICS("Математика");

    private String profileName;

    StudyProfile (String profileName) {
        this.profileName = profileName;
    }
    public String getProfileName() {
        return this.profileName;
    }
}
