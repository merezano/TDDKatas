Integer Range
=============
You are building a class that models some ideas from mathematics. Your class will be used for contiguous sets of integers, 
and it will be called **IntegerRange**. *IntegerRange* is instantiated with two integers representing the lower and upper bounds.

*IntegerRange* will have the following features:

- *min()* - returns an integer representing the minimum value in the integer range.
- *max()* - returns an integer representing the maximum value in the integer range.
- *size()* - returns an integer representing the count of integers in the range.
- *intersects(IntegerRange)* - returns true if the given IntegerRange has a non-empty intersection with the passed IntegerRange
- *intersection(IntegerRange)* - returns an IntegerRange representing the intersection of the given instance and the passed instance.
- *cover(IntegerRange)* - returns an IntegerRange that is the smallest IntegerRange that includes both the given instance and the passed instance