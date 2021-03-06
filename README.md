# ToDoBot for Discord

This a discord bot made to be used as a todo list that can be shared with friends or group members of a project.

I've watched this video https://www.youtube.com/watch?v=KQWFLkv1Wa0 to help me to begin the code.

The prefix to execute a command is `!`.

## First step

The first step was to connect and test the bot. The first command for the test was a `!ping` command to see if the bot respond.

The bot respond `Pong !` to this command, and it proved that the bot was online and working well.

## Second step

The second step was to add todo tasks with the command `!todo`.

This command has two aliases that are `!todo` and `!t`.

The process is to add the following arguments of the command in a text file and save it locally. 

A later step will be to add an end date and to notify the users as it approaches. There's another step that will be to host the bot on a 24h server to have it always online and not only when the program is launched, and save the tasks on a database and not locally in a text file.

## Third step

The third step was to browse the reminding tasks with the command `!reminder`.

This command has two aliases that are `!reminder` and `!re`.

The process is to browse the local text file to see all the tasks left.

The later steps are to see it through the database and to see the time remaining before the task get old.

## Fourth step

The fourth step was to have the possibility to remove a task from the text file by using the command `!remove`.

This command has two aliases that are `!remove` and `!rm`.

The process is to enter the id of the line to remove. The file is browsed and the line corresponding to the id is deleted. Then the different ids are reordered.

The later step is to remove the tasks through the database.

## Fifth step

The fifth step was to see the urgent tasks with the command `!urgent`.

This command has two aliases that are `!urgent`and `!u`.

The process is to browse the local text file and check if there is a date in the tasks. If there is, it will check if the date is in the three next days. If this is in the next three days, the users of the discord server will be notify by the `@everyone` tag and the message will contain the urgent tasks.

The later steps are to store the date in a database, linked with the task id. Then we can check if there is a task with a urgent date or not.

## Sixth step

The sixth step was to show all the command available with the command `!help`.

This command has two aliases that are `!help` and `!h`.

This command show the commands available, and explain if there are some specific use cases.
