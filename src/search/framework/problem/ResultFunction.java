package src.search.framework.problem;

import src.agent.Action;

 // P. 67 A description of what each action does; the formal name for this is the
 // transition model, specified by a function RESULT(s, a) that returns the state
 // that results from doing action a in state s. We also use the term successor
 // to refer to any state reachable from a given state by a single action.

public interface ResultFunction {
	 // Returns the state that results from doing action a in state s
	Object result(Object s, Action a);
}


