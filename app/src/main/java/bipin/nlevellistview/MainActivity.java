package bipin.nlevellistview;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import data.HierarchyItem;
import data.Manufacturing;
import data.ManufacturingItem;

public class MainActivity extends ActionBarActivity {

    List<NLevelItem> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView1);
        list = new ArrayList<NLevelItem>();


        final LayoutInflater inflater = LayoutInflater.from(this);

        final NLevelItem grandParent = new NLevelItem(new SomeObject("GrandParent"),null, new NLevelView() {
                @Override
                public View getView(View convertView, NLevelItem item) {
                    View v=convertView;
                    if (v==null){
                        v = inflater.inflate(R.layout.list_item, null);
                    }
                    TextView tv = (TextView) v.findViewById(R.id.textView);
                    tv.setBackgroundColor(Color.GREEN);
                    String name = (String) ((SomeObject) item.getWrappedObject()).getName();
                    tv.setText(name);
                    return v;
                }
            });
            list.add(grandParent);

            NLevelItem parent = new NLevelItem(new SomeObject("Parent"),grandParent, new NLevelView() {

                    @Override
                    public View getView(View convertView, NLevelItem item) {
                        View v=convertView;
                        if (v==null){
                            v = inflater.inflate(R.layout.list_item, null);
                        }
                        TextView tv = (TextView) v.findViewById(R.id.textView);
                        tv.setBackgroundColor(Color.YELLOW);
                        String name = (String) ((SomeObject) item.getWrappedObject()).getName();
                        tv.setText(name);
                        return v;
                    }
            });

            list.add(parent);

            NLevelItem child = new NLevelItem(new SomeObject("child "),parent, new NLevelView() {


                  @Override
                        public View getView(View convertView, NLevelItem item) {
                            View v=convertView;
                            if (v==null){
                                v = inflater.inflate(R.layout.list_item, null);
                            }
                            TextView tv = (TextView) v.findViewById(R.id.textView);
                            tv.setBackgroundColor(Color.GRAY);
                            String name = (String) ((SomeObject) item.getWrappedObject()).getName();
                            tv.setText(name);
                            return v;
                        }
                  });

            list.add(child);

            NLevelItem grandChild = new NLevelItem(new SomeObject("grand child "),child, new NLevelView() {
                  @Override
                      public View getView(View convertView, NLevelItem item) {
                          View v=convertView;
                          if (v==null){
                          v = inflater.inflate(R.layout.list_item, null);
                      }
                          TextView tv = (TextView) v.findViewById(R.id.textView);
                          tv.setBackgroundColor(Color.DKGRAY);
                          String name = (String) ((SomeObject) item.getWrappedObject()).getName();
                          tv.setText(name);
                          return v;
                  }
                });

                list.add(grandChild);

                NLevelAdapter adapter = new NLevelAdapter(list);
                listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((NLevelAdapter)listView.getAdapter()).toggle(i);
                ((NLevelAdapter)listView.getAdapter()).getFilter().filter();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class SomeObject {
        public String name;

        public SomeObject(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
}



//                    }
//                }
//            }
//        }
//

//

//        HierarchyItem<String> parent = new HierarchyItem<>("Root");
//
//        HierarchyItem<String> levelOne = new HierarchyItem<>(parent, "Level One");
//        HierarchyItem<String> itemOne = new HierarchyItem<>(levelOne, "Item One");
//        HierarchyItem<String> itemTwo = new HierarchyItem<>(levelOne, "Item Two");
//        HierarchyItem<String> itemThree = new HierarchyItem<>(levelOne, "Item Three");
//        HierarchyItem<String> itemFour = new HierarchyItem<>(levelOne, "Item Four");
//        HierarchyItem<String> subItemOne = new HierarchyItem<>(itemFour, "Sub Item One");
//        HierarchyItem<String> subItemTwo = new HierarchyItem<>(itemFour, "Sub Item Two");
//        HierarchyItem<String> subItemThree = new HierarchyItem<>(itemFour, "Sub Item Three");
//        HierarchyItem<String> subItemFour = new HierarchyItem<>(itemFour, "Sub Item Four");
//        HierarchyItem<String> numberOne = new HierarchyItem<>(subItemThree, "Sub Item Three");
//        HierarchyItem<String> numberTwo = new HierarchyItem<>(subItemThree, "Sub Item Four");
//
//
//        HierarchyItem<String> levelTwo = new HierarchyItem<>(parent, "Level Two");
//        HierarchyItem<String> levelThree = new HierarchyItem<>(parent, "Level Three");
//
//        NLevelAdapter adapter = new NLevelAdapter(parent);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                ((NLevelAdapter)listView.getAdapter()).toggle(i);
//                ((NLevelAdapter)listView.getAdapter()).getFilter().filter();
//            }
//        });
