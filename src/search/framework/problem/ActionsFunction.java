package src.search.framework.problem;

import java.util.Set;

import src.agent.Action;

/*
 * Artificial Intelligence A Modern Approach (3rd Edition): page 67.<br>
 * Given a particular state s, ACTIONS(s) returns the set of actions that can be
 * executed in s. We say that each of these actions is <b>applicable</b> in s.
 */
public interface ActionsFunction {
	
    Set<Action> actions(Object s);
}

