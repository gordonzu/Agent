package search.framework;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import src.agent.Action;
import src.environment.map.Map;
import src.environment.map.MapFunctionFactory;
import src.environment.map.MapStepCostFunction;
import src.environment.map.SimplifiedRoadMapOfPartOfRomania;
import src.search.framework.SearchAgent;
import src.search.framework.SearchForActions;
import src.search.framework.SolutionChecker;
import src.search.framework.problem.Problem;
import src.search.framework.qsearch.GraphSearch;
import src.search.uninformed.BreadthFirstSearch;

public class SolutionCheckerTest {

	@Test
	public void testMultiGoalProblem() throws Exception {

		Map romaniaMap = new SimplifiedRoadMapOfPartOfRomania();

		Problem problem = new Problem(SimplifiedRoadMapOfPartOfRomania.ARAD,
				                      MapFunctionFactory.getActionsFunction(romaniaMap), MapFunctionFactory.getResultFunction(),
				                      new DualMapGoalTest(SimplifiedRoadMapOfPartOfRomania.BUCHAREST,
						              SimplifiedRoadMapOfPartOfRomania.HIRSOVA),
				                      new MapStepCostFunction(romaniaMap));

		SearchForActions search = new BreadthFirstSearch(new GraphSearch());

		SearchAgent agent = new SearchAgent(problem, search);

		Assert.assertEquals(
				"[Action[name==moveTo, location==Sibiu], Action[name==moveTo, location==Fagaras], Action[name==moveTo, location==Bucharest], Action[name==moveTo, location==Urziceni], Action[name==moveTo, location==Hirsova]]", agent.getActions().toString());


		Assert.assertEquals(5, agent.getActions().size());
		Assert.assertEquals("14", agent.getInstrumentation().getProperty("nodesExpanded"));
		Assert.assertEquals("4", /* "1" for GraphSearchReducedFrontier*/ agent.getInstrumentation().getProperty("queueSize"));
		Assert.assertEquals("7", /* "5" for GraphSearchReducedFrontier*/ agent.getInstrumentation().getProperty("maxQueueSize"));
	}

	class DualMapGoalTest implements SolutionChecker {
		public String goalState1 = null;
		public String goalState2 = null;

		private Set<String> goals = new HashSet<String>();

		public DualMapGoalTest(String goalState1, String goalState2) {
			this.goalState1 = goalState1;
			this.goalState2 = goalState2;
			goals.add(goalState1);
			goals.add(goalState2);
		}

		public boolean isGoalState(Object state) {
			return goalState1.equals(state) || goalState2.equals(state);
		}

		public boolean isAcceptableSolution(List<Action> actions, Object goal) {
			goals.remove(goal);
			return goals.isEmpty();
		}
	}
}


