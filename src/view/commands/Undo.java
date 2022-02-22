package view.commands;

import data.DataManager;

import java.util.Stack;

import static controller.StateController.undo;

public class Undo extends UndoRedo{
    public Undo(Stack<String> _undo, Stack<String> _redo){
        super( _undo, _redo);
    }

    @Override
    public DataManager execute(DataManager data) {
        DataManager Sample = undo(data, undo, redo);
        if (Sample == null) {
            System.out.println("Stack is clear, you cant undo");
        } else {
            data = Sample;
            System.out.println("Undo successfully applied");
            return data;
        }
        return data;
    }
}
