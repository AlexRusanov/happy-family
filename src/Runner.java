import com.sun.xml.internal.ws.util.StringUtils;
import controller.FamilyController;
import dao.CollectionFamilyDao;
import model.human.Human;
import model.human.Woman;
import service.FamilyService;

import java.util.Scanner;

public class Runner {
    public static void run() {
        FamilyController familyController = new FamilyController(new FamilyService(new CollectionFamilyDao()));
        Scanner scanner = new Scanner(System.in);
        String userInput;

        while (true) {
            System.out.print("\n");
            System.out.println("Доступные команды:\n" +
                    "1. Заполнить тестовыми данными (автоматом создать несколько семей и сохранить их в базе)\n" +
                    "2. Отобразить весь список семей (отображает список всех семей с индексацией, начинающейся с 1)\n" +
                    "3. Отобразить список семей, где количество людей больше заданного\n" +
                    "4. Отобразить список семей, где количество людей меньше заданного\n" +
                    "5. Подсчитать количество семей, где количество членов равно\n" +
                    "6. Создать новую семью\n" +
                    "7. Удалить семью по индексу семьи в общем списке\n" +
                    "8. Редактировать семью по индексу семьи в общем списке\n" +
                    "\t1. Родить ребенка\n" +
                    "\t2. Усыновить ребенка\n" +
                    "\t3. Вернуться в главное меню\n" +
                    "9. Удалить всех детей старше возраста (во всех семьях удаляются дети старше указанного возраста - будем считать, что они выросли)\n" +
                    "10. Сохранить список семей в файл\n" +
                    "11. Загрузить список семей из файла\n"
            );
            System.out.print("\n");
            System.out.print("Введите номер команды или exit для выхода из приложения\n");

            try {
                userInput = scanner.nextLine().trim().toLowerCase();

                if (userInput.equals("exit")) {
                    System.out.println("Спасибо что пользовались нашим приложением! До новых встреч");
                    break;
                }

                switch (userInput) {
                    case ("1"):
                        familyController.initTestRepo();
                        break;
                    case ("2"):
                        familyController.displayAllFamilies();
                        break;
                    case ("3"):
                        System.out.print("Введите интересующее число\n");
                        userInput = scanner.nextLine().trim();
                        System.out.println(familyController.getFamiliesBiggerThan(Integer.parseInt(userInput)));
                        break;
                    case ("4"):
                        System.out.print("Введите интересующее число\n");
                        userInput = scanner.nextLine().trim();
                        System.out.println(familyController.getFamiliesLessThan(Integer.parseInt(userInput)));
                        break;
                    case ("5"):
                        System.out.print("Введите интересующее число\n");
                        userInput = scanner.nextLine().trim();
                        System.out.println(familyController.countFamiliesWithMemberNumber(Integer.parseInt(userInput)));
                        break;
                    case ("6"):
                        System.out.print("Введите имя матери\n");
                        String motherName = StringUtils.capitalize(scanner.nextLine().trim().toLowerCase());
                        System.out.print("Введите фамилию матери\n");
                        String motherSurName = StringUtils.capitalize(scanner.nextLine().trim().toLowerCase());
                        System.out.print("Введите год рождения матери (например, 1985)\n");
                        String motherYear = scanner.nextLine().trim();
                        System.out.print("Введите месяц рождения матери (например, 7)\n");
                        String motherMonth = scanner.nextLine().trim();
                        System.out.print("Введите день рождения матери (например, 21)\n");
                        String motherDay = scanner.nextLine().trim();
                        System.out.print("Введите IQ матери (от 0 до 100)\n");
                        String motherIq = scanner.nextLine().trim();

                        System.out.print("Введите имя отца\n");
                        String fatherName = StringUtils.capitalize(scanner.nextLine().trim().toLowerCase());
                        System.out.print("Введите фамилию отца\n");
                        String fatherSurName = StringUtils.capitalize(scanner.nextLine().trim().toLowerCase());
                        System.out.print("Введите год рождения отца (например, 1985)\n");
                        String fatherYear = scanner.nextLine().trim();
                        System.out.print("Введите месяц рождения отца (например, 7)\n");
                        String fatherMonth = scanner.nextLine().trim();
                        System.out.print("Введите день рождения отца (например, 21)\n");
                        String fatherDay = scanner.nextLine().trim();
                        System.out.print("Введите IQ отца (от 0 до 100)\n");
                        String fatherIq = scanner.nextLine().trim();
                        Human mother = new Woman(motherName, motherSurName, motherDay + "/" + motherMonth + "/" + motherYear, (byte)Integer.parseInt(motherIq));
                        Human father = new Woman(fatherName, fatherSurName, fatherDay + "/" + fatherMonth + "/" + fatherYear, (byte)Integer.parseInt(fatherIq));
                        familyController.createNewFamily(mother, father);
                        break;
                    case ("7"):
                        System.out.print("Введите номер семьи\n");
                        userInput = scanner.nextLine().trim();
                        familyController.deleteFamilyByIndex(Integer.parseInt(userInput) - 1);
                        break;
                    case ("8"):
                        System.out.print("\n");
                        System.out.println("Доступные команды:\n" +
                                "1. Родить ребенка\n" +
                                "2. Усыновить ребенка\n" +
                                "3. Вернуться в главное меню\n"
                        );
                        userInput = scanner.nextLine().trim();
                        int familyId;
                        switch (userInput) {
                            case ("1"):
                                System.out.print("Введите номер семьи\n");
                                familyId = Integer.parseInt(scanner.nextLine().trim()) - 1;
                                System.out.print("Введите имя мальчика\n");
                                String boysName = StringUtils.capitalize(scanner.nextLine().trim().toLowerCase());
                                System.out.print("Введите имя девочки\n");
                                String girlsName = StringUtils.capitalize(scanner.nextLine().trim().toLowerCase());
                                familyController.bornChild(familyController.getFamilyById(familyId), boysName, girlsName);
                                break;
                            case ("2"):
                                System.out.print("Введите номер семьи\n");
                                familyId = Integer.parseInt(scanner.nextLine().trim()) - 1;
                                System.out.print("Введите имя ребенка\n");
                                String childName = StringUtils.capitalize(scanner.nextLine().trim().toLowerCase());
                                System.out.print("Введите фамилию ребенка\n");
                                String childSurName = StringUtils.capitalize(scanner.nextLine().trim().toLowerCase());
                                System.out.print("Введите год рождения ребенка\n");
                                String childsYear = scanner.nextLine().trim();
                                System.out.print("Введите IQ ребенка\n");
                                String childsIq = scanner.nextLine().trim();
                                familyController.adoptChild(familyController.getFamilyById(familyId), new Human(childName, childSurName, "01/01/" + childsYear, (byte)Integer.parseInt(childsIq)));
                                break;
                            case ("3"):
                                break;
                            default:
                                System.out.println("Вы ввели не валидные данные");
                                break;
                        }
                        break;
                    case ("9"):
                        System.out.print("Введите возраст\n");
                        userInput = scanner.nextLine().trim();
                        familyController.deleteAllChildrenOlderThen(Integer.parseInt(userInput));
                        break;
                    case ("10"):
                        familyController.writeDataToFile();
                        break;
                    case ("11"):
                        familyController.loadData();
                        break;
                    default:
                        System.out.println("Вы ввели не валидные данные");
                        break;
                }
            } catch (RuntimeException ex) {
                System.out.println("Вы ввели некорректные данные, что привело к возникновению ошибки - " + ex.getCause() + ex.getMessage() + "\n" + "приложение будет перезапущено");
            }
        }
    }
}
