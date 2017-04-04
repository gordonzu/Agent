package src.agent;

public interface EnvironmentView {
	
    void notify(String msg);

		void agentAdded(Agent agent, Environment source);

		void agentActed(Agent agent, Action action, Environment source);
}


