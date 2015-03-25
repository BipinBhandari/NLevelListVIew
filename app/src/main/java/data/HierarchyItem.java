package data;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import bipin.nlevellistview.NLevelListItem;
import bipin.nlevellistview.R;

/**
 * Created by view9 on 3/19/15.
 */

public class HierarchyItem<T> {
// implements NLevelListItem{
//    public static Context context;
//
//    private ArrayList<HierarchyItem> children;
//    private T value;
//    private boolean isExpanded;
//
//    public HierarchyItem(T value){
//        this.value=value;
//        init();
//    }
//
//    public HierarchyItem(HierarchyItem parent, T value){
//        parent.addChild(this);
//        this.value=value;
//        init();
//    }
//
//    private void init(){
//        children=new ArrayList<>();
//        isExpanded=true;
//    }
//
//    public T getValue() {
//        return value;
//    }
//
//    public boolean hasChildren(){
//        return children != null && children.size() != 0;
//    }
//
//    public void addChild(HierarchyItem child){
//        children.add(child);
//    }
//
//    public ArrayList<HierarchyItem> getChildren() {
//        return children;
//    }
//
//    public boolean isExpanded(){return isExpanded;}
//
//    @Override
//    public void toggle() {
//        isExpanded=!isExpanded;
//    }
//
//
//    @Override
//    public View getView(View convertView) {
//        View v=convertView;
//        if (v==null){
//            v = LayoutInflater.from(context).inflate(R.layout.list_item, null);
//        }
//
//        TextView tv = (TextView) v.findViewById(R.id.textView);
//        tv.setBackgroundColor(Color.DKGRAY);
//        tv.setText(value.toString());
//        return v;
//    }
}
