package agent;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//import aima.test.core.unit.agent.impl.DynamicPerceptTest;
//import aima.test.core.unit.agent.impl.PerceptSequenceTest;
import agent.impl.TableDrivenAgentProgramTest;
//import agent.impl.aprog.simplerule.RuleTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TableDrivenAgentProgramTest.class })
public class AgentTestSuite {

}

/*
@RunWith(Suite.class)
@Suite.SuiteClasses({ RuleTest.class, TableDrivenAgentProgramTest.class,
		DynamicPerceptTest.class, PerceptSequenceTest.class })
public class AgentTestSuite {

}*/

