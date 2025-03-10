package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public  class Team implements Serializable {
    private List<Participant> participants;

    public Team() {
        participants = new ArrayList<>();
    }
    public List<Participant> getAllParticipants() {
        return participants;
    }

    // Добавление участника в команду
    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    // Удаление участника по имени
    public boolean removeParticipant(String name) {
        for (Participant participant : participants) {
            if (participant.getName().equalsIgnoreCase(name)) {
                participants.remove(participant);
                return true;
            }
        }
        return false;
    }

    // Показать всех участников
    public String displayParticipants() {
        StringBuilder participantsInfo = new StringBuilder();
        for (Participant participant : participants) {
            participantsInfo.append(participant).append("\n");
        }

        return participantsInfo.toString();
    }
    // Показать всех атлетов
    public String displayAthlete() {
        StringBuilder athletesInfo = new StringBuilder();
        for (Participant participant : participants) {
            if (participant instanceof Athlete) {
                athletesInfo.append(participant).append("\n");
            }
        }
        return athletesInfo.toString();
    }
    // Выполнить действия для всех участников
    public String performActionForAll() {
        StringBuilder result = new StringBuilder();
        for (Participant participant : participants) {

            result.append(participant.action()).append("\n");
        }
        return result.toString();
    }

    // Найти участника по имени
    public Participant findParticipant(String name) {
        for (Participant participant : participants) {
            if (participant.getName().equalsIgnoreCase(name)) {
                return participant;
            }
        }
        return null;
    }

    // Проверка на наличие тренера
    public boolean hasTrainer() {
        for (Participant participant : participants) {
            if (participant instanceof Coach) {
                return true;
            }
        }
        return false;
    }
}