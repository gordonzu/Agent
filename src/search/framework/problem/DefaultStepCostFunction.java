package src.search.framework.problem;

import src.agent.Action;

public class DefaultStepCostFunction implements StepCostFunction {

	public double c(Object stateFrom, Action action, Object stateTo) {
		return 1;
	}
}


