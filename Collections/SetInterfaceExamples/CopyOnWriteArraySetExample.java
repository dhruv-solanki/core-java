package Collections.SetInterfaceExamples;

import java.util.concurrent.CopyOnWriteArraySet;

// Same as CopyOnWriteArrayList just no duplicates allowed
// Thread safe
// Copy-on-write mechanism
// No duplicates are allowed
// Iterators do not reflect modifications

// Use Case:
// If you have more reads than writes then use it
// If you have more writes then it will be more memory consuming
// Since everytime new copy is created on write operation
public class CopyOnWriteArraySetExample {
    public static void main(String[] args) {
        CopyOnWriteArraySet<Integer> nums = new CopyOnWriteArraySet<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
//        here nums is stable snapshot, and we are also adding 6 everytime
//        still it will not print in this loop
        for(int i: nums) {
            System.out.println(i);
            nums.add(6);
        }
//        here snapshot is updated so it will contain 6
        System.out.println(nums);

//        But if we do same thing with ConcurrentSkipListSet
//        it might add 6 or might not add
//        that's why we call it weakly consistent set
    }
}
