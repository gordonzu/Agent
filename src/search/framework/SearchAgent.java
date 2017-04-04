package src.search.framework;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import src.agent.Action;
import src.agent.Percept;
import src.agent.impl.AbstractAgent;
import src.agent.impl.NoOpAction;
import src.search.framework.problem.Problem;

public class SearchAgent extends AbstractAgent {
	protected List<Action> actionList;

	private Iterator<Action> actionIterator;

	private Metrics searchMetrics;

	public SearchAgent(Problem p, SearchForActions search) throws Exception {
		actionList = search.findActions(p);
		actionIterator = actionList.iterator();
		searchMetrics = search.getMetrics();
	}

	@Override
	public Action execute(Percept p) {
		if (actionIterator.hasNext()) {
			return actionIterator.next();
		} else {
			return NoOpAction.NO_OP;
		}
	}

	public boolean isDone() {
		return !actionIterator.hasNext();
	}

	public List<Action> getActions() {
		return actionList;
	}

	public Properties getInstrumentation() {
		Properties retVal = new Properties();
		Iterator<String> iter = searchMetrics.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String value = searchMetrics.get(key);
			retVal.setProperty(key, value);
		}
		return retVal;
	}
}


