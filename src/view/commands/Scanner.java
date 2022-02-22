package view.commands;

import data.DataManager;

import java.util.Stack;

import static controller.StateController.storeState;

public abstract class Scanner extends UndoRedo{
    java.util.Scanner scanner;
    public Scanner(java.util.Scanner _scanner, Stack<String> _undo, Stack<String> _redo){
        super(_undo, _redo);
    this.scanner = _scanner;
    }
    public abstract DataManager execute(DataManager data);
    public void pushUndo(Stack<String> _undo, DataManager data){
        undo.push(storeState(data));
    }
}
