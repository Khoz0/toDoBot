# ToDoBot for Discord

This a discord bot made to be used as a todo list that can be shared with friends or group members of a project.

I've watched this video https://www.youtube.com/watch?v=KQWFLkv1Wa0 to help me to begin the code.

The prefix to execute a command is `!`.

## First step

The first step was to connect and test the bot. The first command for th etest was a `!ping` command to see if the bot respond.
The bot respond `Pong !` to this command, and it prooved that the bot was online and working well.

## Second step

The second step was to add todo tasks with the command `!todo`.
This command has two aliasses that are `!todo` and `!t`.
The process is to add the following arguments of the command in a text file and save it locally. 
A later step will be to add an end date and to notify the users as it approchs. There's another step that will be to host the bot on a 24h server to have it always online and not only when the progam is launched, and save the tasks on a database and not locally in a text file.

## Third step

The third step was to browse the reminding tasks with the command `!reminder`.
This command has two aliasses that are `!reminder` and `!r`.
The process is to browse the local text file to see all the tasks left.
The later steps are to see it throught a database and to see the time remaining before the task get old.
