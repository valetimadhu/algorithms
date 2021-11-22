package algorithm.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Interval{
	int start;
	int end;
	Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}
public class MergeIntervals {

	public static List<Interval> mergeIntervals(List<Interval> intervals){
		List<Interval> mergedIntervals = new LinkedList<>();
		Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
		Iterator<Interval> iterator = intervals.iterator();
		Interval interval = iterator.next();
		int start= interval.start;
		int end = interval.end;
		while(iterator.hasNext()){
			interval = iterator.next();
			if(interval.start < end){
			end = Math.max(interval.end, end);
			}else{
			mergedIntervals.add(new Interval(start,end));
			start = interval.start;
			end = interval.end;
			}
		}
		mergedIntervals.add(new Interval(start,end));
		return mergedIntervals;
	}
	
	public static boolean isOverlap(List<Interval> intervals) {
		Collections.sort(intervals, (a,b)->Integer.compare(a.start,b.start));
		Iterator<Interval> iterator = intervals.iterator();
		Interval interval = iterator.next();
		int end = interval.end;
		while(iterator.hasNext()){
			interval = iterator.next();
			if(interval.start <= end) return true;
			else{
				end = interval.end;
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1,4));
		intervals.add(new Interval(2,5));
		intervals.add(new Interval(7,9));
		System.out.println(" is overlap "+MergeIntervals.isOverlap(intervals));
		for(Interval interval: MergeIntervals.mergeIntervals(intervals)){
			System.out.println(+interval.start+" : "+interval.end);
		}
	
		intervals = new ArrayList<>();
		System.out.println(" Merged Intervals ");
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(2,4));
		intervals.add(new Interval(5,9));
		System.out.println(" is overlap "+MergeIntervals.isOverlap(intervals));
		for(Interval interval: MergeIntervals.mergeIntervals(intervals)){
			System.out.println(+interval.start+" : "+interval.end);
		}

	}

}
