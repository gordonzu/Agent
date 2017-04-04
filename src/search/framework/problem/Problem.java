package src.search.framework.problem;

/*
 * Artificial Intelligence A Modern Approach (3rd Edition): page 66.<br>
 * A problem can be defined formally by five components: <br>
 * <li>The <b>initial state</b> that the agent starts in.</li>
 * <li>A description of the possible <b>actions</b> available to the agent.
 * Given a particular state s, ACTIONS(s) returns the set of actions that can be
 * executed in s.</li>
 * <li>A description of what each action does; the formal name for this is the
 * <b>transition model, specified by a function RESULT(s, a) that returns the
 * state that results from doing action a in state s.</b></li>
 * <li>The <b>goal test</b>, which determines whether a given state is a goal
 * state.</li>
 * <li>A <b>path cost</b> function that assigns a numeric cost to each path. The
 * problem-solving agent chooses a cost function that reflects its own
 * performance measure. The <b>step cost</b> of taking action a in state s to
 * reach state s' is denoted by c(s,a,s')</li>
 * 
 */
public class Problem {

	protected Object initialState;

	protected ActionsFunction actionsFunction;

	protected ResultFunction resultFunction;

	protected GoalTest goalTest;

	protected StepCostFunction stepCostFunction;

	/*
	 * Constructs a problem with the specified components, and a default step
	 * cost function (i.e. 1 per step).
	 * 
	 * @param initialState
	 *            the initial state that the agent starts in.
	 * @param actionsFunction
	 *            a description of the possible actions available to the agent.
	 * @param resultFunction
	 *            a description of what each action does; the formal name for
	 *            this is the transition model, specified by a function
	 *            RESULT(s, a) that returns the state that results from doing
	 *            action a in state s.
	 * @param goalTest
	 *            test determines whether a given state is a goal state.
	 */


	public Problem(Object initialState, ActionsFunction actionsFunction, 
                                        ResultFunction resultFunction, GoalTest goalTest) {

		this(initialState, actionsFunction, resultFunction, goalTest, new DefaultStepCostFunction());
	}

	/*
	 * Constructs a problem with the specified components, which includes a step
	 * cost function.
	 * 
	 * @param initialState
	 *            the initial state of the agent.
	 * @param actionsFunction
	 *            a description of the possible actions available to the agent.
	 * @param resultFunction
	 *            a description of what each action does; the formal name for
	 *            this is the transition model, specified by a function
	 *            RESULT(s, a) that returns the state that results from doing
	 *            action a in state s.
	 * @param goalTest
	 *            test determines whether a given state is a goal state.
	 * @param stepCostFunction
	 *            a path cost function that assigns a numeric cost to each path.
	 *            The problem-solving-agent chooses a cost function that
	 *            reflects its own performance measure.
	 */
	public Problem(Object initialState, ActionsFunction actionsFunction,
			                            ResultFunction resultFunction, GoalTest goalTest,
			                            StepCostFunction stepCostFunction) {
		this.initialState = initialState;
		this.actionsFunction = actionsFunction;
		this.resultFunction = resultFunction;
		this.goalTest = goalTest;
		this.stepCostFunction = stepCostFunction;
	}

	public Object getInitialState() {
		return initialState;
	}

	public boolean isGoalState(Object state) {
		return goalTest.isGoalState(state);
	}

	public GoalTest getGoalTest() {
		return goalTest;
	}

	public ActionsFunction getActionsFunction() {
		return actionsFunction;
	}

	// Returns the description of what each action does.
	public ResultFunction getResultFunction() {
		return resultFunction;
	}

	// Returns the path cost function.
	public StepCostFunction getStepCostFunction() {
		return stepCostFunction;
	}

	protected Problem() {
	}
}
