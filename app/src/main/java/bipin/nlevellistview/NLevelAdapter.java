package bipin.nlevellistview;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class NLevelAdapter extends BaseAdapter {

    List<NLevelItem> list;
    List<NLevelListItem> filtered;
    public void setFiltered(ArrayList<NLevelListItem> filtered) {
        this.filtered = filtered;
    }
    public NLevelAdapter(List<NLevelItem> list) {
        this.list = list;
        this.filtered = filterItems();
    }

    @Override
    public int getCount() {
        return filtered.size();
    }

    @Override
    public NLevelListItem getItem(int arg0) {
        return filtered.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItem(i).getView(view);
    }

    //    @Override
//    public View getView(int arg0, View arg1, ViewGroup arg2) {
//
//        return getItem(arg0).getView();
//    }

    public NLevelFilter getFilter() {
        return new NLevelFilter();
    }


    class NLevelFilter {

        public void filter() {
            new AsyncFilter().execute();
        }

        class AsyncFilter extends AsyncTask<Void, Void, ArrayList<NLevelListItem>> {

            @Override
            protected ArrayList<NLevelListItem> doInBackground(Void... arg0) {

                return (ArrayList<NLevelListItem>) filterItems();
            }

            @Override
            protected void onPostExecute(ArrayList<NLevelListItem> result) {
                setFiltered(result);
                NLevelAdapter.this.notifyDataSetChanged();
            }
        }


    }

    public List<NLevelListItem> filterItems() {
        List<NLevelListItem> tempfiltered = new ArrayList<NLevelListItem>();
        OUTER: for (NLevelListItem item : list) {
            //add expanded items and top level items
            //if parent is null then its a top level item
            if(item.getParent() == null) {
                tempfiltered.add(item);
            } else {
                //go through each ancestor to make sure they are all expanded
                NLevelListItem parent = item;
                while ((parent = parent.getParent())!= null) {
                    if (!parent.isExpanded()){
                        //one parent was not expanded
                        //skip the rest and continue the OUTER for loop
                        continue OUTER;
                    }
                }
                tempfiltered.add(item);
            }
        }

        return tempfiltered;
    }

    public void toggle(int arg2) {
        filtered.get(arg2).toggle();
    }
}


//
//import java.util.ArrayList;
//import java.util.List;
//
//import android.os.AsyncTask;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//
//import data.HierarchyItem;
//
//public class NLevelAdapter extends BaseAdapter {
//    private HierarchyItem root;
//
//    List<NLevelItem> list;
//	List<NLevelListItem> filtered;
//	public void setFiltered(ArrayList<NLevelListItem> filtered) {
//		this.filtered = filtered;
//
//	}
////	public NLevelAdapter(List<NLevelItem> list) {
////		this.list = list;
////		this.filtered = filterItems();
////	}
//
//    public NLevelAdapter(HierarchyItem root){
//        this.root=root;
//        filterItems(root);
//        this.filtered=filteredItemsCollection;
//    }
//
//	@Override
//	public int getCount() {
//		return filtered.size();
//	}
//
//    @Override
//    public NLevelListItem getItem(int i) {
//        return filtered.get(i);
//    }
//
//	@Override
//	public long getItemId(int arg0) {
//		return 0;
//	}
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//		return getItem(i).getView(view);
//    }
//
//	public NLevelFilter getFilter() {
//		return new NLevelFilter();
//	}
//
//	class NLevelFilter {
//
//		public void filter() {
//			new AsyncFilter().execute();
//		}
//
//		class AsyncFilter extends AsyncTask<Void, Void, ArrayList<NLevelListItem>> {
//
//			@Override
//			protected ArrayList<NLevelListItem> doInBackground(Void... arg0) {
//                filterItems(root);
//				return filteredItemsCollection;
//			}
//
//			@Override
//			protected void onPostExecute(ArrayList<NLevelListItem> result) {
//				setFiltered(result);
//				NLevelAdapter.this.notifyDataSetChanged();
//			}
//		}
//	}
//
////	public List<NLevelListItem> filterItems() {
////		List<NLevelListItem> tempfiltered = new ArrayList<NLevelListItem>();
////		OUTER: for (NLevelListItem item : list) {
////			//add expanded items and top level items
////			//if parent is null then its a top level item
////			if(item.getParent() == null) {
////				tempfiltered.add(item);
////			} else {
////				//go through each ancestor to make sure they are all expanded
////				NLevelListItem parent = item;
////				while ((parent = parent.getParent())!= null) {
////					if (!parent.isExpanded()){
////						//one parent was not expanded
////						//skip the rest and continue the OUTER for loop
////						continue OUTER;
////					}
////				}
////				tempfiltered.add(item);
////			}
////		}
////
////		return tempfiltered;
////	}
//
//
////    public List<NLevelListItem> filterItems(HierarchyItem root) {
////        List<NLevelListItem> tempfiltered = new ArrayList<NLevelListItem>();
////        OUTER: for (NLevelListItem item : list) {
////            //add expanded items and top level items
////            //if parent is null then its a top level item
////            if(item.getParent() == null) {
////                tempfiltered.add(item);
////            } else {
////                //go through each ancestor to make sure they are all expanded
////                NLevelListItem parent = item;
////                while ((parent = parent.getParent())!= null) {
////                    if (!parent.isExpanded()){
////                        //one parent was not expanded
////                        //skip the rest and continue the OUTER for loop
////                        continue OUTER;
////                    }
////                }
////                tempfiltered.add(item);
////            }
////        }
////
////        return tempfiltered;
////    }
//
//    private ArrayList<NLevelListItem> filteredItemsCollection= new ArrayList<>();
//    public void filterItems(HierarchyItem root){
//        filteredItemsCollection.add(root);
//        if (!root.hasChildren() || root.isExpanded()) return;
//        ArrayList<HierarchyItem> children = root.getChildren();
//        for (HierarchyItem h: children){
//            filterItems(h);
//        }
//    }
//
//	public void toggle(int arg2) {
//		filtered.get(arg2).toggle();
//	}
//}
