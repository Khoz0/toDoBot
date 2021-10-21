package org.bot.discord.command;

import org.javacord.api.event.message.MessageCreateEvent;

import java.io.*;
import java.util.Arrays;

/**
 * @author Roberge-Mentec Corentin
 */


public class CommandTodo implements CommandExecutor {

    private File fileTodo;
    private int id = 0;

    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        try {
            createFile();
            idRecuperation();
            writeToDoTask(args);
            event.getChannel().sendMessage("Task added !");
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    private void createFile() throws IOException {
        fileTodo = new File("todo.txt");
        if (fileTodo.createNewFile()) {
            System.out.println("File created");
        } else {
            System.out.println("File already exists");
        }
    }

    private void idRecuperation() throws IOException {
        FileReader fr = new FileReader(fileTodo);

        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null)
        {
            String[] words = line.split(" ");
            String idString = words[0];
            id = Integer.parseInt(idString);
        }
        fr.close();
    }

    private void writeToDoTask(String... args) throws IOException {
        id++;
        String idString = String.valueOf(id);

        FileWriter myWriter = new FileWriter(fileTodo, true);

        myWriter.write(idString);
        myWriter.write(" ");
        for (String s : args) {
            myWriter.write(s);
            myWriter.write(" ");
        }
        myWriter.write("\n");
        myWriter.close();
    }
}
