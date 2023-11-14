package Control2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Toy toy1 = new Toy(1, "конструктор", 2);
        Toy toy2 = new Toy(2, "робот", 2);
        Toy toy3 = new Toy(3, "кукла", 6);

        PriorityQueue<Toy> toysQueue = new PriorityQueue<>((t1, t2) -> t2.getFrequency() - t1.getFrequency());
        toysQueue.add(toy1);
        toysQueue.add(toy2);
        toysQueue.add(toy3);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int randomNumber = (int) (Math.random() * 100) + 1;
            Toy selectedToy = null;
            if (randomNumber <= 20) {
                selectedToy = toy1;
            } else if (randomNumber <= 40) {
                selectedToy = toy2;
            } else {
                selectedToy = toy3;
            }

            result.append(selectedToy.getId()).append(" ");
        }

        try {
            FileWriter writer = new FileWriter("result.json");
            writer.write(result.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}