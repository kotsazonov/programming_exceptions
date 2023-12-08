import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDataApplication {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные (Фамилия Имя Отчество ДатаРождения НомерТелефона Пол), разделенные пробелом:");

            String userInput = scanner.nextLine();
            String[] userData = userInput.split("\\s+");

            // Проверка количества введенных данных
            if (userData.length != 6) {
                System.out.println("Ошибка: неверное количество данных. Должно быть 6 значений.");
                return;
            }

            try {
                // Распарсивание данных
                String lastName = userData[0];
                String firstName = userData[1];
                String middleName = userData[2];
                String birthDate = userData[3];
                long phoneNumber = Long.parseLong(userData[4]);
                char gender = userData[5].charAt(0);

                // Проверка формата данных
                // Здесь вы можете добавить дополнительные проверки формата данных, если необходимо.

                // Создание файла и запись данных
                String fileName = lastName + ".txt";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                    writer.write(lastName + firstName + middleName + birthDate + " " + phoneNumber + gender + "\n");
                    System.out.println("Данные успешно записаны в файл: " + fileName);
                } catch (IOException e) {
                    System.out.println("Ошибка при записи в файл:");
                    e.printStackTrace();
                }

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) {
                System.out.println("Ошибка: неверный формат данных.");
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println("Ошибка при вводе данных:");
            e.printStackTrace();
        }
    }
}