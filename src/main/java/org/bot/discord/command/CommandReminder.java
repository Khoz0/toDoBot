package org.bot.discord.command;

import org.javacord.api.event.message.MessageCreateEvent;

import java.io.*;

/**
 * @author Roberge-Mentec Corentin
 */


public class CommandReminder implements CommandExecutor {

    private File fileTodo;

    /**
     * @param event   the message listened by the bot
     * @param command the command adapted to the message
     * @param args    the information to complete the command
     */
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        try {
            createFile();
            String printTasks = browseFile();
            event.getChannel().sendMessage("Tasks to do:\n```"+printTasks+"```");
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
     * The method to browse the to-do tasks in the to-do file
     * @return the concatenated list of the to-do tasks
     * @throws IOException the exception thrown by the reading of the file
     */
    private String browseFile() throws IOException {
        FileReader fr = new FileReader(fileTodo);

        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }
        fr.close();
        return stringBuilder.toString();
    }
}
