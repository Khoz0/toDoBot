package org.bot.discord.command;

import org.javacord.api.event.message.MessageCreateEvent;

import java.io.*;

/**
 * @author Roberge-Mentec Corentin
 */


public class CommandRemove implements CommandExecutor {

    private File fileTodo;
    private StringBuilder stringBuilder;

    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        if (args.length > 1){
            event.getChannel().sendMessage("To much arguments for this command ! You just need to indicate the id");
        }else {
            try {
                createFile();
                deleteTask(args[0]);
                rewriteTasks(String.valueOf(stringBuilder));
                reOrderIds();
                rewriteTasks(String.valueOf(stringBuilder));
                event.getChannel().sendMessage("Task removed !");
            } catch (Exception e) {
                System.err.println(e);
            }
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

    private void deleteTask(String idToRemove) throws IOException {

        FileReader fr = new FileReader(fileTodo);
        FileWriter myWriter = new FileWriter(fileTodo, true);

        stringBuilder = new StringBuilder();

        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            String[] words = line.split(" ");
            if (!words[0].equals(idToRemove)){
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
        }

        fr.close();
        myWriter.close();
    }

    private void rewriteTasks(String newToDoFile) throws IOException {
        FileWriter myWriter = new FileWriter(fileTodo);
        myWriter.write(newToDoFile);
        myWriter.close();
    }

    private void reOrderIds() throws IOException {
        int id = 1;

        FileWriter myWriter = new FileWriter(fileTodo);

        StringBuilder stringBuilderNewLines = new StringBuilder();

        String[] lines = stringBuilder.toString().split("\n");
        for (String s : lines){
            String[] words = s.split(" ");
            stringBuilderNewLines.append(s.replace(words[0], String.valueOf(id)));
            stringBuilderNewLines.append("\n");
            id++;
        }

        stringBuilder = stringBuilderNewLines;

        myWriter.close();
    }
}
