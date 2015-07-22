import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>(){ 
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if(o1.start==o2.start){
					return 0;
				}
				if(o1.start<o2.start){
					return -1;
				}
				else {
					return 1;
				}
			}			
		});
		Iterator<Interval> iter = intervals.iterator();
		Interval prev = null;
		if(iter.hasNext()){
			prev=iter.next();
		}
		while(iter.hasNext()){
			Interval curr = iter.next();
			if(curr.start>prev.end){
				prev = curr;
			}else{
				if(curr.end>prev.end){
					prev.end = curr.end;
				}
				iter.remove();
			}
		}
		return intervals;
	} 
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
