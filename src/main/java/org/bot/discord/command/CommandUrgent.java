package org.bot.discord.command;

import org.javacord.api.event.message.MessageCreateEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Roberge-Mentec Corentin
 */


public class CommandUrgent implements CommandExecutor {

    private File fileTodo;

    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        try {
            createFile();
            String printTasks = browseFile();
            String urgentTasks = getUrgentTasks(printTasks);
            if (!urgentTasks.equals("")){
                event.getChannel().sendMessage("@everyone\n```"+urgentTasks+"```");
            }else{
                event.getChannel().sendMessage("No urgent tasks here !");
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    private String getUrgentTasks(String printTasks) {
        StringBuilder stringBuilder = new StringBuilder();

        Calendar calendar = Calendar.getInstance();
        Calendar calendarJPlus3 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        calendarJPlus3.add(Calendar.DATE, 3);

        String[] lines = printTasks.split("\n");
        for (String s: lines){
            String[] words = s.split(" ");
            if (words[words.length-1].equals(sdf.format(calendar.getTime())) || words[words.length-1].equals(sdf.format(calendarJPlus3.getTime()))){
                stringBuilder.append(s);
                stringBuilder.append("\n");
            }
        }

        return stringBuilder.toString();
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
