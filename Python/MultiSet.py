import collections

#creating the class
class MultiSet:

    #constructor method. treating our sett attribute as a list.
    def __init__(self,*args):
        self.sett = list(args)

#we use the append list method, since out sett is a list.
    def __add__(self, el):
        self.sett.append(el)

#overrides the division operator.
    def __truediv__(self, el):
        self.sett[:]  = [i for i in self.sett if i != el]

#counts the number of times el is present in sett
    def m(self,el):
       return self.sett.count(el)

#union method.
    def union(self,other):
        counts = collections.Counter(self.sett)
        for value, count in collections.Counter(other.sett).items():
            counts[value] = max(counts[value], count)
        newlist = [value for value, count in counts.items() for _ in range(count)]
        return MultiSet(*newlist)

#intersection method.
    def intersection(self, other):
        counts = collections.Counter(self.sett)
        for value, count in collections.Counter(other.sett).items():
            counts[value] = min(counts[value], count)
        for value, count in counts.copy().items():
            if value not in collections.Counter(other.sett):
                del counts[value]
        newlist = [value for value, count in counts.items()  for _ in range(count)]
        return MultiSet(*newlist)

#the subtraction method.remove the elements in sett list if they are found in lst.
    def __sub__(self, lst):
        for x in lst:
            if x in self.sett:
                self.sett.remove(x)

#tozString method.
    def __str__(self):
        return "{{{0}}}".format( str(self.sett)[1:-1] )


