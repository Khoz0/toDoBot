package org.bot.discord.command;

import org.javacord.api.event.message.MessageCreateEvent;

import java.io.*;

/**
 * @author Roberge-Mentec Corentin
 */


public class CommandReminder implements CommandExecutor {

    private File fileTodo;

    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        try {
            createFile();
            String printTasks = browseFile();
            event.getChannel().sendMessage("```"+printTasks+"```");
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
