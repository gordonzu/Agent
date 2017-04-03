package src.agent.impl.aprog.simplerule;

import src.agent.Action;
import src.agent.impl.ObjectWithDynamicAttributes;

public class Rule {
    private Condition con;

    private Action action;

    public Rule(Condition con, Action action) {
        assert (null != con);
        assert (null != action);

        this.con = con;
        this.action = action;
    }

    public boolean evaluate(ObjectWithDynamicAttributes p) {
        return (con.evaluate(p));
    }

    public Action getAction() {
        return action;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Rule)) {
          return super.equals(o);
        }
        return (toString().equals(((Rule) o).toString()));
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        return sb.append("if ").append(con).append(" then ").append(action)
            .append(".").toString();
    }
}


