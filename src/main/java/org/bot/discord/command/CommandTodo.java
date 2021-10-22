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

    /**
     * @param event   the message listened by the bot
     * @param command the command adapted to the message
     * @param args    the information to complete the command
     */
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

    /**
     * The method to verify if a to-do file already exists and to create it if not
     * @throws IOException the exception thrown by the file creation
     */
    private void createFile() throws IOException {
        fileTodo = new File("todo.txt");
        if (fileTodo.createNewFile()) {
            System.out.println("File created");
        } else {
            System.out.println("File already exists");
        }
    }

    /**
     * The method to recuperate the ids of the differents to-do tasks
     * @throws IOException the exception thrown by the reading of the file
     */
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

    /**
     * The method to write the to-do tasks added in the to-do file
     * @param args the instructions of the to-do tasks
     * @throws IOException the exception thrown by the writing of the file
     */
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
