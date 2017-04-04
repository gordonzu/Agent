package src.search.framework;

import src.search.framework.problem.Problem;

/*
 * Interface for all AIMA3e search algorithms which forget the exploration history and
 * return just a single state which is hopefully a goal state. This search framework expects
 * all search algorithms to provide some metrics and to actually explore the search space
 * by expanding nodes.
 */
public interface SearchForStates {

	Object findState(Problem p);
	
	Metrics getMetrics();
	
	NodeExpander getNodeExpander();
}


