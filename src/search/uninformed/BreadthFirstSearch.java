package src.search.uninformed;

import java.util.List;

import src.agent.Action;
import src.search.framework.Metrics;
import src.search.framework.Node;
import src.search.framework.NodeExpander;
import src.search.framework.QueueFactory;
import src.search.framework.SearchForActions;
import src.search.framework.SearchForStates;
import src.search.framework.SearchUtils;
import src.search.framework.problem.Problem;
import src.search.framework.qsearch.GraphSearch;
import src.search.framework.qsearch.QueueSearch;

/**
 * Artificial Intelligence A Modern Approach (3rd Edition): Figure 3.11, page
 * 82.<br>
 * <br>
 * 
 * <pre>
 * function BREADTH-FIRST-SEARCH(problem) returns a solution, or failure
 *   node &lt;- a node with STATE = problem.INITIAL-STATE, PATH-COST=0
 *   if problem.GOAL-TEST(node.STATE) then return SOLUTION(node)
 *   frontier &lt;- a FIFO queue with node as the only element
 *   explored &lt;- an empty set
 *   loop do
 *      if EMPTY?(frontier) then return failure
 *      node &lt;- POP(frontier) // chooses the shallowest node in frontier
 *      add node.STATE to explored
 *      for each action in problem.ACTIONS(node.STATE) do
 *          child &lt;- CHILD-NODE(problem, node, action)
 *          if child.STATE is not in explored or frontier then
 *              if problem.GOAL-TEST(child.STATE) then return SOLUTION(child)
 *              frontier &lt;- INSERT(child, frontier)
 * </pre>
 * 
 * Figure 3.11 Breadth-first search on a graph.<br>
 * <br>
 * <b>Note:</b> Supports TreeSearch, GraphSearch, and BidirectionalSearch. Just
 * provide an instance of the desired QueueSearch implementation to the
 * constructor!
 * 
 * @author Ciaran O'Reilly
 * @author Ruediger Lunde
 */
public class BreadthFirstSearch implements SearchForActions, SearchForStates {

	private final QueueSearch implementation;

	public BreadthFirstSearch() {
		this(new GraphSearch());
	}

	public BreadthFirstSearch(QueueSearch impl) {
		implementation = impl;
		// Goal test is to be applied to each node when it is generated
		// rather than when it is selected for expansion.
		implementation.setEarlyGoalTest(true);
	}

	@Override
	public List<Action> findActions(Problem p) {
		implementation.getNodeExpander().useParentLinks(true);
		Node node = implementation.findNode(p, QueueFactory.<Node>createFifoQueue());
		return node == null ? SearchUtils.failure() : SearchUtils.getSequenceOfActions(node);
	}
	
	@Override
	public Object findState(Problem p) {
		implementation.getNodeExpander().useParentLinks(false);
		Node node = implementation.findNode(p, QueueFactory.<Node>createFifoQueue());
		return node == null ? null : node.getState();
	}

	@Override
	public NodeExpander getNodeExpander() {
		return implementation.getNodeExpander();
	}
	
	@Override
	public Metrics getMetrics() {
		return implementation.getMetrics();
	}
}
