#include<iostream>
#include<string>

using namespace std;

class Node
{
public:
    string str;
    Node *next;
};

class Queue
{
    Node *head= NULL;
    Node *tail= NULL;
public:
    void enqueue(string str)
    {
        Node *node= new Node();
        node->str= str;
        if(head==NULL)
        {
            head= node;
            tail= node;
        }
        else
        {
            tail->next= node;
            tail= node;
        }
    }
    string dequeue()
    {
        if(!isEmpty())
        {
            string str1= head->str;
            head= head->next;
            return str1;
        }
        else
            return "Queue is Empty!!";

    }
    string top()
    {
        if(!isEmpty())
        {
            return head->str;
        }
        else
            return "Queue is Empty!!";
    }

    bool isEmpty()
    {
        return head==NULL;
    }
};

int main()
{
   Queue que;
   que.enqueue("I");
   que.enqueue("love");
   que.enqueue("you!");
   cout<< que.dequeue()<< " ";
   cout<< que.dequeue()<< " ";
   cout<< que.dequeue()<< " ";
}

