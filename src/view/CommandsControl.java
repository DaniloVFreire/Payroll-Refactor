package view;

import view.commands.Command;
import data.DataManager;
public class CommandsControl {
    Command slot;
    public void setCommand(Command _command){
        slot = _command;
    }
    public DataManager run(DataManager data) {
        return slot.execute(data);
    }

}
