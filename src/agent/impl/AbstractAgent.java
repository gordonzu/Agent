package agent.impl;

import agent.Action;
import agent.Agent;
import agent.AgentProgram;
import agent.Percept;

public abstract class AbstractAgent implements Agent {

    protected AgentProgram program;
	  private boolean alive = true;

	  public AbstractAgent() {

	  }

	  public AbstractAgent(AgentProgram aProgram) {
		    program = aProgram;
	  }

	  public Action execute(Percept p) {
		    if (null != program) {
			      return program.execute(p);
		    }
		    return NoOpAction.NO_OP;
	}

	  public boolean isAlive() {
		    return alive;
	  }

	  public void setAlive(boolean alive) {
		    this.alive = alive;
	  }

}


