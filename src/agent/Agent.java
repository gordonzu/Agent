package src.agent;

public interface Agent extends EnvironmentObject {
	  
    Action execute(Percept percept);

	  boolean isAlive();

	  void setAlive(boolean alive);
}
