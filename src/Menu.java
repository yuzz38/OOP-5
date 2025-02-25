import domain.Athlete;
import domain.Coach;
import domain.Participant;
import domain.Team;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;

public class Menu {

    private static Team team = new Team();

    public static void windowMenu() {
        JFrame frame = new JFrame("Меню команды");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        panel.setBorder(new EmptyBorder(20, 30, 20, 30));
        panel.setBackground(new Color(30,30,30));

        // Меню кнопок
        JButton btnData = new JButton("Работа с данными");
        btnData.setBackground(Color.white);
        btnData.setBorderPainted(false);
        btnData.setForeground(new Color(30,30,30));
        btnData.setFont(new Font("DialogInput", Font.PLAIN, 16));
        btnData.setBorder(new EmptyBorder(10, 20, 10, 20));

        JButton btnTeamActions = new JButton("Действия команды");
        btnTeamActions.setBackground(Color.white);
        btnTeamActions.setBorderPainted(false);
        btnTeamActions.setForeground(new Color(30,30,30));
        btnData.setBorder(new EmptyBorder(10, 20, 10, 20));
        btnTeamActions.setFont(new Font("DialogInput", Font.PLAIN, 16));

        JButton btnShowParticipants = new JButton("Показать всех участников");
        btnShowParticipants.setBackground(Color.white);
        btnShowParticipants.setBorderPainted(false);
        btnShowParticipants.setForeground(new Color(30,30,30));
        btnShowParticipants.setFont(new Font("DialogInput", Font.PLAIN, 16));



        JButton btnSave = new JButton("Сохранить команду в файл");
        btnSave.setBackground(Color.white);
        btnSave.setBorderPainted(false);
        btnSave.setForeground(new Color(30,30,30));
        btnSave.setFont(new Font("DialogInput", Font.PLAIN, 16));

        JButton btnLoad = new JButton("Загрузить команду из файла");
        btnLoad.setBackground(Color.white);
        btnLoad.setBorderPainted(false);
        btnLoad.setForeground(new Color(30,30,30));
        btnLoad.setFont(new Font("DialogInput", Font.PLAIN, 16));

        JButton btnExit = new JButton("Выход");
        btnExit.setBackground(Color.white);
        btnExit.setBorderPainted(false);
        btnExit.setForeground(new Color(30,30,30));
        btnExit.setFont(new Font("DialogInput", Font.PLAIN, 16));

        JButton btnChangeColor = new JButton("Смена темы");
        btnChangeColor.setBackground(Color.white);
        btnChangeColor.setBorderPainted(false);
        btnChangeColor.setForeground(new Color(30,30,30));
        btnChangeColor.setFont(new Font("DialogInput", Font.PLAIN, 16));

        panel.add(btnData);
        panel.add(btnTeamActions);
        panel.add(btnShowParticipants);
        panel.add(btnSave);
        panel.add(btnLoad);
        panel.add(btnExit);
        panel.add(btnChangeColor);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setResizable(false);

        // Действия кнопок
        btnShowParticipants.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showParticipantsInTable();
            }
        });
        btnData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDataMenu();
            }
        });
        btnTeamActions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performActionForAll();
            }
        });


        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTeamToFile();
            }
        });
        btnLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadTeamFromFile();
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnChangeColor.addActionListener(new ActionListener() {
            private boolean isColorChanged = false;
            @Override

            public void actionPerformed(ActionEvent e) {
                if (!isColorChanged) {
                    // Меняем цвет
                    panel.setBackground(Color.white);
                    btnData.setBackground(new Color(30,30,30));
                    btnData.setForeground(Color.white);

                    btnTeamActions.setBackground(new Color(30,30,30));
                    btnTeamActions.setForeground(Color.white);

                    btnShowParticipants.setBackground(new Color(30,30,30));
                    btnShowParticipants.setForeground(Color.white);



                    btnSave.setBackground(new Color(30,30,30));
                    btnSave.setForeground(Color.white);

                    btnLoad.setBackground(new Color(30,30,30));
                    btnLoad.setForeground(Color.white);

                    btnExit.setBackground(new Color(30,30,30));
                    btnExit.setForeground(Color.white);

                    btnChangeColor.setBackground(new Color(30,30,30));
                    btnChangeColor.setForeground(Color.white);

                    isColorChanged = true;
                } else {
                    // Возвращаем исходный цвет
                    panel.setBackground(new Color(30,30,30));
                    btnData.setBackground(Color.white);
                    btnData.setForeground(new Color(30,30,30));

                    btnTeamActions.setBackground(Color.white);
                    btnTeamActions.setForeground(new Color(30,30,30));
                    btnShowParticipants.setBackground(Color.white);
                    btnShowParticipants.setForeground(new Color(30,30,30));
                    btnSave.setBackground(Color.white);
                    btnSave.setForeground(new Color(30,30,30));

                    btnLoad.setBackground(Color.white);
                    btnLoad.setForeground(new Color(30,30,30));

                    btnExit.setBackground(Color.white);
                    btnExit.setForeground(new Color(30,30,30));

                    btnChangeColor.setBackground(Color.white);
                    btnChangeColor.setForeground(new Color(30,30,30));

                    isColorChanged = false;
                }
            }
        });
    }
    private static void showParticipantsInTable() {
        JFrame participantsFrame = new JFrame("Список участников");
        participantsFrame.setSize(600, 400);
        participantsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        participantsFrame.setLocationRelativeTo(null);

        List<Participant> participants = team.getAllParticipants();

        String[] columnNames = {"Имя", "Возраст", "Тип"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (Participant p : participants) {
            String type = (p instanceof Athlete) ? "Атлет" : "Тренер";
            tableModel.addRow(new Object[]{p.getName(), p.getAge(), type});
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        participantsFrame.add(scrollPane, BorderLayout.CENTER);

        // Панель для поиска
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("Поиск");
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        participantsFrame.add(searchPanel, BorderLayout.NORTH);

        JButton btnDeleteParticipant = new JButton("Удалить участника");
        participantsFrame.add(btnDeleteParticipant, BorderLayout.SOUTH);

        // Действие кнопки поиска
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText().toLowerCase().trim();

                if (searchTerm.isEmpty()) {
                    JOptionPane.showMessageDialog(participantsFrame, "Введите имя для поиска.");
                    return;
                }

                // Обновляем таблицу с участниками, удовлетворяющими поисковому запросу
                tableModel.setRowCount(0); // Очистка текущей таблицы
                for (Participant p : participants) {
                    if (p.getName().toLowerCase().contains(searchTerm)) {
                        String type = (p instanceof Athlete) ? "Атлет" : "Тренер";
                        tableModel.addRow(new Object[]{p.getName(), p.getAge(), type});
                    }
                }

                if (tableModel.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(participantsFrame, "Участники с таким именем не найдены.");
                }
            }
        });

        btnDeleteParticipant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String nameToDelete = (String) table.getValueAt(selectedRow, 0);  // Имя выбранного участника
                    if (team.removeParticipant(nameToDelete)) {
                        JOptionPane.showMessageDialog(participantsFrame, "Участник " + nameToDelete + " удален.");
                        tableModel.removeRow(selectedRow);  // Удаление строки из таблицы
                    } else {
                        JOptionPane.showMessageDialog(participantsFrame, "Ошибка при удалении участника.");
                    }
                } else {
                    JOptionPane.showMessageDialog(participantsFrame, "Выберите участника для удаления.");
                }
            }
        });

        participantsFrame.setVisible(true);
    }


    private static void showDataMenu() {
        JFrame dataFrame = new JFrame("Работа с данными");
        dataFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dataFrame.setSize(400, 300);

        dataFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        dataFrame.setBackground(new Color(30,30,30));
        dataFrame.setLocationRelativeTo(null);
        dataFrame.getContentPane().setBackground(new Color(30, 30, 30));
        // Кнопки для работы с данными
        JButton btnAddAthlete = new JButton("Добавить спортсмена");
        btnAddAthlete.setBorderPainted(false);
        btnAddAthlete.setBackground(Color.white);
        btnAddAthlete.setForeground(new Color(30,30,30));
        btnAddAthlete.setFont(new Font("DialogInput", Font.PLAIN, 16));
        btnAddAthlete.setBorder(new EmptyBorder(10, 20, 10, 20));

        JButton btnAddCoach = new JButton("Добавить тренера");
        btnAddCoach.setBorderPainted(false);
        btnAddCoach.setBackground(Color.white);
        btnAddCoach.setForeground(new Color(30,30,30));
        btnAddCoach.setFont(new Font("DialogInput", Font.PLAIN, 16));
        btnAddCoach.setBorder(new EmptyBorder(10, 20, 10, 20));




        dataFrame.add(btnAddAthlete);
        dataFrame.add(btnAddCoach);

        dataFrame.setVisible(true);

        // Действия кнопок
        btnAddAthlete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAthlete();
            }
        });
        btnAddCoach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCoach();
            }
        });



    }


    private static void performActionForAll() {

        if (team.displayParticipants() != "") {
            JOptionPane.showMessageDialog(null, team.performActionForAll());
        } else {
            JOptionPane.showMessageDialog(null, "Некому тренироваться");
        }
    }
    private static void addAthlete() {
        String name = JOptionPane.showInputDialog("Введите имя спортсмена:");

        if (name == null) {
            JOptionPane.showMessageDialog(null ,"Повторите попытку");
            return;
        } else if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null ,"Заполните поле!");
            return;
        }
        String ageInput = JOptionPane.showInputDialog("Введите возраст спортсмена:");
        int age;
        try {
            age = Integer.parseInt(ageInput);
            if (age <= 0) {
                JOptionPane.showMessageDialog(null, "Возраст должен быть положительным числом!");
                return;
            }
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "Возраст должен быть числом!");
            return;
        }
        team.addParticipant(new Athlete(name, age));
        JOptionPane.showMessageDialog(null, "Спортсмен добавлен!");
    }

    private static void addCoach() {
        if (team.hasTrainer()) {
            JOptionPane.showMessageDialog(null, "Тренер уже есть в команде!");
            return;
        }

        String name = JOptionPane.showInputDialog("Введите имя тренера:");

        if (name == null) {
            JOptionPane.showMessageDialog(null ,"Повторите попытку");
            return;
        } else if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null ,"Заполните поле!");
            return;
        }

        String ageInput = JOptionPane.showInputDialog("Введите возраст тренера:");
        int age;
        try {
            age = Integer.parseInt(ageInput);
            if (age <= 0) {
                JOptionPane.showMessageDialog(null, "Возраст должен быть положительным числом!");
                return;
            }
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "Возраст должен быть числом!");
            return;
        }

        String experienceInput = JOptionPane.showInputDialog("Введите стаж работы тренера (в годах):");
        int experience = -1;
        try {
            experience = Integer.parseInt(experienceInput);
            if (experience <= 0) {
                JOptionPane.showMessageDialog(null, "Стаж должен быть положительным числом!");
                return;
            }
        } catch (NumberFormatException e) {
            // Если возникло исключение (например, введена не цифра), показываем сообщение об ошибке
            JOptionPane.showMessageDialog(null, "Стаж должен быть числом!");
            return;
        }


        team.addParticipant(new Coach(name, age, experience));
        JOptionPane.showMessageDialog(null, "Тренер добавлен!");
    }





    private static void saveTeamToFile() {
        // Запрашиваем у пользователя имя файла
        String fileName = JOptionPane.showInputDialog("Введите имя файла для сохранения (без расширения):");

        if (fileName == null || fileName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Имя файла не может быть пустым.");
            return;
        }

        // Добавляем расширение .ser
        fileName = fileName + ".ser";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(team);
            JOptionPane.showMessageDialog(null, "Команда успешно сохранена в файл: " + fileName);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ошибка при сохранении: " + e.getMessage());
        }
    }

    private static void loadTeamFromFile() {
        // Запрашиваем у пользователя имя файла
        String fileName = JOptionPane.showInputDialog("Введите имя файла для загрузки (без расширения):");

        if (fileName == null || fileName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Имя файла не может быть пустым.");
            return;
        }

        // Добавляем расширение .ser
        fileName = fileName + ".ser";

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            team = (Team) in.readObject();
            JOptionPane.showMessageDialog(null, "Команда успешно загружена из файла: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ошибка при загрузке: " + e.getMessage());
        }
    }

}
