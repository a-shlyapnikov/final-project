package MVC;

import Animals.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PetRegistry implements AutoCloseable {
    private List<Animal> animals;
    private static Counter counter = new Counter();

    public PetRegistry() {
        this.animals = new ArrayList<>();
        this.counter = new Counter();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        counter.add();
    }

    public void teachCommand(Animal animal, String command) {
        animal.addCommand(command);
        try (FileWriter writer = new FileWriter("DataBase.csv", true)) {
            String animalType = getAnimalType(animal);
            String animalName = animal.getName();
            String line = animalType + "," + animalName + "," + command + "\n";
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getAnimalType(Animal animal) {
        if (animal instanceof Dog) {
            return "Dog";
        } else if (animal instanceof Cat) {
            return "Cat";
        } else if (animal instanceof Hamster) {
            return "Hamster";
        } else if (animal instanceof Horse) {
            return "Horse";
        } else if (animal instanceof Camel) {
            return "Camel";
        } else if (animal instanceof Donkey) {
            return "Donkey";
        }
        return null;
    }

    public List<String> getCommands(Animal animal) {
        return animal.getCommands();
    }
    public void readDatabase() {
        File databaseFile = new File("DataBase.csv");
        if (!databaseFile.exists()) {
            try {
                databaseFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Чтение данных из базы данных
        try (BufferedReader reader = new BufferedReader(new FileReader(databaseFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 2) {
                    String animalName = data[0];
                    String command = data[1];
                    Animal animal = animals.stream().filter(a -> a.getName().equals(animalName)).findFirst().orElse(null);
                    if (animal != null) {
                        animal.addCommand(command);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void close() throws Exception {
        if (counter.getCount() == 0) {
            throw new Exception("Counter was not used in try-with-resources block");
        } else {
            counter.resetCount();
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
