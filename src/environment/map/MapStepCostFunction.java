package src.environment.map;

import src.agent.Action;
import src.search.framework.problem.StepCostFunction;

/*
 * Implementation of StepCostFunction interface that uses the distance between
 * locations to calculate the cost in addition to a constant cost, so that it
 * may be used in conjunction with a Uniform-cost search.
 * 
 * @author Ciaran O'Reilly
 * 
 */
public class MapStepCostFunction implements StepCostFunction {
	private Map map = null;

	private static double constantCost = 1.0;

	public MapStepCostFunction(Map map) {
		this.map = map;
	}

	public double c(Object fromCurrentState, Action action, Object toNextState) {

		String fromLoc = fromCurrentState.toString();
		String toLoc = toNextState.toString();

		Double distance = map.getDistance(fromLoc, toLoc);

		if (distance == null || distance <= 0) {
			return constantCost;
		}

		return distance;
	}

}


