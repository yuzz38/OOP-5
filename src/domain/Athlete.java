package domain;

public class Athlete extends Participant {

    public Athlete(String name, int age) {
        super(name, age);
    }

    @Override
    public String action() {
        return getName() + " выполняет упражнение.";

    }

    @Override
    public String toString() {
        return "Спортсмен: " + getName() + ", возраст: " + getAge();
    }
}