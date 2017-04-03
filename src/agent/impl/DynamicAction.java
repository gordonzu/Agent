package src.agent.impl;

import src.agent.Action;

public class DynamicAction extends ObjectWithDynamicAttributes implements Action {
	
    public static final String ATTRIBUTE_NAME = "name";

	  public DynamicAction(String name) {
		    this.setAttribute(ATTRIBUTE_NAME, name);
	  }

	  public String getName() {
		    return (String) getAttribute(ATTRIBUTE_NAME);
	  }

	  public boolean isNoOp() {
		    return false;
	  }

	  @Override
	  public String describeType() {
		    return Action.class.getSimpleName();
	  }
}


