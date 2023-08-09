package Actions;
import org.testng.TestNG;
import org.testng.Assert;



public class ActionsHolder {
    private Assert asserts;
    private SharedActions sharedActions;

    public  ActionsHolder(Assert asserts){
        this.setAsserts(asserts);
        sharedActions = null;
    }

    public void Initialize(){
        sharedActions = new SharedActions(this);
    }





    public Assert getAsserts() {
        return asserts;
    }

    public void setAsserts(Assert asserts) {
        this.asserts = asserts;
    }

    public SharedActions getSharedActions() {
        return sharedActions;
    }

    public void setSharedActions(SharedActions sharedActions) {
        this.sharedActions = sharedActions;
    }
}
