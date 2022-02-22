package view.commands;

import data.DataManager;
import java.util.Stack;
import java.util.Scanner;

public abstract class UndoRedo implements Command {
    DataManager data;
    Stack<String> undo;
    Stack<String> redo;
    public UndoRedo(DataManager _data, Stack<String> _undo, Stack<String> _redo){
        this.data = _data;
        this.undo = _undo;
        this.redo = _redo;
    }
    public abstract void execute();
}
