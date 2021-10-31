/*

Assignment 1 part 3 (Lists and Linked Lists)
*/

#include <stdio.h> //for every C program.
#include <stdlib.h> //contains the malloc function.




typedef enum { ATOM, LIST } eltype; //enum type that will later serve to dictate wether an element contains an atom or an address to a _listnode

typedef char atom; //delaring atom  as an alias to char
struct _listnode; //declaring _listnode to use it before it is defined.

typedef struct { //data part of the node
	eltype type; //dictates whether the data part is char or a pointer. if 0 char if 1 pointer. 
	union {
		atom a;
		struct _listnode* l;
	};
} element;


typedef struct _listnode { //this represents the NODE, it has a data and a pointer/reference part. 
	element el;				//the data can either be a char or a pointer
	struct _listnode* next;	//pointer part of the node.
} *list;						//list is a pointer to this struct. thus list = struct _listnode*

const element NIL = { .type = LIST, .l = NULL };


//function prototypes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
element aasel(atom a);
element lasel(struct _listnode* l);
element car(element e);
list cdr(element e);
list cddr(element e);
list cons(element e, list l);
list append(list l1, list l2);
void lfreer(list l);
void print(element e);
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


int main(void) {


	element linkedList;
	

	linkedList.l = malloc(sizeof(struct _listnode) );
	if (linkedList.l == NULL) {
		printf("ERROR: Out of memory.\n");
		return 1;
	}
	
	linkedList = lasel(cons(aasel('a'), cons(lasel(cons(aasel('b'), cons(aasel('c'), NULL))), cons(aasel('d'), cons(aasel('e'), NULL)))));
	


	//print list
	print(linkedList);

	//
	printf("\n\n");

	////print the car of the list.
	print( car(linkedList) );
	
	printf("\n\n");

	////print the cdr of the list.
	print( lasel(cdr(linkedList) ) );

	printf("\n\n");

	////print the car of the car
	print(  car( car(linkedList) )     );

	printf("\n\n");

	free(linkedList.l); //finally free the memory of the LinkedList.

	return 0;
}





//first function 

element aasel(atom a) { //this function takes an atom a and returns an element that contains this atom a.
	element newE;
	newE.type = ATOM;
	newE.a = a;
	return newE;
}


element lasel(struct _listnode* l) { //takes a list as an argument and returns an element that points to that list.
	
	element n;
	n.type = LIST;
	n.l = l;
	return n;
}

element car(element e) { //returns the head of the list. returns NIL if e is not a list.  
	if (e.type == LIST  && e.l != NULL) {
		
		return e.l->el;
	}
	else
		return NIL;
}

list cdr(element e) { //returns an element that points to the same list pointed to by the parameter e but without the head node. i.e. it points to the
						//second node.
	list tail = NULL;
	list cursor = NULL;
	tail = e.l->next;
	cursor = e.l;
	int count = 0;

	if (e.type == 0)
	{
		return NULL;
	}
	else {
		while (cursor != NULL)
		{
			cursor = cursor->next;
			count++;
		}
		if (count <= 1 )
			return NULL;
		else
			return tail;
	}
}

list cddr(element e) { //returns the cdr of the cdr of element e.
	return cdr( lasel(cdr(e) ) );
}

list cons(element e, list l) { //returns a new list that has e as its car and l as its cdr.
	
	list newList = malloc( sizeof(struct _listnode) );

	if (newList == NULL) {
		printf("ERROR: Out of memory.\n");
		exit(1);
	}
	
	//newList is a pointer that point to _listnode that has e as its element part. and the address of l as its next.
	newList->el = e;  
	newList->next = l;
	
	return newList;
}

list append(list l1, list l2) { //appends list 1 and list 2. the 
	list appendedList = (list)malloc(sizeof(l1) + sizeof(l2) );
	appendedList = l1;
	
	while (l1->next != NULL)
	{
		l1 = l1->next;
	}
	l1->next = l2;

	return appendedList;
}

void lfreer(list l) { //frees the memory allocated to the list and inner lists.
	
	struct _listnode* tmp = malloc( sizeof(struct _listnode) ) ;
	
	if (tmp == NULL) {
		printf("ERROR: Out of memory.\n");
		exit(1);
	}

	while (l != NULL)
	{
		if (l->el.type == 1 && l->el.l != NULL)
		{
			lfreer(l->el.l);
		}
		tmp = l;
		l = l->next;
		free(tmp);
	}
}


void print(element e) { //prints the content of element e. 
	if (e.type == LIST) {
		list cursor = e.l;
		int count = 0;
		if (cursor == NULL) //to not print the parenthesis.
		{
			printf("%s", "NIL");
			return;
		}

		if (cursor->next != NULL) { //if there is only one element dont print parenthesis
			printf("%s", "( ");
			count++;
		}
		while (cursor != NULL)
		{
			if (cursor->el.type == 0)
			{
				printf(" %c ", cursor->el.a);
			}
			else if (cursor->el.type == 1 && cursor->el.l == NULL)
				printf("%s", "NIL");
			else
			{
				print(cursor->el);
			}

			cursor = cursor->next;
		}
		if (count > 0)
			printf("%s", " )");
	}

	else
		printf("%c", e.a);
}


//linkedList.l = cons(e ,NULL );
	//linkedList.l = cons(d, linkedList.l);
	//linkedList.l = cons(lasel(cons(b, cons(c, NULL))) , linkedList.l  );
	//linkedList.l = cons( a, linkedList.l);
	//linkedList.l = cons(a, linkedList.l);