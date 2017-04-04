package src.search.framework;

import src.agent.Percept;

/*
 * This interface is to define how to Map a Percept to a State representation
 * for a problem solver within a specific environment. This arises in the
 * description of the Online Search algorithms from Chapter 4.
 */
public interface PerceptToStateFunction {

	Object getState(Percept p);

}


