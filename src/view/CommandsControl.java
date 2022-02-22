package view;

import view.commands.Command;

public class CommandsControl {
    Command slot;
    public void setCommand(Command _command){
        slot = _command;
    }
    public void run() {
        slot.execute();
    }

}
