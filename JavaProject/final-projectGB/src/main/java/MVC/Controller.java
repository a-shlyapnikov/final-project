package MVC;

import Animals.*;

import java.util.List;
import java.util.Scanner;

public class Controller {
    private View ui;
    private static Scanner scanner = new Scanner(System.in);

    public Controller() {
        this.ui = new View();
    }

    public void start() {
        try (PetRegistry petRegistry = new PetRegistry()) {
            while (true) {
                ui.showMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        ui.enterAnimalType();
                        String type = scanner.nextLine();
                        ui.enterName();
                        String name = scanner.nextLine();
                        Animal animal;
                        switch (type) {
                            case "Dog":
                                animal = new Dog(name);
                                break;
                            case "Cat":
                                animal = new Cat(name);
                                break;
                            case "Hamster":
                                animal = new Hamster(name);
                                break;
                            case "Horse":
                                animal = new Horse(name);
                                break;
                            case "Camel":
                                animal = new Camel(name);
                                break;
                            case "Donkey":
                                animal = new Donkey(name);
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + type);
                        }
                        petRegistry.addAnimal(animal);
                        break;
                    case 2:
                        ui.enterName();
                        String animalName = scanner.nextLine();
                        Animal foundAnimal = petRegistry.getAnimals().stream()
                                .filter(a -> a.getName().equals(animalName))
                                .findFirst()
                                .orElse(null);
                        if (foundAnimal == null) {
                            System.out.println("No such animal");
                            break;
                        }
                        System.out.println("Enter command: ");
                        String command = scanner.nextLine();
                        petRegistry.teachCommand(foundAnimal, command);
                        break;
                    case 3:
                        ui.enterName();
                        String aName = scanner.nextLine();
                        Animal fAnimal = petRegistry.getAnimals().stream()
                                .filter(a -> a.getName().equals(aName))
                                .findFirst()
                                .orElse(null);
                        if (fAnimal == null) {
                            System.out.println("No such animal");
                            break;
                        }
                        List<String> commands = petRegistry.getCommands(fAnimal);
                        for (String cmd : commands) {
                            System.out.println(cmd);
                        }
                        break;
                    case 4:
                        return;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
