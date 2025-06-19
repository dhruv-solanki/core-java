package Collections.SetInterfaceExamples;

// Same as Map interface we have Set interface
// All the keys of Map are basically Set
// Because keys are unique
// And Set only contains unique values
// So Set is a collection that can't contain duplicates

// Time Complexity: Normal
// add: O(1)
// get: O(1)
// remove: O(1)

// Time Complexity: Sorted
// add: O(log n)
// get: O(log n)
// remove: O(log n)

//                     No order, Ordered, Sorted, Constants
// Interface - Map --> HashMap, LinkedHashMap, TreeMap, EnumMap
// Interface - Set --> HashSet, LinkedHashSet, TreeSet, EnumSet

// For Thread Safety
// ConcurrentSkipListHashMap
// ConcurrentSkipListSet

import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetOverview {
    public static void main(String[] args) {
//        unordered set
        Set<Integer> nums1 = new HashSet<>();
        nums1.add(33);
        nums1.add(55);
        nums1.add(66);

        System.out.println(nums1.contains(44));
        System.out.println(nums1);

//        ordered set
        Set<Integer> nums2 = new LinkedHashSet<>();
        nums2.add(25);
        nums2.add(12);
        nums2.add(31);
        System.out.println(nums2.remove(31));
        System.out.println(nums2);

//        sorted set
        Set<Integer> nums3 = new TreeSet<>();
        nums3.add(9);
        nums3.add(5);
        nums3.add(2);
        System.out.println(nums3);

//        immutable set, we can give as much as possible
        Set<Integer> nums4 = Set.of(7, 2, 9, 3, 0, 1, 6);
        System.out.println(nums4);
    }
}
