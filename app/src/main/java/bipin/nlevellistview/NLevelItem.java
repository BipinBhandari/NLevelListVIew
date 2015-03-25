package bipin.nlevellistview;
import android.view.View;

public class NLevelItem implements NLevelListItem {

    private Object wrappedObject;
    private NLevelItem parent;
    private NLevelView nLevelView;
    private boolean isExpanded = false;

    public NLevelItem(Object wrappedObject, NLevelItem parent, NLevelView nLevelView) {
        this.wrappedObject = wrappedObject;
        this.parent = parent;
        this.nLevelView = nLevelView;
    }

    public Object getWrappedObject() {
        return wrappedObject;
    }

    @Override
    public boolean isExpanded() {
        return isExpanded;
    }
    @Override
    public NLevelListItem getParent() {
        return parent;
    }
    @Override
    public View getView(View convertView) {
        return nLevelView.getView(convertView, this);
    }
    @Override
    public void toggle() {
        isExpanded = !isExpanded;
    }
}