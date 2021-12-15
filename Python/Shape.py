import math

class Shape:

   #shape counter, so that when they are printed their corresponding number is printed
    i = 1

   #constrcutor method
    def __init__(self):
        self.id = Shape.i
        Shape.i += 1

    #toString method
    def __str__(self):
        return (str(self.id) + ": " + str(type(self).__name__)  + ", perimeter: " + str(self.perimeter()) + ", Area: " + str(self.area()) )

    #there is no denifinition here for the perimeter and area methods. they are here simply for inheritance purposes.
    def perimeter(self):
        pass

    def area(self):
        pass

#defining the Cirle class
class Circle(Shape):

    def __init__(self, radius):
        super().__init__()
        self.radius = radius

    def perimeter(self):
        return (2 * int(self.radius) * math.pi).__round__(5)

    def area(self):
        return (math.pi * int(self.radius)**2).__round__(5)
#if the radius is negative, it prints error. without the perimeter and area, since theyll be worng numbers
    def __str__(self):
        if int(self.radius) < 0:
            return ("Error: Invalid Circle \n" + str(self.id) + ": " + str(type(self).__name__) + ", perimeter: None"  + ", Area: None" )

        return (str(self.id) + ": " + str(type(self).__name__) + ", perimeter: " + str(self.perimeter()) + ", Area: " + str(self.area()) )


#defining the Ellipse class
class Ellipse(Shape):
    def __init__(self, a, b):
        super().__init__()
        if a > b:
           self.major = a
           self.minor = b
        else:
           self.major = b
           self.minor = a


    def area(self):
        return (math.pi * int(self.major) * int(self.minor)).__round__(5)

    def eccentricity(self):
        try:
            return (math.sqrt(int(self.major)**2 - int(self.minor)**2)).__round__(5)
        except:
            return None


    def __str__(self):
        if int(self.major) < 0 or int(self.minor) < 0:
            return ("Error: Invalid Ellipse \n" +str(self.id) + ": " + str(type(self).__name__) + ", perimeter: None"  + ", Area: None" )

        return (str(self.id) + ": " + str(type(self).__name__) + ", perimeter: " + str(self.perimeter()) + ", Area: " + str(self.area()) +
         " \nlinear eccentricity: " + str(self.eccentricity()))

#defininig thr rhombus class
class Rhombus(Shape):
    def __init__(self, d1, d2):
        super().__init__()
        self.d1 = d1
        self.d2 = d2

    def perimeter(self):
        return 4 * math.sqrt(int(self.d1)**2 + int(self.d2)**2).__round__(5)

    def area(self):
        return ((int(self.d1) * int(self.d2))/2).__round__(5)

    def inradius(self):
        try:
            return ((int(self.d1) * int(self.d2))/ (2 * math.sqrt(int(self.d1)**2 + int(self.d2)**2))).__round__(5)
        except:
            return None

    def __str__(self):
        if int(self.d1) < 0 or int(self.d2) < 0:
            return ("Error: Invalid Rhombus \n" +str(self.id) + ": " + str(type(self).__name__) + str(self.id) + ", perimeter: None" + ", Area: None" )

        return (str(self.id) + ": " + str(type(self).__name__) + ", perimeter: " + str(self.perimeter()) + ", Area: " + str(self.area()) +
         " \nin-radius: " + str(self.inradius()))


#opening the file to read.
file = open("shapes.txt", "r")

#reading each line. we split the lines to tokenize them. depending on the shape. we create the corresponding shape class.
#and then we print it, showing the specific name, area, perimeter...etc
for ln in file.readlines():
    shapeName = ln.split()[0]
    if shapeName == "shape":
        shape = Shape()
    elif shapeName == "circle":
        shape = Circle(ln.split()[1])
    elif shapeName == "ellipse":
        shape = Ellipse(ln.split()[1], ln.split()[2])
    elif shapeName == "rhombus":
        shape = Rhombus(ln.split()[1], ln.split()[2])

    print(shape)
    print()
file.close()

#question 7

file = open("shapes.txt", "r")
reader = file.readlines()

# count statistics
stats = {"shapes": 0}

for i in reader:
    q = i.split(" ")
    if len(q) >= 2:
        if q[0] == "circle":
            r = int(q[1])
            p = 2 * math.pi * r
            file = math.pi * (r ** 2)
            print("Circle, perimeter: {:.5f}, area: {:.2f}".format(p, file))

            # if circle shape is first time
            if "circle" not in stats.keys():
                stats["circle"] = 1
            else:
                stats["circle"] + 1  # else increase the circle shape count

        elif q[0] == "ellipse":
            file = int(q[1])
            reader = int(q[2])
            if file > 0 and reader > 0:
                A = math.pi * file * reader
                c = abs(1 - ((reader ** 2) / (file ** 2)))
                E = math.sqrt(c)
                print("Ellipse, perimeter: undefined, area: {:.5f}".format(A))
                print("linear eccentricity: {:.5f}".format(E))

                # if ellipse shape is first time
                if "ellipse" not in stats.keys():
                    stats["ellipse"] = 1
                else:
                    stats["ellipse"] += 1  # add 1 to the count

            else:
                print("Ellipse, perimeter: undefined, area: undefined")

        elif q[0] == "rhombus":
            p = int(q[1])
            w = int(q[2])
            A = p * w / 2
            d = p ** 2 + w ** 2
            P = 2 * math.sqrt(d)
            I = p * w / P
            print("Rhombus, perimeter: {:.5f},area: {:.5f}".format(P, A))
            print("in-radius: {:.5f}".format(I))

            # if rhombus shape is first time
            if "rhombus" not in stats.keys():
                stats["rhombus"] = 1
            else:
                stats["rhombus"] += 1  # add 1 to the count

        else:
            print("Shape,perimeter: undefined, area: undefined")
            print("Error: Invalid Ellipse")

    else:
        print("Shape,perimeter: undefined, area: undefined")
        print("Error: Invalid Ellipse")

    stats["shapes"] += 1  # count every shape in shapes

# get the all all shapes in stats dict (keys) and sort it for ascending order
temp = sorted(stats.keys())

# print each shape statistic :

for s in temp:

    if s == "shapes":
        continue
    print(s + "(s):", stats[s])


print("shape(s):", stats["shapes"])