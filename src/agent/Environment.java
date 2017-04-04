package src.agent;

import java.util.List;

public interface Environment {
	List<Agent> getAgents();

	void addAgent(Agent agent);

	void removeAgent(Agent agent);

	List<EnvironmentObject> getEnvironmentObjects();

	void addEnvironmentObject(EnvironmentObject eo);

	void removeEnvironmentObject(EnvironmentObject eo);

	void step();

	void step(int n);

	void stepUntilDone();

	boolean isDone();

	double getPerformanceMeasure(Agent forAgent);

	void addEnvironmentView(EnvironmentView ev);

	void removeEnvironmentView(EnvironmentView ev);

	void notifyViews(String msg);
}
