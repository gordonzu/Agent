package agent;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import agent.impl.DynamicPerceptTest;
import agent.impl.PerceptSequenceTest;
import agent.impl.aprog.TableDrivenAgentProgramTest;
import agent.impl.aprog.simplerule.RuleTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ RuleTest.class, TableDrivenAgentProgramTest.class,
                    DynamicPerceptTest.class, PerceptSequenceTest.class })
public class AgentTestSuite {

}

/*
@RunWith(Suite.class)
@Suite.SuiteClasses({ RuleTest.class, TableDrivenAgentProgramTest.class,
		DynamicPerceptTest.class, PerceptSequenceTest.class })
public class AgentTestSuite {

}*/

