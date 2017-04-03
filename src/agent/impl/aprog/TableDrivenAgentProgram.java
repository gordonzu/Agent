package src.agent.impl.aprog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import src.agent.Action;
import src.agent.AgentProgram;
import src.agent.Percept;
import src.agent.impl.NoOpAction;
import src.util.datastructure.Table;


public class TableDrivenAgentProgram implements AgentProgram {

    private List<Percept> percepts = new ArrayList<Percept>();
    private Table<List<Percept>, String, Action> table;
    private static final String ACTION = "action";

    //public TableDrivenAgentProgram() {}

    public TableDrivenAgentProgram(Map<List<Percept>, Action> perceptSequenceActions) {  

        List<List<Percept>> rowHeaders = new ArrayList<List<Percept>>( 
                                          perceptSequenceActions.keySet());

        List<String> colHeaders = new ArrayList<String>();
        colHeaders.add(ACTION);

        table = new Table<List<Percept>, String, Action>(rowHeaders, colHeaders);

        for (List<Percept> row : rowHeaders) {
            table.set(row, ACTION, perceptSequenceActions.get(row));
        }
    }

    // function TABLE-DRIVEN-AGENT(percept) returns an action
    public Action execute(Percept percept) {
        // append percept to end of percepts
        percepts.add(percept);

        // action <- LOOKUP(percepts, table)
        // return action
        return lookupCurrentAction();
    }

    
    private Action lookupCurrentAction() {
        Action action = null;

        action = table.get(percepts, ACTION);
        if (null == action) {
            action = NoOpAction.NO_OP;
        }
        return action;
    }  

    
    //public String sayHello() {
      //  return "Fuck You";
    //}

}






