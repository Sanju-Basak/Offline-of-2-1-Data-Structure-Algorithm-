#include<iostream>
#include <assert.h>
using namespace std;

class Node
{
public:
    int data;
    Node* next;
};

void InsertAtFront(Node** head_ref, int data)
{
    Node* new_node= new Node();
    new_node->data= data;
    new_node->next= *head_ref;
    *head_ref= new_node;
}

void InsertAfter(Node* prev_node, int data)
{
    Node* new_node= new Node();
    new_node->data= data;
    new_node->next= prev_node->next;
    prev_node->next= new_node;
}

void append(Node** head_ref, int data)
{
    Node* new_node= new Node();
    new_node->data= data;
    if(*head_ref== NULL)
    {
        *head_ref= new_node;
    }
    else
    {
        Node* last= *head_ref;
        while(last->next != NULL)
        {
            last= last->next;
        }
        last->next= new_node;
    }
}

void deleteKey(Node** head_ref, int data)
{
    Node* temp= *head_ref;
    Node* prev= NULL;
    if(temp != NULL && temp->data== data)
    {
        *head_ref= temp->next;
        delete temp;
    }
    else
    {
        while(temp != NULL && temp->data!= data)
        {
            prev= temp;
            temp= temp->next;
        }
        if(temp== NULL)
            return;
        prev->next= temp->next;
        delete temp;
    }
}

void deleteInAGivenPosition(Node** head_ref, int pos)
{
    if(*head_ref== NULL)
        return;
    Node* temp= *head_ref;
    if(pos== 0)
    {
        *head_ref= temp->next;
        delete temp;
    }
    else
    {
        int i=0;
        while(temp != NULL && i<pos-1)
        {
            temp= temp->next;
            i++;
        }
        if(temp==NULL || temp->next== NULL)
            return;
        Node* node= temp->next->next;
        delete temp->next;
        temp->next= node;
    }
}

void swapNodes(Node** head_ref, int x, int y)
{
    if(x== y)
        return;
    Node* currentX= *head_ref;
    Node* prevX= NULL;
    while(currentX && currentX->data != x)
    {
        prevX= currentX;
        currentX= currentX->next;
    }
    Node* currentY= *head_ref;
    Node* prevY= NULL;
    while(currentY && currentY->data != y)
    {
        prevY= currentY;
        currentY= currentY->next;
    }
    if(currentX== NULL || currentY== NULL)
        return;
    if(prevX != NULL)
        prevX->next= currentY;
    else
        *head_ref= currentY;
    if(prevY != NULL)
        prevY->next= currentX;
    else
        *head_ref= currentX;

    Node *temp= currentX->next;
    currentX->next= currentY->next;
    currentY->next= temp;

}

void deleteFront(Node** head_ref)
{
    if(*head_ref)
        *head_ref= (*head_ref)->next;
}

void deleteLinkedList(Node** head_ref)
{
    Node* temp= *head_ref;
    Node* prev= NULL;
    while(temp)
    {
        prev= temp;
        temp= temp->next;
        delete prev;
    }
    *head_ref= NULL;
}

void ReverseList(Node** head_ref)
{
    Node* prev= NULL;
    Node* curr= *head_ref;
    Node* next= NULL;
    while(curr)
    {
        next= curr->next;
        curr->next= prev;
        prev= curr;
        curr= next;
    }
    *head_ref= prev;
}

int getLength(Node* head)
{
    int i=0;
    while(head)
    {
        head= head->next;
        i++;
    }
    return i;
}

void search(Node* head, int key)
{
    Node *current= head;
    while(current)
    {
        if(current->data== key)
        {
            cout<< key<< " is in the list!!"<< endl;
            return;
        }
        current= current->next;
    }
    cout<< key<< " did not find in the list!!"<< endl;
}

int getNthValue(Node* head, int index)
{
    Node* current= head;
    int c= 0;
    while(current)
    {
        if(c== index)
            return current->data;
        c++;
        current= current->next;
    }

    assert(0);
}

void display(Node* node)
{
    while(node)
    {
        cout<< node->data<< " ";
        node= node->next;
    }
    cout<< endl;
    cout<< "--------------------------------------------------------------------"<< endl;
}

int main()
{
    Node* head= NULL;
    InsertAtFront(&head, 9);
    display(head);
    deleteInAGivenPosition(&head, 0);
    display(head);
    append(&head, 18);
    display(head);

    InsertAtFront(&head, 55);
    display(head);
    InsertAfter(head->next, 56);
    display(head);
    append(&head, 88);
    display(head);
    deleteKey(&head, 88);
    display(head);
    deleteInAGivenPosition(&head, 2);
    display(head);
    append(&head, 45);
    append(&head, 85);
    append(&head, 95);
    append(&head, 85);
    display(head);
    deleteFront(&head);
    display(head);
    //deleteLinkedList(&head);
    //display(head);
    cout<< "Length is:"<< getLength(head)<< endl;
    search(head, 100);
    cout<< "Value at Index 4 is: "<<  getNthValue(head, 4)<< endl;
    display(head);
    swapNodes(&head, 18, 85);
    display(head);
    ReverseList(&head);
    display(head);


}
