


#Qeustion 1:

def luc(n):
    a,b = 2,1
    while a < n:
        print(a, end = " ")
        a,b = b, a+b


#Question 2;
#a
def luc2(n):
    a,b = 2, 1
    l = []
    for i in range(n):
        l.append(a)
        a,b = b, a+b
    return l

#b
def luc3(n):
    a,b = 2,1
    for i in range(n):
        yield a
        a, b = b , a+b

#for i in luc3(7):
#    print(i)


#Question 3:

def fun(seq):
    s = {x for x in seq}
    return s

