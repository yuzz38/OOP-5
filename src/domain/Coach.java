package domain;

public class Coach extends Participant {

    private int experienceYears;

    public Coach(String name, int age, int experienceYears) {
        super(name, age);
        this.experienceYears = experienceYears;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String action() {
        return getName() + " тренирует команду.";

    }

    @Override
    public String toString() {
        return "Тренер: " + getName() + ", возраст: " + getAge() + " и его стаж: " + getExperienceYears();
    }
}