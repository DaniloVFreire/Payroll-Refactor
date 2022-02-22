package view.commands;

import data.DataManager;
import java.util.Stack;

public abstract class UndoRedo implements Command {
    Stack<String> undo;
    Stack<String> redo;
    public UndoRedo(Stack<String> _undo, Stack<String> _redo){
        this.undo = _undo;
        this.redo = _redo;
    }
    public abstract DataManager execute(DataManager data);
}
